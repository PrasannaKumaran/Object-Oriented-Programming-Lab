import java.util.*;
class Person
{
	String name;
	String address;
	Person(String name, String address)
	{
		this.name = name;
		this.address = address;
	}
	String getName()
	{	
		return name;
	}
	String getAddress()
	{	
		return address;
	}
	void setAddress(String address)
	{
		this.address = address;
	}
}
class Employee extends Person
{	
	private int empid;
	private String dept;
	private int basic;
	Employee(String name, String address, int empid, String dept, int basic)
	{
		super(name,address);
		this.empid = empid;
		this.dept = dept;
		this.basic = basic;
	}
	int getEmpid()
	{
		return empid;
	}
	String getDept()
	{
		return dept;
	}
	void setDept(String dept)
	{
		this.dept = dept;
	}
	void setBasic(int basic)
	{
		this.basic = basic;
	}
	int getBasic()
	{
		return basic;
	}
	float calSalary()
	{
		float gross,ded;
       		gross = getBasic() + 0.3f*getBasic() + 0.1f*getBasic();
		ded = 0.095f*getBasic() + 0.09f*getBasic();
		return gross-ded;
	}
}
class Faculty extends Employee
{
	private String designation;
	private String course;
	Faculty(String name, String address, int empid, String dept, int basic,String desingation, String course)
	{
		super(name,address,empid,dept,basic);
		this.designation = designation;
		this.course = course;
	}
	String getDesig()
	{	
		return designation;
	}
	void setDesig(String designation)
	{
		this.designation = designation;
	}
	void setCourse(String course)
	{
		this.course = course;
	}
	String getCourse()
	{
		return course;
	}
	float calSalary()
	{
		float gross,ded;
        		gross = getBasic() + 0.3f*getBasic() + 0.1f*getBasic();
		ded = 0.095f*getBasic() + 0.09f*getBasic();
		return gross-ded;
	}
}
interface Student
{
	float[] getMarks();
	float calcGPA();
}
class ResearchAssistant extends Employee implements Student
{
	private float[] marks;
	private String project;
	private String course;
	ResearchAssistant(String name, String address, int empid, String dept, int basic, String project, String course,float[] marks)
	{
		super(name,address,empid,dept,basic);
		this.project = project;
		this.course = course;
		this.marks = marks;
	}
	String getProject()
	{
		return project;
	}
	String getCourse()
	{
		return course;
	}
	void setCourse(String course)
	{
		this.course = course;
	}
	public float [] getMarks()
	{	
		return marks;	
	}
	public float calcGPA()
	{
		float total = 0;
		float avg = 0;
		for (int i = 0; i < 3; i++)
			total += marks[i];
		avg = total /3.0f;
		if (avg > 80)
			return 4.0f;
		else if (avg > 60)
			return 3.0f;
		else if (avg > 40)
			return 2.5f;
		else
			return 2.0f;
	}
}
class TestPoly
{
     public static void main(String args[])
      {
        Scanner in = new Scanner(System.in);
        String name, address, dept, desig, course, project;
        int empid;
        int basic;
        float marks[] = new float[3];
        System.out.println(" ************ Employee********** ");
        System.out.println(" Enter Name : ");
        name = in.next();
        System.out.println(" Enter Address: ");
        in.nextLine();
        address = in.nextLine();
        System.out.println(" Enter Emp ID: ");
        empid = in.nextInt();
        System.out.println(" Enter Department: ");
        dept = in.next();
        System.out.println(" Enter Basic: ");
        basic = in.nextInt();
        System.out.println("**********************EMPLOYEE DETAILS***************");
        Employee E = new Employee(name, address, empid, dept, basic);
        System.out.println(" Name: "+ E.getName());
        System.out.println(" Address: "+ E.getAddress());
        System.out.println(" Emp ID: "+ E.getEmpid());
        System.out.println(" Department: "+E.getDept());
        System.out.println(" Basic: "+ E.getBasic());
        System.out.println(" Salary: "+ E.calSalary());
        
        
        System.out.println(" *********** Faculty ************ ");
        System.out.println(" Enter Name : ");
        name = in.next();
        System.out.println(" Enter Address: ");
        in.nextLine();
        address = in.nextLine();
        System.out.println(" Enter Emp ID: ");
        empid = in.nextInt();
        System.out.println(" Enter Department: ");
        dept = in.next();
        System.out.println(" Enter Designation: ");
        desig = in.next();
        System.out.println(" Enter Course: ");
        course = in.next();
        System.out.println(" Enter Basic: ");
        basic = in.nextInt();
        System.out.println("**********************FACULTY DETAILS *************************");
        Faculty F = new Faculty(name, address, empid, dept, basic, desig, course);
        System.out.println(" Name: "+ F.getName());
        System.out.println(" Address: "+ F.getAddress());
        System.out.println(" Emp ID: "+ F.getEmpid());
        System.out.println(" Department: "+F.getDept());
        System.out.println(" Basic: "+ F.getBasic());
        System.out.println(" Salary: "+ F.calSalary());
        
        
        System.out.println(" *************Research Assistant************* ");
        System.out.println(" Enter Name : ");
        name = in.next();
        System.out.println(" Enter Address: ");
        in.nextLine();
        address = in.nextLine();
        System.out.println(" Enter Emp ID: ");
        empid = in.nextInt();
        System.out.println(" Enter Department: ");
        dept = in.next();
        System.out.println(" Enter Project: ");
        project = in.next();
        System.out.println(" Enter Course: ");
        course = in.next();
        System.out.println(" Enter Basic: ");
        basic = in.nextInt();
        System.out.println(" Enter Marks: ");
        for(int i=0;i<3;i++)
        {
            System.out.println(" Enter Mark for Subject "+(i+1));
            marks[i]=in.nextInt();
        }
        System.out.println("*************R.Asst DETAILS**********************");
        ResearchAssistant R = new ResearchAssistant(name, address, empid, dept, basic, project, course,marks);
        System.out.println(" Name: "+ R.getName());
        System.out.println(" Address: "+ R.getAddress());
        System.out.println(" Emp ID: "+ R.getEmpid());
        System.out.println(" Department: "+R.getDept());
        System.out.println(" Basic: "+ R.getBasic());
        System.out.println(" Project: "+R.getProject());
        System.out.println(" Course: "+R.getCourse());
        marks = R.getMarks();
        for(int i=0;i<3;i++)
        { 
            System.out.println(" Mark for Subject "+(i+1)+" is "+marks[i]);
        }
        System.out.println(" Salary: "+ R.calSalary());
    }	
}




































