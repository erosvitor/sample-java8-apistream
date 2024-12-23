package com.ctseducare.streams;

import java.util.stream.Stream;

public class TerminalOperations {
	
	public static void main(String[] args) {
		
		Stream<Employee> employees = Stream.of(
				new Employee(1, "Fulano da Silva", 3500.0), 
			    new Employee(2, "Beltrano Gomes", 4100.0), 
			    new Employee(3, "Siclano Pereira", 1800.0),
			    new Employee(4, "Anequim Gonçalves", 2400.0),
			    new Employee(5, "Nama Pedrosa", 3200.0)
		);
		
		// ==================================================================================================== 
		// forEach()
		// It loops over the stream elements, calling the supplied function on each element.
		//
		// Tip: forEach is a terminal operation, which means that, after the operation is performed, the stream
		// pipeline is considered consumed, and can no longer be used.
		// ====================================================================================================
		employees.forEach(e -> e.incrementSalary(100.0));
		
		// ==================================================================================================== 
        // WARNING!!!
		// The following command will throw an exception because after the above command completes, the stream
		// will be closed because 'forEach' is a terminal operation
		// ==================================================================================================== 
		//employees.forEach(e -> System.out.println(e.getSalary()));
		
		// ==================================================================================================== 
        // Solution:
		// Create a new Stream each time we need one.
		// ==================================================================================================== 

		// ==================================================================================================== 
        // Anothers terminal operations:
		// - collect()
		// - reduce()
		// - anyMatch()
		// - allMatch()
		// - noneMatch()
		// - collect()
		// - count()
		// - findAny()
		// - findFirst()
		// - forEach()
		// - min()
		// - max()
		// - reduce()
		// - toArray()
		// ==================================================================================================== 
	}

}
