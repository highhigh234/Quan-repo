
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class GetInput {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    //Integer and error checking methods
    public static Integer getInt(String msg, String error, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int num;
                String input = in.readLine();
                num = Integer.parseInt(input);
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Id must be a positive integer greater than zero");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(error);
            }
        }
    }
    
    //String checking method and error message
    public static String getString(String msg, String error, String regex) {
        while (true) {
            try {
                System.out.print(msg);
                String input = in.readLine();
                if (input.matches(regex)) {
                    return input;
                }
            } catch (IOException e) {
                System.out.println("Error due to IOException");
            }
            System.out.println(error);
        }
    }
}
