package com.valtech.training.assignments;

public class PassStrengthChecker {

	public boolean checkLower(String a) {

		int count1 = 0;

		String lower = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < a.length(); i++) {
			if (lower.contains("" + a.charAt(i))) {
				count1++;
			}
		}
		if (count1 > 0)
			return true;
		else
			return false;
	}

	public boolean checkUpper(String a) {

		int count2 = 0;

		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int i = 0; i < a.length(); i++) {
			if (upper.contains("" + a.charAt(i))) {
				count2++;
			}
		}
		if (count2 > 0)
			return true;
		else
			return false;
	}

	public int checkNumber(String a) {

		int count3 = 0;

		String number = "1234567890";

		for (int i = 0; i < a.length(); i++) {
			if (number.contains("" + a.charAt(i))) {
				count3++;
			}
		}
		return count3;

	}

	public int checkSpecials(String a) {

		int count4 = 0;

		String specials = "!@#$%^&*(),.<>:;/?'[]{}|";

		for (int i = 0; i < a.length(); i++) {
			if (specials.contains("" + a.charAt(i))) {
				count4++;
			}
		}
		return count4;
	}

	public int passwordStrength(String a) {

		int ps = 0;
		boolean l = checkLower(a);
		boolean u = checkUpper(a);
		int n = checkNumber(a);
		int s = checkSpecials(a);

		if (a.length() >= 8) {
			if (l)
				ps = ps + 5;
			if (u)
				ps = ps + 5;
			if (n > 0)
				ps = ps + 5 + n - 1;
			if (s > 0)
				ps = ps + 5 + (s - 1) * 2;
			return ps;
		} else
			return 0;

	}

	public String strength(int a) {
		if (a < 20)
			return "Weak";
		if (a < 25 && a > 20)
			return "Moderate";
		else
			return "Strong";
	}

	public static void main(String[] args) {

		PassStrengthChecker psc1 = new PassStrengthChecker();
		System.out.println(psc1.passwordStrength("12asD.23"));
		System.out.println(psc1.checkLower("12asD.23"));
		System.out.println(psc1.checkUpper("12asD.23"));
		System.out.println(psc1.checkNumber("12asD.23"));
		System.out.println(psc1.checkSpecials("12asD.23"));
		System.out.println(psc1.strength(psc1.passwordStrength("123456789")));
	}

}
