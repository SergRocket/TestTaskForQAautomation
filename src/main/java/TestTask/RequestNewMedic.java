package TestTask;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class RequestNewMedic {
    public WebDriver webDriver = new ChromeDriver();

    public RequestNewMedic(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @Test
    public void requestMedic() throws InterruptedException {
        webDriver.get("http://demo.hospitalrun.io/#/login");
        Thread.sleep(1000);
        //open the login page
        webDriver.findElement(By.id("identification")).sendKeys("hr.doctor@hospitalrun.io");
        webDriver.findElement(By.id("password")).sendKeys("HRt3st12");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"ember480\"]/div/form/div[2]/button")).click();
        Thread.sleep(6000);
        webDriver.findElement(By.id("ember767")).click();
        Thread.sleep(2000);
        //ckick on the new request item
        boolean requests = webDriver.findElements(By.id("ember2115")).size()>0;
        boolean completed = webDriver.findElements(By.id("ember2118")).size()>0;
        boolean newreqiest = webDriver.findElements(By.id("ember2137")).size()>0;
        boolean returns = webDriver.findElements(By.id("ember2177")).size()>0;
        if((requests) && (completed) && (newreqiest) && (returns))
            System.out.print("All elements are shown");
        else if((!requests) && (!completed) && (!newreqiest) && (!returns))
            System.out.print("One of the elements is missing");
        //check if all elements are shown
        webDriver.findElement(By.id("ember2137")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.id("patientTypeAhead-ember2510")).sendKeys("Test Patient");
        WebElement testpatient = webDriver.findElement(By.xpath("//*[@id=\"ember2546\"]/span/div/div/div[4]/strong"));
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("arguments[0].click()", testpatient);
        Thread.sleep(500);
        webDriver.findElement(By.id("visit-ember2555")).click();
        Thread.sleep(1000);
        WebElement visit = webDriver.findElement(By.xpath("//*[@id=\"visit-ember2555\"]/option[2]"));
        jse.executeScript("arguments[0].click()", visit);
        webDriver.findElement(By.id("inventoryItemTypeAhead-ember2577")).sendKeys(" Pramoxine");
        WebElement prescript = webDriver.findElement(By.id("prescription-ember2609"));
        //fill all input fields with data
        jse.executeScript("arguments[0].click()", prescript);
        Thread.sleep(1000);
        webDriver.findElement(By.id("prescription-ember2609")).sendKeys("Testing prescription");
        webDriver.findElement(By.id("display_prescriptionDate-ember2632")).click();
        webDriver.findElement(By.id("display_prescriptionDate-ember2632")).sendKeys("10/15/2020");
        int min = 1;
        int max = 5;
        int randomInt = (int)(Math.random()*(max - min+1)+min);
        String randomNum = Integer.toString(randomInt);
        //select the random quantity
        webDriver.findElement(By.id("quantity-ember2651")).sendKeys(randomNum);
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"ember2473\"]/div/div[2]/button[2]")).click();
        Thread.sleep(3000);
        //complete the request
        Assert.assertTrue(webDriver.findElements(By.xpath("//*[@id=\"ember2838\"]/div/div/div")).size()>0);
        Assert.assertTrue(webDriver.findElements(By.xpath("//*[@id=\"ember2922\"]/div/div/div/div[3]/button"))
                .size()>0);
        //check if the pop up is shown
        webDriver.findElement(By.xpath("//*[@id=\"ember2922\"]/div/div/div/div[3]/button")).click();
        Assert.assertTrue(webDriver.findElements(By.xpath("//*[@id=\"ember2838\"]/div/div/div")).size()==0);
        Assert.assertTrue(webDriver.getCurrentUrl().contains("/medication/edit/new"));
        //check if the request was successful

    }
    @After
    public void Teardown() {
        if (webDriver != null) ;
        System.out.print("Test was completed");

    }
}
