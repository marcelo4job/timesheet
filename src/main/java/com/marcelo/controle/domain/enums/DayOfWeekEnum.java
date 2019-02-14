package com.marcelo.controle.domain.enums;

public enum DayOfWeekEnum {
    SUNDAY(1, "Sunday"),
    MONDAY(2, "Monday"),
    TUESDAY(3, "Tuesday"),
    WEDNESDAY(4, "Wednesday"),
    THURSDAY(5, "Thursday"),
    FRIDAY(6, "Friday"),
    SATURDAY(7, "Saturday");

    private Integer cod;
    private String desc;

    private DayOfWeekEnum(Integer cod, String descricao){

        this.cod = cod;
        this.desc = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static DayOfWeekEnum toEnum(Integer cod){

        if(cod == null){
            return null;
        }
        for (DayOfWeekEnum x : DayOfWeekEnum.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido:" + cod);
    }

}
