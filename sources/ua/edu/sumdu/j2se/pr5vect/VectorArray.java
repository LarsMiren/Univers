package ua.edu.sumdu.j2se.pr5vect;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by God on 09.03.2017.
 */
public class VectorArray implements ArrayVector {

    private double[] arr;

    public VectorArray(){
        set(0);
    }

    public VectorArray(double... elements){
        set(elements);
    }

    @Override
    public void set(double... elements) throws NullPointerException {
        arr = new double[elements.length];
//        if(elements.length > arr.length) {
//            double[] m = new double[arr.length + 50];
//            for (int i = 0; i < arr.length; i++) {
//                m[i] = arr[i];
//            }
//            arr = m;
//        }
        if (elements == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < elements.length; i++) {
            arr[i] = elements[i];
        }
    }

    @Override
    public double[] get() {
        double[] a = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        return a;
    }

    @Override
    public ArrayVector clone() {
        ArrayVector a = new VectorArray(get());
        return a;
    }

    @Override
    public int getSize() {
        return arr.length;
    }

    @Override
    public void set(int index, double value) {
        if (index < 0) return;
        else if (index > arr.length) {
            double[] m = new double[index + 1];
            for (int i = 0; i < arr.length; i++) {
                m[i] = arr[i];
            }
            arr = m;
        }
        arr[index] = value;
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if(index < 0 || index >= arr.length) throw new ArrayIndexOutOfBoundsException();
        return arr[index];
    }

    @Override
    public double getMax() {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }
        return min;
    }

    @Override
    public void sortAscending() {
        int n;
        double min;
        for (int i = 0; i < arr.length; i++) {
            n = i;
            min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > min) {
                    min = arr[j];
                    n = j;
                }
            }
            arr[n] = arr[i];
            arr[i] = min;
        }
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        ArrayVector a = new VectorArray(get());
        int l;
        if(a.getSize() > anotherVector.getSize()) l = anotherVector.getSize();
        else l = a.getSize();
        for (int i = 0; i < l; i++) {
            a.set(i, a.get(i) + anotherVector.get(i));
        }
        return a;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        ArrayVector a = new VectorArray(get());
        int l;
        double m = 0;
        if(a.getSize() > anotherVector.getSize()) l = anotherVector.getSize();
        else l = a.getSize();
        for (int i = 0; i < l; i++) {
            m += a.get(i) * anotherVector.get(i);
        }
        return m;
    }

    @Override
    public double getNorm() throws ArithmeticException {
        double m = 0;
        for (int i = 0; i < arr.length; i++) {
            m += arr[i] * arr[i];
        }
        if (m < 0) throw new ArithmeticException("Sqrt < 0");
        return Math.sqrt(m);
    }
}
