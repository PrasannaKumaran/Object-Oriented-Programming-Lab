import java.util.Scanner;
public class Students {

        public int id;
        public String department;
        public char grade;
        public double total;
        public String Student_name;
        public int marks[]= new int[3];
        public int no_of_students;
    public void Search(int x,Students[] s,int no_of_students)
    {   int flag=0;    
        for(int i=0;i<no_of_students;i++)
        {
            if (x==s[i].id)
            {   
                System.out.println("Student record found !");
                flag=1;
                break;
            }
        }
        if (flag==0)
            System.out.println("Student record not found !");
            
    }
    public void Search(String Dept,Students[] s,int no_of_students)
        {   int flag=0;
            for(int i=0;i<no_of_students;i++)
            {     if (s[i].department.equals(Dept))
                {   System.out.println("Student record found !");
                    flag=1;
                    break;
                }
            }
            if (flag==0)
                System.out.println("Student record not found!");
        }
    public void stu_total(Students[] stud,int no_of_students)
            
    {
        for(int i=0;i<no_of_students;i++)
            for(int j=0;j<3;j++)
                stud[i].total+=stud[i].marks[j];
        for(int i=0;i<no_of_students;i++)
               if((stud[i].total/3)>80)
                   stud[i].grade='A';
               else if((stud[i].total/3)>60&& (stud[i].total/3)<80)
                   stud[i].grade='B';
               else if((stud[i].total/3)>40&& (stud[i].total/3)<60)
                   stud[i].grade='C';
               else
                   stud[i].grade='R';
    }
    
    public void display(Students[] stud,int nos)
    { System.out.println("************Student Details************ \n");
      System.out.println("ID        Name        Department      Marks       Total       Grade \n ");
      for(int i=0;i<nos;i++)
           System.out.println(stud[i].id +"           " +stud[i].Student_name+"        " + stud[i].department +"         "+ stud[i].marks[0] +" "+stud[i].marks[1] +" "+stud[i].marks[2]+"      "+stud[i].total+"       "+stud[i].grade);        }
    
    public void marksheet(Students[] stud,int nos,int S_id)
    {
           for(int i=0;i<nos;i++)
           {
               if(stud[i].id==S_id)
               {
                   System.out.println("*********** Student Marksheet*********");
                   System.out.println("ID        Name        Department      Marks      Total     Greade\n ");
                   System.out.println(stud[i].id +"           " +stud[i].Student_name+"        " + stud[i].department +"         "+ stud[i].marks[0] +" "+stud[i].marks[1] +" "+stud[i].marks[2]+"      "+stud[i].total+"       "+stud[i].grade);
               }
           }
    }
    public static void main(String args[])
    {       
        Scanner stu_det=new Scanner(System.in);
        int n;
        System.out.println("Enter no of students ");
        Students st=new Students();
        n=stu_det.nextInt();
        Students[] s=new Students[n];
        for(int i=0;i<n;i++)
            s[i]=new Students();
        int choice;
        int search_id;
        String search_dept;
        do
        {
        System.out.println("Main Menu \n");
        System.out.println("1.Input Details \n");
        System.out.println("2.Display \n");
        System.out.println("3.Mark sheet for a student \n");
        System.out.println("4.Search by id \n");
        System.out.println("5.Search by department \n");
        System.out.println("6.Exit");
        System.out.println("Enter choice");
        choice=stu_det.nextInt();
        if(choice==1)
        {
       		System.out.println("Enter the student Details ");
        	for(int i=0;i<n;i++)
       		 {
        	    System.out.println("\nEnter Student name");
      		      s[i].Student_name=stu_det.next();
      		      System.out.println("Enter Student id");
      		      s[i].id=stu_det.nextInt();
      		      System.out.println("Enter Department");
      		      s[i].department=stu_det.next();
      		      System.out.println("Enter Marks scored in 3 subjects");
      		      for(int j=0;j<3;j++)
      		          s[i].marks[j]=stu_det.nextInt();
     		   }
        st.stu_total(s,n);
       	}
        else if (choice==2)
               st.display(s,n);
        else if (choice==3)     
        {   int s_id;
            System.out.println("Enter student id ");
                s_id=stu_det.nextInt();
            st.marksheet(s,n,s_id);
        }
        else if(choice==4)
        {
            System.out.println("Enter id no to be searched");
            search_id=stu_det.nextInt();
            st.Search(search_id,s,n);
        }
        else if(choice==5)
        {
            System.out.println("Enter department to be searched");
            search_dept=stu_det.next();
            st.Search(search_dept,s,n);
        }
        
        }while(choice!=6);
}
}
