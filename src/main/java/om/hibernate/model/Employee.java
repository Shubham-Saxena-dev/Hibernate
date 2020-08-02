package om.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tblEmployee", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class Employee {

	@Column(name = "NAME") 
	private String name;

	@Id
	@Column(name = "ID", unique = true, insertable = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "SALARY")
	private double salary;
 
	@OneToMany(mappedBy="emp", cascade = CascadeType.ALL)
	//@JoinTable(name = "tblTemp", joinColumns = @JoinColumn(name = "EMPLOYEE_AC"), inverseJoinColumns = @JoinColumn(name="MyACC"))
	private List<Account> account;

	public Employee() {

	}

	public Employee(String name, String address, double salary) {
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
}
