package com.lambda.demonstrate;

public class Track {

	private String name;
	private int length;
	public Track(String name, int id) {
		super();
		this.name = name;
		this.length = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	

	@Override
	public String toString(){
		return "[name:"+name+",length:"+length+"]";
	}
	
	
}
