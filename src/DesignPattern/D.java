package DesignPattern;

class D {
    A a;

    public void setA(A a) {
        this.a = a;
    }

    public String playStrategy() {
        return a.getString();
    }
}
