import java.util.ArrayList;
import java.util.Scanner;

public class InventoryControlSystem {
	private ArrayList<Product> inventory;
	
	//creates an array which will store all the products
	public InventoryControlSystem() {
		inventory = new ArrayList<Product>();
	}
	
	//allows the user to add products to the array
	public void addProduct(Product p) {
		inventory.add(p);
	}
	
	//allows the user to check the inventory (things like price, quantity, and last shipment)
	public void checkInventory() {
		System.out.println("Inventory: ");
		for (Product p : inventory) {
			System.out.println(p.getName() + ", Price: " + p.getPrice() + ", Quantity: " + p.getQuantity() + ", Last Shipment: " + p.getLastShipment());
		}
	}
	
	public void searchProduct(String name) {
		for (Product p : inventory) {
			if (p.getName().equalsIgnoreCase(name)) {
				System.out.println("Price: " + p.getPrice() + ", Quantity: " + p.getQuantity() + ", Last Shipment: " + p.getLastShipment());
				return;
			}
		}
		System.out.println("Product not found");
	}
	
	public void orderProduct(String name, int quantity) {
		for (Product p : inventory) {
			if (p.getName().equalsIgnoreCase(name)) {
				if (p.getQuantity() >= quantity) {
					System.out.println("Product is already in stock");
					return;
				} else {
					System.out.println("Order placed for " + quantity + " " + p.getName());
					p.setQuantity(p.getQuantity() + quantity);
					return;
				}
			}
		}
		System.out.println("Product not found");
	}
	
	//runs the program
	public static void main (String[] args) {
		InventoryControlSystem system = new InventoryControlSystem();
		//sets some general products into the array to start
		system.addProduct(new Product("Apple", 1.00, 100, "02/14/2023"));
		system.addProduct(new Product("Orange", 0.85, 150, "02/03/2023"));
		system.addProduct(new Product("Banana", 1.50, 20, "01/27/2023"));
		system.addProduct(new Product("Pear", 1.00, 75, "01/15/2023"));
		
		//takes user input to add new products to the inventory
		Scanner scanner = new Scanner(System.in);
		//allows the user to pick which choice they want (check inventory, search for products, add new products, end)
		int choice;
		do {
			System.out.println("\nChoose an option: ");
			System.out.println("1. Check for Inventory");
			System.out.println("2. Search for a Product");
			System.out.println("3. Order a Product");
			System.out.println("4. Quit");
			choice = scanner.nextInt();
			
			//takes the user's choice
			switch (choice) {
			//this choice will show the user the current inventory
			case 1:
				system.checkInventory();
				break;
			//this choice will allow the user to search for products in the inventory (not finished yet)
			case 2:
				System.out.print("Enter product name: ");
				scanner.nextLine();
				String name = scanner.nextLine();
				system.searchProduct(name);
				break;
			case 3:
			//this choice will allow the user to add new products to the inventory (not finished yet)
				System.out.print("Enter product name: ");
				scanner.nextLine();
				String productName = scanner.nextLine();
				System.out.print("Enter quantity: ");
				int quantity = scanner.nextInt();
				system.orderProduct(productName, quantity);
				break;
			//this choice ends the program
			case 4:
				System.out.println("Thank you for using the Inventory Control System!");
				break;
			//the default choice runs if the user picks an invalid choice
			default:
				System.out.println("Invalid choice, please choose again");
			}
		//the user will be asked for a new choice each time until they choose 4 to end the program
		} while (choice != 4);
	}
}

class Product{
	private String name;
	private double price;
	private int quantity;
	private String lastShipment;
	
	public Product (String name, double price, int quantity, String lastShipment) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.lastShipment = lastShipment;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getLastShipment() {
		return lastShipment;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

