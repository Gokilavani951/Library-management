import java.util.Scanner;

public class javalbm{

    static String[] books = new String[100];
    static boolean[] issued = new boolean[100];
    static int count = 0;

    // Add Book
    public static void addBook(String bookName) {
        if (count < books.length) {
            books[count] = bookName;
            issued[count] = false;
            count++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full!");
        }
    }

    // Display Books
    public static void displayBooks() {
        if (count == 0) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nAvailable Books:");

        for (int i = 0; i < count; i++) {
            System.out.println(
                (i + 1) + ". " + books[i] +
                (issued[i] ? " (Issued)" : " (Available)")
            );
        }
    }

    // Issue Book
    public static void issueBook(int index) {

        if (index < 0 || index >= count) {
            System.out.println("Invalid book number.");
        } else if (issued[index]) {
            System.out.println("Book already issued.");
        } else {
            issued[index] = true;
            System.out.println("Book issued successfully.");
        }
    }

    // Return Book
    public static void returnBook(int index) {

        if (index < 0 || index >= count) {
            System.out.println("Invalid book number.");
        } else if (!issued[index]) {
            System.out.println("Book was not issued.");
        } else {
            issued[index] = false;
            System.out.println("Book returned successfully.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n========= Library Menu =========");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book name: ");
                    String name = sc.nextLine();
                    addBook(name);
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    System.out.print("Enter book number to issue: ");
                    int issueIndex = sc.nextInt() - 1;
                    issueBook(issueIndex);
                    break;

                case 4:
                    System.out.print("Enter book number to return: ");
                    int returnIndex = sc.nextInt() - 1;
                    returnBook(returnIndex);
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}