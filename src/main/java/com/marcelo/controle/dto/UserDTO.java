package com.marcelo.controle.dto;

import com.marcelo.controle.domain.Record;
import com.marcelo.controle.domain.User;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 80, message = "O tamnho deve ser entre 5 e 80 caracteres!")
    private String name;
    private String departament;
    private String roles;
    private Record record;

    public UserDTO(){

    }

    public UserDTO(User obj){

        id = obj.getId();
        name = obj.getName();
        departament = obj.getDepartament();
        roles = obj.getRoles();
        record = obj.getRecord();
    }

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
}
