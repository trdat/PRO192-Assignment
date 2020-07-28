
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trduy
 */
public class PracticeReadingFile {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("B:\\Assignments\\PRO192\\PRO192-Assignment\\src\\testdb.txt");
        int i;
        while ((i = fr.read()) != -1) {
            System.out.println((char)i);
        }
    }
}
