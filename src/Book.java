
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
public class Book {

    private String code;
    private String title;
    private int qua;
    private double price;

    public Book() {
    }

    public Book(String code, String title, int qua, double price) {
        this.code = code;
        this.title = title;
        this.qua = qua;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getQua() {
        return qua;
    }

    public double getPrice() {
        return price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
