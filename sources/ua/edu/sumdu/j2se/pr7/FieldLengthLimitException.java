package ua.edu.sumdu.j2se.pr7;

import java.io.IOException;

/**
 * Created by God on 14.04.2017.
 */
public class FieldLengthLimitException extends IOException {
    @Override
    public String getMessage() {
        return "Out of limits";
    }

    @Override
    public String toString(){
        return getMessage();
    }
}
