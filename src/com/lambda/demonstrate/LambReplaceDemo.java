package com.lambda.demonstrate;

public class LambReplaceDemo {

	public static void main(String[] args) {
		
	
		setListener(new OnSomeStringListener(){
			 public String onAction(String param){
				 
				return param;
				
			}
		});
		setListener(p -> p);
		setListener(p -> {
			return p+"suffix";
		});
		
//		setSomething(p -> p);

	}
	
	public static void setListener(OnSomeStringListener listener){
		
		listener.onAction("on action");
	}

	
	public static void setSomething(OnSomeParentClass someAction){
		someAction.onAction("on parent action");
	}



	interface OnSomeStringListener{
		public String onAction(String param);
	}
	
	abstract class OnSomeParentClass{
		public abstract String onAction(String param);
	}
	
}
