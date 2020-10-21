package com.methodtest.entity;

public class DialysisOrderResultForm {
    private String groupcode;
    private String mainFlag;
    private String medicinename;
    private String markUUID;

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }

    public String getMainFlag() {
        return mainFlag;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
    }

    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }

    public String getMarkUUID() {
        return markUUID;
    }

    public void setMarkUUID(String markUUID) {
        this.markUUID = markUUID;
    }

    public DialysisOrderResultForm(String groupcode, String mainFlag, String medicinename) {
        this.groupcode = groupcode;
        this.mainFlag = mainFlag;
        this.medicinename = medicinename;
    }
}
