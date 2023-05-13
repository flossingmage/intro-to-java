package Ch2DataTypesAndLoops;

//add a comment here to describe this program
public class TimeV1 {
    public static void main(String... args) {
        var Hours = 365 * 24;
        var Minutes = Hours * 60;

        //calculate hours in a year
        System.err.println("Hours in a year = " + Hours);
        //calculate minutes in a year
        System.err.println("Minutes in a year = " + Minutes);
        //calculate seconds in a year
        System.err.println("Seconds in a year = " + Minutes * 60);
    }
}