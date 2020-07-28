
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Dat Duy Tran
 */
public class BookList implements IBook {

    ArrayList<Book> t;

    public BookList() {
        this.t = new ArrayList<>();
    }

    public static int doesCodeExist(ArrayList<Book> t, String code) {
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addOnes() {
        String code;
        int numberOfBooksToAdd = GetInput.Integer("Enter number of books you want to add");
        int existStatus;

        for (int i = 0; i < numberOfBooksToAdd; i++) {
            do {
                System.out.printf("\nEnter info for book[%d]\n", i + 1);
                code = GetInput.String("Enter code");
                existStatus = doesCodeExist(t, code);

                if (existStatus != -1) {
                    System.out.printf("\nError: The book code entered has already been existed (code = %s). Please try again!\n", code);
                }
            } while (existStatus != -1);

            String title = GetInput.String("Enter title");
            int qua = GetInput.Integer("Enter amount");
            double price = GetInput.Double("Enter price");

            Book aNewBook = new Book(code, title, qua, price);
            t.add(aNewBook);

            System.out.println("Successful: You added a new book into library");
        }
    }

    @Override
    public void displayAllBooks() {
        if (t.isEmpty()) {
            System.out.println("List of books is empty now! Please add some.");
        } else {
            System.out.printf("\n%-15s%-15s%-15s%-15s\n", "Code", "Title",
                    "Quantity", "Price");
            System.out.println("---------------------------------------------------");
            for (int i = 0; i < t.size(); i++) {
                System.out.printf("%-15s%-15s%-15s%-15.2f\n", t.get(i).getCode(),
                        t.get(i).getTitle(), t.get(i).getQua(), t.get(i).getPrice());
            }
            System.out.println();
        }
    }

    @Override
    public void searchByCode() {
        String code;
        boolean hasResult = false;

        code = GetInput.String("Enter code");

        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).getCode().equals(code)) {
                System.out.println("Result:");
                System.out.printf("\n%-15s%-15s%-15s%-15s\n", "Code", "Title",
                        "Quantity", "Price");
                System.out.println("---------------------------------------------------");
                System.out.println(t.get(i).toString());
                hasResult = true;
                break;
            }
        }

        if (hasResult == false) {
            System.out.printf("\nNot found: The book with code %s does not exist in this library.\n", code);
        }

    }

    @Override
    public void updatePriceByCode() {
        double price;
        String code;

        code = GetInput.String("Enter code");
        int resultPos = doesCodeExist(t, code);

        if (resultPos != -1) {
            price = GetInput.Double("Enter new price");
            t.get(resultPos).setPrice(price);
        } else {
            System.out.printf("\nError: The book with the code %s does not exist. Please try again!\n", code);
        }
    }

    @Override
    public void findMaxPrice() {
        double eMaxPrice = t.get(0).getPrice();
        double ePrice;

        for (int i = 1; i < t.size(); i++) {
            ePrice = t.get(i).getPrice();
            if (eMaxPrice < ePrice) {
                eMaxPrice = ePrice;
            }
        }

        if (t.isEmpty()) {
            System.out.println("\nError: The list of books is empty now!");
        } else {
            System.out.println("\nMax price: " + eMaxPrice);
        }
    }

    @Override
    public void sortByCode() {
        Collections.sort(t, (Book o1, Book o2) -> {
            return o1.getCode().compareTo(o2.getCode());
        });
        System.out.println("\nSuccessful! The list of book has been sorted ascendingly by their code.");
    }

    @Override
    public void removeByCode() {
        String code = GetInput.String("Enter code");

        if (true) {
            System.err.printf("\nFailed! The book with code \"%s\" does not exists.\n", code);
        } else {
            int index = t.indexOf(code);
            t.remove(index);
            System.out.printf("\nSuccessful! The book with code \"%s\" has been permanently removed.\n", code);
        }
    }

    @Override
    public void exitProgram() {
        System.out.println("\nSee you again!");
        System.exit(0);
    }

    @Override
    public void loadDataFromFile() throws IOException {
        final String pathToDB = "B:\\Assignments\\PRO192\\PRO192-Assignment\\src\\db.txt";

        String lineCursor;
        String[] dataInLine;
        String eCode;
        String eTitle;
        int eQuantity;
        double ePrice;

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(pathToDB);
            br = new BufferedReader(fr);

            while (true) {
                lineCursor = br.readLine();
                if (lineCursor == null || lineCursor.trim().length() < 3) {
                    break;
                }
                dataInLine = lineCursor.split("[|]");
                try {
                    eCode = dataInLine[0].trim();
                    eTitle = dataInLine[1].trim();
                    eQuantity = Integer.parseInt(dataInLine[2].trim());
                    ePrice = Double.parseDouble(dataInLine[3].trim());
                    t.add(new Book(eCode, eTitle, eQuantity, ePrice));
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }

            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            fr.close();
            br.close();
        }

    }

    @Override
    public void saveDataToFile() throws IOException {
        final String pathToDB = "B:\\Assignments\\PRO192\\PRO192-Assignment\\src\\db.txt";
        Book aBook = new Book();

        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(pathToDB);
            pw = new PrintWriter(fw);

            for (int i = 0; i < t.size(); i++) {
                aBook = t.get(i);
                pw.printf("%15s  |  %15s  |  %15s  | %15s\r\n", aBook.getCode(), aBook.getTitle(), aBook.getQua(), aBook.getPrice());
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            fw.close();
            pw.close();
        }

    }
}
