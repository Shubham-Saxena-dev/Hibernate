package com.hibernate.main;

import com.hibernate.dao.EmployeeDAO;

public class HibernateStarter {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		dao.saveEmployeeDetails();
	}
}
