package gr.ntua.ece.softeng.kidspiration;

public class MonthProviderReference {
    private int id;
    private int provider_id;
    private double january;
    private double february;
    private double march;
    private double april;
    private double may;
    private double june;
    private double july;
    private double august;
    private double september;
    private double octomber;
    private double november;
    private double december;

    public MonthProviderReference(int id, int provider_id, double january, double february, double march, double april, double may, double june, double july, double august, double september, double octomber, double november, double december) {
        this.id = id;
        this.provider_id = provider_id;
        this.january = january;
        this.february = february;
        this.march = march;
        this.april = april;
        this.may = may;
        this.june = june;
        this.july = july;
        this.august = august;
        this.september = september;
        this.octomber = octomber;
        this.november = november;
        this.december = december;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public double getJanuary() {
        return january;
    }

    public void setJanuary(double january) {
        this.january = january;
    }

    public double getFebruary() {
        return february;
    }

    public void setFebruary(double february) {
        this.february = february;
    }

    public double getMarch() {
        return march;
    }

    public void setMarch(double march) {
        this.march = march;
    }

    public double getApril() {
        return april;
    }

    public void setApril(double april) {
        this.april = april;
    }

    public double getMay() {
        return may;
    }

    public void setMay(double may) {
        this.may = may;
    }

    public double getJune() {
        return june;
    }

    public void setJune(double june) {
        this.june = june;
    }

    public double getJuly() {
        return july;
    }

    public void setJuly(double july) {
        this.july = july;
    }

    public double getAugust() {
        return august;
    }

    public void setAugust(double august) {
        this.august = august;
    }

    public double getSeptember() {
        return september;
    }

    public void setSeptember(double september) {
        this.september = september;
    }

    public double getOctomber() {
        return octomber;
    }

    public void setOctomber(double octomber) {
        this.octomber = octomber;
    }

    public double getNovember() {
        return november;
    }

    public void setNovember(double november) {
        this.november = november;
    }

    public double getDecember() {
        return december;
    }

    public void setDecember(double december) {
        this.december = december;
    }
}
