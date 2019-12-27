package java8.lambda;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class Car implements Movable {
    @Override
    public void move(String str) {
        System.out.println("gogo car move" + str);
    }

    Movable movable = new Movable() {
        @Override
        public void move(String str) {
            System.out.println("gogo car move" + str);
        }
    };

    Movable movable1 = (str) -> {
        System.out.println("gogo car move" + str);
    };

    Movable movable2 = (str) -> System.out.println("gogo car move" + str);

}
