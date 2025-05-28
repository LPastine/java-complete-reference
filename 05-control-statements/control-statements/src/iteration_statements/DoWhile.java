package iteration_statements;

public class DoWhile {
    public static void main(String[] args) {
        int n = 10;

//        do {
//            System.out.println("tick " + n);
//            n--;
//        } while (n > 0);

        // More efficient version
        do {
            System.out.println("tick " + n);
        } while (--n > 0);
    }
}
