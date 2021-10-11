package br.com.exj.cadastro.enums;

public enum ServicosEnum {

    AUTENTICACAO("0", "Autenticacao"),
    EXJTECNOLOGIA("1", "ExJTecnologia");

    private String key;
    private String description;

    private ServicosEnum(String key, String description){
        this.key = key;
        this.description = description;
    }

    public static ServicosEnum getEnumByKey(String key){
        for(ServicosEnum servicosEnum : ServicosEnum.values()){
            if(servicosEnum.getKey().equals(key)){
                return servicosEnum;
            }
        }
        return null;
    }

    public String getKey(){ return key; }

    public String getDescription(){ return description; }
}
