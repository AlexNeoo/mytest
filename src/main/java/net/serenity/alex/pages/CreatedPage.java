package net.serenity.alex.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;

import java.lang.reflect.Type;

@DefaultUrl("https://alex.atlassian.net/projects/PROJ/issues/?filter=addedrecently")

public class CreatedPage extends PageObject {

    @FindBy(xpath="//span[text()='To Do']")
    WebElementFacade Label;

    @FindBy(xpath="//span[text()='Done']")
    WebElementFacade Done;

    public void setLabel(String label) {
        Label.click();
        if (label == "Done")
            Done.click();
    }
}

