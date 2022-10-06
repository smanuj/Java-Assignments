package com.valtech.training.assignments;

import java.util.Comparator;

public class CustomerList implements Comparator {
	
	    String name;
	    char type;
	    float moneySpent;
	    String doj;
	
	
	public CustomerList(String name, char type, float moneySpent, String doj) {
			super();
			this.name = name;
			this.type = type;
			this.moneySpent = moneySpent;
			this.doj = doj;
		}

	public int typeComparision(char a)	{
		a=Character.toLowerCase(a);
		switch(a) {
		case 'd' : return 1;
		case 'p' : return 2;
		case 'g' : return 3;
		case 's' : return 4;
		default : return 0;
		}
	}

	public int compare(CustomerList o1, CustomerList o2) {
		char a = o1.type;
		char b = o2.type;
		int ct1 = typeComparision(a);
		int ct2 = typeComparision(b);
		if (ct1 < ct2) {
			return -1;
		}
		if (ct1 > ct2) {
			return +1;
		}	
//		else {
//
//			if (vc1 < vc2) {
//				// System.out.println("a");
//				return -1;
//			}
//			if (vc1 > vc2) {
//				return +1;
//			} else {
//				
//				return o1.compareTo(o2);
//			}
//
//		}
		
		
		return 0;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
