package Ch3parameters;

public class Temperature {
    public static void main(String[] args) {
        double tempf = 98.6;
        double tempc = 0.0;
        System.out.println("Body temp in C is: " + ftoc(tempf,tempc));
    }

    // converts Fahrenheit temperatures to Celsius
    public static double ftoc(double tempf, double tempc) {
        tempc = (tempf - 32) * 5 / 9;
        return tempc;
    }
}
