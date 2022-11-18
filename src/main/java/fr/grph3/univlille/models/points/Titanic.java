package fr.grph3.univlille.models.points;

import com.opencsv.bean.CsvBindByName;

import fr.grph3.univlille.models.columns.IColumn;

public class Titanic implements IPoint {

    @CsvBindByName(column = "PassengerId")
    private double passengerId;
    @CsvBindByName(column = "Survived")
    private double survived;
    @CsvBindByName(column = "Pclass")
    private double pclass;
    @CsvBindByName(column = "Name")
    private String name;
    @CsvBindByName(column = "Sex")
    private String sex;
    @CsvBindByName(column = "Age")
    private double age;
    @CsvBindByName(column = "SibSp")
    private double sibSp;
    @CsvBindByName(column = "Parch")
    private double parch;
    @CsvBindByName(column = "Ticket")
    private String ticket;
    @CsvBindByName(column = "Fare")
    private double fare;
    @CsvBindByName(column = "Cabin")
    private String cabin;
    @CsvBindByName(column = "Embarked")
    private String embarked;

    public double getPassengerId() {
        return passengerId;
    }

    public double getSurvived() {
        return survived;
    }

    public double getPClass() {
        return pclass;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public double getAge() {
        return age;
    }

    public double getSibSp() {
        return sibSp;
    }

    public double getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public double getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setPassengerId(double passengerId) {
        this.passengerId = passengerId;
    }

    public void setSurvived(double survived) {
        this.survived = survived;
    }

    public void setPClass(double pClass) {
        this.pclass = pClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setSibSp(double sibSp) {
        this.sibSp = sibSp;
    }

    public void setParch(double parch) {
        this.parch = parch;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    @Override
    public double getValue(IColumn column) {
        if ("Pclass".equals(column.getName())) return pclass;
        if ("Age".equals(column.getName())) return age;
        if ("SibSp".equals(column.getName())) return sibSp;
        if ("Parch".equals(column.getName())) return parch;
        if ("Fare".equals(column.getName())) return fare;
        return 0;
    }

    @Override
    public String toString() {
        return "Titanic{" +
                "passengerId=" + passengerId +
                ", survived=" + survived +
                ", pclass=" + pclass +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sibSp=" + sibSp +
                ", parch=" + parch +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarked='" + embarked + '\'' +
                '}';
    }
}
