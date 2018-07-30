package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public WebDriver driver;

    public void navigate(String URL) {
        driver.get(URL);
        System.out.println("Переход на: " + URL);
    }

    @FindBy(css = "a[href*='54425']")
    private WebElement findComputers;

    @FindBy(css = "a[href*='54545']")
    private WebElement findTablets;

    @FindBy(css = ".n-snippet-card2")
    private List<WebElement> findlinksPoint;

    @FindBy(css = "span[data-bem='{\"select\":{\"textAll\":\"Показать все\"}}'] button")
    private WebElement findShowAllButton;

    @FindBy(xpath = "//*[@class='select__list']/div[1]")
    private WebElement findFirstList;

    @FindBy(xpath = "//*[@class='select__list']/div[2]")
    private WebElement findSecondList;


    public void clickTablets() {
        Actions actions = new Actions(driver);
        actions.moveToElement(findComputers);
        actions.perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findTablets.click();
    }

    public void clickShowAllButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(findShowAllButton);
        findShowAllButton.click();
    }

    public int getPointsCount(int point){
        clickShowAllButton();
        if(point == 12)
            findFirstList.click();
        else if(point == 48)
            findSecondList.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findlinksPoint.size();
        return findlinksPoint.size();
    }

}






