package com.marcelo.controle.dto;

import com.marcelo.controle.domain.Record;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserNewDTO {

    private String name;
    private String departament;
    private String roles;
    private Record record;


    private Record recordId;
    private Integer dayOfWeek;
    private LocalTime times;
    private LocalDate date = LocalDate.now();
    private String satatus;



    public UserNewDTO(){

    }


    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public String getSatatus() {
        return satatus;
    }

    public void setSatatus(String satatus) {
        this.satatus = satatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Record getRecordId() {
        return recordId;
    }

    public void setRecordId(Record recordId) {
        this.recordId = recordId;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getTimes() {
        return times;
    }

    public void setTimes(LocalTime times) {
        this.times = times;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
