package giovanna_urrego.training.globant.com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import giovanna_urrego.training.globant.com.pages.HomePage;
import junit.framework.Assert;

public class Tests {

  WebDriver driver;

  @BeforeMethod
  public void before() {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
  }

/*  @AfterMethod
  public void after() {
    driver.quit();
  }*/

/*  @Test
  public void verifyTitle() {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    homePage.go(driver);
    Assert.assertEquals("Automation Training | Aprender a automatizar en un solo sitio", homePage.getPageTitle(driver));
  }*/
  
/*  @Test
  public void verifySearch(){
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    homePage.go(driver);
    Assert.assertEquals("Nothing Found", homePage.search(driver, "nanan"));
  }*/
  
  @Test
  public void verifyDisplayedDate(){
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	homePage.go(driver);
	System.out.println("FECHA" + homePage.dateTime(driver));
	String lista[] = homePage.dateTimeText(driver);
	System.out.println("FECHA TEXTO");
	homePage.imprimirArray(lista);
	homePage.clickLinks(driver);
  }
  

}
