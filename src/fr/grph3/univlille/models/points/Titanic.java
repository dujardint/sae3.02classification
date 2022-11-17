package fr.grph3.univlille.models.points;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBeanBuilder;

import fr.grph3.univlille.models.columns.MistakeNormalizableValueException;

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
	private char embarked;
	
	

	public Titanic(double passengerId, double survived, double pclass, String name, String sex, double age,
			double sibSp, double parch, String ticket, double fare, String cabin, char embarked) {
		super();
		this.passengerId = passengerId;
		this.survived = survived;
		this.pclass = pclass;
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

	public char getEmbarked() {
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

	public void setEmbarked(char embarked) {
		this.embarked = embarked;
	}


	@Override
	public String toString() {
		return "titanic [passengerId=" + passengerId + ", survived=" + survived + ", pclass=" + pclass + ", name="
				+ name + ", sex=" + sex + ", age=" + age + ", sibSp=" + sibSp + ", parch=" + parch + ", ticket="
				+ ticket + ", fare=" + fare + ", cabin=" + cabin + ", embarked=" + embarked + "]";
	}

	public static List<Titanic> loadTitanic(String path) throws IllegalStateException, IOException {
		return new CsvToBeanBuilder<Titanic>(Files.newBufferedReader(Paths.get(path))).withSeparator(',')
				.withType(Titanic.class).build().parse();
	}
	
	public Titanic(int passengerId, int survived, int placeClass, String name, String sex, int age, int sibSp, int parch, String ticket, double fare, String cabin, char embarked ) {
		this.passengerId = passengerId;
		this.survived = survived;
		this.pclass = placeClass;
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
	
	public Titanic(){}

	@Override
	public Object getValue(fr.grph3.univlille.models.columns.IColumn column) {
		switch(column.getName()) {
		case "PassengerId" : return passengerId;
		case "Survived" : return survived;
		case "Pclass" : return pclass;
		case "Name" : return name;
		case "Sex" : return sex;
		case "Age" : return age;
		case "SibSp" : return sibSp;
		case "Parch" : return parch;
		case "Ticket" : return ticket;
		case "Fare" : return fare;
		case "Cabin" : return cabin;
		case "Embarked" : return embarked;
		default : return null;
		}
	}

	@Override
	public double getNormalizedValue(fr.grph3.univlille.models.columns.IColumn xColumn) {
		try {
			return xColumn.getNormalizedValue(this);
		} catch (MistakeNormalizableValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


}
