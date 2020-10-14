package TestTask;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Logout {
    public WebDriver webDriver = new ChromeDriver();

    public Logout(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @Test
    public void logout() throws InterruptedException {
        webDriver.get("http://demo.hospitalrun.io/#/login");
        Thread.sleep(1000);
        //open login page
        webDriver.findElement(By.id("identification")).sendKeys("hr.doctor@hospitalrun.io");
        webDriver.findElement(By.id("password")).sendKeys("HRt3st12");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"ember480\"]/div/form/div[2]/button")).click();
        Thread.sleep(6000);
        //click on the settings button
        webDriver.findElement(By.xpath("//*[@id=\"ember433\"]/nav/header/a[2]")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"ember433\"]/nav/header/nav/a[1]")).click();
        //logout out of the page
        Assert.assertTrue(webDriver.getCurrentUrl().contains("/#/login"));

    }
    @After
    public void Teardown() {
        if (webDriver != null) ;
        System.out.print("Test was completed");

    }
}
