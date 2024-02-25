package Library;

public class Book {
	
	private String name;         //title
	private String author;       //author
	private String publisher;    //publisher
	private String adress;       //Collection location
	private String status;       //Borrowing status
	private int qty;             //Copies for sale
	private double price;        //Price
	private int brwCopies;       //Copies for borrowing
	
	public Book() {
	}

	public Book(String name, String author, String publisher,String adress,
			int qty, double price,int brwCopies) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.adress = adress;
		this.qty = qty;
		this.price = price;
		this.brwCopies = brwCopies;
	}
	
	public String toString(){
		String text = "Book Name: " + name+
				"Book author: " + author+
				"Book publisher: " + publisher+
				"Book Colletion address: " + adress+
				"Qty: " + String.valueOf(qty)+
				"Price: " + String.valueOf(price)+
				"Borrowing copies: " + String.valueOf(brwCopies);
		return text;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBrwCopies() {
		return brwCopies;
	}

	public void setBrwCopies(int brwCopies) {
		this.brwCopies = brwCopies;
	}
	
	
	
}
