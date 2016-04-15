package giovanna_urrego.training.globant.com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
  
  @FindBy(css="div time")
  private WebElement time;
  
  @FindBy(tagName="a")
  private List<WebElement> links;
  

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
  
  public String dateTime(WebDriver driver) {
	  String dateTime = time.getAttribute("datetime");
	  return dateTime;
  }
  
  public String[] dateTimeText (WebDriver driver){
	  String dateTimeText[] = new String[2];
	  for (int i = 0; i<dateTimeText.length; i++ ){
	    dateTimeText[i] = time.getText();
	  }
	  return dateTimeText;
  }
  
  public void imprimirArray (String lista[]){
    for(int i=0;i<lista.length;i++){
        System.out.println(lista[i]);
        }
  }
  
  public void clickLinks (WebDriver driver){
    for(int i = 0; i < links.size(); i++) {
      System.out.println(links.get(i));
      String window1 = driver.getWindowHandle();
      new Actions(driver)
      .keyDown(Keys.CONTROL)
      .keyDown(Keys.SHIFT)
      .click(links.get(i))
      .keyUp(Keys.SHIFT)
      .keyUp(Keys.CONTROL)
      .perform();
      //String window2 = driver.getWindowHandle();
      driver.switchTo().window(window1);
      
      //links.get(i).click();
      //entryTitle.click();
      }
  }
  
  

  /*for(int i=0 ; i<linkList.size() ; i++)
  {
      if(linkList.get(i).getAttribute("href").contains("long"))
      {
          linkList.get(i).click();
          break;
      }*/
  //}

}
