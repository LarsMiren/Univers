package ua.edu.sumdu.j2se.pr4;

import java.lang.reflect.Array;

/**
 * Created by God on 23.02.2017.
 */
public class ControlFlowStatement implements ControlFlowStatements2 {

    @Override
    public  int getFunctionValue(int x) {
        if (x < -2 || x > 2) return 2 * x;
        else return -3 * x;
    }

    @Override
    public String decodeMark(int mark) {
        switch ( mark ) {
            case 1:
                return "Fail";
            case 2: 
                return "Poor";
            case 3: 
                return "Satisfactory";
            case 4: 
                return "Good";
            case 5: 
                return "Excellent";
            default:
                return "\"Error\"";
        }
    }

    @Override
    public double[][] initArray() {
        double[][] arr = new double[5][8];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                arr[i][j] = Math.pow(i, 4) - Math.sqrt(j);
            }
        }
        return arr;
    }

    @Override
    public double getMaxValue(double[][] array) {
        double max = array[0][0];
        for (double[] i: array ) {
            for (double j: i ) {
                if(max < j) max = j;
            }
        }
        return max;
    }

    @Override
    public Sportsman calculateSportsman(float P) {
        Sportsman alex = new Sportsman();
        float dis = 10;
        do {
            alex.addDay(dis);
            dis = dis*(1 + P/100);
        } while(alex.getTotalDistance() <= 200);
        return alex;
    }

    @Override
    public String toString() {
        return "ControlFlowStatement{}";
    }

    public static void main(String[] args) {
        ControlFlowStatement azaza = new ControlFlowStatement();
        double[][] arr = azaza.initArray();

        System.out.println(azaza.getMaxValue(arr));
        System.out.println(azaza.getFunctionValue(6));
        System.out.println(azaza.decodeMark(2) + azaza.decodeMark(7));
        System.out.println(azaza.calculateSportsman(10));
    }
}
