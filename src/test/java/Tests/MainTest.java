package Tests;

import Driver.BaseDriver;
import Pages.ComparePage;
import Pages.MainPage;
import Pages.YaLinksPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MainTest extends BaseDriver {
    public MainPage mainPage;
    public ComparePage comparePage;
    public YaLinksPage yaLinksPage;
    final String URL = "https://market.yandex.ru/";
    final String MATCHINTEXT = "Товаров нет";
    final String GOMARKETMAINPAGE = "//a[contains(text(),'Перейти на главную')]";
    final String[] titlePages = {"","видео", "Картинки", "Новости", "Карты", "Маркет", "Переводчик", "Музыка"};

    final int TWELVEPOINTS = 12;
    final int FORTYEIGHPOINTS = 48;
    final int COUNTPOINTSTOCOMPARE = 2;
    final int FIRSTPOINTINLIST = 0;
    final int SECONDPOINTINLIST = 1;

    @Test
    public void countPointsTest() {
        mainPage = new MainPage(driver);
        int countPoints;

        mainPage.navigate(URL);
        mainPage.clickTablets();
        countPoints = mainPage.getPointsCount(TWELVEPOINTS);
        Assert.assertEquals(countPoints, TWELVEPOINTS);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countPoints = mainPage.getPointsCount(FORTYEIGHPOINTS);
        Assert.assertEquals(countPoints, FORTYEIGHPOINTS);

    }


    @Test
    public void compareTest() {
        comparePage = new ComparePage(driver);
        String takeTitle;
        int countItemsInCompare;

        comparePage.getItemsToCompare(FIRSTPOINTINLIST, SECONDPOINTINLIST);
        countItemsInCompare = comparePage.getCountCompareItems();
        Assert.assertEquals(COUNTPOINTSTOCOMPARE, countItemsInCompare);
        comparePage.removeItemsFromCompare();
        takeTitle = comparePage.getAfterRemoveText();
        Assert.assertTrue(takeTitle.contains(MATCHINTEXT));
        //comparePage.goToMarket(GOMARKETMAINPAGE));
    }

    @Test
    public void marketLinksTest() {
        yaLinksPage = new YaLinksPage(driver);
        yaLinksPage.navigate("https://market.yandex.ru/catalog/54545/list?hid=6427100&track=menuleaf&onstock=1&local-offers-first=0");

        boolean resultToNavigate;
        yaLinksPage.goToYa();
        for (int i = 1; i < 8; i++) {
            resultToNavigate = yaLinksPage.goToPage(By.xpath("//div[@role='navigation']/a[" + i + "]"), titlePages[i]);
            System.out.println("Result navigate to pages: " + resultToNavigate);
            Assert.assertTrue(resultToNavigate);
        }
    }
}





