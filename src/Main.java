import exceptions.Unexpected_value;
import geometry2d.*;
import geometry3d.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.click();
        button.click();

        Balance balance = new Balance();
        balance.result();
        balance.addRight(2);
        balance.result();
        balance.addLeft(3);
        balance.result();
        balance.set_balance();
        balance.result();

        Bell bell = new Bell();
        bell.sound();
        bell.sound();
        bell.sound();

        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(4);
        separator.addNumber(0);
        separator.addNumber(-3);
        separator.addNumber(-2);
        separator.odd();
        separator.even();

        Table table = new Table(3,2);
        table.setValue(0,0,1);
        table.setValue(0,1,3);
        table.setValue(1,0,2);
        table.setValue(1,1,2);
        table.setValue(2,1,4);
        System.out.println("Rows: " + table.rows());
        System.out.println("Cols: " + table.cols());
        System.out.println("table[0,1]: " + table.getValue(0, 1));
        System.out.println(table.toString());
        System.out.println(table.average());
        
        Figure circle = null;
        try {
            circle = new Circle(-1);
        } catch(Unexpected_value exc){
            System.out.println(exc.getMessage());
        }
        
        try {
            circle = new Circle(1);
        } catch (Unexpected_value exc){
            System.out.println(exc.getMessage());
        }

        System.out.println("circle.area(): " + circle.area());
        System.out.println("circle.perimeter(): " + circle.perimeter());
        System.out.println(circle.toString());

        Figure triangle = null;
        try {
            triangle = new Triangle(2, 6, 2);
        } catch (Throwable exc){
            System.out.println(exc.getMessage());
        }

        try {
            triangle = new Triangle(1, 1, 1);
        } catch (Exception exc) {
            return;
        }

        System.out.println("triangle.area(): " + triangle.area());
        System.out.println("triangle.perimeter(): " + triangle.perimeter());
        System.out.println(triangle.toString());

        Cylinder cylinder = null;
        try {
            cylinder = new Cylinder(circle, -2);
        } catch (Unexpected_value e) {
            System.out.println(e.getMessage());
        }

        try {
            cylinder = new Cylinder(circle, 2);
        } catch (Exception e) {
            return;
        }

        System.out.println("cylinder.volume(): " + cylinder.volume());
    }
}

class Button {
    int clicks;

    void click() {
        System.out.println("Clicks: " + ++clicks);
    }
}

class Balance {
    int weight_right, weight_left;

    void addRight(int weight) {
        if(weight < 0) return;
        weight_right += weight;
    }

    void addLeft(int weight) {
        if(weight < 0) return;
        weight_left += weight;
    }

    void set_balance() {
        weight_right = (weight_left = min(weight_left, weight_right));
    }

    void result() {
        if(weight_right == weight_left) System.out.println("=");
        else System.out.println(weight_left > weight_right ? "L" : "R");
    }
}

class Bell {
    int state;

    void sound() {
        System.out.println(state++ == 0 ? "ding" : "dong");
        state %= 2;
    }
}

class OddEvenSeparator {
    List<Integer> OddNumbers = new ArrayList<Integer>();
    List<Integer> EvenNumbers = new ArrayList<Integer>();

    void addNumber(int num) {
        if(num % 2 == 0) EvenNumbers.add(num);
        else OddNumbers.add(num);
    }

    void odd() {
        System.out.println(OddNumbers);
    }

    void even() {
        System.out.println(EvenNumbers);
    }
}

class Table {
    int[][] numbers;

    Table(int rows, int cols) {
        numbers = new int[rows][cols];
    }

    int getValue(int row, int col) {
        return numbers[row][col];
    }

    void setValue(int row, int col, int value) {
        numbers[row][col] = value;
    }

    int rows() {
        return numbers.length;
    }

    int cols() {
        return numbers[0].length;
    }

    public String toString() {
        String array = "[";
        for(int i = 0; i < this.rows(); ++i) {
            array += (Arrays.toString(numbers[i]) + (i < this.rows() - 1 ? "\n" : "]\n"));
        }

        return array;
    }

    float average() {
        float sum = 0;
        for(int i = 0; i < this.rows(); ++i) {
            sum += IntStream.of(numbers[i]).sum();
        }
        return sum / (this.rows() * this.cols());
    }
}