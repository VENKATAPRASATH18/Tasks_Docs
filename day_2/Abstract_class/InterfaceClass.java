

 interface Template {

    void myMethod(); 

    //implicitly public, static, and final
    int MY_CONSTANT = 42;

    // method with a body (introduced in Java 8)
    default void myDefaultMethod() {
        System.out.println("Default method implementation");
    }

    // Static method (introduced in Java 8)
    static void myStaticMethod() {
        System.out.println("Static method implementation");
    }
}


public class InterfaceClass implements Template{
	
	public  void myMethod() {
		System.out.printf("this is abstract method implementation");
	}

	
	public static void main(String[] ar){
	 InterfaceClass obj=new InterfaceClass();
	 obj.myDefaultMethod();
	 Template.myStaticMethod();
	 	
	}
}


