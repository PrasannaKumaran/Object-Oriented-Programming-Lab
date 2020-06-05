
import java.util.Random;
import java.util.Scanner;
public class NumberGuess {

   int number_of_trials;
   int random_no;
   
   public int random_generator()
           
   {
       Random rand=new Random();
       int x=rand.nextInt(100);
       return x;
       
   }

    public static void main(String[] args) {
       
        NumberGuess guess=new NumberGuess();
        int random_no=guess.random_generator();
        int trials=0;
        Scanner ch = new Scanner(System.in);
        int choices=ch.nextInt();
        System.out.println("Enter your chocie \n");
        while(choices!=random_no)
        {
            if(choices>random_no)
            {
                System.out.print("Enter lower \n");
                choices=ch.nextInt();
                trials++;
            }
            else if(choices<random_no)
            {
                System.out.print("Enter Higher \n");
                choices=ch.nextInt();
                trials++;
            }
           
        }
        System.out.print("The no is \n");
        System.out.print(random_no);
        System.out.print("Congratz no of trials taken is : \n");
        System.out.print(trials);
        
}
}