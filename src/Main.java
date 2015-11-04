import java.util.Random;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		double thirst = 3;
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		int inventory = 0;
		int days=0;
		while(thirst!=0)
		{
			int watermelon=r.nextInt(3)+1;
			//System.out.println("The watermelon is under rock "+watermelon+"!");
			System.out.println("You have been stranded for "+days+" days!");
			System.out.println("You have "+thirst+" days of hydration!");
			System.out.println("You have "+inventory+" watermelons in your satchel!");
			System.out.println("Rock 1,2,or3, or eat?");
			int choice = -1;
			String str=in.nextLine();
			try
			{
				choice = Integer.parseInt(str);
			}
			catch(NumberFormatException e)
			{
				if(str.equalsIgnoreCase("eat"))
				{
					if(inventory>0)
					{
						inventory--;
						thirst=3;
					}
					else
					{
						System.out.println("You have no more watermelons in your satchel!");
					}
					continue;
				}
				System.out.println("Bad input!");
				continue;
			}
			if(choice<1 || choice>3)
			{
				System.out.println("Bad input!");
				continue;
			}
			thirst--;
			if(choice==watermelon)
			{
				System.out.println("You found a watermelon!");
				System.out.println("Eat or keep?");
				str="";
				while(!(str.equalsIgnoreCase("keep") || str.equalsIgnoreCase("eat")))
				{
					str = in.nextLine();
					if(!(str.equalsIgnoreCase("keep") || str.equalsIgnoreCase("eat")))
					{
						System.out.println("Bad input!");
					}
				}
				if(str.equalsIgnoreCase("keep"))
				{
					inventory++;
				}
				if(str.equalsIgnoreCase("eat"))
				{
					thirst=3;
				}
			}
			if(thirst==0)
			{
				if(inventory>0)
				{
					inventory--;
					thirst=3;
					System.out.println("You ate a watermelon to save yourself!");
				}
			}
			days++;
		}
		System.out.println("You died!");
	}

}
