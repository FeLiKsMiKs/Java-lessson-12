package ua.lviv.lgs.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static void menu() {
		System.out.println();
		System.out.println("¬вед≥ть 1, щоб вивести toString() даних елемент≥в масиву на консоль");
		System.out.println("¬вед≥ть 2, щоб дл€ вс≥х об`Їкт≥в даного масиву засетити одинаковий  об`Їкт класу јвто");
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<material> MaterialArrayList = new ArrayList<material>();
		for (material MaterialValue : material.values()) {
			MaterialArrayList.add(MaterialValue);
		}
		while (true) {
			menu();

			switch (scanner.nextInt()) {

			case 1: {

				List <Auto> autoArrayList1 = new ArrayList<Auto>(); 

				for (int i = 0; i < getRandomValueFromRange(1, 5); i++) {
					List <Auto> autoArrayList2 = new ArrayList<Auto>(); 
					for (int j = 0; j < getRandomValueFromRange(1, 5); j++) {
						autoArrayList2.add(new Auto(getRandomValueFromRange(100, 250),
								getRandomValueFromRange(1980, 2018),
								new Helm(getRandomValueFromRange(35, 50),
										MaterialArrayList.get(getRandomValueFromRange(0, MaterialArrayList.size() - 1)).toString()),
								new Engine(getRandomValueFromRange(2, 12))));
					}
					autoArrayList1.addAll(autoArrayList2);
				}

				System.out.println(autoArrayList1);
				
				break;
			}

			case 2: {

				Auto auto = new Auto(getRandomValueFromRange(100, 250), getRandomValueFromRange(1980, 2018),
						new Helm(getRandomValueFromRange(35, 50),
								MaterialArrayList.get(getRandomValueFromRange(0, MaterialArrayList.size() - 1)).toString()),
						new Engine(getRandomValueFromRange(2, 12)));

				List <Auto> autoArrayList3 = new ArrayList <Auto>();
				
				for (int i = 0; i < getRandomValueFromRange(1, 5); i++) {
					autoArrayList3.add(auto);
				}
				System.out.println(autoArrayList3);
				break;
			}

			default: {
				System.out.println("Only 1 or 2");

				break;
			}

			}
		}
	}

	static int getRandomValueFromRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("Min value must be less than max value!");
		}

		Random randomValue = new Random();
		return randomValue.nextInt(max - min + 1) + min;
	}
}
