package com.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ComparatorTest {

	public static void main(String[] args) {
    List<Person> personList=Person.createShortList();
    
    //Sort with Inner Class
    Collections.sort(personList,new Comparator<Person>(){

		@Override
		public int compare(Person o1, Person o2) {
			return o1.getSurName().compareTo(o2.getSurName());
		}
    	
    });
    
    System.out.println("===Sorted Asc SurName");
    for(Person p:personList)
    	p.print();
    
    //Use Lambda instread
    //print Asc
   
    Collections.sort(personList,(Person p1,Person p2) -> p1.getSurName().compareTo(p2.getSurName()));
    System.out.println("===Sorted Asc SurName");
    for(Person p:personList)
    	p.print();
    
    
    //print desc
    System.out.println("===Sorted desc SurName");
    Collections.sort(personList,(p1,p2) -> p2.getSurName().compareTo(p1.getSurName()));
    for(Person p:personList)
    	p.print();
    
    
    personList.forEach(p -> p.print());
    
    Stream stream;
    

	}
	
	
	

}
