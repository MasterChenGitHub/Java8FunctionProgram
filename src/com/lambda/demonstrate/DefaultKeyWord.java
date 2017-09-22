package com.lambda.demonstrate;

public class DefaultKeyWord {

	public static void main(String[] args) {
		Parent parent = new ParentImp();
		parent.welcome();
		
		parent=new ParentImpOverride();
		parent.welcome();

	}

	public interface Parent {
		public void message(String body);

		public default void welcome() {
			message("Parent: Hi!");
		}

		public String getLastMessage();
	}

	public static class ParentImp implements Parent {

		@Override
		public void message(String body) {
			System.out.println(body);

		}

		@Override
		public String getLastMessage() {
			return "parent implement message";
		}

	}
	public static class ParentImpOverride implements Parent {
		
		@Override
		public  void welcome() {
			message("override default method!");
		}

		
		@Override
		public void message(String body) {
			System.out.println(body);
			
		}
		
		@Override
		public String getLastMessage() {
			return "parent implement message";
		}
		
	}
}
