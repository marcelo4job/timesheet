package com.marcelo.controle.dto;

import com.marcelo.controle.domain.Record;
import com.marcelo.controle.domain.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class RecordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String dayOfWeek;
    private LocalTime times;
    private LocalDate date;
    private String status;
//    private User user;



    public RecordDTO(){

    }

    public RecordDTO(Record obj){

        id = obj.getId();
        dayOfWeek = (obj.getDayOfWeek() == null) ? null : obj.getDayOfWeek().getDesc();
        times = obj.getTimes();
        date = obj.getDate();
        status = obj.getStatus();
//        user = obj.getUser();

    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
