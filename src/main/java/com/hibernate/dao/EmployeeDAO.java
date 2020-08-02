package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hibernate.util.HibernateConnector;

import om.hibernate.model.Account;
import om.hibernate.model.AccountType;
import om.hibernate.model.Employee;

public class EmployeeDAO {

	Transaction tr = null;

	public void saveEmployeeDetails() {
		Employee emp = new Employee("Shubham", "Lucknow", 2200000);

		// Save Value

		/*
		 * Account acc = new Account(AccountType.SAVINGS, 2500000); Account acc1 = new
		 * Account(AccountType.CURRENT, 2500000); emp.setAccount(Arrays.asList(acc,
		 * acc1)); acc.setEmp(emp); acc1.setEmp(emp); Session session =
		 * HibernateConnector.getSessionFactory().openSession(); tr =
		 * session.beginTransaction(); session.save(emp); session.save(acc);
		 * session.save(acc1); tr.commit(); session.close();
		 */

		// Fetch value

		Session session = HibernateConnector.getSessionFactory().openSession();
		tr = session.beginTransaction();

		// Criteria Query
		Criteria cr = session.createCriteria(Account.class);
		cr.add(Restrictions.eq("accType", AccountType.SAVINGS));
		cr.add(Restrictions.ne("amount", Double.valueOf(2600000)));
		List<Account> acc = cr.list();

		// NamedQuery
		Query query = session.getNamedQuery(Account.queryName).setParameter("accType", AccountType.SAVINGS);
		List<Account> queryList = query.list();
		for (Account a : queryList) {
			System.out.println("ACCOUNT_NO: " + a.getAccountNo());
			System.out.println("ACC_TYPE: " + a.getAccType());
			System.out.println("AMOUNT: " + a.getAmount());
			System.out.println("Employee: " + a.getEmp().getName());
			System.out.println();
		}

		/*
		 * Employee getEmp = (Employee) session.get(Employee.class, 1);
		 * 
		 * System.out.println( "Name: " + getEmp.getName() + " Address: " +
		 * getEmp.getAddress() + " Salary:" + getEmp.getSalary());
		 */

		// Update value getEmp.setSalary(2600000); session.merge(getEmp);
		tr.commit();
		session.close();

	}

}
