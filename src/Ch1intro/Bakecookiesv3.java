package Ch1intro;
//** this version eliminates redundancy by using decomposition.
public class Bakecookiesv3 {
    public static void main(String[] arg) {
    makeBatter();
    bakeCookies();
    decorateCookies();

    }

    public static void makeBatter () {
        System.out.println("Mix the dry ingredients.");
        System.out.println("Cream the butter and sugar.");
        System.out.println("Beat in the eggs.");
        System.out.println("Stir in the dry ingredients.");


    }

    public static void bakeCookies () {
        System.out.println("Set the oven temperature.");
        System.out.println("Set the timer.");
        System.out.println("Place a batch of cookies into the oven.");
        System.out.println("Allow the cookies to bake.");
        System.out.println("Set the oven temperature.");
        System.out.println("Set the timer.");
        System.out.println("Place a batch of cookies into the oven.");
        System.out.println("Allow the cookies to bake.");

    }

    public static void decorateCookies () {
        System.out.println("Mix ingredients for frosting.");
        System.out.println("Spread frosting and sprinkles.");

    }
}
