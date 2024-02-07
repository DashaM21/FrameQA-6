package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageThreePage extends BasePage {
    public PageThreePage(WebDriver driver) {
        super(driver);
    }
    {
        try {
            WebElement elementSubscription = driver
                    .findElement(By.xpath("//div[class='cl-floating-box-close-icon']"));

                elementSubscription.click();
                System.out.println("Нажатие выполнено.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
