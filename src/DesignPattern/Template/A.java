package DesignPattern.Template;

abstract class A {
    public int templatemethod(int num1, int num2) { //재사용하고자하는 template 메서드
        System.out.println("입력받은 값 => [" + num1 + "," + num2 + "]");
        int result = calculation(num1, num2);
        hook();
        return result;
    }

    public abstract int calculation(int num1, int num2); //오버라이딩에 의해 구현제가 바뀔수 있는 추상메서드

    public void hook() { } //아무것도 하지않는 '구현' 메서드
}