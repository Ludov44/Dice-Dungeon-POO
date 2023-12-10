package io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    /**
     * lecteur d'input utilisateur
     * @param msg invite pour affichage à l'utilisateur
     * @return entrée utilisateur
     */
    public static String getInput(String msg){
        String input;
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        return input;
    }

    /**
     * lecteur de choix booléen de l'utilisateur
     * @param msg invite pour affichage à l'utilisateur
     * @param charChoice caractéres indiquant un accord de l'utilisateur
     * @return true si l'utilisateur accepte (input == charChoice) false sinon
     */
    public static boolean getChoice(String msg, char charChoice){
        String input = getInput(msg);
        if (input.length() > 0) {
            char choice = input.charAt(0);
            return (choice == charChoice);
        }
        return false;
        
    }

    /**
     * lecteur d'input utilisateur pour un entier (0 si autre chose qu'un entier est entré par utilisateur)
     * @param msg invite pour affichage à l'utilisateur
     * @return entrée utilisateur
     */
    public static int getInt(String msg){
        int input;
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            input = 0;
        }
        return input;
    }
}
