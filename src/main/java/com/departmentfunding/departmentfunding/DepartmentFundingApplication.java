package com.departmentfunding.departmentfunding;

import java.util.*;

//import static org.springframework.boot.SpringApplication.*;

public class DepartmentFundingApplication {
	private static boolean zen = true;
	private static HashMap<String, Integer> Department = new HashMap<>();
	private static Map<String, List<Integer>> Grouping = new HashMap<>();
	private static List<Integer> objects = new ArrayList<>();
	private static Integer zeta = 0;
	private static Integer yen = 0;

	public static void main(String[] args) {
		//run(DepartmentFundingApplication.class, args);
		minimain();
	}
	//This is the main call, but it's split out from main so that it can ask you again and again if you mistype one of the options
	private static void minimain(){
		Scanner scan = new Scanner(System.in);

		System.out.println("Please Select whether you're a 'Manager', a 'Programmer', or a 'Tester' using those exact spellings");
		String input = scan.nextLine();

		if (input.equals("Manager")) {
			zeta = zeta+1;
			Department.put("Manager "+zeta,600);
			objects.add(zeta);
			objects.add(600);
			Grouping.put("Manager", objects);

			Manager();
		}
		if (input.equals("Programmer")) {
			Department.put("Programmer",2000);
			objects.add(yen);
			objects.add(2000);
			Grouping.put("Programmer", objects);
			others();
		}
		if (input.equals("Tester")) {
			Department.put("Tester",1000);
			objects.add(yen);
			objects.add(1000);
			Grouping.put("Tester", objects);
			others();
		} else {
			minimain();
		}
	}
	//Our main manager call, this is where all the other calls root out from
	private static void Manager() {
		Scanner man = new Scanner(System.in);
		System.out.println("Please type 'Yes' or 'No' if anyone report to you, using those exact spellings");
		String maninput = man.nextLine();

		if (maninput.equals("Yes")) {
			mainman();
		}
		if (maninput.equals("No")) {
			zen = false;
			others();
		} else {
			Manager();
		}
	}
	//A lesser version of the minimain call
	private static void mainman() {
		Scanner miniman = new Scanner(System.in);
		System.out.println("Please Select: 'Manager','Programmer', or 'Tester'");
		String minimaninput = miniman.nextLine();
		if (minimaninput.equals("Manager")) {
			//This one is, in theory, a loop so that you can add other roles to it and bounce back up the chain if need be
			zen = true;
			Department.put("Manager",600);
			while(zen){
				Manager();
				//TODO: Create a Sublist for Managers somehow
			}
			mainmanfolk();
		}
		if (minimaninput.equals("Programmer")) {
			//TODO: Add this to the sublist
			Department.put("Programmer",2000);
			mainmanfolk();
		}
		if (minimaninput.equals("Tester")) {
			Department.put("Tester",1000);
			//TODO: Add this to the sublist
			mainmanfolk();
		} else {
			mainman();
		}
	}
	//This is so you can add more folks to a manager. Also it should make it so that there's not a lot of duplicate code in mainman()
	private static void mainmanfolk(){
		Scanner folksy = new Scanner(System.in);
		System.out.println("Anyone else for this manager? Please type 'Yes' or 'No'");
		String folksyinput = folksy.nextLine();
		if (folksyinput.equals("Yes")){
			mainman();
		}
		if(folksyinput.equals("No")){
			//TODO: Add a bit of code here so that this NO does something
			others();
		}
		else{
			mainmanfolk();
		}
	}
	//Once you've added all the managers to a chain, this is where you should end up
	private static void others(){
		Scanner otherfolk = new Scanner(System.in);
		System.out.println("Anyone else you need to add overall? Please type 'Yes' or 'No'");
		String otherfolkinput = otherfolk.nextLine();
		if (otherfolkinput.equals("Yes")){
				mainman();
		}
		if (otherfolkinput.equals("No")){
			System.out.println("Here's everyone you need to worry about:");
			//TODO: Make a list of Each Manager and how much they'll cost
			//TODO: Fix this For-Loop
			int x = 0;
			int y = 0;
			String z;
			for(Map.Entry<String, Integer> people : Department.entrySet()){
				y = y+people.getValue();
				if (people.getKey().equals("Manager")){
					x = x+1;
					z = "Manager"+x;
				}else{
				    z = people.getKey();
                }
				//System.out.println("Department Cost is: "y);
				System.out.println(z);
			}
			//TODO: Figure out how to just end the code right here with no extra things printed
		}
		else{
			System.out.println("Please type 'Yes' or 'No'");
			others();
		}
	}

}