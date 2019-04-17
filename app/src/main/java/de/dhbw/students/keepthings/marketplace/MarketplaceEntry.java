package de.dhbw.students.keepthings.marketplace;

public class MarketplaceEntry {

    private String title;
    private String owner;
    private String dateTo;
    private String dateFrom;

    public MarketplaceEntry(String title, String owner, String dateTo, String dateFrom) {
        this.title = title;
        this.owner = owner;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;

    }

    public String getTitle() {
        return title;
    }

    public String getOwner() {
        return owner;
    }

    public String getDateTo() {
        return dateTo;
    }

    public String getDateFrom() {
        return dateFrom;
    }

}