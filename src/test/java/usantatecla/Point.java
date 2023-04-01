package usantatecla;

public class Point {

    static final double VALUE = 4.4;
    static final double DEVIATION = 0.1;

    static double getLess(double value) {
        return value - Point.DEVIATION;
    }

    static double getEqual(double value) {
        return value;
    }

    static double getGreater(double value) {
        return value + Point.DEVIATION;
    }
}
