import convertor.Convertor;
import java.util.*;
import java.text.DecimalFormat;

class TestCurrency
{
	
	public static void main(String[] args)
	{	
		Convertor c = new Convertor();
		Scanner det = new Scanner(System.in);
		String INR;
		String YEN;
		String Dollar;
		float converted;
		DecimalFormat f = new DecimalFormat("##.00");
		try
		{		
				System.out.println("Enter INR");
				INR = det.next();
				float val = Float.parseFloat(INR);	
				converted = c.INR_to_Yen(val);
				System.out.println(INR + " ₹ " + " in " + " ¥, : " + f.format(converted));
				converted = c.INR_to_Dollar(val);
				System.out.println(INR +" ₹ " + " in " + " $ : " + f.format(converted));
		}
		catch (Exception e)
		{	
				System.out.println(e);
		}
		try
		{	
			System.out.println("Enter Yen");
			YEN = det.next();
			float val = Float.parseFloat(YEN);
			converted = c.Yen_to_INR(val);
			System.out.println(YEN + " ¥, " + " in " + " ₹ : " + f.format(converted));
			converted = c.Yen_to_Dollar(val);
			System.out.println(YEN + " ¥, " + " in " + " $ : " + f.format(converted));
		}
		catch (Exception e)
		{
				System.out.println(e);
		}
		try
			{	System.out.println("Enter Dollar");
				Dollar = det.next();
				float val = Float.parseFloat(Dollar);	
				converted = c.Dollar_to_INR(val);
				System.out.println(Dollar +" $ "+ " in " + " ₹ : " + f.format(converted));
				converted = c.Dollar_to_Yen(val);
				System.out.println(Dollar + " $ " + " in " + " ¥, : " + f.format(converted));
			}
		catch (Exception e)
			{
				System.out.println(e);
			}

	}	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
