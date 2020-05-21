package assignment02;

public class LibraryTester {

	public static void main(String[] args) {
		Book[] library0 = 
			{ new Book("Pride and Prejudice by Jane Austen", 432),
					new Book("Frankenstein; Or, The Modern Prometheus by Mary Wollstonecraft Shelley", 280),
					new Book("A Modest Proposal by Jonathan Swift", 48),
					new Book("Et dukkehjem. English by Henrik Ibsen", 78),
					new Book("Little Women by Louisa May Alcott", 280),
					new Book("The Importance of Being Earnest: A Trivial Comedy for Serious People by Oscar Wilde", 98),
					new Book("Alice's Adventures in Wonderland by Lewis Carroll", 200),
					new Book("A Tale of Two Cities by Charles Dickens", 341),
					new Book("Moby Dick; Or, The Whale by Herman Melville", 458),
					new Book("Beowulf: An Anglo-Saxon Epic Poem", 270),
					new Book("Adventures of Huckleberry Finn by Mark Twain", 366)
			};
		Book[] library1 = {};
		Book[] library2 = null; 
		Book[] library3 = 
			{ null,
					new Book("Pride and Prejudice by Jane Austen", 432),
					new Book("Frankenstein; Or, The Modern Prometheus by Mary Wollstonecraft Shelley", 280),
					new Book("A Modest Proposal by Jonathan Swift", 48),
					new Book("Et dukkehjem. English by Henrik Ibsen", 78),
					new Book("Little Women by Louisa May Alcott", 280),
					null,
					new Book("The Importance of Being Earnest: A Trivial Comedy for Serious People by Oscar Wilde", 98),
					new Book("Alice's Adventures in Wonderland by Lewis Carroll", 200),
					new Book("A Tale of Two Cities by Charles Dickens", 341),
					new Book("Moby Dick; Or, The Whale by Herman Melville", 458),
					new Book("Beowulf: An Anglo-Saxon Epic Poem", 270),
					new Book("Adventures of Huckleberry Finn by Mark Twain", 366),
					null
			};
		System.out.println(Library.mostPages(library0));
		System.out.println(Library.mostPages(library1));
		System.out.println(Library.mostPages(library2));
		System.out.println(Library.mostPages(library3));
		System.out.println(Library.numPagesInLibrary(library0));
		System.out.println(Library.numPagesInLibrary(library1));
		System.out.println(Library.numPagesInLibrary(library2));
		System.out.println(Library.numPagesInLibrary(library3));

	}

}
