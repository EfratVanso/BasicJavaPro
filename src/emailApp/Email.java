package emailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength =10;
	private String department;
	private int mailBoxCapacity=500;
	private String alternateEmail;
	private String companySuffix= "company.com";
	private String email;	

	//constructor to receive first and last name
	public Email (String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		//System.out.println("EMAIL CREATED: "+this.firstName +" "+this.lastName);
		
		//call a method asking for depart - return depart
		this.department =this.setDepartment();
		//System.out.println("Department: "+this.department);
		
		//call a method that return random pass
		this.password = randonPassword(defaultPasswordLength);
		//System.out.println("Your code is: "+this.password);
		
		//combine elements to generate email
		email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+this.department+"."+companySuffix;
		//System.out.println("Your email is: "+this.email);

	}
	
	
	//Ask for department
	private String setDepartment() {
		System.out.print("DEPARTMENT CODES:\n1 fot sales\n2 for development\n3 for accountion\n0 fot none.\nENTER DEPARTMEND CODE: " );
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice==1)
			return "sales";
		else if (depChoice==2)
			return "dev";
		else if (depChoice==3)
			return "acct";
		else return "";		
	}
	
	
	//Generate a random pass
	private String randonPassword(int length)
	{
		String passwordSet="ABCDEFGHIGJLMNOPQRSTUVWXYZ1234567890%#$";
		char[] password = new char[length];
		for (int i= 0; i<length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//set the mailbox capacity
	public void setMailBoxCapacity (int capacity) {
		this.mailBoxCapacity=capacity;
	}
	
	//change the password
	public void setPassword (String password) {
		this.password=password;
	}
	
	//set alternate mail
	public void setAlternateEmail (String altMail) {
		this.alternateEmail=altMail;
	}
	
	//get methods:
	
	public int etMailBoxCapacity () {return	mailBoxCapacity;}
	public String getAlternateEmail () {return	alternateEmail;}
	public String getPassword () {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: "+firstName+" "+lastName+
				"\nCOMPANY EMAIL: "+email+
				"\nMAILBOX CAPACITY"+ mailBoxCapacity+ " mb";
	}
}//class
	
