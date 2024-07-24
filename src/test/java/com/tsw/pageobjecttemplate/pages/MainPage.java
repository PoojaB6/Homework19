package com.tsw.pageobjecttemplate.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
// page_url = https://todomvc.com/examples/react/dist/#/active/
public class MainPage {

    public SelenideElement inputField = $("[data-testid='text-input']");
    public SelenideElement itemCreated = $("[data-testid='todo-item-label']");
    public SelenideElement itemComplete = $("[data-testid='todo-item-toggle']");
    public SelenideElement clearCompletedButton = $(By.className("clear-completed"));

}