import java.util.*;
class Account
{
	private String cname;
	private String pan;
	private int accno;
	private String branch;
	private float balance;
	Account(String cname,int accno,String branch,float balance)
	{
		this.cname = cname;
		this.accno = accno;
		this.branch = branch;
		this.balance = balance;
		this.pan = "None";
	}
	Account(String cname,String pan, int accno, String branch, float balance)
	{
		this.cname = cname;
		this.accno = accno;
		this.branch = branch;
		this.balance = balance;
		this.pan = pan;
	}
	public int getAcno()
	{
		return accno;
	}
	public String getcname()
	{
		return cname;
	}
	public String getPan()
	{
		return pan;
	}
	public String getBranch()
	{
		return branch;
	}
	public float getBal()
	{
		return balance;
	}
	public void setPan(String pan)
	{
		this.pan = pan;
	}
	public void setBalance(float balance)
	{
		this.balance = balance;
	}
	public void deposit(int accno, float amt) throws PANRequiredException
	{
		this.accno = accno;
		if ((amt > 50000) && this.pan.equals("None"))
			throw new PANRequiredException();
		this.balance = this.balance + amt;
		
	}
	public void withdraw(int accno, float amt) throws NoEnoughMoneyException,MinBalRequiredException
	{	
		this.accno = accno;
		if (this.balance < amt)
			throw new NoEnoughMoneyException();
		else if (this.balance - amt < 1000)
			throw new MinBalRequiredException();
		this.balance = this.balance - amt;
		
	}
	/*public void Account_Search(Account[] acc , int n , int c_acno) throws AccountNotFoundException
	{
		for(int i = 0 ; i < n ;i++)
		{   	
			if (acc[i].getAcno() == c_acno)
			{
				System.out.println("***************Account Found****************");
				System.out.println("Account Details :");
				System.out.println( "Name    : " + acc[i].getcname());
				System.out.println( "PAN     : " + acc[i].getPan());
				System.out.println( "Branch  : " + acc[i].getBranch());
				System.out.println( "Balance : " + acc[i].getBal());
				break;
				
			}
			else
				throw new AccountNotFoundException();
		 }*/
		
	}
	class PANRequiredException extends Exception
	{
	int detail;
	PANRequiredException()
		{
		detail = 1;
		}
	public String toString()
		{
		return "PAN Required"+"["+detail+"]";
		}
	} 
	class AccountNotFoundException extends Exception
	{
	int detail;
	AccountNotFoundException()
		{
		detail = 2;
		}
	public String toString()
		{
		return "Account Not Found! !"+"["+detail+"]";
		}
	}
	class MinBalRequiredException extends Exception
	{
	int detail;
	MinBalRequiredException()
		{
		detail = 3;
		}
	public String toString()
		{
		return "Minimum Balance Required!"+"["+detail+"]";
		}
	}
	class NoEnoughMoneyException extends Exception
	{
	int detail;
	NoEnoughMoneyException()
		{
		detail = 4;
		}
	public String toString()
	{
		return "Not Enough Money !"+"["+detail+"]";
	}
	}	
class ErrorHandlingCase1
{	
	public static void Account_Search(Account[] acc , int n , int c_acno) throws AccountNotFoundException
	{
		for(int i = 0 ; i < n ;i++)
		{   	
			if (acc[i].getAcno() == c_acno)
			{
				System.out.println("***************Account Found****************");
				System.out.println("Account Details :");
				System.out.println( "Name    : " + acc[i].getcname());
				System.out.println( "PAN     : " + acc[i].getPan());
				System.out.println( "Branch  : " + acc[i].getBranch());
				System.out.println( "Balance : " + acc[i].getBal());
				break;
				
			}
			else
				throw new AccountNotFoundException();
		 }
	}
	public static void main(String[] args)
	{
		Scanner det = new Scanner(System.in);
		String customer_name;
		String branch;
		float balance;
		String pan;	
		int acno;	
		int no_of_people;
		String choice;
		int amt;
		System.out.println("Enter no of people");
		no_of_people = det.nextInt();		
		Account[] a = new Account[no_of_people];
		for(int i = 0; i< no_of_people ; i++)
		{
			System.out.println("Enter customer name ");
			customer_name = det.next();
			System.out.println("Enter account number");
			acno = det.nextInt();
			System.out.println("Enter Branch");
			branch = det.next();
			System.out.println("Enter Balance");
			balance = det.nextFloat();
			System.out.println("Do you have a PAN no?");
			choice = det.next();
			if (choice.equals("yes"))
			{	
				pan = det.next();
				a[i] = new Account(customer_name,pan,acno,branch,balance) ;
			}
			else
				a[i] = new Account(customer_name,acno,branch,balance) ;
		}
//***************************************************************************************************************************************		
		
//*****************************************************************************************************************************************
		int ch;
		int flag = 0;
		do
		{
		System.out.println(" 1. Deposit .");
		System.out.println(" 2. Withdraw .");
		System.out.println(" 3. Search .");	
		System.out.println(" 4 .Exit .");
		System.out.println("Enter choice ");
		ch = det.nextInt();
		
		if(ch == 1)
		{	
		System.out.println("Enter account no for deposit");
		acno = det.nextInt();
		for (int i = 0;i <no_of_people; i++)
			{	
			if (a[i].getAcno() == acno)
				{	
						System.out.println("*************************************************");
						System.out.println(" Account Details ");
						System.out.println( "Name        : " + a[i].getcname());
						System.out.println( "PAN     	   : " + a[i].getPan());
						System.out.println( "Branch      : " + a[i].getBranch());
						System.out.println( "Old Balance : " + a[i].getBal());
						System.out.println("*************************************************");
						
					System.out.println("Enter amount to be deposited");				
					amt = det.nextInt();
					try
						{
						a[i].deposit(acno,amt);	
						System.out.println("*************************************************");
						System.out.println(" Account Details ");
						System.out.println( "Name        : " + a[i].getcname());
						System.out.println( "PAN     	   : " + a[i].getPan());
						System.out.println( "Branch      : " + a[i].getBranch());
						System.out.println( "New Balance : " + a[i].getBal());
						System.out.println("*************************************************");
						}
					catch(Exception e)
						{System.out.println("Exception : " + e );}
					flag = 1;
					break;
				}
		
			}
			if (flag == 0)
				System.out.println("Account Not Found");
		
		}
//***************************************************************************************************************************************
		else if (ch == 2)
		{
		System.out.println("Enter account no for withdrawal");
		acno = det.nextInt();
		for (int i = 0;i <no_of_people; i++)
		{
			if (a[i].getAcno() == acno)
			{	
						System.out.println("*************************************************");
						System.out.println(" Account Details ");
						System.out.println( "Name        : " + a[i].getcname());
						System.out.println( "PAN     	   : " + a[i].getPan());
						System.out.println( "Branch      : " + a[i].getBranch());
						System.out.println( "Old Balance : " + a[i].getBal());
						System.out.println("*************************************************");
						
				System.out.println("Enter amount to be withdrawn");
				amt = det.nextInt();
				try
					{
					a[i].withdraw(acno,amt);
					System.out.println("*************************************************");
					System.out.println(" Account Details ");
					System.out.println( "Name        : " + a[i].getcname());
					System.out.println( "PAN     	   : " + a[i].getPan());
					System.out.println( "Branch      : " + a[i].getBranch());
					System.out.println( "New Balance : " + a[i].getBal());
					System.out.println("*************************************************");
					}
				catch(Exception e)
				{
					System.out.println("Exception : " + e );
				}
			}
		}	
		}
	
		else if (ch == 3)
		{
		System.out.println("Enter account number to be searched");
		acno = det.nextInt();
		try			
			{	
				ErrorHandlingCase1.Account_Search(a,no_of_people,acno);
			}
		catch(Exception e)
			{
				System.out.println("Exception : " + e );
			}
		}
		}while (ch!=4);
	}
}
			
			
	

