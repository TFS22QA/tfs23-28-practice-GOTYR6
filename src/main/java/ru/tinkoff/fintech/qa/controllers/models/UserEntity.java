package ru.tinkoff.fintech.qa.controllers.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@ApiModel(description = "users")
public class UserEntity {
    @Id
    @JsonProperty("id")
    Integer id;
    @Column(name = "fio")
    @JsonProperty("fio")
    String fio;
    @Column(name = "phone")
    @JsonProperty("phone")
    String phone;
    @Column(name = "passportSeries")
    @JsonProperty("passportSeries")
    Integer passwordSeries;
    @Column(name = "passportNumber")
    @JsonProperty("passportNumber")
    Integer passwordNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPasswordSeries() {
        return passwordSeries;
    }

    public void setPasswordSeries(Integer passwordSeries) {
        this.passwordSeries = passwordSeries;
    }

    public Integer getPasswordNumber() {
        return passwordNumber;
    }

    public void setPasswordNumber(Integer passwordNumber) {
        this.passwordNumber = passwordNumber;
    }
}
