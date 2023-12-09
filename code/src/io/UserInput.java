package io;

import java.util.Scanner;

public class UserInput {
    /**
     * lecteur d'input utilisateur
     * @return monstre généré avec type et stats aléatoires
     */
    public static String getInput(String msg){
        String input;
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        return input;
    }
}
