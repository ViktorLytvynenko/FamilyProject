package org.example;

import org.example.Controllers.FamilyController;

import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        FamilyController familyController = new FamilyController();

        Menu.showMenu();

        Scanner in = new Scanner(System.in);
        while (true) {
            String error = "Зробіть коректний вибір";
            String choice = "Введіть число";
            familyController.setAllFamilies(FileManager.loadData());
            if (in.hasNextInt()) {
                int userResult = in.nextInt();
                in.nextLine();
                switch (userResult) {
                    case 1:
                        familyController.setAllFamilies(FileManager.loadTestData());
                        Menu.showMenu();
                        break;
                    case 2:
                        familyController.displayAllFamilies();
                        Menu.showMenu();
                        break;
                    case 3:
                        do {
                            System.out.println(choice);
                            if (in.hasNextInt()) {
                                int userResult3 = in.nextInt();
                                familyController.getFamiliesBiggerThan(userResult3);
                                Menu.showMenu();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        break;
                    case 4:
                        do {
                            System.out.println(choice);
                            if (in.hasNextInt()) {
                                int userResult4 = in.nextInt();
                                familyController.getFamiliesLessThan(userResult4);
                                Menu.showMenu();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        break;
                    case 5:
                        do {
                            System.out.println(choice);
                            if (in.hasNextInt()) {
                                int userResult5 = in.nextInt();
                                System.out.println(familyController.countFamiliesWithMemberNumber(userResult5) + " family/families");
                                Menu.showMenu();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        break;
                    case 6:
                        System.out.println("Створюємо нову родину");

                        System.out.println("Введіть ім'я матері");
                        String motherName = in.nextLine();
                        System.out.println("Введіть прізвище матері");
                        String motherSurname = in.nextLine();
                        System.out.println("Введіть рік народження матері");
                        int motherYear;
                        do {
                            if (in.hasNextInt()) {
                                motherYear = in.nextInt();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        in.nextLine();
                        String motherYearString = String.valueOf(motherYear);
                        System.out.println("Введіть місяць народження матері");
                        int motherMonth;
                        do {
                            if (in.hasNextInt()) {
                                motherMonth = in.nextInt();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        in.nextLine();
                        String motherMonthString = String.valueOf(motherMonth);
                        System.out.println("Введіть день народження матері");
                        int motherDay;
                        do {
                            if (in.hasNextInt()) {
                                motherDay = in.nextInt();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        in.nextLine();
                        String motherDayString = String.valueOf(motherDay);
                        StringBuilder motherBirthdate = new StringBuilder();
                        motherBirthdate.append(motherDayString).append("/").append(motherMonthString).append("/").append(motherYearString);
                        System.out.println("Введіть iq матері");
                        int motherIQ;
                        do {
                            if (in.hasNextInt()) {
                                motherIQ = in.nextInt();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        in.nextLine();
                        System.out.println("Введіть ім'я батька");
                        String fatherName = in.nextLine();
                        System.out.println("Введіть прізвище батька");
                        String fatherSurname = in.nextLine();
                        System.out.println("Введіть рік народження батька");
                        int fatherYear;
                        do {
                            if (in.hasNextInt()) {
                                fatherYear = in.nextInt();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        in.nextLine();
                        String fatherYearString = String.valueOf(fatherYear);
                        System.out.println("Введіть місяць народження батька");
                        int fatherMonth;
                        do {
                            if (in.hasNextInt()) {
                                fatherMonth = in.nextInt();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        in.nextLine();
                        String fatherMonthString = String.valueOf(fatherMonth);
                        System.out.println("Введіть день народження батька");
                        int fatherDay;
                        do {
                            if (in.hasNextInt()) {
                                fatherDay = in.nextInt();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        in.nextLine();
                        String fatherDayString = String.valueOf(fatherDay);
                        StringBuilder fatherBirthdate = new StringBuilder();
                        fatherBirthdate.append(fatherDayString).append("/").append(fatherMonthString).append("/").append(fatherYearString);
                        System.out.println("Введіть iq батька");
                        int fatherIQ;
                        do {
                            if (in.hasNextInt()) {
                                fatherIQ = in.nextInt();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        in.nextLine();

                        Woman mother = new Woman(motherName, motherSurname, String.valueOf(motherBirthdate), motherIQ);
                        Man father = new Man(fatherName, fatherSurname, String.valueOf(fatherBirthdate), fatherIQ);

                        familyController.createNewFamily(mother, father);
                        Menu.showMenu();
                        break;
                    case 7:
                        do {
                            System.out.println("Напишіть порядковий номер сім'ї (ID) для видалення");
                            if (in.hasNextInt()) {
                                int userResult7 = in.nextInt();
                                in.nextLine();
                                familyController.deleteFamilyByIndex(userResult7);
                                Menu.showMenu();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        Menu.showMenu();
                        break;
                    case 8:
                        do {
                            Menu.showMenuEditFamily();
                            if (in.hasNextInt()) {
                                int userResultEditFamily = in.nextInt();
                                in.nextLine();

                                switch (userResultEditFamily) {
                                    case 1:
                                        int familyId1;
                                        do {
                                            System.out.println("Напишіть порядковий номер сім'ї (ID)");
                                            if (in.hasNextInt()) {
                                                familyId1 = in.nextInt();
                                                in.nextLine();
                                                break;
                                            } else {
                                                System.out.println(choice);
                                                in.nextLine();
                                            }
                                        } while (true);

                                        System.out.println("Напишіть ім'я хлопчика");
                                        String boyName = in.nextLine();
                                        System.out.println("Напишіть ім'я дівчинки");
                                        String girlName = in.nextLine();
                                        familyController.bornChild(familyController.getFamilyById(familyId1), boyName, girlName);
                                        Menu.showMenu();
                                        break;
                                    case 2:
                                        int familyId2;
                                        do {
                                            System.out.println("Напишіть порядковий номер сім'ї (ID)");
                                            if (in.hasNextInt()) {
                                                familyId2 = in.nextInt();
                                                in.nextLine();
                                                break;
                                            } else {
                                                System.out.println(choice);
                                                in.nextLine();
                                            }
                                        } while (true);

                                        System.out.println("Напишіть ім'я дитини");
                                        String childName = in.nextLine();
                                        System.out.println("Напишіть прізвище дитини");
                                        String childSurname = in.nextLine();
                                        System.out.println("Введіть рік народження дитини");
                                        int childYear;
                                        do {
                                            if (in.hasNextInt()) {
                                                childYear = in.nextInt();
                                                break;
                                            } else {
                                                System.out.println(choice);
                                                in.nextLine();
                                            }
                                        } while (true);
                                        in.nextLine();
                                        String childYearString = String.valueOf(childYear);
                                        System.out.println("Введіть місяць народження дитини");
                                        int childMonth;
                                        do {
                                            if (in.hasNextInt()) {
                                                childMonth = in.nextInt();
                                                break;
                                            } else {
                                                System.out.println(choice);
                                                in.nextLine();
                                            }
                                        } while (true);
                                        in.nextLine();
                                        String childMonthString = String.valueOf(childMonth);
                                        System.out.println("Введіть день народження дитини");
                                        int childDay;
                                        do {
                                            if (in.hasNextInt()) {
                                                childDay = in.nextInt();
                                                break;
                                            } else {
                                                System.out.println(choice);
                                                in.nextLine();
                                            }
                                        } while (true);
                                        in.nextLine();
                                        String childDayString = String.valueOf(childDay);
                                        StringBuilder childBirthdate = new StringBuilder();
                                        childBirthdate.append(childDayString).append("/").append(childMonthString).append("/").append(childYearString);

                                        int childIQ;
                                        do {
                                            System.out.println("Введіть iq дитини");
                                            if (in.hasNextInt()) {
                                                childIQ = in.nextInt();
                                                in.nextLine();
                                                break;
                                            } else {
                                                System.out.println(choice);
                                                in.nextLine();
                                            }
                                        } while (true);

                                        Human child = new Human(childName, childSurname, String.valueOf(childBirthdate), childIQ);
                                        familyController.adoptChild(familyController.getFamilyById(familyId2), child);
                                        Menu.showMenu();
                                        break;
                                    case 3:
                                        Menu.showMenu();
                                        break;
                                    default:
                                        System.out.println(error);
                                        break;
                                }
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        break;
                    case 9:
                        int userResult9;
                        do {
                            System.out.println("Введіть вік для видалення всіх дітей старше даного віку:");
                            if (in.hasNextInt()) {
                                userResult9 = in.nextInt();
                                familyController.deleteAllChildrenOlderThen(userResult9);
                                Menu.showMenu();
                                break;
                            } else {
                                System.out.println(choice);
                                in.nextLine();
                            }
                        } while (true);
                        Menu.showMenu();
                        break;
                    default:
                        System.out.println(error);
                        Menu.showMenu();
                }
            } else {
                String input = in.next().toLowerCase();
                if (input.equals("exit")) {
                    FileManager.writeData(familyController.getAllFamilies());
                    return;
                } else {
                    System.out.println(error);
                }
            }
        }
    }
}