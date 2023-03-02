import java.util.Scanner;

public class personType {

	private static personType instance = null;
	private String firstName;
	private String middleName;
	private String lastName;
	
	public static personType getInstance() {
		if (instance == null) {
			instance = new personType();
		}
		return instance;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setMiddleName(String middleName) {
        this.middleName = middleName;
	}
	 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return firstName + " " + middleName + " " + lastName;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the Singleton Pattern!");
		System.out.println("Please enter your name into the database");
		
		personType person = personType.getInstance();
		  
        System.out.print("Enter your first name: ");
        person.setFirstName(input.nextLine());
  
        System.out.print("Enter your middle name: ");
        person.setMiddleName(input.nextLine());
  
        System.out.print("Enter your last name: ");
        person.setLastName(input.nextLine());
        
        System.out.println("\nYour full name is " + person.getFullName());

	}

}
