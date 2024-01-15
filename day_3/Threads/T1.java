class T2 extends Thread {
        
         public void run() {
         
             System.out.println("sample execution");
         }
         
     }


public class T1 extends Thread {
        
         public void run() {
        
             System.out.println("sample execution");
         }
         public static void main(String[] a){
         T1 obj_1 = new T1();
         T1 obj_2 = new T1();
         obj_1.start();
         obj_2.start();
       
         System.out.println("Created Thread_1 default name:" +obj_1.getName());
         System.out.println("Created Thread_2 default name::" +obj_2.getName());

	obj_1.setName("t1");
	obj_2.setName("t2");
	 System.out.println("Created Thread_1 defined name:" +obj_1.getName());
         System.out.println("Created Thread_2 defined name::" +obj_2.getName());
         Thread.currentThread().setName("main_thread");
         System.out.println("main thread defined:" +Thread.activeCount());
         System.out.println("main thread:" +Thread.currentThread().getName());
         
         }
     }
