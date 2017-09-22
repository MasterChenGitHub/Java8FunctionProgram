package com.lambda.demonstrate;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class ArraysDemo {

	public static void main(String[] args) {
		//prefix
		BinaryOperator<Floor> opt = (f1, f2) -> new Floor(f1.getLength() + f2.getLength(),
				f1.getWidth() + f2.getWidth());
		Floor[] floors = Floor.getFloorSizes();
		System.out.println("parallel prefix for complete array");
		Arrays.parallelPrefix(floors, opt);
		Consumer<Floor> print = f-> System.out.println(f.getLength()+", "+f.getWidth());
		Arrays.stream(floors).forEach(print);
		
		System.out.println("parallel prefix for array from index 1 to 4");
		floors = Floor.getFloorSizes();
		Arrays.parallelPrefix(floors, 1, 4, opt);
		Arrays.stream(floors).forEach(print);		
		
		System.out.println("=============");
		
        //setall and foreach
        Arrays.asList(parallelInitialize(100)).forEach(i->System.out.println(i));;
		
		//parallelSort
        User[] users = User.getUsers();
		System.out.println("--Sort complete array--");
		Arrays.parallelSort(users);
		Consumer<User> printUser = u-> System.out.println(u.getName()+"-"+u.getAge());
		Arrays.stream(users).forEach(printUser);		
		System.out.println("--Sort array from index 1 to 4--");
		users = User.getUsers();
		Arrays.parallelSort(users, 1, 4);
		Arrays.stream(users).forEach(printUser);
        
		
		//foreach foreachordered

		Stream.of("AAA", "BBB", "CCC").parallel().forEach(s -> System.out.println("Output:" + s));
		Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Output:" + s));

		
	
	}

	
	public static Double[] parallelInitialize(int size) {
		Double[] values = new Double[size];
		Arrays.parallelSetAll(values, i -> 1.2*i);
		return values;
		}
	
	
	public static class Floor {
		private int length;
		private int width;
		public Floor(int length, int width) {
			this.length = length;
			this.width = width;
		}
		public int getLength() {
			return length;
		}
		public int getWidth() {
			return width;
		}
		public static Floor[] getFloorSizes() {
			Floor[] floors = new Floor[6];
			floors[0] = new Floor(2, 3);
			floors[1] = new Floor(4, 5);
			floors[2] = new Floor(3, 6);
			floors[3] = new Floor(2, 1);
			floors[4] = new Floor(1, 7);
			floors[5] = new Floor(4, 3);
			return floors;
		}
	} 
	
	
	public static class User implements Comparable<User> {
		private String name;
		private int age;	
		public User(String name, int age) {
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		@Override
		public int compareTo(User user) {
			return age-user.age;
		}
		public static User[] getUsers() {
			User[] users = new User[6];
			users[0] = new User ("Ram", 25);
			users[1] = new User ("Shyam", 22);
			users[2] = new User ("Mohan", 21);
			users[3] = new User ("Suresh", 30);
			users[4] = new User ("Ramesh", 20);
			users[5] = new User ("Dinesh", 27);
			return users;
		}
	}
}
