package ua.edu.sumdu.j2se.pr7;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by God on 14.04.2017.
 */
public class ExceptionDemo {
    private Scanner sr = new Scanner(System.in);

    public static void main(String[] args) throws FieldLengthLimitException {
        String name;
        ExceptionDemo e = new ExceptionDemo();
        try {
            name = e.readName();
        } catch (IOException e1) {
            name = "";
        }
        if (name.length() < 2 || name.length() > 16) throw new FieldLengthLimitException();
        else System.out.println("Hello, " + name);
    }

    public String readName() throws IOException {
        return sr.nextLine();
    }
}
