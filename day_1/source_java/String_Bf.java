import java.util.Scanner;
public class String_Bf{
public static void main(String[] ar){
Scanner s=new Scanner(System.in);
String read=s.nextLine();
//String input="cliq";
StringBuffer sb=new StringBuffer(read);
for(int i=0;i<sb.length()/2;i++){
	char t=sb.charAt(i);
	sb.setCharAt(i,sb.charAt(sb.length()-1-i));
	sb.setCharAt(sb.length()-1-i,t);
}
System.out.println(sb);

}
}
