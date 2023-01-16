
//import io.appium.java_client.MobileElement;
        import io.appium.java_client.android.AndroidDriver;
        import junit.framework.TestCase;
        import org.junit.After;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
        import java.net.MalformedURLException;
        import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestMariam<MobileElement> {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 2 API 30");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:platformVersion", "11");
        desiredCapabilities.setCapability("appium:skipUnlock", "false");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        // Test 1
        MobileElement whatToDo = (MobileElement) driver.findElement(By.id("com.example.yeshasprabhakar.todo:id/emptyTextView\n"));
        String textWhatToDo = driver.findElements(whatToDo).getText();
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);

        MobileElement plusTask = (MobileElement) driver.findElement(By.id("com.example.yeshasprabhakar.todo:id/fab"));
        plusTask.click();

        MobileElement windowTask = (MobileElement) driver.findElement(By.id("com.example.yeshasprabhakar.todo:id/alertTitle"));
        String textWindowTask = driver.findElements(windowTask).getText();
        Assert.assertEquals("Let's add new task!", textWindowTask);

        MobileElement myTask = (MobileElement) driver.findElement(By.id("com.example.yeshasprabhakar.todo:id/edit_title"));
        myTask.click().sendKeys("Test");

        MobileElement doneBtn = (MobileElement) driver.findElement(By.id("android:id/button1"));
        doneBtn.click();

        MobileElement newTaskName = (MobileElement) driver.findElement(By.id("com.example.yeshasprabhakar.todo:id/titleRow"));
        String textNewTaskName = driver.findElements(newTaskName).getText();
        Assert.assertEquals("Test", textNewTaskName);

        //Test 2
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);
        plusTask.click();
        Assert.assertEquals("Let's add new task!", textWindowTask);
        myTask.click().sendKeys("Test");
        MobileElement cancelBtn = (MobileElement) driver.findElement(By.id("android:id/button2"));
        cancelBtn.click();
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);

        //Test 3
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);
        plusTask.click();
        Assert.assertEquals("Let's add new task!", textWindowTask);
        doneBtn.click();
        //Fehlermeldung "Keine Aufgabe angelegt"
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);

        //Test 4
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);
        plusTask.click();
        Assert.assertEquals("Let's add new task!", textWindowTask);
        myTask.click().sendKeys("Test");
        doneBtn.click();
        Assert.assertEquals("Test", textNewTaskName);

        MobileElement deleteBtn = (MobileElement) driver.findElement(By.id("com.example.yeshasprabhakar.todo:id/delete"));
        deleteBtn.click();

        Assert.assertThat((NewTastName).enabled); //no newTaskName existing
        Assert.assertEquals("What do you want to do today? You can create new ToDo using + button", textWhatToDo);

        //Test 5
        MobileElement sunMoonBtn = (MobileElement) driver.findElement(By.id("com.example.yeshasprabhakar.todo:id/themeActionButton"));
        //MobileElement background = (MobileElement) driver.findElement(By.class(android.widget.ImageView));
        sunMoonBtn.click();
        //dark layout
        sunMoonBtn.click();
        //light layout

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
