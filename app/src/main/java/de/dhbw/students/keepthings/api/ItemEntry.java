package de.dhbw.students.keepthings.api;

import java.sql.Date;

public class ItemEntry {
    private int ITEM_ID;
    private String ITEM_NAME;
    private String ITEM_DESC;
    private int OWNER;
    private String BORROWER;
    private String DATE_FROM;
    private String DATE_TO;
    private boolean success;

    public int getITEM_ID() {
        return ITEM_ID;
    }

    public void setITEM_ID(int ITEM_ID) {
        this.ITEM_ID = ITEM_ID;
    }

    public String getITEM_NAME() {
        return ITEM_NAME;
    }

    public void setITEM_NAME(String ITEM_NAME) {
        this.ITEM_NAME = ITEM_NAME;
    }

    public String getITEM_DESC() {
        return ITEM_DESC;
    }

    public void setITEM_DESC(String ITEM_DESC) {
        this.ITEM_DESC = ITEM_DESC;
    }

    public int getOWNER() {
        return OWNER;
    }

    public void setOWNER(int OWNER) {
        this.OWNER = OWNER;
    }

    public String getBORROWER() {
        return BORROWER;
    }

    public void setBORROWER(String BORROWER) {
        this.BORROWER = BORROWER;
    }

    public String getDATE_FROM() {
        return DATE_FROM;
    }

    public void setDATE_FROM(String DATE_FROM) {
        this.DATE_FROM = DATE_FROM;
    }

    public String getDATE_TO() {
        return DATE_TO;
    }

    public void setDATE_TO(String DATE_TO) {
        this.DATE_TO = DATE_TO;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ItemEntry(int ITEM_ID, String ITEM_NAME, String ITEM_DESC, int OWNER, String BORROWER, String DATE_FROM, String DATE_TO, boolean success) {

        this.ITEM_ID = ITEM_ID;
        this.ITEM_NAME = ITEM_NAME;
        this.ITEM_DESC = ITEM_DESC;
        this.OWNER = OWNER;
        this.BORROWER = BORROWER;
        this.DATE_FROM = DATE_FROM;
        this.DATE_TO = DATE_TO;
        this.success = success;
    }
}
