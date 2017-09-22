package com.lambda.demonstrate;

import java.util.function.Supplier;

public class LogLambda {

	private static boolean isDebug = true;

	public static void setEnable(boolean isEnable) {
		isDebug = isEnable;
	}

	public static void d(Supplier<String> message) {

		if (isDebug)
			System.out.println(message.get());
	}

}
