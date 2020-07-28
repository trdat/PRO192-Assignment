
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dat Duy Tran
 */
public class Main {

    public static void displayMenu() {
        System.out.println("BOOK MANAGEMENT SYSTEM");
        System.out.println("-------------------------------------");
        System.out.println("1. Input and add book(s) to the end");
        System.out.println("2. Display all books");
        System.out.println("3. Search a book for given code");
        System.out.println("4. Update the book's price for given code");
        System.out.println("5. Find the (first) max price value");
        System.out.println("6. Sort the list ascendingly by code");
        System.out.println("7. Remove the book having given code");
        System.out.println("8. Load data from file");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) throws IOException {
        int userChoice;
        BookList book = new BookList();

        while (true) {
            // prompt user to get their choice
            displayMenu();
            userChoice = GetInput.Integer("Enter your choice", 0, 8);
            book.loadDataFromFile();
            switch (userChoice) {
                case 0:
                    // exit program
                    book.exitProgram();
                    break;
                case 1:
                    // input and add book(s) to the end.
                    book.addOnes();
                    break;
                case 2:
                    book.displayAllBooks();
                    break;
                case 3:
                    book.searchByCode();
                    break;
                case 4:
                    book.updatePriceByCode();
                    break;
                case 5:
                    book.findMaxPrice();
                    break;
                case 6:
                    book.sortByCode();
                    break;
                case 7:
                    book.removeByCode();
                    break;
                case 8:
                    book.loadDataFromFile();
                    break;
            }
            System.out.println();
        }
    }
}
