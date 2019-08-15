package net.serenity.alex.steps;

import net.serenity.alex.pages.CreatedPage;
import net.serenity.alex.pages.DonePage;
import net.serenity.alex.pages.JiraPage;
import net.serenity.alex.pages.StartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static java.util.concurrent.TimeUnit.SECONDS;

public class EndUserSteps extends ScenarioSteps {

    StartPage startPage;
    JiraPage jiraPage;
    DonePage donePage;
    CreatedPage createdPage;

    @Step
    public void is_on_the_login_page() {
        startPage.open();
    }

    @Step
    public void login_with(String email) {
        startPage.setImplicitTimeout( 2, SECONDS);
        startPage.login_with(email);
        startPage.waitForAllTextToAppear("Projects");
    }

    @Step
    public void should_see(String text) { assert(startPage.containsText(text));
    }

    @Step
    public void is_on_the_issue_page() {
        jiraPage.setImplicitTimeout( 20, SECONDS);
        jiraPage.open();
        jiraPage.waitForAllTextToAppear("Open issues");
    }

    @Step
    public void is_on_the_created_recently_issue_page() {
        createdPage.setImplicitTimeout( 20, SECONDS);
        createdPage.open();
        createdPage.waitForAllTextToAppear("Created recently");
    }

    @Step
    public void updates_status_of_last_issue_to(String text) {
        createdPage.setImplicitTimeout( 20, SECONDS);
        createdPage.setLabel(text);
        createdPage.waitForAllTextToAppear(text);
    }

    @Step
    public void creates_issue(String issue) {
        jiraPage.setImplicitTimeout( 20, SECONDS);
        jiraPage.add_issue(issue);
        jiraPage.waitForAllTextToAppear("Open issues");
    }

    @Step
    public void should_see_issue_in_the_issue_list(String text) {
        createdPage.setImplicitTimeout( 20, SECONDS);
        createdPage.open();
        createdPage.waitForAllTextToAppear("Created recently");
        assert(startPage.containsText(text));
    }

    @Step
    public void should_see_issue_on_the_done_page(String text) {
        donePage.setImplicitTimeout( 20, SECONDS);
        donePage.open();
        donePage.waitForAllTextToAppear("Done issues");
        assert(startPage.containsText(text));
    }

    @Step
    public void enters_existing_issue_into_jira_search(String name) {
        jiraPage.setImplicitTimeout( 20, SECONDS);
        jiraPage.waitForAllTextToAppear("Advanced search");
        jiraPage.search_issue(name);
        jiraPage.waitForAllTextToAppear("issue");
    }

    @Step
    public void should_see_issue_on_the_serch_result(String text) {
        assert (jiraPage.containsText(text));
    }
}