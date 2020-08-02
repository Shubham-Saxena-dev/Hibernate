package om.hibernate.model;

public enum AccountType {

	SAVINGS("SavingAccount"), SALARY("SalaryAccount"), CURRENT("CurrentAccount");

	String accountType;

	AccountType(String type) {
		this.accountType = type;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
