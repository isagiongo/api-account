package com.isagiongo.conta.entities;

public class CreateAccountRequest {

    private String number;

    private String agency;

    private String cpf;

    public CreateAccountRequest(){
    }

    public CreateAccountRequest(String number, String agency, String cpf) {
        this.number = number;
        this.agency = agency;
        this.cpf = cpf;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
