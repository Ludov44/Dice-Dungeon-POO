package io;

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
     * lecteur de choix O/N de l'utilisateur
     * @param msg invite pour affichage à l'utilisateur
     * @return true si l'utilisateur accepte (O ou o) false sinon
     */
    public static boolean getChoice(String msg){
        char choice = getInput(msg).charAt(0);
        return (choice == 'O' || choice == 'o');
    }

    /**
     * lecteur d'input utilisateur pour un entier
     * @param msg invite pour affichage à l'utilisateur
     * @return entrée utilisateur
     */
    public static int getInt(String msg){
        int input;
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        return input;
    }
}
