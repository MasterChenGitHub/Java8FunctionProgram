package com.lambda.demonstrate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

import static java.util.stream.Collectors.toList;

public class StreamDemo {

	public static void main(String[] args) {
		
		List<Artist> artists=Arrays.asList(new Artist("a"),new Artist("a"),new Artist("a"));
		String result =artists.stream()
                .map(Artist::getName)
                .collect(Collectors.joining(", ", "[", "]"));

		// demo1 map
		List<String> collected = new ArrayList<>();
		for (String s : Arrays.asList("a", "b", "hello")) {
			String upperCaseString = s.toUpperCase();
			collected.add(upperCaseString);
		}
		System.out.println(collected.toString());

		collected.clear();
		collected = Stream.of("a", "b", "hello")
				.map(string -> string.toUpperCase())
				.collect(Collectors.toList());

		System.out.println(collected.toString());

		// demo2 filter
		// old
		List<String> beginningWithNumbers = new ArrayList<>();
		for (String value : Arrays.asList("a", "1abc", "abc1")) {
			if (Character.isDigit(value.charAt(0))) {
				beginningWithNumbers.add(value);
			}
		}
		System.out.println(beginningWithNumbers.toString());
		// stream
		beginningWithNumbers.clear();
		beginningWithNumbers = Stream.of("a", "1abc", "abc1")
				.filter(value -> Character.isDigit(value.charAt(0)))
				.collect(Collectors.toList());
		System.out.println(beginningWithNumbers.toString());
		
		// demo3 flatmap

		List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
				.flatMap(numbers -> numbers.stream())
				.collect(toList());

		// demo4  max min
		List<Track> tracks = Arrays.asList(new Track("Bakai", 524), new Track("Violets for Your Furs", 378),
				new Track("Time Was", 451));
		Track shortestTrack = tracks.stream()
				.min(Comparator.comparing(track -> track.getLength()))
				.get();
		Track longestTrack = tracks.stream()
				.max(Comparator.comparing(track -> track.getLength()))
				.get();

		System.out.println(shortestTrack.toString());
		System.out.println(longestTrack.toString());
		
		//demo5  reduce
		int acc1 = 0;
		for (Integer element : asList(1, 2, 3)) {
		acc1 = acc1 + element;
		}
		System.out.println("acc1:"+acc1);
		
		int startValue=0;
		int count = Stream.of(1, 2, 3)
				.reduce(startValue, (acc, element) -> acc + element);
		
		int min = Stream.of(1, 2, 3)
				.reduce(3, (acc, element) -> {
					if(element<acc){
						return element;
					}else{
						return acc;
					}
				});
		
		System.out.println(count);
		
		System.out.println("min:"+min);
		
		//demo6  method reference
		
	String names=Arrays.asList(new Artist("a"),new Artist("b"),new Artist("c")).stream()
			.map(Artist::getName)//.map(artist->argist.getName())
			.collect(Collectors.toList()).toString();
		System.out.println(names);
		
		
	}
	public static class Artist{
		private String name;

		public Artist(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}

}
