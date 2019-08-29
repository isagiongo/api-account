package com.isagiongo.conta.entities;

public class LimitCreateRequest {

    private String idAccount;

    public LimitCreateRequest(){}

    public LimitCreateRequest(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
}
