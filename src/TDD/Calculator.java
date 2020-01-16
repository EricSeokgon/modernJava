package TDD;

public class Calculator {
    public int sum(int a, int b) {
        return 0;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(10, 20) == 30);
        System.out.println(calc.sum(1, 2) == 3);
        System.out.println(calc.sum(-10, 20) == 10);
        System.out.println(calc.sum(0, 0) == 0);
    }
}
