package de.dhbw.students.keepthings.api;

import java.sql.Timestamp;

public class MessageEntry {
    private int MESSAGE_ID;
    private String MESSAGE;
    private int SENDER;
    private int RECEIVER_ID;
    private String SENT_TIMESTAMP;
    private boolean success;

    public int getMESSAGE_ID() {
        return MESSAGE_ID;
    }

    public void setMESSAGE_ID(int MESSAGE_ID) {
        this.MESSAGE_ID = MESSAGE_ID;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public int getSENDER() {
        return SENDER;
    }

    public void setSENDER(int SENDER) {
        this.SENDER = SENDER;
    }

    public int getRECEIVER_ID() {
        return RECEIVER_ID;
    }

    public void setRECEIVER_ID(int RECEIVER_ID) {
        this.RECEIVER_ID = RECEIVER_ID;
    }

    public String getSENT_TIMESTAMP() {
        return SENT_TIMESTAMP;
    }

    public void setSENT_TIMESTAMP(String SENT_TIMESTAMP) {this.SENT_TIMESTAMP = SENT_TIMESTAMP;}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public MessageEntry(int MESSAGE_ID, String MESSAGE, int SENDER, int RECEIVER_ID, String SENT_TIMESTAMP, boolean success) {

        this.MESSAGE_ID = MESSAGE_ID;
        this.MESSAGE = MESSAGE;
        this.SENDER = SENDER;
        this.RECEIVER_ID = RECEIVER_ID;
        this.SENT_TIMESTAMP = SENT_TIMESTAMP;
        this.success = success;
    }
}
