import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

   public class HelloClient 
  {
    static Hello hello;
    public static void main(String args[])
    {  try {

           ORB orb=ORB.init(args, null);
           org.omg.CORBA.Object objRef =
		orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            hello = HelloHelper.narrow(ncRef.resolve_str("Hello"));

	    
            System.out.println(hello.sayHello());
            System.out.println("The sum 1 to 100 is "+ hello.sum(100));
            System.out.println("The sum 1 to 1000 is "+ hello.sum(1000));            
             }
            catch (Exception e) { e.printStackTrace(); }                            
    
                               }
                            }
                                                              
                
 
