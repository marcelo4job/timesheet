package com.marcelo.controle.dto;

import com.marcelo.controle.domain.Record;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class RecordNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    public Integer getRecord;


    private Integer dayOfWeek;
    private LocalTime times;
    private LocalDate date = LocalDate.now();
    private String status;


    private Integer userId;
    private String name;
    private String departament;
    private String roles;




    public RecordNewDTO() {
    }




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
