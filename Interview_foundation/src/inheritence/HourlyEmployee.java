package inheritence;

public class HourlyEmployee extends Employee{

	
	
	private double wageRate;
	private double hours;
	
	
	public HourlyEmployee() {
		super();
		this.setWageRate(0);
		this.setHours(0);
	}
	
	
	public HourlyEmployee(String theName, double a, double b){
		super(theName);
		this.setWageRate(a);
		this.setHours(b);
	}
	


	public double getHours() {
		return hours;
	}


	public void setHours(double hours) {
		this.hours = hours;
	}


	public double getWageRate() {
		return wageRate;
	}


	public void setWageRate(double wageRate) {
		this.wageRate = wageRate;
	}
	
	
	public String toString(){
		return (super.toString()+"HourlyEmployee class");
	}
}
