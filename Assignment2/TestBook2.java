import java.util.*;
class Author
{
		private String name;
		private String email;
		private char gender;

	public Author(String name,String email,char gender)
	{
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	public String getName()
	{
		return name;
	}
	public String getEmail()
	{
		return email;
	}
	public char getGender()
	{
		return gender;
	}
	public void setEmail(String email)
	{
		this.email = email ;
	}
}
 class Book
{
		private String name;
		private Author[] author;
		private double price;
		private int qty;
	Book(String name,Author[] author,double price)
	{
		this.name = name;
		this.price = price;
		this.author = author;
		this.qty = 0;
	}
	Book(String name, Author[] author, double price, int qty)
	{
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.author = author;
	}
	public String getName()
	{
		return name;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
	public double getPrice()
	{
		return price;
	}
	public void setQty(int qty)
	{
		this.qty = qty;
	}
	public int getQty()
	{
		return qty;
	}
	public Author[] getAuthor()
	{
		return author;
	}
}
class TestBook2
{
	public static void main(String args[])
	{	Scanner details = new Scanner(System.in);
		 int no_of_books;
		 String bname;
		 String gname;
		 String gemail;
		 double bprice;		
		 int ggender;
		 int bqty;
               	 String a_name;
		 String a_email;
		 char a_gender;
		System.out.println("Enter number of books");
		no_of_books = details.nextInt();
		Book[] b = new Book[no_of_books];
		int[] no_of_authors = new int[no_of_books];
		for (int i=0 ;i < no_of_books; i++)
			{	
				System.out.println("Enter Name of book");
				bname = details.next();
				System.out.println("Enter Price");
				bprice = details.nextDouble();
				System.out.println("Enter Quantity" );
				bqty = details.nextInt();	
				System.out.println("Enter number of Authors");
				no_of_authors[i] = details.nextInt();
				Author[] a = new Author[no_of_authors[i]];				
				for(int k=0; k<no_of_authors[i];k++)
				{	System.out.println("Enter the name of the author");
					a_name = details.next();			
                               	        System.out.println("Enter the mail id");
					a_email = details.next();
					System.out.println("Enter Gender");
					a_gender = details.next().charAt(0);
					a[k]= new Author(a_name, a_email, a_gender);
				}
				if (bqty!=0)
					b[i] = new Book(bname,a,bprice,bqty);
				else
					b[i] = new Book(bname,a,bprice);
			}
			
			System.out.println("*************************Book and Author Details************************ ");		
			for (int i=0 ;i< no_of_books; i++)
			{	bname = b[i].getName();
				bprice = b[i].getPrice();
				bqty = b[i].getQty();
				Author[] A = b[i].getAuthor();
				System.out.println("Book Name   :" + bname);
				System.out.println("Price 	  :" + bprice);
				System.out.println("Quantity    :" + bqty);
				for(int j=0;j<no_of_authors[i];j++)
				{	System.out.println("Author Name :" + A[j].getName());
					System.out.println("Email 	  :" + A[j].getEmail());
					System.out.println("Gender	  :" + A[j].getGender());
				}				
				+System.out.println("************************************************************");
				
			}	
			
	}
}

			
