package java8.FunctionalInterface;

import java.util.concurrent.Callable;
import java.util.function.*;

public class RunnableEx {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("hello functional");
        r.run();

        Supplier<String> s = () -> "hello supplier";
        String result = s.get();

        Consumer<String> c = str -> System.out.println(str);
        c.accept("hello consumer");

        Function<String, Integer> f = str -> Integer.parseInt(str);
        Integer apply = f.apply("1");

        Predicate<String> p = str -> str.isEmpty();
        final boolean hello = p.test("hello");

        UnaryOperator<String> u = str -> str + " operator";
        String hello_unary = u.apply("hello unary");

        BinaryOperator<String> b = (str1, str2) -> str1 + " " + str2;
        String apply1 = b.apply("hello", "binary");

        BiPredicate<String, Integer> bp = (str, num) -> str.equals(Integer.toString(num));
        boolean test = bp.test("1", 1);


    }
}
