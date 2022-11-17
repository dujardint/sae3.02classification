package fr.grph3.univlille.models.points.builders;

import fr.grph3.univlille.models.points.Titanic;

public class TitanicBuilder {

    private double passengerId;
    private double survived;

    private double pClass;
    private double sibSp;
    private double age;
    private double parch;
    private double fare;
    private String name;
    private String sex;
    private String ticket;
    private String cabin;
    private char embarked;

    public TitanicBuilder withPassengerId(double passengerId) {
        this.passengerId = passengerId;
        return this;
    }

    public TitanicBuilder withSurvived(double survived) {
        this.survived = survived;
        return this;
    }

    public TitanicBuilder withPClass(double pClass) {
        this.pClass = pClass;
        return this;
    }

    public TitanicBuilder withSibSp(double sibSp) {
        this.sibSp = sibSp;
        return this;
    }

    public TitanicBuilder withAge(double age) {
        this.age = age;
        return this;
    }

    public TitanicBuilder withParch(double parch) {
        this.parch = parch;
        return this;
    }

    public TitanicBuilder withFare(double fare) {
        this.fare = fare;
        return this;
    }

    public TitanicBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TitanicBuilder withSex(String sex) {
        this.sex = sex;
        return this;
    }

    public TitanicBuilder withTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }

    public TitanicBuilder withCabin(String cabin) {
        this.cabin = cabin;
        return this;
    }

    public TitanicBuilder withEmbarked(char embarked) {
        this.embarked = embarked;
        return this;
    }

    
    public Titanic build(){
    	Titanic titanic = new Titanic();
        titanic.setPassengerId(passengerId);
        titanic.setSurvived(survived);
        titanic.setPClass(pClass);
        titanic.setSibSp(sibSp);
        titanic.setAge(age);
        titanic.setParch(parch);
        titanic.setFare(fare);
        titanic.setName(name);
        titanic.setSex(sex);
        titanic.setTicket(ticket);
        titanic.setCabin(cabin);
        titanic.setEmbarked(embarked);
        return titanic;
    }
    
    
}
