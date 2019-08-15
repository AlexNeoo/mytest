package net.serenity.alex.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://alex.atlassian.net/")

public class StartPage extends PageObject {

    @FindBy(id="username")
    private WebElementFacade emailField;

    @FindBy(id="login-submit")
    private WebElementFacade submitButton;

    @FindBy(id="password")
    private WebElementFacade passwordField;

    @FindBy(id="login-submit")
    private WebElementFacade loginButton;


    public void login_with(String keyword) {
        typeInto(emailField, keyword);
        submitButton.click();
        typeInto(passwordField, "20202020");
        loginButton.click();
    }

}