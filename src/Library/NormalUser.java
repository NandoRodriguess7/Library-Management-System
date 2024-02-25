package Library;

public class NormalUser extends User{
	
	public NormalUser(String name) {
		super(name);
	}
	
	public NormalUser(String name, String email, String phoneNumber) {
		super(name, email, phoneNumber);
	}
	
	@Override
	public void menu() {
		System.out.println("View Books");
		System.out.println("Search");
		System.out.println("Place Order");
		System.out.println("Borrow menu");
		System.out.println("Calculate Fine");
		System.out.println("Return Book");
		System.out.println("Exit");
	}
	
}