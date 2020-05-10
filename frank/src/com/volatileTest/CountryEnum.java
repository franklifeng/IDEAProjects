package com.volatileTest;

/**
 * @author frank
 * @create 2019-07-31 21:56
 */
public enum CountryEnum {
    one(1,"齐"),two(2,"魏"),three(3,"赵"),four(4,"燕"),five(5,"楚"),six(6,"楚");

    private Integer id;
    private String value;

    public int getId(){
        return id;
    }
    public String getValue(){
        return  value;
    }

    CountryEnum(Integer id,String value){
        this.id = id;
        this.value = value;
    }

    public static CountryEnum getValue(int id) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum element:countryEnums) {
            if (id == element.id){
                return element;
            }
        }
        return null;
    }
}
