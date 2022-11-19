package main.java.fr.grph3.univlille.models.points;

import com.opencsv.bean.CsvBindByName;

import main.java.fr.grph3.univlille.models.columns.IColumn;

public class Titanic implements IPoint {

    @CsvBindByName(column = "PassengerId")
    private double passengerId;

    @CsvBindByName(column = "Survived")
    private double survived;

    @CsvBindByName(column = "Pclass")
    private double pClass;

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

   

	public Titanic(double passengerId, double survived, double pClass, String name, String sex, double age,
			double sibSp, double parch, String ticket, double fare, String cabin, String embarked) {
		super();
		this.passengerId = passengerId;
		this.survived = survived;
		this.pClass = pClass;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.sibSp = sibSp;
		this.parch = parch;
		this.ticket = ticket;
		this.fare = fare;
		this.cabin = cabin;
		this.embarked = embarked;
	}

	public Titanic() {
		// TODO Auto-generated constructor stub
	}

	public double getPassengerId() {
        return passengerId;
    }

    public double getSurvived() {
        return survived;
    }

    public double getPClass() {
        return pClass;
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
    @Override
    public Object getValue(IColumn column) {
    	switch(column.getName()) {
		case "PassengerId" : return passengerId ;
		case "Survived" : return survived ;
		case "Pclass" : return pClass ;
		case "Name" : return name;
		case "Sex" : return sex ;
		case "Age" : return age ;
		case "SibSp" : return sibSp ;
		case "Parch" : return parch;
		case "Ticket" : return ticket ;
		case "Fare" : return fare;
		case "Cabin" : return cabin ;
		case "Embarked" : return embarked ;
		default : return null;
	}
    }

    @Override
    public String toString() {
        return "Titanic{" +
                "passengerId=" + passengerId +
                ", survived=" + survived +
                ", pclass=" + pClass +
                ", name=" + name  +
                ", sex=" + sex + 
                ", age=" + age +
                ", sibSp=" + sibSp +
                ", parch=" + parch +
                ", ticket=" + ticket  +
                ", fare=" + fare +
                ", cabin=" + cabin + 
                ", embarked=" + embarked  +
                '}';
    }
}
