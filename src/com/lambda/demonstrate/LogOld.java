package com.lambda.demonstrate;

public class LogOld {

	private static boolean isDebug = true;

	public static void setEnable(boolean isEnable) {
		isDebug = isEnable;
	}

	public static void d(String message) {

		if (isDebug)
			System.out.println(message);
	}
	
	public static void d(LogMessage message) {

		if (isDebug)
			System.out.println(message.get());
	}
	
	public interface LogMessage{
		public String get();
	}

}
