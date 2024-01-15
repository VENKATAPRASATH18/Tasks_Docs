import java.lang.reflect.Method;
import java.net.*;
import java.io.*;
 public class A{
  public static void addPath(String s) throws Exception {
  File f = new File(s);
  URL u = f.toURL();
  URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
  Class urlClass = URLClassLoader.class;
  Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
  method.setAccessible(true);
  method.invoke(urlClassLoader, new Object[]{u});
}
public static void main(String[] ar){
//addPath("/home/venkat-20466/Documents/Task_Docs/day_1/Dependencies");
 B obj=new B();

}
}
