import java.util.Scanner;
import static java.lang.Math.*;

public class Glass {
   private int amount;
   private int volume;
   private static int pours = 0;
   
   public Glass(int amount, int volume)
   {
      this.amount = amount;
      this.volume = volume;
   }
   
   public int getAmount()
   {  
      return amount;
   }
   
   public String toString()
   {
      return amount + "/" + volume;
   }
   
  public void display()
  {
      System.out.println(this);
  }
   
  public static int getPours()
  {
      return pours;
  }  
  
  public void pour(Glass from) 
  {
      pours++;
      int space = volume - amount;
      // int space = this.volume - this.amount;
      //int transfer = Math.min(space, from.amount);
      int transfer = min(space, from.amount);
      amount += transfer;
      from.amount -= transfer;
  }
  
  
  public static void play()
  {
      /*
      Glass[] glasses = new Glass[3];
      glasses[0] = new Glass(0,3);
      glasses[1] = new Glass(0,5);
      glasses[2] = new Glass(8,8);
      */
      
      
      //Glass[] glasses = new Glass[3]; {new Glass(0,3); new Glass(0,5); new Glass(8,8);};
      Glass[] glasses = {new Glass(0,3), new Glass(0,5), new Glass(8,8)};
      Scanner input = new Scanner(System.in);
      
      while (glasses[1].getAmount() != 4 && glasses[2].getAmount() !=4)
      {
         for (int i = 0; i < glasses.length; i++)
            System.out.printf("Glass %d: %s%n", i +1, glasses[i]);
            
            int source = 0;
            int destination = 0;
            
            System.out.print("Pour from glass <1, 2, 3, or 4 to quit>: ");
            source = input.nextInt();
            
            if (source == 4)
               System.exit(0);
               
            System.out.print("Pour to glass <1, 2, 3, or 4 to quit>: ");
            destination = input.nextInt();
            
            if (destination == 4)
               System.exit(0);
               
            if (source > 0 && source <= 3 && destination > 0 && destination <= 3)
               glasses[destination - 1].pour(glasses[source - 1]);
      }
      
      System.out.println("\n\nYou have solved the puzzle in " + Glass.getPours() + " pours");
      
      for (Glass g : glasses) 
         g.display();
  
  }
  
  
  
	public static void main(String[] args)
	{
      Glass.play();

	}
}