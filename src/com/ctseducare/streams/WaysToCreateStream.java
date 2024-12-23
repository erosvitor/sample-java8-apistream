package com.ctseducare.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WaysToCreateStream {

	public static void main(String[] args) {
		
		// Dado um vetor de employees...
		// ====================================================================================================
		Employee[] arrayOfEmployees = {
				new Employee(1, "Fulano da Silva", 3500.0), 
			    new Employee(2, "Beltrano Gomes", 4100.0), 
			    new Employee(3, "Siclano Pereira", 1800.0),
			    new Employee(4, "Anequim Gonçalves", 2400.0),
			    new Employee(5, "Nama Pedrosa", 3200.0)
		};
		
		// ...podemos criar uma Lista a partir do vetor
		// ====================================================================================================
		List<Employee> listOfEmployees = Arrays.asList(arrayOfEmployees);

		// Dado um vetor ou uma lista, podemos criar uma Stream a partir do vetor...
		// ====================================================================================================
		Stream<Employee> streamEmployeesFromArray = Stream.of(arrayOfEmployees);
		
		// ...ou podemos criar uma Stream a partir da Lista de uma formas
		// ====================================================================================================
		//Stream streamEmployeesFromList = Stream.of(listOfEmployees);  // Modo 1
		Stream<Employee> streamEmployeesFromList = listOfEmployees.stream();  // Modo 2

		// Criando uma stream do zero
		// ====================================================================================================
		Stream<Employee> streamEmployeesFromZero = Stream.of(
				new Employee(1, "Fulano da Silva", 3500.0), 
			    new Employee(2, "Beltrano Gomes", 4100.0), 
			    new Employee(3, "Siclano Pereira", 1800.0),
			    new Employee(4, "Anequim Gonçalves", 2400.0),
			    new Employee(5, "Nama Pedrosa", 3200.0)
		);
		
		Stream.Builder<Employee> streamBuilder = Stream.builder();
		streamBuilder.add(new Employee(1, "Fulano da Silva", 3500.0));
		streamBuilder.add(new Employee(2, "Beltrano Gomes", 4100.0));
		streamBuilder.add(new Employee(3, "Siclano Pereira", 1800.0));
		streamBuilder.add(new Employee(4, "Anequim Gonçalves", 2400.0));
		streamBuilder.add(new Employee(5, "Nama Pedrosa", 3200.0));
		Stream<Employee> streamEmployeesFromStreamBuilder = streamBuilder.build();
	}

}
