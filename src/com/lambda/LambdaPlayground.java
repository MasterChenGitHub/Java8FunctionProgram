package com.lambda;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class LambdaPlayground {
	
	static class Imaginary{
		int real;
		int imaginary;
		
		public Imaginary(int r,int i){
			real=r;
			imaginary=i;
		}
		
		
	}

	public static void main(String[] args) {
	Runnable noArguments=()-> System.out.println("Hello World");
	
	ActionListener oneArgument=event ->System.out.println("button clicked");
	
	Runnable multiStatement=()->{
	 System.out.print("Hello");
	 System.out.println("World");
	};
	
	BinaryOperator<Long> add=(x,y)->x+y;
	BinaryOperator<Imaginary> sub=(x,y)->{
		Imaginary result=new Imaginary(x.real-y.real,x.imaginary-y.imaginary);
	
		return result;
	};
	System.out.println(add.apply(3l, 5l));
	
	
	
	
	final String[] array={"hello","world"};
	
	System.out.println(array);

	}

}
