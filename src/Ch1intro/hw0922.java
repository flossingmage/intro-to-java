package Ch1intro;
// fixing redundancy author Kevin Dobruskin 9/23/2022 v1.0
public class hw0922 {
    public static void main(String[] args){
        System.out.println("I once wrote a program that wouldn't compile");
        notCompile();
        smiled();
        System.out.println();
        System.out.println("my program did nothing");
        System.out.println("So I started typing.");
        notCompile();
        notCompile();
        smiled();
        System.out.println();
        System.out.println("\"Parse error\" cried the compiler");
        System.out.println("Luckily I'm such a code baller.");
        backslash();
        println();
        notCompile();
        smiled();
        System.out.println();
        System.out.println("Now the compiler wanted an identifier");
        System.out.println("and I thought the situation was getting dire");
        stringArg();
        backslash();
        println();
        notCompile();
        smiled();
        System.out.println();
        System.out.println("Java complained an enum");
        System.out.println("Boy, these computers really dumb!");
        System.out.println("I added a public class and called it Scum,");
        stringArg();
        backslash();
        println();
        notCompile();
        smiled();
    }
    public static void notCompile() {
        System.out.println("I don't know why it wouldn't compile,");
    }
    public static void println() {
        System.out.println("I added System.out.println(\"I <3 coding\"),");
    }
    public static void smiled() {
        System.out.println("My teacher just smiled");
    }

    public static void stringArg() {
        System.out.println("I added a main method with its String[] args,");
    }

    public static void  backslash() {
        System.out.println("I added a backslash to escape the quotes,");

    }
}
