package DesignPattern.Template;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class ATest {

    @Test
    public void calculation() {
        Sum sum = new Sum();
        assertThat(sum.templatemethod(5,10),is(15));

        Multi multi = new Multi();
        assertThat(multi.templatemethod(5, 10), is(50));
    }
}