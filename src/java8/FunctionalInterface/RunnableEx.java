package java8.FunctionalInterface;

public class RunnableEx {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("hello functional");
        r.run();

    }
}
