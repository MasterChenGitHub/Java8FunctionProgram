package com.lambda.demonstrate;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaLogDemo {

	public static void main(String[] args) {
	
		
	String s="hellHHadfQQ";
	long count=s.chars().filter(c -> Character.isUpperCase(c)).count();
	System.out.println(s+" upper case count:"+count);
	
	
	Stream<String> stream=Stream.of("a","b","c");
//	stream.collect(Collectors.toList());
//	stream.collect(Collectors.toList(LinkedList::new));
//	stream.collect(Collectors.toSet());
//	stream.collect(Collectors.toSet(TreeSet::new));
//	stream.collect(Collectors.toMap(m ->m , m -> m+"s"));
//	stream.collect(Collectors.toConcurrentMap(m ->m , m -> m+"s"));
//	stream.collect(Collectors.toCollection(collectionFactory));
//	stream.collect(Collectors.maxBy(Comparator.comparing(t -> t.hashCode())));
//	stream.collect(Collectors.minBy(comparator));
	
	System.out.println("max:"+stream.collect(Collectors.maxBy(Comparator.comparing(t -> t.hashCode()))).get());
//	Collectors.partitioningBy(predicate)
//		stream.collect(Collectors.groupingBy(m -> m,Collectors.counting()));
	
	Supplier<String> sp=()-> "some string"+expensiveOperation();
	
	
	
	boolean isDebug=true;
	
	
	if(isDebug){
		System.out.println(sp.get()); 
	}
	
	

	}
public static String expensiveOperation(){
	return "expensive operation";
}
}
