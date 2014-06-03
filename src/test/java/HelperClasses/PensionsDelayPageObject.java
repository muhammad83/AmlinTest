package HelperClasses;

/**
 * Created by muhammadqureshi on 02/06/2014.
 */
public class PensionsDelayPageObject {
    private String yearOfBirth;
    private String retirementAge;
    private String annualSalary;
    private String pensionContribution;
    private String pensionContributionDD;
    private String delayPension;

    public PensionsDelayPageObject(String yearOfBirth, String retirementAge, String annualSalary, String pensionContribution, String pensionContributionDD, String delayPension){
        this.yearOfBirth = yearOfBirth;
        this.retirementAge = retirementAge;
        this.annualSalary = annualSalary;
        this.pensionContribution = pensionContribution;
        this.pensionContributionDD = pensionContributionDD;
        this.delayPension = delayPension;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setRetirementAge(String retirementAge) {
        this.retirementAge = retirementAge;
    }

    public void setAnnualSalary(String annualSalary) {
        this.annualSalary = annualSalary;
    }

    public void setPensionContribution(String pensionContribution) {
        this.pensionContribution = pensionContribution;
    }

    public void setPensionContributionDD(String pensionContributionDD) {
        this.pensionContributionDD = pensionContributionDD;
    }

    public void setDelayPension(String delayPension) {
        this.delayPension = delayPension;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getRetirementAge() {
        return retirementAge;
    }

    public String getAnnualSalary() {
        return annualSalary;
    }

    public String getPensionContribution() {
        return pensionContribution;
    }

    public String getPensionContributionDD() {
        return pensionContributionDD;
    }

    public String getDelayPension() {
        return delayPension;
    }
}
