package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ComparePage {
    public ComparePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;
    ArrayList<String> toCompare = new ArrayList<String>();

    @FindBy(xpath = "//*[@class='n-snippet-card2__toolbar']/descendant::div/i[1]")
    private List<WebElement> itemsToCompare;

    @FindBy(xpath = "//*[@class='popup-informer__content']/descendant::div/a")
    private WebElement compareBtn;

    @FindBy(xpath = "//*[@class='n-compare-content__line i-bem n-compare-content__line_js_inited']/div")
    private List<WebElement> countCompareItems;

    @FindBy(css = ".n-compare-toolbar__action")
    private WebElement removeItems;

    @FindBy(css = ".title_size_18")
    private WebElement afterRemoveText;

    @FindBy(css = "//*[@class='layout layout_type_maya n-page-compare']/descendant::div/a[2]") ////  a[@class='link'][@href='/'] a[contains(text(),'Перейти на главную')]  //*[@class='layout layout_type_maya n-page-compare']/descendant::div/a[2]
    private WebElement goMarket;

    public void getItemsToCompare(int firstItem, int secondItem) {
        Actions actions = new Actions(driver);
        actions.moveToElement(itemsToCompare.get(firstItem));
        itemsToCompare.get(firstItem).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions.moveToElement(itemsToCompare.get(secondItem));
        itemsToCompare.get(secondItem).click();

        compareBtn.click();
    }

    public int getCountCompareItems() {
        System.out.println("Elements in compare: " + countCompareItems.size());
        return countCompareItems.size();
    }

    public void removeItemsFromCompare() {
        removeItems.click();
    }

    public String getAfterRemoveText() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return afterRemoveText.getText();

    }
    public void goToMarket(By locator){
        //Actions actions = new Actions(driver);
        //actions.moveToElement(goMarket);
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        //goMarket.click();
    }
}

