package Ch1intro;

/**
 * This program will remove all redundancy
 * Kevin Dobruskin
 * 9/30/22
 * v1.0
 */
public class Project1 {
    public static void main(String[] args) {
        verse1();
        verse2();
        verse3();
        verse4();
        verse5();
        verse6();
    }

    public static void verse1() {
        System.out.println("There was an old woman who swallowed a fly,");
        iDontKnow();
    }

    public static void verse2() {
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wiggled and iggled and jiggled inside her.");
        swallowedSpider();
    }

    public static void verse3() {
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How obsurd to swallow a bird.");
        swallowBird();
    }

    public static void verse4() {
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        swallowCat();
    }

    public static void verse5() {
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        swallowDog();
    }

    public static void verse6() {
        System.out.println("There was an old woman who swallowed a man,");
        System.out.println("How could she swallow a man");
        swallowMan();

    }

    public static void swallowMan() {
        System.out.println("She swallowed the man to get the dog.");
        swallowDog();
    }

    public static void swallowDog() {
        System.out.println("She swallowed the dog to catch the cat,");
        swallowCat();
    }

    public static void swallowCat() {
        System.out.println("She swallowed the cat to catch the bird,");
        swallowBird();
    }

    public static void swallowBird() {
        System.out.println("She swallowed the bird to catch the spider,");
        swallowedSpider();
    }

    public static void swallowedSpider() {
        System.out.println("She swallowed the spider to catch the fly,");
        iDontKnow();
    }

    public static void iDontKnow() {
        System.out.println("I don't know why she swallowed that fly,");
        sheWillDie();
    }

    public static void sheWillDie() {
        System.out.println("perhaps she'll die.");
        System.out.println();
    }
}
