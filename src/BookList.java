
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trduy
 */
public class BookList implements IBook {

    @Override
    public void addBook(ArrayList<Book> t) {}

    @Override
    public void displayBook(ArrayList<Book> t) {}

    @Override
    public void searchBook(ArrayList<Book> t, String newCode) {}

    @Override
    public void updateBookPrice(ArrayList<Book> t, double newPrice) {}

    @Override
    public double findMaxPrice(ArrayList<Book> t) {
        return 1.1;
    }
    
    @Override
    public void sortList(ArrayList<Book> t, int option) {}

    @Override
    public void removeBook(ArrayList<Book> t, String givenCode) {}

    @Override
    public void loadDataFile() {}

    @Override
    public void exitProgram() {}
}
