package DesignPattern;


//getString()을 재사용

//상속을 이용한 방법
class B implements A {

    @Override
    public String getString() {
        return "Hello World";
    }
}

//합성을 이용한 방법
class C implements A{
    @Override
    public String getString() {
        return "Hello LichKing";
    }
}
