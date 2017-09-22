package com.lambda.demonstrate;


public class LogTest {

	public static void main(String[] args) {

		System.out.println("old log util");
		LogOld.d(expensiveOperation());
//		LogLambda.d(()->"hello world old log");
		System.out.println("old log util disable");
		LogOld.setEnable(false);
		LogOld.d(expensiveOperation());
		
		System.out.println("======================");
		System.out.println("new log util");
		LogLambda.d(()->expensiveOperation());
//		LogLambda.d(()->"hello world new log");
		System.out.println("new log util disable");
		LogLambda.setEnable(false);
		LogLambda.d(()->expensiveOperation());
		
		LogOld.d(new LogOld.LogMessage(){
			public String get(){
				return expensiveOperation();
			}
		});
		
		

		
	}

	
	public static String expensiveOperation(){
		
		System.out.println("exprnsive operation");
		return "expensive operation to generate log message";
	}
}
