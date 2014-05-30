package HelperClasses;

/**
 * Created by muhammadqureshi on 28/05/2014.
 */
public class UpdateRecorder {
    private String taxReliefFromTaxMan;
    private String yourContri;
    private String totalPensPot;
    private String annPensRealTerms;
    private String delayedPensPot;
    private String delayedannPensRealTerms;

    public void SetValues(String taxReliefFromTaxMan, String yourContri, String totalPensPot, String annPensRealTerms,
                            String delayedPensPot, String delayedannPensRealTerms) {
        this.taxReliefFromTaxMan = taxReliefFromTaxMan;
        this.yourContri = yourContri;
        this.totalPensPot = totalPensPot;
        this.annPensRealTerms = annPensRealTerms;
        this.delayedPensPot = delayedPensPot;
        this.delayedannPensRealTerms = delayedannPensRealTerms;
    }

    public String getTaxReliefFromTaxMan() {
        return taxReliefFromTaxMan;
    }

    public String getYourContri() {
        return yourContri;
    }

    public String getTotalPensPot() {
        return totalPensPot;
    }

    public String getAnnPensRealTerms() {
        return annPensRealTerms;
    }

    public String getDelayedPensPot() {
        return delayedPensPot;
    }

    public String getDelayedannPensRealTerms() {
        return delayedannPensRealTerms;
    }
}
