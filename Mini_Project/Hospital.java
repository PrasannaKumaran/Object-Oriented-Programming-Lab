package Hospital;

public class Hospital 
{
	private String name;
	private String address;
	private long  ph_no;
	private int no_of_doctors;
	private int in_patients;
	private int no_of_admin;
	public 
	Hospital(String name, String address,long ph_no,int no_of_doctors,int in_patients,int no_of_tech)
	{
		this.name = name;
		this.address = address;
		this.ph_no = ph_no;
		this.no_of_doctors = no_of_doctors;
		this.in_patients = in_patients;
		this.no_of_admin = no_of_tech;
	}
	public long getPh()
	{
		return ph_no;
	}
	public String getAddress()
	{
		return address;
	}
        public void display()
        {
         System.out.println("\n\nDetails of "+name+" hospital");
         System.out.println("Address : "+address);
         System.out.println("Phone no : "+ph_no);
         System.out.println("Doctor capacity : "+no_of_doctors);
         System.out.println("Patients capacity : "+in_patients);
         System.out.println("Administrator capacity : "+no_of_admin);
        }
}


