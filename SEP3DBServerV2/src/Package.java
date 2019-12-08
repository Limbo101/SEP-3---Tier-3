import com.sun.jdi.connect.Connector;

import java.io.Serializable;


public class Package implements Serializable
{
   private String operation;
   private String argument;
   int arg;


   public Package(String operation, String argument )
   {
      this.operation = operation;
      this.argument = argument;

   }

   public String getArgument()
   {
      return argument;
   }

   public String getOperation()
   {
      return operation;
   }

   public String toString(){
       return operation + argument;
   }


}
