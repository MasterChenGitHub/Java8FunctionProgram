package com.lambda.demonstrate;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class CommonTypes {

	public static void main(String[] args) {
		
		Supplier<Long> supplierLongMaxValue = () -> Long.MAX_VALUE;
		
		System.out.println(supplierLongMaxValue.get());

		Consumer<Long> printSelf = (i) -> System.out.println(i);

		printSelf.accept(100l);

		Function<Long, Boolean> biggerThanZeroVersion1 = i -> i > 0;
		
		if(biggerThanZeroVersion1.apply(100l))
			System.out.println("bigger than zero version1");

		Predicate<Long> biggerThanZeroVersion2 = i -> i > 0;
		
		if(biggerThanZeroVersion2.test(1l)){
			System.out.println("bigger than zero version2");
		}
		
		BinaryOperator<Long> add=(i,j)->i+j;
		
		System.out.println(add.apply(2l,4l));
		
		 
//		[ˈju:nəri] adj.一元的；
		UnaryOperator<Long> increaceOne=i -> i+1;
		
		
		System.out.println(increaceOne.apply(2l));
	
		
		Character.isDigit('a');
		
	}

}
