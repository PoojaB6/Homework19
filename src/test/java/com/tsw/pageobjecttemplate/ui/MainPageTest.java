package com.tsw.pageobjecttemplate.ui;
import com.codeborne.selenide.Configuration;
import com.tsw.pageobjecttemplate.pages.MainPage;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://todomvc.com/examples/react/dist/#/");
    }
    //class 19
    @Test
    public void createNewToDoActionAndItIsShownOnTheList() {
        mainPage.inputField.click();
        mainPage.inputField.setValue("wake up");
        mainPage.inputField.pressEnter();
        mainPage.itemCreated.shouldBe(visible);
    }

    @Test
    public void CreateMultipleActionsAndThenTheActionsAreListedAllTogether() {

        String todoFirstItem = "1.Make a cup of coffee";
        String todoSecondItem = "2.Do some exercise";
        //String locatorTemplate = label[@data-testid='todo-item-label' and contains(text(), '1.Make a cup of coffee')]
        //To build unique locator
        //To build second locator
        //Assert that those locator are presented - so they are unique

        mainPage.inputField.click();
        mainPage.inputField.click();
        mainPage.inputField.setValue(todoFirstItem);
        mainPage.inputField.pressEnter();
        mainPage.inputField.setValue(todoSecondItem);
        mainPage.inputField.pressEnter();
        mainPage.itemCreated.shouldHave(visible);
    }

    //Hm19

    @Test
    public void userIsAbleToMarkTheActionsAsCompleted() {
        mainPage.inputField.click();
        mainPage.inputField.setValue("Make a cup of coffee");
        mainPage.inputField.pressEnter();
        mainPage.itemComplete.click();
        mainPage.itemComplete.isSelected();

    }

     @Test
    public void userIsAbleToClickClearCompletedButton() {
        mainPage.inputField.click();
        mainPage.inputField.setValue("do exercise");
        mainPage.inputField.pressEnter();
        mainPage.itemComplete.click();
        mainPage.clearCompletedButton.click();
    }
}