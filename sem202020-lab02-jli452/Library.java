package lab02;

public class Library
{
	public static void main(String[] args)
		{
			Book[] library = new Book[3];
			library[0] = new Book("Book1", 20);
			library[1] = new Book("Book2", 30);
			library[2] = new Book("Book3", 40);
			
			for (int i = 0; i < library.length; i++)
				System.out.println(library[i].getTitle());

			for (Book a : library)
				System.out.println(a.getNumPages());

			//Testing numPagesInLibrary
			System.out.println("Expected: 90");
			System.out.println("Actual: " + numPagesInLibrary(library));
			if (numPagesInLibrary(library) == 90)
				System.out.println("Passed");
			else
				System.out.println("Failed");
			
			//Testing mostPages
			System.out.println("Expected: 40");
			System.out.println("Actual: " + mostPages(library));
			if (mostPages(library) == 40)
				System.out.println("Passed");
			else
				System.out.println("Failed");
		}

	public static int numPagesInLibrary(Book[] books)
		{
			int total = 0;
			for (int i = 0; i < books.length; i++)
				total+=books[i].getNumPages();
			return total;
		}

	public static int mostPages(Book[] books)
		{
			int most = 0;
			for (int i = 0; i < books.length; i++)
				{
					if (books[i].getNumPages() > most)
						most = books[i].getNumPages();
				}
			return most;
		}
}

