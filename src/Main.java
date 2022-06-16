
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class Main {

    public static void main(String[] args) {

        ManageStudents manager = new ManageStudents();
        ArrayList<Student> listStudents = new ArrayList<>();
   
        while (true) {
            //Step1: Display menu.
            DisplayMeun();
            //Step2: Get user choice.
            int userchoice = GetChoice();
            //Step3: Switch function related to use's choice. 
            switch (userchoice) {
                case 1:
                    //User choice 1: Create Student.
                    manager.Create(listStudents);
                    break;
                case 2:
                    //User choice 2: Find and Sort Student
                    manager.FindAndSort(listStudents);
                    break;
                case 3:
                    //User choice 3: Update or Delete Student.
                    manager.UpdateOrDelete(listStudents);
                    break;
                case 4:
                    //User choice 4: Report
                    manager.Report(listStudents);
                    break;
                case 5:
                    //User choice 5: Exit
                    Exit();
            }
        }

    }

    private static void DisplayMeun() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT\n"
                + "1. Create\n"
                + "2. Find and Sort\n"
                + "3. Update/Delete\n"
                + "4. Report\n"
                + "5. Exit\n"
                + "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
    }

    private static void Exit() {
        System.exit(0);
    }

    private static int GetChoice() {
        Scanner sc = new Scanner(System.in);      
        while (true) {            
            System.out.print("Enter choice :");
            int choice = sc.nextInt();
            if (choice <= 5 && choice >= 1) {
                return choice;
            }else{
                System.out.println("Invalid selection! Please re-enter your choice from 1 to 5");
            }
        }
         
    }
    
    
}
