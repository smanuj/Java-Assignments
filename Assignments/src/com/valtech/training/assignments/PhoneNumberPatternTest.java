package com.valtech.training.assignments;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class PhoneNumberPatternTest {

	PhoneNumberPattern p= new PhoneNumberPattern();
	List<Long> nums = new ArrayList<>();
	
	@Test
	public void test() {
		
		//Test Case Set 1
		
		nums.add(1234567890L);
		nums.add(7300422656L);
		int size=nums.size();
		assertEquals(0,PhoneNumberPattern.checkPhoneNumber(size, nums));
		
		//Test Case Set 2
		
		nums.add(1212121212L);
		nums.add(9999999999L);
		nums.add(7300422656L);
		size=nums.size();
		
		
		assertEquals(0,PhoneNumberPattern.checkPhoneNumber(size, nums));
		
		//Test Case Set 3 
		
		nums.add(1234567890L);
		nums.add(9876543210L);
		size=nums.size();
		
		
		assertEquals(0,PhoneNumberPattern.checkPhoneNumber(size, nums));
		
		// Test Case Set 4
		
		nums.add(9000099990L);
		nums.add(7300422656L);
		size=nums.size();
		
		
		assertEquals(0,PhoneNumberPattern.checkPhoneNumber(size, nums));
		
		
		//Test Case Set 5
		
		nums.add(1212121212L);
		nums.add(7300422656L);
		size=nums.size();
		
		
		assertEquals(0,PhoneNumberPattern.checkPhoneNumber(size, nums));
		
	}
	
	
	

}
