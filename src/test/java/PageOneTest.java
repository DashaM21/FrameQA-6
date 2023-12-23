import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import functions.ActionClass;

    public class PageOneTest extends BaseTest {

        @Test
        public void a() {
            driver.get("https://harvest-clothing.com.ua/");
            WebDriverWait wait = new WebDriverWait(driver, 10);

            try {
                WebElement policyConfirm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='policy__confirm']")));
                policyConfirm.click();
                wait.until(ExpectedConditions.stalenessOf(policyConfirm));
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500);");
            WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='btn-wrap double-mt text-center']")));
            wait.until(ExpectedConditions.visibilityOf(element1));
            element1.click();
        }

        @Test
        public void b() throws InterruptedException {
            driver.get("https://harvest-clothing.com.ua/");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='collapsed-content']//a[@href='https://harvest-clothing.com.ua/specials/']")));
            element3.click();
            Thread.sleep(3000);
        }

        @Test
        public void с() throws InterruptedException {
            driver.get("https://harvest-clothing.com.ua/");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element3 = driver.findElement(By.xpath("//div[contains(@class, 'idsearch dropdn dropdn_search hide-mobile only-icon')]"));
            element3.click();
            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='search-input']")));
            searchInput.sendKeys("Сумка", Keys.ENTER);
            wait.until(ExpectedConditions.titleContains("Пошук - Сумка"));
        }

        @Test
        public void d() throws InterruptedException {
            driver.get("https://harvest-clothing.com.ua/");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='mmenu-item--mega o-nas']")));
            Actions actions = new Actions(driver);
            actions.moveToElement(element4).build().perform();
            WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mmenu-col text-uppercase font-rubik']//a[@href='https://harvest-clothing.com.ua/manufacturing']")));
            wait.until(ExpectedConditions.visibilityOf(element5));
            element5.click();
            Thread.sleep(5000);
        }

        @Test
        public void e() throws InterruptedException{
            driver.get("https://harvest-clothing.com.ua/");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500);");
            WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bnslider-arrows container-fluid']//button[@aria-label='Previous']")));
            wait.until(ExpectedConditions.visibilityOf(element6));
            element6.click();
            Thread.sleep(3000);
        }
    }


