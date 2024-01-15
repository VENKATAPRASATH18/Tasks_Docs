 class Check 
{
private static Check obj=new Check();
 private Check () { 
	System.out.println("private constructor");
   }
   public static Check getObj(){
   return obj;
   }
}
public class Singleton_Object 
{


public static void main(String[] args) 
{

   Check lv =Check.getObj();
  
   
  } 
}
