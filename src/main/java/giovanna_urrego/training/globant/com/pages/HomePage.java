package giovanna_urrego.training.globant.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

  @FindBy(className="entry-title")
  private WebElement entryTitle;
  
  @FindBy(id="s")
  private WebElement search;
  
  @FindBy(id="searchsubmit")
  private WebElement searchSubmit;
  
  

  public void go(WebDriver driver) {
    driver.get("http://10.28.148.127/wordpress/");
  }

  public String getPageTitle(WebDriver driver) {
    return driver.getTitle();
  }
  
  public String search(WebDriver driver, String searchText){
    search.sendKeys(searchText);
    searchSubmit.submit();
    WebDriverWait wait = new WebDriverWait(driver, 10000);
    String text = (wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("entry-title")))).getText();
    return text;
  }

}
