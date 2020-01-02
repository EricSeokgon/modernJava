package DesignPattern.Template;

public class Multi extends A {
    @Override
    public int calculation(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public void hook() {
        System.out.println("연산 종료"); //구현 메서드 이기때문에 필요에 따라 오버라이딩 하면된다.
    }
}
