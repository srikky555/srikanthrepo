package com.prokarma.logging1;



import java.util.Objects;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class Mainapp  {

	private static final org.apache.log4j.Logger logger = Logger.getLogger(Mainapp.class);	
	static int option = 0;
	int j = 0;

	public static void main(String[] args) throws Exception {

		Datacapture dc = new Datacapture();
		Scanner scanner = new Scanner(System.in);
		boolean isenough = true;
		do {
			logger.info("plese select a option from menu");
			logger.info("1.Add Main Task\n2.Print Details\n3.Update Maintask\n4.Exit");
			option = scanner.nextInt();

			switch (option) {
			case 1:

				MainTask mainTask = dc.getmain(scanner,logger);
				if (!Objects.isNull(mainTask)) {					
                   DBcontext.intialize(mainTask);
				}

				break;

			case 2:
				DataDisplay.Display(logger);
				break;
				
			case 3:
				Dbupdate.update(logger);
				break;
			
			case 4:
				isenough = false;
				break;
			}
		} while (isenough);

	}
}
