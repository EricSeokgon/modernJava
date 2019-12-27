package DesignPattern;


//getString()을 재사용
class A {
    public String getString() {
        return "Hello World";
    }
}

//상속을 이용한 방법
class B extends A {

}

//합성을 이용한 방법
class C {
    public String getString() {
        A a = new A();

        return a.getString();
    }
}

