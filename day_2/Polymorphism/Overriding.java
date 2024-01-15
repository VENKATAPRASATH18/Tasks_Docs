
class Parent{
public  void execute(int i, int j) {
		System.out.printf("execute method with two integers(Parent class)");
	}
}  
public class Overriding extends Parent{
	@Override
	public  void execute(int i, int j) {
		System.out.printf("execute method with two integers");
	}

	public static void execute(int[] ints) {
		System.out.println("execute method with array of integers");
	}

	public  static void execute(char a,char b) {
		System.out.println("execute method with two characters");
	}
	
	public static void main(String[] ar){
	 Parent obj=new Overriding();
	 obj.execute(1,2);
	}
}


