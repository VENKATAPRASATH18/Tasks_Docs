public class Example {
     
  
     
    int a = 10;
    void Pass_By_Value(int a) {
       
        a = a+10; // local var get affected
    }
    void Pass_By_Reff(Example e) {
       
        e.a = e.a+10; // local var get affected
    }
     
    public static void main(String[] args) {
 
        Example obj= new Example();
        System.out.println("Before pass-by-value: " + obj.a);
	//belongs to which and why
        obj.Pass_By_Value(200);
        System.out.println("After pass-by-value: " + obj.a);
        
        System.out.println("Before pass-by-reff: " + obj.a);

        obj.Pass_By_Reff(obj);
        System.out.println("After pass-by-reff: " + obj.a);
         
         
    }
    }
