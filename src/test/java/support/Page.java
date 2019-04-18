package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;

public class Page {

    protected WebDriver browser;

    protected Page(WebDriver driver) {
        browser = driver;
        PageFactory.initElements(driver, this);
    }

    public <T> T on(Class<T> c) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        if (c.isInstance(this)) {
            return (T) this;
        }
        return c.getConstructor(WebDriver.class).newInstance(browser);
    }
}
