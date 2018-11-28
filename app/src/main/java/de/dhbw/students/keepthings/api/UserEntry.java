package de.dhbw.students.keepthings.api;

public class UserEntry {

    private String USER_ID;
    private String NAME;
    private String FIRST_NAME;
    private String PASSWORD;
    private String E_MAIL;
    private String TEL_NR;
    private String USERNAME;
    private String TYPE;
    private boolean VERIFIED;
    private boolean success;



    public UserEntry(String USER_ID, String NAME, String FIRST_NAME, String PASSWORD, String e_MAIL, String TEL_NR, String USERNAME, String TYPE, boolean VERIFIED, boolean success) {
        this.USER_ID = USER_ID;
        this.NAME = NAME;
        this.FIRST_NAME = FIRST_NAME;
        this.PASSWORD = PASSWORD;
        E_MAIL = e_MAIL;
        this.TEL_NR = TEL_NR;
        this.USERNAME = USERNAME;
        this.TYPE = TYPE;
        this.VERIFIED = VERIFIED;
        this.success = success;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getE_MAIL() {
        return E_MAIL;
    }

    public void setE_MAIL(String e_MAIL) {
        E_MAIL = e_MAIL;
    }

    public String getTEL_NR() {
        return TEL_NR;
    }

    public void setTEL_NR(String TEL_NR) {
        this.TEL_NR = TEL_NR;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public boolean isVERIFIED() {
        return VERIFIED;
    }

    public void setVERIFIED(boolean VERIFIED) {
        this.VERIFIED = VERIFIED;
    }

    public boolean isSuccess() {return success;}

    public void setSuccess(boolean success) {this.success = success;}
}