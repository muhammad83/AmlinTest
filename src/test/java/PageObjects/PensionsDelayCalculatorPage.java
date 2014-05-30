package PageObjects;

import HelperClasses.PensionPageHelper;
import HelperClasses.UpdateRecorder;
import SharedDriver.SharedDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by muhammadqureshi on 26/05/2014.
 */
public class PensionsDelayCalculatorPage {

    private SharedDriver driver;
    private PensionPageHelper pensionPageHelper;

    private WebElement yearBornTB;
    private WebElement retirementAgeTB;
    private WebElement annualSalaryTB;
    private WebElement pensionContributionTB;
    private WebElement pensionContributionDD;
    private WebElement delayStartTB;
    private WebElement taxReliefLB;
    private WebElement yourContriLB;
    private WebElement totalPensPotLB;
    private WebElement annualPensRealTermLB;
    private WebElement delayedPenPotLB;
    private WebElement delayedAnnualPenRealTermLB;
    private Select contrDD;
    private UpdateRecorder updateRecorder;

    public PensionsDelayCalculatorPage(final SharedDriver driver) {
        this.driver = driver;
        String URL = "http://www.bestinvest.co.uk/investment-tools-and-calculators/pension-delay-calculator";
        driver.navigate().to(URL);
        updateRecorder = new UpdateRecorder();
    }

    public void SetFormValues(String yearOfBirth, String retAge, String annualSal, String penContr, String yearlyOrMonthly, String delayPen) {

        ChangeFrame();
        SetPageValuesToVariables();

        SetJSTextBoxValue(yearBornTB, yearOfBirth);
        SetJSTextBoxValue(retirementAgeTB, retAge);
        SetJSTextBoxValue(annualSalaryTB, annualSal);
        SetJSTextBoxValue(pensionContributionTB, penContr);
        SetJSTextBoxValue(delayStartTB,delayPen);

        contrDD = new Select(pensionContributionDD);
        contrDD.selectByValue(String.valueOf(yearlyOrMonthly));
    }

    public void SetFormValues(String yearOfBirth, String retAge, String annualSal, String penContr, String yearlyOrMonthly) {
        SetFormValues(yearOfBirth, retAge, annualSal, penContr, yearlyOrMonthly, "0");
    }

    public void ButtonClick(String buttonName) {

        driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]")).click();
    }

    public Boolean CheckAllFieldsAreReset(String yearOfBirth, String retAge, String annualSal, String penContr,
                                          String yearlyOrMonthly, String taxRelief, String yourContri, String totalPensPot,
                                          String annPensRealTerm, String delayStart, String delayedPensPot,
                                          String delayedAnnPensRealTerm) {

        if (!yearBornTB.getAttribute("value").contentEquals(yearOfBirth)
                || !retirementAgeTB.getAttribute("value").contentEquals(retAge)
                || !annualSalaryTB.getAttribute("value").contentEquals(annualSal)
                || !pensionContributionTB.getAttribute("value").contentEquals(penContr)
                || !contrDD.getFirstSelectedOption().getText().contentEquals(yearlyOrMonthly)
                || !taxReliefLB.getAttribute("value").contentEquals(taxRelief)
                || !yourContriLB.getAttribute("value").contentEquals(yourContri)
                || !totalPensPotLB.getAttribute("value").contentEquals(totalPensPot)
                || !annualPensRealTermLB.getAttribute("value").contentEquals(annPensRealTerm)
                || !delayStartTB.getAttribute("value").contentEquals(delayStart)
                || !delayedPenPotLB.getAttribute("value").contentEquals(delayedPensPot)
                || !delayedAnnualPenRealTermLB.getAttribute("value").contentEquals(delayedAnnPensRealTerm)) {
            return false;
        }

        return true;
    }

    public Boolean CheckAllFieldsAreReset(String resetORWrongValue) {

        if (resetORWrongValue.equals(pensionPageHelper.ResetForm)) {
            return CheckAllFieldsAreReset("1980", "65", "", "", pensionPageHelper.monthlyOption, "£0", "£0", "£0", "£0", "", "£0", "£0");
        } else if (resetORWrongValue.equals(pensionPageHelper.WrongValues)) {
            return CheckAllFieldsAreReset("0", "0", "0", "0", pensionPageHelper.monthlyOption, "£0", "£0", "NaN", "NaN", "0", "NaN", "NaN");
        }

        return false;
    }

    public void ChangeYearOfBirth(String yearOfBirth) {
        yearBornTB.clear();
        yearBornTB.sendKeys(yearOfBirth);
    }

    public void ChangeRetAge(String retAge) {
        retirementAgeTB.clear();
        retirementAgeTB.sendKeys(retAge);
    }

    public void ChangeAnnualSal(String annualSal) {
        annualSalaryTB.clear();
        annualSalaryTB.sendKeys(annualSal);
    }

    public void ChangePensContri(String pensContri) {
        pensionContributionTB.clear();
        pensionContributionTB.sendKeys(pensContri);
    }

    public void ChangeDelayPensionStart(String delayPensStart) {
        delayStartTB.clear();
        delayStartTB.sendKeys(delayPensStart);
    }

    public void StoreLastDisplayedValue() {
        updateRecorder.SetValues(taxReliefLB.getAttribute("value"), yourContriLB.getAttribute("value"),
                totalPensPotLB.getAttribute("value"), annualPensRealTermLB.getAttribute("value"),
                delayedPenPotLB.getAttribute("value"), delayedAnnualPenRealTermLB.getAttribute("value"));
    }

    public Boolean CheckPageForUpdates() {
        if (updateRecorder.getTaxReliefFromTaxMan().equals(taxReliefLB.getAttribute("value"))
                || updateRecorder.getYourContri().equals(yourContriLB.getAttribute("value"))
                || updateRecorder.getTotalPensPot().equals(totalPensPotLB.getAttribute("value"))
                || updateRecorder.getAnnPensRealTerms().equals(annualPensRealTermLB.getAttribute("value")))
            return false;

        return true;

    }

    public Boolean CheckPageForPensDelayUpdates() {
        if (updateRecorder.getDelayedPensPot().equals(delayedPenPotLB.getAttribute("value"))
                || updateRecorder.getDelayedannPensRealTerms().equals(delayedAnnualPenRealTermLB.getAttribute("value")))
            return false;

        return true;

    }

    public void CheckCalculation(){
        totalPensPotLB.getAttribute("value")
    }

    private void ChangeFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
    }

    private void SetPageValuesToVariables() {
        yearBornTB = driver.findElement(By.id("XLEW_2_6_4"));
        retirementAgeTB = driver.findElement(By.id("XLEW_2_7_4"));
        annualSalaryTB = driver.findElement(By.id("XLEW_2_8_4"));
        pensionContributionTB = driver.findElement(By.id("XLEW_2_9_4"));
        pensionContributionDD = driver.findElement(By.id("XLEW_2_9_5"));
        delayStartTB = driver.findElement(By.id("XLEW_2_23_4"));
        taxReliefLB = driver.findElement(By.id("XLEW_2_10_3"));
        yourContriLB = driver.findElement(By.id("XLEW_2_11_3"));
        totalPensPotLB = driver.findElement(By.id("XLEW_2_19_3"));
        annualPensRealTermLB = driver.findElement(By.id("XLEW_2_20_3"));
        delayedPenPotLB = driver.findElement(By.id("XLEW_2_25_3"));
        delayedAnnualPenRealTermLB = driver.findElement(By.id("XLEW_2_26_3"));
    }

    private void ClearTextBoxValue(WebElement textBoxToClear) {
        textBoxToClear.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        textBoxToClear.sendKeys(Keys.BACK_SPACE);
    }

    private void CallOnChangeFunction(WebElement textBoxToCallOn) {
        driver.executeScript(
                "console.log(arguments[0]); $(arguments[0]).change(); return true;"
                , textBoxToCallOn);

    }

    private void SetJSTextBoxValue(WebElement jSTextBox, String value){
        ClearTextBoxValue(jSTextBox);
        jSTextBox.sendKeys(value);
        CallOnChangeFunction(jSTextBox);
    }


}
