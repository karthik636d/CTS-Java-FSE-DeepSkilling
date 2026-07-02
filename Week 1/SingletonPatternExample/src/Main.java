import Logger.Logger;

public class Main {
    public static void main(String[] args) {
        System.out.print("User 1: ");
        Logger logger1 = Logger.getInstance();

        System.out.print("User 2: ");
        Logger logger2 = Logger.getInstance();

        System.out.println("Are both instances same? " + (logger1 == logger2)); // true
    }
}