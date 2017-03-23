package ua.edu.sumdu.j2se.pr2;

public class Employee1 implements Employee{
	private int salary = 1000;
	private String firstName;
	private String lastName;
	private Employee manager;

	public Employee1(int salary, String firstName, String lastName, Employee manager) {
		this.salary = salary;
		this.firstName = firstName;
		this.lastName = lastName;
		this.manager = manager;
	}

	@Override
	public void increaseSalary(int value) {
		salary +=value;
	}

	public Employee1(){
		super();
	}

	@Override
	public int getSalary() {
		return salary;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public Employee getManager() {
		return manager;
	}

	@Override
	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public void setSalary(int salary) {

		this.salary = salary;
	}

	@Override
	public String getFullName(){
		return firstName + " " + lastName;
	}

	@Override
	public String getManagerName(){
		if(manager == null) return "No manager";
		else return manager.getFullName();
	}

	@Override
	public Employee getTopManager(){
		Employee current = this;
		for(;;){
			if(current.getManager() == null){
				return current;
			} else {
				current = current.getManager();
			}
		}
	}

	public static void main(String[] args) {
		Employee1 employee1 = new Employee1(1200, "Ararat", "Doppelganger", null);
		Employee1 employee2 = new Employee1(1199, "Mararat", "Doppelganger", employee1);
		Employee1 employee3 = new Employee1(1198, "Zamararat", "Doppelganger", employee2);
		System.out.println(employee3.getFullName());
		System.out.println(employee3.getManagerName());
		System.out.println(employee3.getTopManager().getFullName());

	}
}