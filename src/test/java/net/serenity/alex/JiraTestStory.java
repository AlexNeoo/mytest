package net.serenity.alex;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import net.serenity.alex.steps.EndUserSteps;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@RunWith(ThucydidesRunner.class)
public class JiraTestStory {
    String new_issue = "new issue-07 15.08.2019";

    @Managed()
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://alex.atlassian.net/")
    public Pages page;

    @Steps
    public EndUserSteps endUser;

    @Issue("#Jira-1")
    @Before
    public void user_can_login_to_the_jira_main_page() {
        endUser.is_on_the_login_page();
        endUser.login_with("al.nezhurenko@gmail.com");
        endUser.should_see("Projects");
    }

    @Test()
    public void a_user_can_create_new_issue_on_the_jira_page() {
        endUser.is_on_the_issue_page();
        endUser.creates_issue(new_issue);
        endUser.should_see_issue_in_the_issue_list(new_issue);
    }

    @Test()
    public void b_user_can_find_existing_issue_via_jira_search() {
        endUser.is_on_the_issue_page();
        endUser.enters_existing_issue_into_jira_search("proj-5");
        endUser.should_see_issue_on_the_serch_result("issue-1");
    }

    @Test()
    public void c_user_can_update_existing_issue() {
        endUser.is_on_the_created_recently_issue_page();
        endUser.updates_status_of_last_issue_to("Done");
        endUser.should_see_issue_on_the_done_page(new_issue);
    }
}