import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

  class HelloImpl extends HelloPOA {
       public String sayHello() {
        return "Hello guys the answers are \n";    }
 
      public int sum(int x)  {
       if (x>0) return(x+sum(x-1));
          else return 0;      }     }

 public class HelloServer {
  public static void main(String args[]) {
   try {
    ORB orb = ORB.init(args, null);
   POA rootPoa = (POA)orb.resolve_initial_references("RootPOA");
   rootPoa.the_POAManager().activate();
   HelloImpl hello=new HelloImpl();

   org.omg.CORBA.Object ref=rootPoa.servant_to_reference(hello);
   Hello href=HelloHelper.narrow(ref);
   
   org.omg.CORBA.Object oRef=
  	orb.resolve_initial_references("NameService");

   NamingContextExt ncRef=NamingContextExtHelper.narrow(oRef);

   String name="Hello";
   NameComponent path[] = ncRef.to_name(name);
   ncRef.rebind(path, href);
   
   System.out.println("Hello Everyone! Server is ready");
   orb.run(); 

                    }    
   catch(Exception e) { e.printStackTrace(); }

   System.out.println ("Goodbye Server Exiting");  
                                            }
                            }
                                                              
                
 
