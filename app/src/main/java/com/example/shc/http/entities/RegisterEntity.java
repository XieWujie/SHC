package com.example.shc.http.entities;

public class RegisterEntity {

    /**
     * sessionToken : 0uxnt1zqocace13m7icy7o77z
     * updatedAt : 2020-06-04T13:16:00.125Z
     * phone : 18612340000
     * objectId : 5ed8f4109cf1520006386a47
     * username : hjiang
     * createdAt : 2020-06-04T13:16:00.125Z
     * emailVerified : false
     * mobilePhoneVerified : false
     */

    private String sessionToken;
    private String updatedAt;
    private String phone;
    private String objectId;
    private String username;
    private String createdAt;
    private boolean emailVerified;
    private boolean mobilePhoneVerified;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isMobilePhoneVerified() {
        return mobilePhoneVerified;
    }

    public void setMobilePhoneVerified(boolean mobilePhoneVerified) {
        this.mobilePhoneVerified = mobilePhoneVerified;
    }
}
