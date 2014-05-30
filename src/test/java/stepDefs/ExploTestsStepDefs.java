package stepDefs;

import HelperClasses.PensionPageHelper;
import PageObjects.PensionsDelayCalculatorPage;
import SharedDriver.SharedDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by muhammadqureshi on 26/05/2014.
 */
public class ExploTestsStepDefs {

    private SharedDriver driver;
    private PensionsDelayCalculatorPage pensionsDelayCalculatorPage;
    private PensionPageHelper pensionPageHelper;

    private String yearOfBirth = "1983";
    private String retAge = "60";
    private String grossSal = "120,000";
    private String pensContri = "5,000";
    private String contriMonthlyOrYearly = pensionPageHelper.monthlyOption;
    private String delayPensStart = "0";

    public ExploTestsStepDefs() {
        driver = new SharedDriver();
        pensionsDelayCalculatorPage = new PensionsDelayCalculatorPage(driver);


    }

    @Given("^I have provided all the details on the Pensions Delay Calculator form$")
    public void I_have_provided_all_the_details_on_the_Pensions_Delay_Calculator_form() throws Throwable {
        pensionsDelayCalculatorPage.SetFormValues(yearOfBirth, retAge, grossSal, pensContri, contriMonthlyOrYearly);
    }

    @When("^I click \"([^\"]*)\" button$")
    @And("^I click on \"([^\"]*)\" button.$")
    @Then("^I click on \"([^\"]*)\" button$")
    public void I_click_button(String button) throws Throwable {
        pensionsDelayCalculatorPage.StoreLastDisplayedValue();
        pensionsDelayCalculatorPage.ButtonClick(button);
    }

    @Then("^I should see all the fields reset to (\\d+)$")
    public void I_should_see_all_the_fields_reset_to(int arg1, String arg2) throws Throwable {
        Assert.assertTrue(pensionsDelayCalculatorPage.CheckAllFieldsAreReset(pensionPageHelper.ResetForm));
    }

    @When("^I update “Year you were born” field$")
    public void I_update_Year_you_were_born_field() throws Throwable {
        yearOfBirth = "1980";
        pensionsDelayCalculatorPage.ChangeYearOfBirth(yearOfBirth);
    }

    @Then("^the “Tax relief from the taxman”, “Your contribution” fields and “Results” section apart from “If you delay starting your pension by” field of the page should display calculated values.$")
    @And("^I should see the “Results” section of the page with updated results.$")
    public void I_should_see_the_Results_section_of_the_page_with_updated_results() throws Throwable {
        Assert.assertTrue(pensionsDelayCalculatorPage.CheckPageForUpdates());
    }

    @When("^I update “Retirement age” field$")
    public void I_update_Retirement_age_field() throws Throwable {
        retAge = "65";
        pensionsDelayCalculatorPage.ChangeRetAge(retAge);
    }

    @When("^I update “Annual salary before tax \\(£\\)” field$")
    public void I_update_Annual_salary_before_tax_£_field() throws Throwable {
        grossSal = "150,000";
        pensionsDelayCalculatorPage.ChangeAnnualSal(grossSal);
    }

    @When("^I update “Gross pension contribution \\(£\\)” field$")
    public void I_update_Gross_pension_contribution_£_field() throws Throwable {
        pensContri = "7,000";
        pensionsDelayCalculatorPage.ChangePensContri(pensContri);
    }

    @When("^I update “If you delay starting your pension by” field$")
    public void I_update_If_you_delay_starting_your_pension_by_field() throws Throwable {
        delayPensStart = "10";
        pensionsDelayCalculatorPage.ChangeDelayPensionStart(delayPensStart);
    }

    @Then("^I should see the “Your total delayed pension pot could be” and “Delayed annual pension in real terms” fields with updated results.$")
    public void I_should_see_the_Your_total_delayed_pension_pot_could_be_and_Delayed_annual_pension_in_real_terms_fields_with_updated_results() throws Throwable {
        pensionsDelayCalculatorPage.CheckPageForPensDelayUpdates();
    }

    @Given("^I have provided non numeric values for all the fields$")
    public void I_have_provided_non_numeric_values_for_all_the_fields() throws Throwable {
        pensionsDelayCalculatorPage.SetFormValues("a","b","c","d",pensionPageHelper.monthlyOption,"e");
    }

    @Then("^I should get “NaN” in the Results sections of the page.$")
    public void I_should_get_NaN_in_the_Results_sections_of_the_page() throws Throwable {
        Assert.assertTrue(pensionsDelayCalculatorPage.CheckAllFieldsAreReset(pensionPageHelper.WrongValues));
    }

    @Given("^I have provided negative values for “Year you were born” and “Retirement age”.$")
    public void I_have_provided_negative_values_for_Year_you_were_born_and_Retirement_age_() throws Throwable {
       pensionsDelayCalculatorPage.SetFormValues("-1","-2","20,000","500",pensionPageHelper.monthlyOption);
    }

    @Given("^I have provided (\\d+) digits for “Year you were born”$")
    public void I_have_provided_digits_for_Year_you_were_born(int arg1) throws Throwable {
        pensionsDelayCalculatorPage.SetFormValues("83","60","70,000","1,000",pensionPageHelper.monthlyOption);
    }

    @Given("^I have provided all the details and selected “Gross pension contribution” drop down option as “Yearly”$")
    public void I_have_provided_all_the_details_and_selected_Gross_pension_contribution_drop_down_option_as_Yearly() throws Throwable {
        pensionsDelayCalculatorPage.SetFormValues("83","60","70,000","25,000",pensionPageHelper.yearlyOption);
    }

    @Then("^I should get the “Results” page calculations done with yearly contribution.$")
    public void I_should_get_the_Results_page_calculations_done_with_yearly_contribution() throws Throwable {
        pensionsDelayCalculatorPage.Ch

    }
}
