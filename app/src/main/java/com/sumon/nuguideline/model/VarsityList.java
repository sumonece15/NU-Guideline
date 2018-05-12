package com.sumon.nuguideline.model;

/**
 * Created by sumon on 5/10/2018.
 */

public class VarsityList {

    private int logoId;
    private String varsityName;

    public VarsityList(int logoId, String varsityName) {
        this.logoId = logoId;
        this.varsityName = varsityName;
    }

    public int getLogoId() {
        return logoId;
    }

    public void setLogoId(int logoId) {
        this.logoId = logoId;
    }

    public String getVarsityName() {
        return varsityName;
    }

    public void setVarsityName(String varsityName) {
        this.varsityName = varsityName;
    }
}
