package com.marcelo.controle.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcelo.controle.domain.enums.DayOfWeekEnum;
import com.marcelo.controle.domain.enums.StatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Record implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Dia")
    private Integer dayOfWeek;

    @Column(name = "Hora")
    private LocalTime times = LocalTime.now();

    @Column(name = "Data")
    private LocalDate date = LocalDate.now();

    @Column(name = "Sataus")
    private String status;


//    @ManyToOne
//    @JoinColumn(name = "user_id ")
//    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "record")
    private List<User> users = new ArrayList<>();

    //Construtores

    public Record(){

        }
    public Record(Integer id, DayOfWeekEnum dia, LocalTime hora, LocalDate date, String status){

    }

    public Record(Integer id, DayOfWeekEnum dia, LocalTime hora, LocalDate date, StatusEnum status) {
        this.id = id;
        this.dayOfWeek = (dia == null) ? null : dia.getCod();
        this.times = hora;
        this.date = date;
        this.status = (status == null) ? null : status.getDesc();
//        this.user = funcionario;



    }

    //Get&Set's


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }


//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

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

    public DayOfWeekEnum getDayOfWeek() {
        return DayOfWeekEnum.toEnum(dayOfWeek);
    }

    public void setDia(DayOfWeekEnum dia) {
        this.dayOfWeek = dia.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record horaBanco = (Record) o;
        return Objects.equals(id, horaBanco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
