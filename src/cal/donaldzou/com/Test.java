package cal.donaldzou.com;

import java.io.*;
import java.util.*;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {

        // The name of the file to open.
        String fileName = "";
        Scanner keyboard = new Scanner(System.in);

        int i;

        try {
            for (int m = 0; m < 1000000; m++) {
                System.out.println("Home add -1, Guest add -2, Home T.O -3, Guest T.O -4");
                i = keyboard.nextInt();

                switch (i){
                    case 1:
                    fileName = "/Users/Donaldzou/Desktop/LIVESTREAMFILE/HOME SCORE.txt";
                    FileWriter home = new FileWriter(fileName);
                    PrintWriter home1 = new PrintWriter(home);
                    System.out.print("Home Score:");
                    int h = keyboard.nextInt();
                    home1.print(h);
                    home1.close();
                    System.out.println("DONE!");
                    System.out.println("------------------------");
                    continue;

                    case 2:
                        fileName = "/Users/Donaldzou/Desktop/LIVESTREAMFILE/AWAY SCORE.txt";
                        FileWriter away = new FileWriter(fileName);
                        PrintWriter away1 = new PrintWriter(away);
                        System.out.print("Away Score:");
                        int g = keyboard.nextInt();
                        away1.print(g);
                        away1.close();
                        System.out.println("DONE!");
                        System.out.println("------------------------");
                        continue;

                }

            }

        }

        // Assume default encoding.

        catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
            // Or we could just do this
            // ex.printStackTrace();
        }
    }
}
