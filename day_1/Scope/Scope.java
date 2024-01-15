public class Scope 
{

 public  void local_var(int a) { // method scope
	int x = 20; // local scope  
	System.out.println("local scope var"+x);
	System.out.println("Methid scope var"+a);
   }
public static void main(String[] args) 
{

   Scope lv = new Scope();
   lv.local_var(11);
   //System.out.println("Accessing local variable: " +lv.x); //  error.
   
  } 
}
