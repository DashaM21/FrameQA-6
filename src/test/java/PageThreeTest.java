import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class PageThreeTest extends BaseTest {
    @BeforeMethod
    public void openThreePage() {
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
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement clothes = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hdr-nav']//li[@class='mmenu-item--mega']//a[@href='https://harvest-clothing.com.ua/clothing/']")));
        actions.moveToElement(clothes).build().perform();
        WebElement dresses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mmenu-col']//a[@href='https://harvest-clothing.com.ua/clothing/zhenschinam/w-sukni/']")));
        dresses.click();
        wait.until(ExpectedConditions.titleContains("Купити сукню від українського бренду HARVEST"));
        WebElement blackDress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='prd-img-area']")));
        blackDress.click();
        wait.until(ExpectedConditions.titleContains("Сукня \"Elin\" чорна – HARVEST"));

    }

    @Test
    public void number1() {
        WebElement sizeM = driver.findElement(By.xpath("//ul[@class='size-list js-size-list']//label[@class='radio inStock']"));
        sizeM.click();
        WebElement buyDress = driver.findElement(By.xpath("//div[@class='btn-wrap']"));
        buyDress.click();
        WebDriverWait waitWindow = new WebDriverWait(driver, 10);
        WebElement window = waitWindow.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalCheckOut")));
    }

    @Test
    public void number2() throws InterruptedException {
        WebDriverWait wait6 = new WebDriverWait(driver, 10);
        WebElement feedback = wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='prd-rating']//a[@class='prd-review-link']")));
        feedback.click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");
        WebDriverWait waitStars = new WebDriverWait(driver, 10);
        WebElement stars = waitStars.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wrap']//span[@title='Отлично']")));
        stars.click();
        WebElement buttonSend = driver.findElement(By.id("button-review"));
        buttonSend.click();
        WebElement alertText = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        String textFromSpan = alertText.getText();
        System.out.println(textFromSpan);
    }

    @Test
    public void number3() {
        WebDriverWait wait7 = new WebDriverWait(driver, 10);
        WebElement feedback = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel-heading']//a[@data-src='#hidden-deliviry']")));
        feedback.click();
        WebElement dostavka = wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal--simple modal--md info-modal fancybox-content']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", dostavka);
    }

    @Test
    public void number4() {
        WebDriverWait waitFoto = new WebDriverWait(driver, 10);
        WebElement foto1 = waitFoto.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://harvest-clothing.com.ua/image/cache/webp/catalog/0_Одяг/750440000006370000/IMG-5646-1000x1250.webp']")));
        foto1.click();
        WebElement arrow = waitFoto.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='fancybox-button fancybox-button--arrow_right']")));
        for (int i = 0; i < 8; i++) {
            arrow.click();
        }
    }

    @Test
    public void number5() {
        WebDriverWait waitMessage = new WebDriverWait(driver, 10);
        WebElement message = waitMessage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='b24-widget-button-inner-item b24-widget-button-icon-animation']")));
        message.click();
        WebElement telegram = waitMessage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='b24-widget-button-social-item ui-icon ui-icon-service-telegram connector-icon-45']")));
        telegram.click();
    }
}
