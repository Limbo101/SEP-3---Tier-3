import java.io.Serializable;

public class Package implements Serializable
{
   private String name;
   private String text;

   public Package(String operation, String text)
   {
      this.name = operation;
      this.text = text;
   }

   public String getText()
   {
      return text;
   }

   public String getName()
   {
      return name;
   }

}