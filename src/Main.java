public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new SetSolver().run();
        long finish = System.currentTimeMillis();
        System.out.println("TIME ELAPSED: " + (finish - start));
    }
}