package de.dhbw.students.keepthings.api;

public class LoginEntry {
    private boolean success;
    private int UID;

    public LoginEntry(boolean success, int UID) {
        this.success = success;
        this.UID = UID;
    }

    public boolean isSuccess() {

        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }
}
