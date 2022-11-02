package chargement;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

import Interfaces.IColumn;
import Interfaces.IPoint;

public class TitanicDonneeBrut implements IPoint{


	private List<TitanicDonneeBrut> datas;

	@CsvBindByName(column = "PassengerId")
	private double passengerId;
	@CsvBindByName(column = "Survived")
	private double survived;
	@CsvBindByName(column = "Pclass")
	private double pclass;
	@CsvBindByName(column = "Name")
	private String name;
	@CsvBindByName(column = "Sex")
	private SexTitanic sex;
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

	public SexTitanic getSex() {
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

	public void setSex(SexTitanic sex) {
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
	public String toString() {
		return "titanic [passengerId= " + passengerId + ", survived=" + survived + ", pclass=" + pclass + ", name="
				+ name + ", sex=" + sex + ", age=" + age + ", sibSp=" + sibSp + ", parch=" + parch + ", ticket="
				+ ticket + ", fare=" + fare + ", cabin=" + cabin + ", embarked=" + embarked + "]";
	}


	@Override
	public Object getValue(IColumn col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getNormalizedValue(IColumn xcol) {
		// TODO Auto-generated method stub
		return 0;
	}

}
