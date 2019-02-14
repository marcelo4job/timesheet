package com.marcelo.controle.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String departament;
    private String roles;

//    @JsonIgnore
//    @OneToMany(mappedBy = "user")
//    private List<Record> records = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "record_id ")
    private Record record;

    //Construtores
    public User(Integer matricula, String name, String departament, String roles, Integer getRecord){

    }

    public User(Integer matricula, String nome, String setor, String cargo, Record record) {
        this.id = matricula;
        this.name = nome;
        this.departament = setor;
        this.roles = cargo;
        this.record = record;
    }
    //Gett&Set's


    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
//
//  public List<Record> getUsers() {
//        return records;
//    }
//
//    public void setUsers(List<Record> records) {
//        this.records = records;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
