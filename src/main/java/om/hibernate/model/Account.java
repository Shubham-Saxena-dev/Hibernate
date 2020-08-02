package om.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tblAccount", uniqueConstraints = { @UniqueConstraint(columnNames = "ACCOUNT_NO") })
@NamedQueries({
	@NamedQuery(name=Account.queryName, query = "from Account a where a.accType =:accType")
})
public class Account {

	public static final String queryName = "GET_ACCOUNT";
	
	@Column(name = "ACCOUNT_NO", insertable = true, updatable = false, unique = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNo;

	@Column(name = "ACC_TYPE")
	private AccountType accType;

	@Column(name = "AMOUNT")
	private double amount;

	@ManyToOne
	private Employee emp;
	
	public Account() {
	}

	public Account(AccountType accType, double amount) {
		this.accType = accType;
		this.amount = amount;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public AccountType getAccType() {
		return accType;
	}

	public void setAccType(AccountType accType) {
		this.accType = accType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
