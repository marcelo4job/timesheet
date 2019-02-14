package com.marcelo.controle.domain.enums;

public enum StatusEnum {

    ENTRADA(1, "ENTRADA"),
    SAÍDA_INTERVALO(2, "SAÍDA_INTERVALO"),
    ENTRADA_INTERVALO(3, "ENTRADA_INTERVALO"),
    SAÍDA(4, "SAÍDA");

    private Integer cod;
    private String desc;

    private StatusEnum(Integer cod, String descricao){

        this.cod = cod;
        this.desc = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static StatusEnum toEnum(String cod){

        if(cod == null){
            return null;
        }
        for (StatusEnum x : StatusEnum.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido:" + cod);
    }
}
