package de.dhbw.students.keepthings;

public class LentOutEntry {

    private String title;
    private String person;
    private String dateTo;
    private String dateFrom;

    public LentOutEntry(String title, String person, String dateTo, String dateFrom) {
        this.title = title;
        this.person = person;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;

    }

    public String getTitle() {
        return title;
    }

    public String getPerson() {
        return person;
    }

    public String getDateTo() {
        return dateTo;
    }

    public String getDateFrom() {
        return dateFrom;
    }

}