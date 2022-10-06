package com.valtech.training.assignments;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class CustomerTest {

	// Customer cu= new Customer();

	int Diamond = 4;
	int Platinum = 3;
	int gold = 2;
	int silver = 1;

	@Test
	public void test() throws Exception {
		Set<Customer> cust = new TreeSet<Customer>();

		Customer cus1 = new Customer("Anuj", gold, "2001-09-25", 23000);
		Customer cus2 = new Customer("Bharatha", Platinum, "2001-09-13", 23000);
		Customer cus3 = new Customer("this guy", Diamond, "2001-08-25", 5400);
		Customer cus4 = new Customer("hello", Platinum, "2001-09-10", 54000);
		Customer cus5 = new Customer("hi", gold, "2001-10-25", 5400);
		Customer cus6 = new Customer("Jordy", silver, "2001-10-25", 5400);


		cust.add(cus1);
		cust.add(cus2);
		cust.add(cus3);
		cust.add(cus4);
		cust.add(cus5);
		cust.add(cus6);

		System.out.println(cust.size());
		for (Customer c : cust) {
			System.out.println(c.name + " " + convert_to_string(c.type) + " " + c.date + " " + c.moneyspent);
		}

	}

	public String convert_to_string(int t1) {
		switch (t1) {
		case 1:
			return "Silver";

		case 2:
			return "Gold";

		case 3:
			return "Paltinum";

		case 4:
			return "Diamond";

		default:
			return "0";

		}
	}

}
