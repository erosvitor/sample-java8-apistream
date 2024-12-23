package com.ctseducare.streams;

import java.util.List;

public class OperationsOverListOfStrings {

	public static void main(String[] args) {
		
//		List<String> fruits = new ArrayList<>();
//		fruits.add("Banana");
//		fruits.add("Morango");
//		fruits.add("Abacaxi");
//		fruits.add("Maçã");
//		fruits.add("Limão");
//		fruits.add("Melância");
//		fruits.add("Melão");
//		fruits.add("Laranja");
		
		// Java 8 - Arrays.asList gera uma lista de tamanho fixo permitindo que os elementos sejam alterados
		//List<String> fruits = Arrays.asList("Banana", "Morango", "Abacaxi", "Maçã", "Limão", "Melância", "Melão", "Laranja");
	    
		// Java 9 - List.of retorna uma lista imutável
		List<String> fruits = List.of("Banana", "Morango", "Abacaxi", "Maçã", "Limão", "Melância", "Melão", "Laranja");
		System.out.println(fruits);
		System.out.println();
		
		// Java 8
		//List<String> fruitsSorted = fruits.stream().sorted().collect(Collectors.toList());
		List<String> fruitsSorted = fruits.stream().sorted().toList();
		System.out.println(fruitsSorted);
		System.out.println();
		
		// Java 8
		List<String> fruitsStartWithM = fruits.stream().filter(fruit -> fruit.startsWith("M")).toList();
		System.out.println(fruitsStartWithM);
		System.out.println();
		
		// Java 8
		List<String> fruitsInUpperCase = fruits.stream().map(fruit -> fruit.toUpperCase()).toList();
		System.out.println(fruitsInUpperCase);
		System.out.println();
		
		// Java 8
		long fruitsTotalWithM = fruits.stream().filter(fruit -> fruit.startsWith("M")).count();
		System.out.println(fruitsTotalWithM);

	}

}
