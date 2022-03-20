package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BMICalculatorTest {
    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
    }

    @Test
    public void WeightHeightCmsSITest(){
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("65");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("165");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        String indexSI = driver.findElement(By.xpath("//input[@name='si']")).getAttribute("value");
        Double SI = Double.valueOf(indexSI);
        String text_result = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        String message = "";
        if (SI <= 15){ message = "Your category is Starvation";}
        if (SI > 15 && SI <= 18.5){ message = "Your category is Underweight";}
        if (SI > 18.5 && SI <= 25){ message = "Your category is Normal";}
        if (SI > 25 && SI <= 30){ message = "Your category is Overweight";}
        if (SI > 30){ message = "Your category is Obese";}
        Assert.assertEquals(text_result, message);
    }


    @Test
    public void WeightHeightCmsUSTest(){
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("65");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("165");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        String indexSI = driver.findElement(By.xpath("//input[@name='us']")).getAttribute("value");
        Double SI = Double.valueOf(indexSI);
        String text_result = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        String message = "";
        if (SI <= 15){ message = "Your category is Starvation";}
        if (SI > 15 && SI <= 18.5){ message = "Your category is Underweight";}
        if (SI > 18.5 && SI <= 25.4){ message = "Your category is Normal";}
        if (SI > 25.4 && SI <= 30.5){ message = "Your category is Overweight";}
        if (SI > 30.5){ message = "Your category is Obese";}
        Assert.assertEquals(text_result, message);
    }

    @Test
    public void WeightHeightCmsUKTest(){
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("65");
        driver.findElement(By.xpath("//input[@name='ht']")).sendKeys("165");
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        String indexSI = driver.findElement(By.xpath("//input[@name='uk']")).getAttribute("value");
        Double SI = Double.valueOf(indexSI);
        String text_result = driver.findElement(By.xpath("//input[@class='content']")).getAttribute("value");
        String message = "";
        if (SI <= 95){ message = "Your category is Starvation";}
        if (SI > 95 && SI <= 117){ message = "Your category is Underweight";}
        if (SI > 117 && SI <= 158){ message = "Your category is Normal";}
        if (SI > 158 && SI <= 190){ message = "Your category is Overweight";}
        if (SI > 190){ message = "Your category is Obese";}
        Assert.assertEquals(text_result, message);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
