package com.ctseducare.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationsOverListOfObjectsFromDatabase {
	
	private static EmployeeRepository repository = new EmployeeRepository();

	public static void main(String[] args) {

	    Integer[] employeeIds = { 1, 2, 3, 4, 5 };

		// ==================================================================================================== 
		// map()
		// Produces a new stream after applying a function to each element of the original stream. The new
		// stream could be of different type.
		// ====================================================================================================
        System.out.println("map()");
        System.out.println("-----");
	    List<Employee> employees1 = Stream
	    		.of(employeeIds)
	    		.map(repository::findById)
	    		.collect(Collectors.toList());
	    employees1.stream().forEach(e -> System.out.println(e.getName()));
	    System.out.println("");
	    
		// ==================================================================================================== 
		// filter()
		// produces a new stream that contains elements of the original stream that pass a given test (specified
	    // by a Predicate).
		// ====================================================================================================
	    System.out.println("filter()");
        System.out.println("--------");
	    List<Employee> employees2 = Stream
	    		.of(employeeIds)
	    		.map(repository::findById)
	    		.filter(e -> e != null)
	    		.filter(e -> e.getSalary() > 3000.0)
	    		.collect(Collectors.toList());
	    employees2.stream().forEach(e -> System.out.println(e.getName() + ", " + e.getSalary()));
	    System.out.println("");
	    
		// ==================================================================================================== 
		// findFirst()
		// Returns an Optional for the first entry in the stream; the Optional can, of course, be empty.
		// ====================================================================================================
	    System.out.println("findFirst()");
        System.out.println("-----------");
	    Employee employee1 = Stream
	    		.of(employeeIds)
	    		.map(repository::findById)
	    		.filter(e -> e != null)
	    		.filter(e -> e.getSalary() > 5000.0)
	    		.findFirst()
	    		//.get();  // vai gerar uma exceção porque não existe funcionário com salário maior que 5000.00. Deve-se usar o 'orElse'
	    		.orElse(null);
	    if (employee1 == null) {
	    	System.out.println("Não tem funcionário com salário maior que 5000.00");
		    System.out.println("");
	    }

		// ==================================================================================================== 
		// peek()
		// Sometimes we need to perform multiple operations on each element of the stream before any terminal
 	    // operation is applied.
		// ====================================================================================================
	    System.out.println("peek()");
        System.out.println("------");
	    List<Employee> employees3 = Stream
	    		.of(employeeIds)
	    		.map(repository::findById)
	    		.peek(e -> e.incrementSalary(100.0))
	    		.peek(e -> e.setName(e.getName().toUpperCase()))
	    		.collect(Collectors.toList());
	    employees3.stream().forEach(e -> System.out.println(e.getName() + ", " + e.getSalary()));
	    System.out.println("");

 	    
		// ==================================================================================================== 
		// flatMap()
		// A stream can hold complex data structures like Stream<List<String>>. In cases like this, flatMap()
	    // helps us to flatten the data structure to simplify further operations
		// ====================================================================================================
	    System.out.println("flatMap()");
        System.out.println("--------");
 	    List<List<String>> namesNested = Arrays.asList(
 	    		Arrays.asList("Jeff", "Bezos"),
 	    		Arrays.asList("Bill", "Gates"),
 	    		Arrays.asList("Mark", "Zuckerberg")
 	    );
 	    List<String> namesFlatStream = namesNested
 	    		.stream()
 	    		.flatMap(Collection::stream)
 	    		.collect(Collectors.toList());
 	    namesFlatStream.stream().forEach(n -> System.out.println(n));
 	    System.out.println("");
 	    
		// ==================================================================================================== 
		// skip() and limit()
		// skip(X)  - skip the X first elements 
	    // limit(Y) - limit to Y elements from the infinite stream generated using iterate(). 
		// ====================================================================================================
	    System.out.println("skip() and limit()");
        System.out.println("------------------");
 	    Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);
 	    List<Integer> collect = infiniteStream
 	    		.skip(3)
 	    		.limit(5)
 	    		.collect(Collectors.toList());
 	    collect.forEach(e -> System.out.println(e));
 	    System.out.println("");

		// ==================================================================================================== 
		// min()
	    // Returns the minimum element in the stream based on a comparator 
		// ====================================================================================================
	    System.out.println("min()");
        System.out.println("-----");
        Employee employeeWithLowerSalary = Stream
        		.of(employeeIds)
        		.map(repository::findById)
        		.min(Comparator.comparingDouble(Employee::getSalary))
        		.get();
        System.out.println("Lower salary: " + employeeWithLowerSalary.getSalary());
	    System.out.println("");
  
		// ==================================================================================================== 
		// max()
	    // Returns the maximum element in the stream based on a comparator 
		// ====================================================================================================
	    System.out.println("max()");
        System.out.println("-----");
        Employee employeeWithHigherSalary = Stream
        		.of(employeeIds)
        		.map(repository::findById)
        		.max(Comparator.comparingDouble(Employee::getSalary))
        		.get();
        System.out.println("Higher salary: " + employeeWithHigherSalary.getSalary());
	    System.out.println("");

		// ==================================================================================================== 
		// distinct()
	    // Returns the distinct elements in the stream, eliminating duplicates.  
		// ====================================================================================================
	    System.out.println("distinct()");
        System.out.println("----------");
        List<String> fruits1 = List.of("Lemon", "Banana", "Apple", "Orange", "Banana", "Watermelon", "Lemon");
        List<String> fruits2 = fruits1
        		.stream()
        		.distinct()
        		.toList();
        fruits2.forEach(f -> System.out.println(f));
        System.out.println("");
	    
	}

}
