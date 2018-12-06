package domain.model;

import org.w3c.dom.DOMException;

import java.util.ArrayList;

public class Person {
    private String name, adres, postalCode;
    private int id;

    public Person(int id, String name, String adres, String postalCode){
        setId(id);
        setName(name);
        setAdres(adres);
        setPostalCode(postalCode);
    }

    public Person(){}

    public void setId(int id){
        if(id <= 0 ) throw new DomainException("Id can't be lower then 1");
        this.id = id;
    }

    public void setName(String name){
        if(isEmpty(name)) throw new DomainException("Name can't be empty");
        this.name = name;
    }

    public void setAdres(String adres){
        if(isEmpty(adres)) throw new DomainException("Adres can't be empty");
        this.adres = adres;
    }

    public void setPostalCode(String postalCode){
        if(isEmpty(postalCode)) throw new DomainException("Postal code can't be empty");
        this.adres = adres;
    }

    private boolean isEmpty(String str){
        if(str == null || str.trim().isEmpty()) return true;
        return false;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getAdres(){
        return this.adres;
    }

    public String getPostcalCode(){
        return this.postalCode;
    }
}
