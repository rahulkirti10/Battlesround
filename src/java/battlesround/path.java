package battlesround;
import java.io.*;   
public class path { 
    public static void main(String args[]) 
    { 
  
        // try-catch block to handle exceptions 
        try { 
  
            // Create a file object 
            File f = new File("5e5393f370bd6.png"); 
 
            String absolute = f.getAbsolutePath(); 

            System.out.println("Original  path: "
                               + f.getPath()); 
            System.out.println("Absolute  path: "
                               + absolute); 
        } 
        catch (Exception e) { 
            System.err.println(e.getMessage()); 
        } 
}     
}
