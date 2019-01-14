package com.example.Aspect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {

	public static void main(String ar[]) {
//		For Each
//		String test = "test";
//		IntStream c = test.chars();
//		c.forEach(System.out::println);
		
//		filter
//		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//		filtered.stream().forEach(System.out:: println);
		
//		map.distinct()
//		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//		//get list of unique squares
//		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
//		squaresList.stream().forEach(System.out :: println);
		
//		limit
//		Random random = new Random();
//		random.ints().limit(10).forEach(System.out::println);
		
//		limit(10).sorted()
//		Random random = new Random();
//		random.ints().limit(10).sorted().forEach(System.out::println);
		
//		parallelStream
//		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//		int count = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
//		System.out.println(count);
		
//		Optional<String> opt = Optional.of("static value");
//		System.out.println(opt.get());
		
//		List<Integer> myList = new ArrayList<Integer>();
//		for(int i=0; i<10; i++) myList.add(i);
		
//		myList.forEach(new Consumer<Integer>() {
//			public void accept(Integer t) {
//				System.out.println("forEach anonymous class Value::"+t);
//			}
//
//		});
	}
	
	public void testMethod(){
		System.out.println("Test Method Called");
	}
}
