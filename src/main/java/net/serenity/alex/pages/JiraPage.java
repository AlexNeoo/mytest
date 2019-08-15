package net.serenity.alex.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://alex.atlassian.net/projects/PROJ/issues")

public class JiraPage extends PageObject {

    @FindBy(id="createGlobalItem")
    private WebElementFacade createButton;

    @FindBy(id="create-issue-submit")
    private WebElementFacade submitButton;

    @FindBy(id="summary")
    private WebElementFacade summaryField;

    @FindBy(name="search")
    private WebElementFacade searchField;

    public void add_issue(String issue) {
        createButton.click();
        typeInto(summaryField, issue);
        submitButton.click();
    }

    public void search_issue(String name) {
        typeInto(searchField, name);
    }
}

