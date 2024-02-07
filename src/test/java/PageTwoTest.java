import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static java.lang.System.in;

public class PageTwoTest extends BaseTest{
    @BeforeMethod
        public void openTwoPage(){
            driver.get("https://harvest-clothing.com.ua/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement policyConfirm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='policy__confirm']")));
            policyConfirm.click();
            wait.until(ExpectedConditions.stalenessOf(policyConfirm));
        } catch (TimeoutException e) {
            System.out.println("Cookies відсутні. Продовжуєм");
        }
        Actions actions = new Actions(driver);
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        WebElement acsesuars = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hdr-nav']//li[@class='mmenu-item--mega']")));
        actions.moveToElement(acsesuars).build().perform();
        WebElement backpacks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='submenu-list']//a[@href='https://harvest-clothing.com.ua/accessories/backpacks/womens/']")));
        backpacks.click();
        wait.until(ExpectedConditions.titleContains("Купити жіночий міський рюкзак в Україні від бренду HARVEST"));
        }
    @Test
    public void first(){
        WebElement sortuvatu = driver.findElement(By.xpath("//select[@class='form-control input-sm']"));
        sortuvatu .click();
        Select select = new Select(sortuvatu);
        select.selectByVisibleText("Ціна (висока > низька)");
    }

    @Test
    public void second(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600);");
        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        try {
            WebElement podzvonutu = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cl-floating-box-close-icon']")));
            podzvonutu.click();
            wait4.until(ExpectedConditions.stalenessOf(podzvonutu));
        } catch (TimeoutException e) {
            System.out.println("Cookies відсутні. Продовжуєм");
        }
        WebElement size = driver.findElement(By.xpath("//label[@for='filter-9']"));
        size.click();
        WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
    }
    @Test
    public void third(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1200);");
        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        try {
            WebElement podzvonutu = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cl-floating-box-close-icon']")));
            podzvonutu.click();
            wait4.until(ExpectedConditions.stalenessOf(podzvonutu));
        } catch (TimeoutException e) {
            System.out.println("Cookies відсутні. Продовжуєм");
        }
        WebElement koton = driver.findElement(By.xpath("//label[@for='filter-28']"));
        koton.click();
        WebElement lon = driver.findElement(By.xpath("//label[@for='filter-19']"));
        lon.click();
        WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
    }
    @Test
    public void fourth(){
        WebElement product = driver.findElement(By.xpath("//div[@class='prd-img-area']"));
        product.click();
        WebDriverWait waitProduvt = new WebDriverWait(driver, 10);
        waitProduvt.until(ExpectedConditions.titleContains("Рюкзак в літак \"AVIAPACK\" кеш'ю - HARVEST"));
    }
    @Test
    public void fifth() throws InterruptedException{
        Thread.sleep(5000);
        WebElement like = driver.findElement(By.xpath("//div[@class='prd-grid-wrap']//div[@class='prd prd-has-loader prd-sale prd-new product-grid aos-init aos-animate loaded']//a[@class='label-wishlist icon-heart js-label-wishlist ']"));
        like.click();
        WebElement iconkaLike = driver.findElement(By.xpath("//i[@class='icon icon-heart-1']"));
        iconkaLike.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleContains("Мої закладки"));
    }
    }
