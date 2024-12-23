package com.ctseducare.streams;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RelatorioTime {

	public static void main(String[] args) {
	    try {
			List<Jogador> jogadores = obterJogadores();
			
			Jogador artilheiro = jogadores.stream().max(Comparator.comparingInt(Jogador::getGolsMarcados)).get();
			System.out.println("Artilheiro: " + artilheiro.getNome());

			Jogador maisVelho = jogadores.stream().max(Comparator.comparingInt(Jogador::getIdade)).get();
			System.out.println("Mais velho: " + maisVelho.getNome());

			Jogador maisNovo = jogadores.stream().min(Comparator.comparingInt(Jogador::getIdade)).get();
			System.out.println("Mais novo: " + maisNovo.getNome());
			
			double idadeMedia = jogadores.stream().mapToInt(Jogador::getIdade).average().getAsDouble();
			System.out.println("Idade média: " + idadeMedia);
			
			List<String> times = jogadores.stream().map(jogador -> jogador.getTimeAtual()).distinct().sorted().collect(Collectors.toList());
			System.out.println("Times: " + times);
			
			List<Jogador> jogadoresPorTime = jogadores.stream().sorted(Comparator.comparing(Jogador::getTimeAtual)).toList();
			jogadoresPorTime.forEach(jogador -> System.out.println(jogador.getTimeAtual() + ", " + jogador.getNome()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
		    e.printStackTrace();
		}
	}
	
	public static List<Jogador> obterJogadores() throws IOException, URISyntaxException {
	    URI uri = ClassLoader.getSystemResource("jogadores.txt").toURI();
        Path caminho = Paths.get(uri);
	    Stream<String> linhas = Files.lines(caminho, StandardCharsets.UTF_8);
        List<String> listaDeLinhas = linhas.collect(Collectors.toList());
        List<Jogador> listaDeJogadores = new ArrayList<>();
        Jogador jogador;
        Iterator<String> it = listaDeLinhas.listIterator();
        String str = null;
        while (it.hasNext()) {
        	str = (String)it.next();
            String info[]  = str.split(",");
            jogador = new Jogador();
            jogador.setNome(info[0]);
            jogador.setPosicao(info[1]);
            jogador.setIdade(Integer.parseInt(info[2]));
            jogador.setTimeAtual(info[3]);
            jogador.setGolsMarcados(Integer.parseInt(info[4]));
            listaDeJogadores.add(jogador);
        }
        linhas.close();
        return listaDeJogadores;
      }
}
