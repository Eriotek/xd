//package loginPackage;
//
//import org.openqa.selenium.NoSuchContextException;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//
///**
// * Created by student01 on 15.12.15.
// */
//public class LoginPage {
//
//    private HomePageLocator locators;
//
//    public LoginPage(WebDriver driver) {
//        locators = new HomePageLocator();
//        PageFactory.initElements(driver, locators);
//
//    }
//
//    public void loginAs(String username, String password) {
//        locators.usernameInput.sendKeys(username);
//        locators.passwordInput.sendKeys(password);
//        locators.signInButton.click();
//    }
//
//    public boolean isError() {
//        try {
//            locators.signInError.isDisplayed();
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//}
