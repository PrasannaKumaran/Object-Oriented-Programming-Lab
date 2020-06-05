//package project;

import Hospital.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.*;
class Person
{
	private String Title;
	private String Name;
	private String DoB;
	private String gender;
	private String Home_address;
	private long ph_no;
	
	Person(String Title,String Name,String DoB,String gender,String Home_address,long ph_no)
	{
		this.Title = Title;
		this.Name = Name;
		this.DoB = DoB;
		this.gender = gender;
		this.Home_address = Home_address;
		this.ph_no = ph_no;
	}
	public String getName()
	{
		return Name;
	}
	public String getDoB()
	{
		return DoB;
	}
	public String getTitle()
	{
		return Title;
	}
}
class Patient extends Person
{
	private int patient_id;
	private String sickness;  
	private int threat_level;
	private String allergy;
	private String[] prescription;
	float no_of_bed_days;
	public float bill;
	private String jdate;
	
	public Patient(String Title,String Name,String DoB,String gender,String Home_address,int patient_id,String sickness,String allergy,String[] prescription,long ph_no,int threat_level,String jdate)
	{
		super(Title,Name, DoB,gender,Home_address,ph_no);
		this.patient_id = patient_id;
		this.sickness = sickness;
		this.allergy = allergy;
		this.prescription = prescription;
		this.threat_level = threat_level;
		this.bill = 0;
		this.no_of_bed_days =0;
		this.jdate = jdate;
	}
	public String getSickness()
	{
		return sickness;
	}
	public String getAllergy()
	{
		return allergy;
	}
	public String[] getPrescription()
	{
		return prescription;
	}
	public String getJdate()
	{
		return jdate;
	}
	public void calBill(Doctor doc[])
	{
		switch(threat_level)
		{
			case 1: 
				bill = (1.15f * no_of_bed_days * 5000) +  (1*4000) + 500;
				break;
			case 2: 
				bill = (1.15f * no_of_bed_days * 5000) +  (2*4000) + 1500;
				break;
			case 3: 
				bill = (1.15f * no_of_bed_days * 5000) +  (3*4000) + 2500;
				break;
			case 4: 
				bill = (1.15f * no_of_bed_days * 5000) +  (4*4000) + 3500;
				break;
		}
		printBill(doc);
	}
	public void printBill(Doctor doc[])
	{
		
		System.out.println("****************************** PATIENT REPORT *************************");
		System.out.println("Name		: " + getName());
		System.out.println("DoB		: " + getDoB());
		System.out.println("Sickness		: " + getSickness());
		System.out.println("Allergy		: " + getAllergy());
		System.out.println("Prescription	: ");
		String[] pres = getPrescription();
		for(int i=0; i< pres.length; i++)
			System.out.println( i + "." + pres[i]);
		System.out.println("Admission Date	: " + getJdate());
		System.out.println("Admitted Days	: " + no_of_bed_days);
		System.out.println("Doctors Incharge : ");
		for(int i=0;i<threat_level;i++)
		{
			String na = doc[i].getName();
			System.out.println(na);
		}
		System.out.println("Bill Amount 	: " + bill);
	}
		
}
interface staff 
{
	String getJoiningDate();
	String[] getEducation();
	float getSalary();
        void display();
}

class Doctor extends Person implements staff
{	
	private int experience;
	private String speciality;
	private String[] Education;
	private String JoiningDate;
	private float Salary;		
	
	public String getJoiningDate()
	{
		return JoiningDate;
	}
	public String[] getEducation()
	{
		return Education;
	}
	public float getSalary()
	{
		return Salary;
	}
	public int getExperience()
	{
		return experience;
	}
	public void setExperience(int experience)
	{
		this.experience = experience;
	}
	public void setSalary(int Salary)
	{
		this.Salary = Salary;
	}
	
	Doctor(String Title,String Name,String DoB,String gender,String Home_address,long ph_no,int experience, String speciality,String[] Education,String JoiningDate,float Salary)
	{
		super(Title, Name, DoB, gender, Home_address, ph_no);
		this.experience = experience;
		this.speciality = speciality;
		this.Education = Education;
		this.JoiningDate = JoiningDate;
		this.Salary = Salary;
	}
        
        public void display(){
            System.out.println("\n\nDoctor Details");
            System.out.println("Experience : "+experience);
            System.out.println("Speciality : "+speciality);
            System.out.println("Joining date"+JoiningDate);
            System.out.println("Salary : "+Salary);
        }
	
}
class Admin extends Person implements staff
{
	private int experience;
	private String[] Education;
	private String JoiningDate;
	private float Salary;
	private int clearance;		
	
	public String getJoiningDate()
	{
		return JoiningDate;
	}
	public String[] getEducation()
	{
		return Education;
	}
	public float getSalary()
	{
		return Salary;
	}
	public int getExperience()
	{
		return experience;
	}
	public void setExperience(int experience)
	{
		this.experience = experience;
	}
	public int getClearance()
	{
		return clearance;
	}
	Admin(String Title,String Name,String DoB,String gender,String Home_address,long ph_no,int experience,String[] Education,String JoiningDate,float Salary,int clearance)
	{
		super(Title, Name, DoB, gender, Home_address, ph_no);
		this.experience = experience;
		this.Education = Education;
		this.JoiningDate = JoiningDate;
		this.Salary = Salary;
		this.clearance = clearance;
	}
        
        public void display(){
            System.out.println("\n\nAdmin Details");
            System.out.println("Experience : "+experience);
            System.out.println("Joining date : "+JoiningDate);
            System.out.println("Salary : "+Salary);
            System.out.println("Clearance : "+clearance);
        }
}


    
    

/* EXCEPTIONS */
class StaffNotFoundException extends Exception
{
	private int det;
	StaffNotFoundException()
	{
		det = 1;
	}
	public String toString()
	{
		return "Staff Not Found in the Database " + " \n Exception" + det;
	}
} 
class AdminNotFoundException extends Exception
{
	private int det;
	AdminNotFoundException()
	{
		det = 7;
	}
	public String toString()
	{
		return "Tech Not Found in the Database " + " \n Exception" + det;
	}
} 

class DoctorNotFoundException extends Exception
{
	private int det;
	DoctorNotFoundException()
	{
		det = 6;
	}
	public String toString()
	{
		return "Doctor Not Found in the Database " + " \n Exception" + det;
	}
} 

class PatientNotFoundException extends Exception
{
	private int det;
	PatientNotFoundException()
	{
		det = 2;
	}
	public String toString()
	{
		return "Patient Not Found in the Database " + " \n Exception" + det;
	}
} 
class PatientCountException extends Exception
{	

	private int det;
	PatientCountException()
	{
		det = 3;
	}
	public String toString()
	{
		return "No more patients can be accomodated!  " + " \n Exception" + det;
	}
}
class DoctorCountException extends Exception
{	

	private int det;
	DoctorCountException()
	{
		det = 4;
	}
	public String toString()
	{
		return "No more Doctors can be hired!!  " + " \n Exception" + det;
	}
}

class AdminCountException extends Exception
{	

	private int det;
	AdminCountException()
	{
		det = 5;
	}
	public String toString()
	{
		return "No more Administrators can be hired!!  " + " \n Exception" + det;
	}
}




/*END OF EXCEPTION				*/

class Project
{
	public int patient_search_details(Patient[] pat,int np, String name) throws PatientNotFoundException
	{
		int flag = 0;
		int pos =0;
		for(int i = 0 ;i <np; i++)
    		{ 
    			String check =pat[i].getName();
    			if(check.equals(name))
    			{
    				pos = i;
    				flag =1;
    				break;
    			}
    		}
    		if (flag == 0)
    			throw new PatientNotFoundException();
    		else
    			return pos;
        						        	
	}	
	public int doctor_search_details(Doctor[] doc,int nd, String name) throws DoctorNotFoundException
	{
		int flag = 0;
		int pos =0;
		for(int i = 0 ;i <nd; i++)
    		{ 
    			String check =doc[i].getName();
    			if(check.equals(name))
    			{
    				pos = i;
    				flag =1;
    				break;
    			}
    		}
    		if (flag == 0)
    			throw new DoctorNotFoundException();
    		else
    			return pos;
        						        	
	}	
	public int admin_search_details(Admin[] tech,int nd, String name) throws AdminNotFoundException
	{
		int flag = 0;
		int pos =0;
		for(int i = 0 ;i <nd; i++)
    		{ 
    			String check =tech[i].getName();
    			if(check.equals(name))
    			{
    				pos = i;
    				flag =1;
    				break;
    			}
    		}
    		if (flag == 0)
    			throw new AdminNotFoundException();
    		else
    			return pos;
        						        	
	}	
	
	public void patient_count(int count,int np) throws PatientCountException
	{
		if(count == np)
			throw new PatientCountException();
	}
	public void doctor_count(int count,int nd) throws DoctorCountException
	{
		if(count == nd)
			throw new DoctorCountException();
	}
	public void admin_count(int count,int nt) throws AdminCountException
	{
		if(count == nt)
			throw new AdminCountException();
	}
				   
	public static void main(String args[])
	{	
		Project pro = new Project();
		Person per;
		Patient[] pat;
		Doctor[] doc;
		Admin[] tech;
		Hospital h;
		long pn;
		int ndoc;
		int n_inp;
		int ntech;
		String name,title,DoB,gender,address,sickness,allergy,speciality,jdate,dis_date;
		int threat;
		int exp,clearance;
		float sal;
		int id;
		int choice;
		int pcount =0 , dcount= 0, tcount= 0;
               
		Scanner det = new Scanner(System.in);
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		System.out.println("*****************************************************WELCOME ********************************************");
		System.out.println("\n\n\n\n\n\n\n");
		System.out.println("Enter the name of the Hospital");
		name = det.next();
		System.out.println("Enter the address ");
		address=det.next();
		System.out.println("Enter phone number");
		pn = det.nextLong();
		System.out.println("Enter Inpatient Capacity");
		n_inp = det.nextInt();
		System.out.println("Enter Doctor Capacity");
		ndoc = det.nextInt();
		System.out.println("Enter Administrators Capacity");
		ntech = det.nextInt();
		h = new Hospital(name,address,pn,ndoc,n_inp,ntech);
                h.display();
		pat = new Patient[n_inp];
		doc = new Doctor[ndoc];
		tech = new Admin[ntech];
		System.out.println("**********************************************************************************************************");
		do
		{	
			System.out.println(" \n\n************************Main Menu***********************");
			System.out.println("	1. Patient");
			System.out.println("	2. Staff  ");
			System.out.println("	3. Exit   ");
			System.out.println("	Enter choice");
			System.out.println("**********************************************************");
			choice = det.nextInt();
			switch(choice)
			{
				case 1: 
					int ch;
					System.out.println("**********************************************************");
					System.out.println(" 1. InPatient");
					System.out.println(" 2. OutPatient");
					System.out.println(" 3. Exit");
					System.out.println(" Enter Choice");
					ch = det.nextInt();
					System.out.println("**********************************************************");
					switch(ch)
					{
						case 1: 
						        System.out.println("Enter Patient ID");
						        id = det.nextInt();
						        System.out.println("Enter Patient Name");
						        name = det.next();
						        System.out.println("Date Of Birth (Format dd/mm/yyyy)");
						        DoB = det.next();
						        System.out.println("Gender");
						        gender = det.next();
						        System.out.println("Residential Address");
						        address = det.next();
						        System.out.println("Contact Number");
						        pn = det.nextLong();
						        System.out.println("Title if any *");
						        title= det.next();
						        System.out.println("Symptoms / Sickness ");
						        sickness = det.next();
						        System.out.println("Allergies");
						        allergy = det.next();
						        System.out.println("Life Threat Level ( 1 - 4 )");
						        threat = det.nextInt();
						        System.out.println("Enter Admission Date (Format dd/mm/yyyy)");
						        jdate = det.next();
						        int no_of_drugs;
						        System.out.println("Enter Number of drugs");
						        no_of_drugs = det.nextInt();
						        System.out.println("Prescription");
						        String[] pres = new String[no_of_drugs];
						        for(int i=0;i<no_of_drugs ; i++)
						        	pres[i] = det.next();
						        pat[pcount] = new Patient(title,name,DoB,gender,address,id,sickness,allergy,pres,pn,threat,jdate);
						        pcount+=1;
						        try
						        {
						        	pro.patient_count(pcount,n_inp);
						        }
						        catch(Exception e)
						        {
						        	System.out.println(e);
						        }
						        		
						        break;
						case 2: 
						        System.out.println("Enter the Name of the person to be discharged");
						        name = det.next();
						        int position;
						        try
						        {
						        	position = pro.patient_search_details(pat,pcount,name);
						        	System.out.println("Enter day of Admission");
						        	String a = det.next();
						        	System.out.println("Enter month of Admission");
						        	String b = det.next();
						        	System.out.println("Enter year of Admission");
						        	String c = det.next();
						       	String st = a+ " " + b + " " +c;
						    	System.out.println("Enter day of Discharge");
						    	a = det.next();
						        	System.out.println("Enter month of Discharge");
						        	b = det.next();
						        	System.out.println("Enter year of Discharge");
						        	c = det.next();
						       	dis_date = a+ " " + b + " " + c;
						       	per = pat[position];   	
						    	try
						 	{					
						 		//System.out.println(pat[position].getJdate()); 	 	 	 	
						 		Date start = myFormat.parse(st);
	      							Date end = myFormat.parse(dis_date);
	      							long difference =  end.getTime() - start.getTime(); 
	      							float daysBetween = (difference / (1000*60*60*24));
            							pat[position].no_of_bed_days = daysBetween;
            							pcount = pcount -1 ;
            							n_inp = n_inp +1;						  
            							pat[position].calBill(doc); 
	 					       	 }
                                                       		catch (Exception e)
                                                       		{
                                                            	  System.out.println("Wrong Date Format! ");
                                                        		}
                                                        	        }
						         	catch (Exception e)
	 						{
	 						 System.out.println("Patient not found in the Database");
						        	}
						  
						        break;
					}
				
				case 2:
					int cho;
					System.out.println("**********************************************************");
					System.out.println(" 1. Doctor");
					System.out.println(" 2. Administrator");
					System.out.println(" 3. Exit");
					System.out.println(" Enter Choice");
					cho=det.nextInt();
					System.out.println("**********************************************************");
					switch (cho)
					{
						
					   case 1:
					   	System.out.println(" 1. Create profile ");
						System.out.println(" 2. Display details ");
						System.out.println(" 3. Exit");
						System.out.println("  Enter choice " );
						int c = det.nextInt();
						switch(c)
						{
							case 1:
							        System.out.println("Enter Doctor Name");
							        name = det.next();
							        System.out.println("Date Of Birth (Format dd//mm/yyyy)");
							        DoB = det.next();
							        System.out.println("Gender ");
							        gender = det.next();
							        System.out.println("Residential Address");
							        address = det.next();
							        System.out.println("Contact Number");
							        pn = det.nextLong();
							        System.out.println("Experience");
							        exp =det.nextInt();
							        System.out.println("Speciality");
							        speciality = det.next();
							        System.out.println("Joining Date");
							        jdate = det.next();
							        System.out.println("Title");
							        title = det.next();
							        System.out.println("Salary");
							        sal = det.nextFloat();
							        System.out.println("How many certificates ?");
							        int cer =det.nextInt();
							        System.out.println("Enter Education Qualifications ");
							        String[] qual = new String[cer];
							        for(int i=0;i<cer;i++)
							        	qual[i]=det.next();
							        doc[dcount] = new Doctor(title,name,DoB,gender,address,pn,exp,speciality,qual,jdate,sal);							       
							        dcount+=1;
							       try
						       	         {
						        		pro.doctor_count(dcount,ndoc);
						        	         }
						       	      catch(Exception e)
						        		{
						       		 	System.out.println(e);
						       		}
						        	       break; 	
						        	       					        
							case 2:
								System.out.println("Enter Doctor name");
								name = det.next();
								try
								{
									int position = pro.doctor_search_details(doc,ndoc,name);
									per = doc[position];
                                                                        doc[position].display();
									
								}
								catch(Exception e)
								{
									System.out.println(e);
								}
								break;
						}
						break;
					case 2:
					   	System.out.println(" 1. Create profile ");
						System.out.println(" 2. Display details ");
						System.out.println(" 3. Doctor Promotion");
						System.out.println(" 3. Exit");
						System.out.println("  Enter choice " );
						int q = det.nextInt();
						switch(q)
						{
							case 1:
							        System.out.println("Enter Technician Name");
							        name = det.next();
							        System.out.println("Date Of Birth (Format dd//mm/yyyy)");
							        DoB = det.next();
							        System.out.println("Gender ");
							        gender = det.next();
							        System.out.println("Residential Address");
							        address = det.next();
							        System.out.println("Contact Number");
							        pn = det.nextLong();
							        System.out.println("Experience");
							        exp =det.nextInt();
							        System.out.println("Joining Date");
							        jdate = det.next();
							        System.out.println("Title");
							        title = det.next();
							        System.out.println("Salary");
							        sal = det.nextFloat();
							        System.out.println("How many certificates ?");
							        int cer =det.nextInt();
							        System.out.println("Enter Education Qualifications ");
							        String[] qual = new String[cer];
							        for(int i=0;i<cer;i++)
							        	qual[i]=det.next();
							        System.out.println("Clearance (1-4)");
							        int cle = det.nextInt();
							        
							        tech[tcount] = new Admin(title,name,DoB,gender,address,pn,exp,qual,jdate,sal,cle);							       
							        tcount+=1;
							       try
						       	         {
						        		pro.admin_count(tcount,ntech);
						        	         }
						       	      catch(Exception e)
						        		{
						       		 	System.out.println(e);
						       		}
						        	       break; 	
						        	       					        
							case 2:
								System.out.println("Enter Administration name");
								name = det.next();
								try
								{
									int position = pro.admin_search_details(tech,ntech,name);
									per = tech[position];
                                                                        tech[position].display();
									
								}
								catch(Exception e)
								{
									System.out.println(e);
								}
								break;
							case 3: 	System.out.println("Enter Technician name");
								name = det.next();
								try
								{
									int position = pro.admin_search_details(tech,ntech,name);
									per = tech[position];
									int cl =tech[position].getClearance();
									if(cl >3)
									  {
										System.out.println("success 1");
										System.out.println("Enter Doctor name");
										name = det.next();
										try
										{
										System.out.println("success 2");
										int po = pro.doctor_search_details(doc,ndoc,name);
										per = doc[po];
										System.out.println("New Salary ");
										int salary = det.nextInt();
										doc[po].setSalary(salary);
									
										}
										catch(Exception e)
										{
											System.out.println(e);
										}
										System.out.println("success 3");
									}
									else
									System.out.println("Permission Denied!");
									
								}
								catch(Exception e)
								{
									System.out.println(e);
								}
								break;
							    	
						}
					}
				}
			}
			
			while(choice != 3);
}
}
	
	
	
	
	
	
