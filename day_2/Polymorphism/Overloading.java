

public class Overloading {

	public static void execute(int i, int j) {
		System.out.printf("execute method with two integers");
	}

	public static void execute(int[] ints) {
		System.out.println("execute method with array of integers");
	}

	public static void execute(char a,char b) {
		System.out.println("execute method with two characters");
	}
	
	public static void main(String[] ar){
	 //Overloading obj=new Overloading();
	 execute(5,6);
	}
}


