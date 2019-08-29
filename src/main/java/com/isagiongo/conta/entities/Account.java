package com.isagiongo.conta.entities;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Account {

    @Id
    private String id;

    private String number;

    private String agency;

    private String cpf;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate modifyDate;

    private Boolean active = true;

    public Account(CreateAccountRequest request) {
        this.number = request.getNumber();
        this.agency = request.getAgency();
        this.cpf = request.getCpf();
    }

    public Account(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
