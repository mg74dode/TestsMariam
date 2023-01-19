
        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.android.AndroidDriver;
        import junit.framework.TestCase;
        import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.junit.Test;
        import java.net.MalformedURLException;
        import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestMariam<MobileElement> {
    static AppiumDriver driver;

    private By whatToDo = By.id("com.example.yeshasprabhakar.todo:id/emptyTextView\n");
    private String textWhatToDo = driver.findElement(this.whatToDo).getText();
    private By plusTask = By.id("com.example.yeshasprabhakar.todo:id/fab");
    private By windowTask = By.id("com.example.yeshasprabhakar.todo:id/alertTitle");
    private String textWindowTask = driver.findElement(this.windowTask).getText();
    private By myTask = By.id("com.example.yeshasprabhakar.todo:id/edit_title");
    private By doneBtn = By.id("android:id/button1");
    private By cancelBtn = By.id("android:id/button2");
    private By newTaskName = By.id("com.example.yeshasprabhakar.todo:id/titleRow");
    private String textNewTaskName = driver.findElements(this.newTaskName).getText();
    private By deleteBtn = By.id("com.example.yeshasprabhakar.todo:id/delete");
    private By sunMoonBtn = By.id("com.example.yeshasprabhakar.todo:id/themeActionButton");
    public /*static*/ void main(String[] args) {
        try {
            openTaskApp();
        } catch (Exception exp) {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
        };
        try {
            test1();
            test2();
            test3();
            test4();
            test5();

        } catch (Exception exp) {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
        }
    }
    public static void openTaskApp() throws MalformedURLException {
        //capabilities of the device
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 2 API 30");
        desiredCapabilities.setCapability("undid", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "11");
        //capabilities of the application
        desiredCapabilities.setCapability("appPackage", "");
        desiredCapabilities.setCapability("appActivity", "");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(remoteUrl, desiredCapabilities);

        System.out.println("Test started");
    }

    public void test1(String[] args) {
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);
        driver.findElement(this.plusTask).click();
        Assert.assertEquals("Let's add new task!", textWindowTask);
        driver.findElement(this.myTask).sendKeys("Test");
        driver.findElement(this.doneBtn).click();
        Assert.assertEquals("Test", textNewTaskName);
        System.out.println("Der Task" + textNewTaskName + "wurde angelegt");
    }
        public void test2(String[] args) {
            Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);
            driver.findElement(this.plusTask).click();
            Assert.assertEquals("Let's add new task!", textWindowTask);
            driver.findElement(this.myTask).sendKeys("Test");
            driver.findElement(this.cancelBtn).click();
            Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);
            System.out.println("Kein Task wurde angelegt!");
        }
    public void test3(String[] args) {
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);
        driver.findElement(this.plusTask).click();
        Assert.assertEquals("Let's add new task!", textWindowTask);
        driver.findElement(this.doneBtn).click();
        //Fehlermeldung "Keine Aufgabe angelegt"
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);
    }
    public void test4(String[] args) {
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);
        driver.findElement(this.plusTask).click();
        Assert.assertEquals("Let's add new task!", textWindowTask);
        driver.findElement(this.myTask).sendKeys("Test");
        driver.findElement(this.doneBtn).click();
        Assert.assertEquals("Test", textNewTaskName);
        driver.findElement(this.deleteBtn).click();
        driver.findElement(this.newTaskName).isEnabled();
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);
    }
    public void test5(String[] args) {
        driver.findElement(this.sunMoonBtn).click();
        //dark layout
        driver.findElement(sunMoonBtn).isSelected();
        driver.findElement(this.sunMoonBtn).click();
        //light layout
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
