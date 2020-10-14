package TestTask;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class InvalidLogin {
    public WebDriver webDriver = new ChromeDriver();

    public InvalidLogin(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @Test
    public void InvalidTest() throws InterruptedException {
        webDriver.get("http://demo.hospitalrun.io/#/login");
        //open login page
        Thread.sleep(2000);
        webDriver.findElement(By.id("identification")).sendKeys("hr.doctor@hos.io");
        webDriver.findElement(By.id("password")).sendKeys("HRt12");
        Thread.sleep(1000);
        //login with invalid creds
        webDriver.findElement(By.xpath("//*[@id=\"ember480\"]/div/form/div[2]/button")).click();
        Thread.sleep(6000);
        Assert.assertTrue(webDriver.getCurrentUrl().contains("#/login"));
        boolean error = webDriver.findElements(By.xpath("//*[@id=\"ember433\"]/div/form/div[2]/div[1]")).size() > 0;
        //check if the error message is shown
        if (error)
            System.out.print("The error message is shown");
        else if (!error)
            System.out.print("Th error message is missing");

    }

    @After
    public void Teardown() {
        if (webDriver != null) ;
        System.out.print("Test was completed");

    }
}
