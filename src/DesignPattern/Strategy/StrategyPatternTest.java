package DesignPattern.Strategy;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StrategyPatternTest {

    @Test
    public void StrategyPatternTest() {
        B b = new B();
        C c = new C();

        //System.out.println(b.getString());
        //System.out.println(c.getString());
        assertThat(b.getString(),is(equalTo("Hello World")));
        assertThat(c.getString(),is(equalTo("Hello LichKing")));

        D d = new D();
        d.setA(new B());
        System.out.println(d.playStrategy());
        d.setA(new C());
        System.out.println(d.playStrategy());

    }

}