package view;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class UI {

    public String getString(String prompt) {
        System.out.println(prompt);
        System.out.print(" > ");
        String input = new Scanner(System.in).nextLine();
        if (input.length() == 0) {
            System.out.println("Please enter a valid value");
            return getString(prompt);
        }
        return input;
    }

    public int getInt(String prompt) {
        System.out.println(prompt);
        System.out.print(" > ");
        Integer input;

        try {
            input = new Scanner(System.in).nextInt();
            return input;
        } catch (Exception e) {
            System.out.println("Please enter an integer");
            return getInt(prompt);
        }
    }

    public static int getInt(String prompt, int lowerLimit, int upperLimit) {
        System.out.println(prompt);
        System.out.print(" > ");
        int input;
        try {
            input = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("Please enter an integer");
            return getInt(prompt, lowerLimit, upperLimit);
        }
        if (input < lowerLimit || input > upperLimit) {
            System.out.println("Please enter a value between " + lowerLimit + " and " + upperLimit);
            return getInt(prompt, lowerLimit, upperLimit);
        }
        return input;
    }

    public Serializable getInt(String prompt, int digits) {
        System.out.println(prompt);
        System.out.print(" > ");
        String input;
        Integer newNum;
        try {
            input = new Scanner(System.in).nextLine();
            if (input.length() != digits) {
                return getInt(prompt, digits);
            }
            newNum = Integer.valueOf(input);
        } catch (Exception e) {
            System.out.println("Please enter an integer");
            return getInt(prompt, digits);
        }
        return input;
    }

    public static Date getDate(String prompt) {
        System.out.println(prompt);
        int day, month, year;
        day = getInt("Please enter day", 1, 31);
        month = getInt("Please enter month", 1, 12) - 1;
        year = getInt("Please enter year", 2020, 2024) - 1900;
        Date date = new Date(year, month, day);
        return date;
    }

    public static int menu() {

        System.out.println("1 - Add a new project");
        System.out.println("2 - Add a new team member");
        System.out.println("3 - Remove a specific team member");
        System.out.println("4 - Remove a specific project");
        System.out.println("5 - Display a specific project");
        System.out.println("6 - Display all projects");
        System.out.println("7 - Display project team sizes");
        System.out.println("8 - Quit");

        try {
            int option = Input.getInteger("Enter an option: ");
            if (option < 1 || option > 8) {
                System.out.println("Invalid menu option");
                return menu();
            }
            return option;
        } catch (Exception e) {
            System.out.println("Enter a valid option");
        }

        return menu();
    }

    public Boolean repeat() {
        Boolean result = false;
        Character response;
        response = Input.getCharacter("continue(y/n)?  ");
        if ((response == 'y') || (response == 'Y')) {
            result = true;
        }
        return result;
    }
}

