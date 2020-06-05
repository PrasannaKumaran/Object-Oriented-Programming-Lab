
import java.util.Scanner;
public class E_Bill {
    public int consumer_no;
    public String Consumer_name;
    public int prev_month_reading;
    public int cur_month_reading;
    public String type_of_connection;
    public double Bill;
    public int readings;
    

    E_Bill(int consumer_no,String Consumer_name,int prev_month_reading,int cur_month_reading,String type_of_connection)
            
    {
      this.consumer_no=consumer_no;
      this.Consumer_name=Consumer_name;
      this.cur_month_reading=cur_month_reading;
      this.prev_month_reading=prev_month_reading;
      this.type_of_connection=type_of_connection;
    }
    public double domestic()
            {   int readings=cur_month_reading - prev_month_reading;
     if(readings<=100)
         Bill=readings*1;
     else if(readings>100 && readings<=200)
         Bill=100+((readings-100)*2.50);
     else if(readings>200 && readings<=500)
         Bill=100+100*2.50+((readings-200)*4);
     else 
         Bill=100+100*2.50+300*4+((readings-500)*6);
          System.out.println("Readings :"+readings+"\n");
     return Bill;
            }
    public double commercial()
            { int readings=cur_month_reading - prev_month_reading;
     if(readings<=100)
         Bill=readings*2;
     else if(readings>100 && readings<=200)
         Bill=200+((readings-100)*4.50);
     else if(readings>200 && readings<=500)
         Bill=200+450+((readings-200)*6);
     else 
         Bill=200+450+1800+((readings-500)*7);
          System.out.println("Readings"+readings); 
     return Bill;
            }
            
public static void main(String args[])
{   int pre_read;
    int cur_read;
    String user_name;
    int  u_id;
    String u_type;
    Scanner cus=new Scanner(System.in);
    System.out.println("Enter customer name ");
    user_name=cus.nextLine();
    System.out.println("Enter customer id ");
    u_id=cus.nextInt();
    System.out.println("Enter type of connection Commerical/Domestic ");
    u_type=cus.next();
    System.out.print("Enter previous month reading ");
    pre_read=cus.nextInt();
    System.out.print("Enter current month reading ");
    cur_read=cus.nextInt();
    E_Bill new_customer= new E_Bill(u_id,user_name,pre_read,cur_read,u_type);
    System.out.print("\n \n********** Bill********* \n");
    double Bill_amount=0;    
    if (new_customer.type_of_connection.equals("Domestic"))
           Bill_amount=new_customer.domestic();
    else if(new_customer.type_of_connection.equals("Commercial"))
        Bill_amount=new_customer.commercial();
    System.out.println("Customer No :"+new_customer.consumer_no+"\n");
    System.out.println("Customer Name:"+new_customer.Consumer_name+"\n");
    System.out.println("Connection Type: "+new_customer.type_of_connection+"\n");
    System.out.println("Previous Reading: "+new_customer.prev_month_reading+"\n");
    System.out.println("Current Reading: "+new_customer.cur_month_reading+"\n"); 
    System.out.println("Bill Amount: "+Bill_amount);
}
}

