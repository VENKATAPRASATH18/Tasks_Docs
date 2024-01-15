import java.util.Scanner;
public class String_Compare{
public static void buffer_mutable(){
               String main="zoho";
               StringBuffer sub=new StringBuffer(main);
               sub.append("cliq");
               System.out.println("Main Stirng is " + main);
               System.out.println("After concat - >Main Stirng is" + sub.toString());
    }
       public static void string_immutable(){

               String main="zoho";
               main.concat("cliq");
               System.out.println("After concat - >Main Stirng is " + main);
            //   System.out.println("Sub Stirng is " + sub);
               

    }
public static void main(String[] ar){
System.out.println("String_Buffer :");
  buffer_mutable();
 System.out.println("String :");
  string_immutable();
  

}
}
