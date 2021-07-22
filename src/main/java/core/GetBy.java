package core;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.Annotations;

public class GetBy {
    public static By getBy(String fieldName, Class ic) {
        try {
            return new Annotations(ic.getField(fieldName)).buildBy();
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}

