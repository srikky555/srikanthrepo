package com.prokarma.logging1;


public class PersonValidator {

	public static boolean ValidatePerson(String o, Person p) throws PersonisNotaplicableException {
		boolean isValidPerson = false;

			if (o.equalsIgnoreCase("MainTask")) {
				if (p.age > 30) {
					isValidPerson = true;
				} else {
					throw new PersonisNotaplicableException("Person is not valid");
				}
			}

			if (o.equalsIgnoreCase("SubTask")) {
				if (p.age > 20 && p.age <= 30) {
					isValidPerson = true;
				} else {
					throw new PersonisNotaplicableException("Person is not valid");
				}

			}
			return isValidPerson;
		

	}
}
