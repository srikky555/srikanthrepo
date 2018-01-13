package com.prokarma.logging1;


import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Datacapture {
	static int no;

	public MainTask getmain(Scanner sc, Logger logger) {
		MainTask mt1 = null;


		try {
			logger.info("Please Enter The Main task Detalis");
			logger.info("Title:");
			String title = sc.next();
			logger.info("Description:");
			String description = sc.next();
			logger.info("Assigned to:");
			String name = sc.next();
			logger.info("Asignees Age:");
			int age = sc.nextInt();
			Person p1 = new Person(name, age);

			if (PersonValidator.ValidatePerson("maintask", p1)) {
				logger.info("No of Subtasks:");
				no = sc.nextInt();
				mt1 = new MainTask(title, description, p1, createSub(no, sc,logger));

			
			}

		} catch (PersonisNotaplicableException p) {
			logger.error(p);

		}

		return mt1;

	}

	private List<Subtask> createSub(int no, Scanner sc1, Logger logger) {
		List<Subtask> st = new ArrayList<Subtask>();

		try {
			for (int i = 0; i < no; i++) {

				logger.info("Please Enter The sub task Detalis");
				logger.info("Title:");
				String title = sc1.next();
				logger.info("Description:");
				String description = sc1.next();
				logger.info("Assigned to:");
				String name = sc1.next();
				logger.info("Asignees Age:");
				int age = sc1.nextInt();
				Person p2 = new Person(name, age);
				if (PersonValidator.ValidatePerson("Subtask", p2)) {
					logger.info("No of estimated hours:");
					int hrs = sc1.nextInt();

					st.add(new Subtask(title, description, p2, hrs));
					
				}

			}
		} catch (PersonisNotaplicableException p) {
			logger.error(p);

		}
		

		return st;

	}

	

	}


