/**
 * LOGOS It Academy DZ file
 * 
 */
package ua.lviv.lgs.second;
/**
 * @since java 1.8
 * @author Roman
 * @version 1.1
 */

import java.util.ArrayList;
import java.util.Scanner;

import ua.lviv.lgs.second.Application.Month;

public class Application {

	enum Seasons{
		WINTER, SPRING, SUMMER, AUTUMN;
	}
	enum Month{
		DECEMBER(31, Seasons.WINTER),
		JANUARY(31,Seasons.WINTER),
		FEBRUARY(28,Seasons.WINTER),
		MARCH(31,Seasons.SPRING),
		APRIL(30,Seasons.SPRING),
		MAY(31,Seasons.SPRING),
		JUNE(30,Seasons.SUMMER),
		JULY(31,Seasons.SUMMER),
		AUGUST(31,Seasons.SUMMER),
		SEPTEMBER(30,Seasons.AUTUMN),
		OCTOBER(31,Seasons.AUTUMN),
		NOVEMBER(30,Seasons.AUTUMN);
		 int days;
		Seasons season;
		public Seasons getSeason() {
			return season;
		}
		public  int getDays() {
			return days;
		}
		Month(int days, Seasons season) {
			this.days = days;
			this.season = season;
		}
		
		 
		 
	}
	/**
	 *displays us menu on the console
	 **/
	static void menu() {
		System.out.println("Натисніть 0 щоб перевірити чи є такий місяць ");
		System.out.println("Натисніть 1 щоб вивести всі місяці з такою ж порою року");
		System.out.println("Натисніть 2 щоб вивести всі місяці які мають таку саму кількість днів");
		System.out.println("Натисніть 3 щоб вивести всі місяці які мають меншу кількість днів");
		System.out.println("Натисніть 4 щоб вивести всі місяці які мають більшу кількість днів");
		System.out.println("Натисніть 5 щоб вивести наступну пору року");
		System.out.println("Натисніть 6 щоб вивести попередню пору року");
		System.out.println("Натисніть 7 щоб вивести всі місяці які мають парну кількість днів");
		System.out.println("Натисніть 8 щоб вивести всі місяці які мають непарну кількість днів");
		System.out.println("Натисніть 9 щоб вивести чи місяць має парну кількість днів");
	}
	
	public static void main(String[] args) throws WrongInputConsoleParametersException {
		ArrayList<Month> MonthArrayList = new ArrayList<Month>();
		for (Month monthValue : Month.values()) {
			MonthArrayList.add(monthValue);
		}

		ArrayList<Seasons> SeasonsArrayList = new ArrayList<Seasons>();
		for (Seasons seasonValue : Seasons.values()) {
			SeasonsArrayList.add(seasonValue);
		}
		Scanner sc = new Scanner(System.in);
		/* calls our menu  */
		while(true) {
			menu();
			/* takes values from scanner and  runs corresponding case*/
			switch (sc.next()) {
			case "0":{ 
				System.out.println("Enter continent: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();
				boolean flag = isMonthPresent(MonthArrayList, month);
				if(!flag) {
					System.out.println("Doesn`t exist");
					throw new WrongInputConsoleParametersException("Error");
				}
			
			
				break;
			
			}
			case "1":{
				System.out.println("Enter season: ");
				sc = new Scanner(System.in);
				String sn = sc.next().toUpperCase();
				boolean flag = false;
				for(Month c : MonthArrayList) {
					if(c.getSeason().name().equals(sn)) {
						
						flag = true;
					}
				}
				if(flag) {
					Seasons dir = Seasons.valueOf(sn);
					for(Month cont: MonthArrayList) {
						if(cont.getSeason().toString().equalsIgnoreCase(sn)) {
							System.out.println(cont);
						}
					}
				}
				if(!flag) {
					System.out.println("Doesn`t exist");
					throw new WrongInputConsoleParametersException("Error");
				}
			
			
				break;
			}
			case "2": {
				sc = new Scanner(System.in);
				System.out.println("Enter days");
				int days = sc.nextInt();

				boolean flag = false;

				for (Month months : MonthArrayList) {
					if (months.getDays() == days) {
						flag = true;
					}
				}

				if (flag == true) {
					

					for (Month months2 : MonthArrayList) {
						if (months2.getDays() == days) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					System.out.println("Error");
					throw new WrongInputConsoleParametersException("Error");}
				

				break;
			}
			case "3": {
				sc = new Scanner(System.in);
				System.out.println("Enter days");
				int days = sc.nextInt();

				boolean flag = false;

				for (Month months : MonthArrayList) {
					if (months.getDays() == days && days >= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					

					for (Month months2 : MonthArrayList) {
						if (months2.getDays() < days) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					System.out.println("Error");
					throw new WrongInputConsoleParametersException("Error");
					}

				break;
			}
			case "4": {
				sc = new Scanner(System.in);
				System.out.println("Enter days");
				int days = sc.nextInt();

				boolean flag = false;

				for (Month months : MonthArrayList) {
					if (months.getDays() == days && days <= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					

					for (Month months2 : MonthArrayList) {
						if (months2.getDays() > days) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false) {
					System.out.println("Error");
					throw new WrongInputConsoleParametersException("Error");
					}

				break;
			}
			case "5":{ 
				System.out.println("Enter season: ");
				sc = new Scanner(System.in);
				String continent = sc.next().toUpperCase();
				boolean flag = false;
				String month = sc.next().toUpperCase();
				for (Seasons seasons : SeasonsArrayList) {
					if (seasons.name().equalsIgnoreCase(continent)) {
						flag = true;
					}
				}
				if(flag) {
					Month month2 = Month.valueOf(month);
					int i = month2.ordinal();
					if(i == (SeasonsArrayList.size() -1)) {
						i = 0;
						System.out.println(SeasonsArrayList.get(i));
					}else {
						System.out.println(SeasonsArrayList.get(i+1));
					}
				}
				if(!flag) {
					System.out.println("Doesn`t exist");
					throw new WrongInputConsoleParametersException("Error");
				}
			
			
				break;
			
			}
			case "6":{ 
				System.out.println("Enter season: ");
				sc = new Scanner(System.in);
				String continent = sc.next().toUpperCase();
				boolean flag = false;
				for (Seasons seasons : SeasonsArrayList) {
					if (seasons.name().equalsIgnoreCase(continent)) {
						flag = true;
					}
				}
				if(flag) {
					Month cont2 = Month.valueOf(continent);
					int i = cont2.ordinal();
					if(i == (SeasonsArrayList.size()- 1)) {
						i = 0;
						System.out.println(SeasonsArrayList.get(i));
					}else {
						System.out.println(SeasonsArrayList.get(i-1));
					}
				}
				if(!flag) {
					System.out.println("Doesn`t exist");
					throw new WrongInputConsoleParametersException("Error");
				}
			
			
				break;
			
			}
			case "7":{ 
				for ( Month month : MonthArrayList) {
					if (month.getDays() % 2 == 0) {
						System.out.println(month);
					}
				}
			
			
				break;
			
			}
			case "8":{ 
				for ( Month month : MonthArrayList) {
					if (month.getDays() % 2 != 0) {
						System.out.println(month);
					}
				}
			
			
				break;
			
			}
			case "9":{ 
				System.out.println("Enter month: ");
				sc = new Scanner(System.in);
				String day = sc.next().toUpperCase();
				boolean flag = isMonthPresent(MonthArrayList, day);
				if(flag) {
					Month month = Month.valueOf(day);
					if (month.getDays() % 2 == 0) {
						System.out.println("Month has even number of days");
					}else { System.out.println("Month has odd number of days");}
				}else {
					System.out.println("Error");
					throw new WrongInputConsoleParametersException("Error");
				}
				
			
				break;
			
			}
			}
		}
		
	}
	/**
	 * Checks if the month exists in array
	 * 
	 * @param mas, month
	 * 
	 * @return boolean expression
	 * 
	 */
	static boolean isMonthPresent(ArrayList<Month> monthArrayList, String month) {
		boolean flag = false;
		for(Month c : monthArrayList) {
			if(c.name().equals(month)) {
				System.out.println("Month exist");
				flag = true;
			}
		}
		return flag;
	}
	 /**
		 * Converts all letters to upper case
		 * 
		 * @param string
		 * 
		 * @return String
		 * 
		 */
	 static String firstUpperCase(String string) {
			if (string == null || string.isEmpty()) {
				return string;
			} else {
				return string.substring(0, 1).toUpperCase() + string.substring(1);
			}
		}
}
