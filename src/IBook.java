
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dat Duy Tran
 */
public interface IBook {

    public void addOnes();

    public void displayAllBooks();

    public void searchByCode();

    public void updatePriceByCode();

    public void findMaxPrice();

    public void sortByCode();

    public void removeByCode();

    public void loadDataFromFile() throws IOException;
    
    public void saveDataToFile() throws IOException;
    
    public void exitProgram();
}
