package fr.grph3.univlille.entities;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class Titanic implements Point{
	
	static List<Titanic> datas;

	@CsvBindByName(column = "PassengerId") 
	public double passengerId;
	@CsvBindByName(column = "Survived")
	public double survived;
	@CsvBindByName(column = "Pclass") 
	public double pclass;
	@CsvBindByName(column = "Name") 
	public String name;
	@CsvBindByName(column = "Sex") 
	public String sex;
	@CsvBindByName(column = "Age") 
	public double age;
	@CsvBindByName(column = "SibSp") 
	public double sibSp;
	@CsvBindByName(column = "Parch") 
	public double parch;
	@CsvBindByName(column = "Ticket") 
	public String ticket;
	@CsvBindByName(column = "Fare") 
	public double fare;
	@CsvBindByName(column = "Cabin") 
	public String cabin;
	@CsvBindByName(column = "Embarked") 
	public String embarked;
	
	public Titanic() {
	}

	public Titanic(double passengerId, double survived, double pclass, String name, String sex, double age,
			double sibSp, double parch, String ticket, double fare, String cabin, String embarked) {
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
	
	public double getPclass() {
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

	public void setPassenger_Id(double passenger_Id) {
		this.passengerId = passenger_Id;
	}

	public void setSurvived(double survived) {
		this.survived = survived;
	}

	public void setPclass(double pclass) {
		this.pclass = pclass;
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
	public Object getValue(Column<? extends Point> column) {
		return column.getDataset();
	}

	@Override
	public double getNormalizedValue(Column<? extends Point> xColumn) {
		if(xColumn.isNormalizable()) {
			return xColumn.getNormalizedValue(null);
		}
		return 0.0;
	}

	@Override
	public String toString() {
		return "titanic [passengerId= " + passengerId + ", survived=" + survived + ", pclass=" + pclass + ", name="
				+ name + ", sex=" + sex + ", age=" + age + ", sibSp=" + sibSp + ", parch=" + parch + ", ticket="
				+ ticket + ", fare=" + fare + ", cabin=" + cabin + ", embarked=" + embarked + "]";
	}
	
	
	public List<Titanic> getClosest(List<Titanic> elements, int number) {
	    // TODO Auto-generated method stub
	    return null;
	}

}
