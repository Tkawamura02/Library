public class Library {
	
	String address;
	Book[] Library;
	int bookamount;
	
    public Library(String addresses) {
    	address = addresses;
    	Library = new Book[100];
    	bookamount = 0;
	}

	// Add the missing implementation to this class

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

	private void returnBook(String string) {
		for(int i=0; i<bookamount; i++)
			if(Library[i].getTitle().equals(string)) 
				if(Library[i].isBorrowed()) {
					System.out.println("You successfully returned " + string);
					Library[i].returned();
					return;
				}
				else {
					System.out.println("This book was not borrowed.");
					return;
				}
					
		System.out.println("Sorry, this book is not in our catalog.");	
	}

	private void printAvailableBooks() {
		if(bookamount == 0)
			System.out.println("No book in catalog.");
		for(int i=0; i<bookamount; i++)
			if(!Library[i].isBorrowed())
				System.out.println(Library[i].getTitle());
	}

	private void borrowBook(String string) {
		for(int i=0; i<bookamount; i++)
			if(Library[i].getTitle().equals(string)) 
				if(Library[i].isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");
					return;
				}
				else {
					System.out.println("You successfully borrowed " + string);
					Library[i].rented();
					Library[i].rented = true;
					return;
				}
					
		System.out.println("Sorry, this book is not in our catalog.");
	}

	private void printAddress() {
		System.out.println(address);
	}

	private static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9AM to 5PM.");
	}

	private void addBook(Book book) {
		Library[bookamount] = book;
		bookamount++;
	}
} 