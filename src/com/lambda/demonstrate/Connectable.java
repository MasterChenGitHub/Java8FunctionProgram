package com.lambda.demonstrate;

public interface Connectable {
	
	
	void print(String message);
	
	 default void welcome(String hello){
		print(hello);
	}

}
