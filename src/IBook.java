
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
public interface IBook {

    public void addBook(ArrayList<Book> t);

    public void displayBook(ArrayList<Book> t);

    public void searchBook(ArrayList<Book> t, String newCode);

    public void updateBookPrice(ArrayList<Book> t, double newPrice);

    public double findMaxPrice(ArrayList<Book> t);

    public void sortList(ArrayList<Book> t, int option);

    public void removeBook(ArrayList<Book> t, String givenCode);

    public void loadDataFile();

    public void exitProgram();
}
