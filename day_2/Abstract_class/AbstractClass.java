
 class Template{
//public abstract void sample();

public void NonabsMethods();
}


public class AbstractClass extends Template{

	public  void sample() {
		System.out.printf("this is abstract method implementation");
	}

	
	public static void main(String[] ar){
	 AbstractClass obj=new AbstractClass();
	 obj.sample();
	 obj.NonabsMethods();
	 	 //obj.sample_2(); throws error
	}
}


