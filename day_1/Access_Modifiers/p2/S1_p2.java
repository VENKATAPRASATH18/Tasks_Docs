package p2;
//import p1.Sample_1;

public class S1_p2{
public static void details(){
System.out.println("This is s1_p2 class from package p2");
}

public static void main(String[] ar){

	try{
	//fullqCls
	p1.Sample_1.details();
	System.out.println("Sample_1 class from package p1 ivoked in s1_p2 of package p2");
	}
	catch(Exception e)
	 {
		System.out.println(e);
	 }
	

}
}
