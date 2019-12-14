import com.sun.jdi.connect.Connector;

import java.io.Serializable;


public class Package implements Serializable
{
   private String action;
   private String data;



   public Package(String action, String data )
   {
      this.action = action;
      this.data = data;

   }

   public String getArgument()
   {
      return data;
   }

   public String getOperation()
   {
      return action;
   }

   public String toString(){
       return action + data;
   }


}
