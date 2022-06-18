
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dell
 */
public class ManageStudents {

    //Check Duplicate in list student
    private boolean CheckDuplicate(String id, String Semester, String CourseName, ArrayList<Student> listStudents) {
        //first student to last student of ListStudent array list.
        for (Student student : listStudents) {
            if (student.getId().equals(id) && student.getSemester().equals(Semester) && student.getCourseName().equals(CourseName)) {
                return true;
            }
        }
        return false;
    }

    // Check Duplicate ID
    private boolean CheckDuplicateID(String id, ArrayList<Student> listStudents) {
        //first student to last student of ListStudent array list.
        for (Student student : listStudents) {
            if (student.getId().equals(id)) {
                return true;
            }
        }
        return false;

    }

    //Check Exist in list Report
    private boolean CheckReportExist(Report newreport, ArrayList<Report> listReport) {
        for (Report report : listReport) {
            //Check newreport(getStudentName, CourseName) equal to report(getStudentName, CourseName).
            if (newreport.getId().equals(report.getId())
                    && newreport.getCourseName().equals(report.getCourseName())) {
                return true;
            }
        }
        return false;
    }

    private void getNewStudent(ArrayList<Student> listStudents) {
        String id;
        String CourseName;
        String Semester;
        String StudentName = "";
        id = GetInput.getString("Enter student id :", "id Invalid", "[a-zA-Z0-9 .]+$");
        //Check the input id with the id in the student list
        if (CheckDuplicateID(id, listStudents)) {
            //first student to last student of ListStudent array list.
            for (int i = 0; i < listStudents.size(); i++) {
                //id equals the id in the list
                if (listStudents.get(i).getId().equals(id)) {
                    StudentName = listStudents.get(i).getStudentName();
                }
            }

        } else {
            StudentName = GetInput.getString("Enter student name :", "Name student Invalid", "^[a-zA-Z ]+$");
        }

        Semester = GetInput.getString("Enter student semester :", "Semester Invalid", "^[1-9 ]+$");
        CourseName = GetInput.getString("Enter student course name :", "There are only three courses: Java, .Net, C/C++",
                "(Java)|(\\.Net)|(C/C.++)");
        //id, Semester, CourseName equals the id,Semester, CourseName in the list
        if (CheckDuplicate(id, Semester, CourseName, listStudents)) {
            System.out.println("Duplicate!");
        } else {
            listStudents.add(new Student(id, StudentName, Semester, CourseName));
            System.out.println("Success!");
        }

    }

    public void Create(ArrayList<Student> listStudents) {
        while (true) {
            //Yes or No condition depends on the number of students
            if (listStudents.size() <= 2) {
                //Enter information and save it to the list
                getNewStudent(listStudents);
            } else {
                String SelectionYorN = GetInput.getString("Do you want countinue (Y/N)?\n", "Invalid countinue", "^[Y/N]$");
                //User's choice coincides with Yes
                if (SelectionYorN.equals("Y")) {
                    //Enter information and save it to the list
                    getNewStudent(listStudents);
                    //User choice coincides with No and stop
                } else {
                    break;
                }
            }
        }
    }

    public void FindAndSort(ArrayList<Student> listStudents) {
        for (int i = 0; i < listStudents.size(); i++) {
            listStudents.get(i);
        }
        //first student to last student of ListStudent array list.
        for (int i = 0; i < listStudents.size(); i++) {
            //Loop access from first element to before sorted element
            for (int j = 0; j < listStudents.size() - i - 1; j++) {
                //Compare the names of two adjacent student objects
                if (listStudents.get(j).getStudentName().compareToIgnoreCase(listStudents.get(j + 1).getStudentName()) > 0) {
                    //Swap the position of two students
                    Student newstudent = listStudents.get(j);
                    listStudents.set(j, listStudents.get(j + 1));

                    listStudents.set(j + 1, newstudent);
                    //newstudent = newstudent;

                    //Collections.swap(listStudents, j, j + 1);
                }
            }

        }

        String searcherName = GetInput.getString("Enter search name(student name or a part of student name): ",
                "Name Invalid", "^[a-zA-Z ]+$");
        int count = 0;
        boolean isExisted = false;

        //first student to last student of ListStudent array list.
        for (Student student : listStudents) {
            //Check the entered name is in the list
            if (student.getStudentName().toUpperCase().contains(searcherName.toUpperCase())) {
                if (count == 0) {
                    System.out.format("%-20s%-20s%-20s\n",
                            "Student name", "Semester", "Course Name");
                }

                count++;
                isExisted = true;
                System.out.format("%-20s%-20s%-20s\n", student.getStudentName(), student.getSemester(), student.getCourseName());
            }
        }
        //Not found print out the message
        if (isExisted == false) {
            System.out.println("Not Found");
        }

    }

    public void UpdateOrDelete(ArrayList<Student> listStudents) {

        ArrayList<Student> listResult = new ArrayList<>();
        if (listStudents.isEmpty()) {
            System.out.println("List Students list is empty!");
        } else {
            String searchId = GetInput.getString("Enter search id :", "ID Invalid", "[a-zA-Z0-9 .]+$");
            //first student to last student of ListStudent array list.
            for (Student student : listStudents) {
                //search Id found in list
                if (student.getId().equals(searchId)) {
                    listResult.add(new Student(student.getId(), student.getStudentName(), student.getSemester(), student.getCourseName()));
                }
            }
            //search Id found in list
            if (CheckDuplicateID(searchId, listStudents)) {
                System.out.println("===LIST OF STUDENTS FOUNDED BY ID===");
                System.out.format("%-4s%-10s%-20s%-20s%-20s\n", "Stt", "ID", "Name", "Semester", "Course");
                //first student to last student of listResult array list.
                for (int i = 0; i < listResult.size(); i++) {
                    System.out.format("%d. %-15s%-30s%-20s%-20s\n", i + 1, listResult.get(i).getId(),
                            listResult.get(i).getStudentName(), listResult.get(i).getSemester(), listResult.get(i).getCourseName());
                }

                String SelectionUorD = GetInput.getString("Do you want to update (U) or delete (D) student?\n",
                        "Invalue ", "^[U/D]$");
                //Option U is update
                if (SelectionUorD.equals("U")) {
                    int count = 0;
                    int countupdate = 0;
                    String StudentName = "";
                    int numberStudent = GetInput.getInt("Select the number of students to update:", "Invalid", 1, listResult.size());

                    for (int i = 0; i < listStudents.size(); i++) {
                        //serachID equals id in list student
                        if (listStudents.get(i).getId().equals(searchId)) {
                            countupdate++;

                            //Found location of student record to update
                            if (countupdate == numberStudent) {
                                String id = GetInput.getString("Enter student id :", "id Invalid", "[a-zA-Z0-9 .]+$");

                                StudentName = GetInput.getString("Enter student name :", "Name student Invalid", "^[a-zA-Z ]+$");

                                String Semester = GetInput.getString("Enter student semester :", "Semester Invalid", "[1-9]+");
                                String CourseName = GetInput.getString("Enter course student name :", "There are only three courses: Java, .Net, C/C++",
                                        "(Java)|(\\.Net)|(C/C.++)");
                                //Check Duplicate in the student list
                                if (CheckDuplicate(id, Semester, CourseName, listStudents)) {
                                    System.out.println("Duplicate!");
                                    count++;
                                    break;
                                }
                                if (count == 0) {
                                    listStudents.set(i, new Student(id, StudentName, Semester, CourseName));
                                    System.out.println("Uplate Success!");
                                    //first student to last student of ListStudent array list
                                    for (Student student : listStudents) {
                                        //id equals the id in the list and the list name is different from the input name
                                        if (id.equals(student.getId()) && !(StudentName.equals(student.getStudentName()))) {
                                            //Update the updated name for the record with id and different name
                                            student.setStudentName(StudentName);
                                        }
                                    }
                                }

//                                //Delete all records in report list
//                                listResult.removeAll(listResult);
                                System.out.println("List after being updated:");
                                System.out.format("%-15s%-30s%-20s%-20s\n", "ID", "Student name", "Semester", "Course Name");
                                //first student to last student of ListStudent array list
                                for (Student student : listStudents) {
                                    System.out.println(student);

                                }
                            }
                        }
                    }

                    //Option D is update
                } else {
                    int numberStudent = GetInput.getInt("Select the number of students to Delete:", "Invalid", 1, listResult.size());
                    int countdelete = 0;
                    //first student to last student of ListStudent array list.
                    for (Student student : listStudents) {
                        //search Id found in list 
                        if (student.getId().equals(searchId)) {
                            countdelete++;
                        }

                        //variable that counts the number of matches with the stt in the list result
                        if (countdelete == numberStudent) {
                            listStudents.remove(student);

                            System.out.println("Removed!");
                            break;

                        }

                    }

                    System.out.println("List after being deleted:");
                    System.out.format("%-15s%-30s%-15s%-15s\n", "ID", "Name", "Semester", "Course");
                    for (Student student : listStudents) {
                        System.out.println(student);
                    }

                }
                //Id not found
            } else {
                System.out.println("Id not found");
            }

        }
    }

    public void Report(ArrayList<Student> listStudents) {

        if (listStudents.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        ArrayList<Report> ListReport = new ArrayList<>();
        //Loop use to traverse each object student from 
        //first student to last student of ListStudent array list.
        for (Student student : listStudents) {
            Report newreport = new Report(student.getId(),
                    student.getStudentName(), student.getCourseName(), 1);
            if (CheckReportExist(newreport, ListReport)) {
                //Loop use to traverse each object report from 
                //first report to last report of ListReport array list.
                for (Report report : ListReport) {
                    //Check newreport(ID, CourseName) equal to report(ID, CourseName).
                    if (newreport.getId().equals(report.getId())
                            && newreport.getCourseName().equals(report.getCourseName())) {
                        report.setTotalOfCourse(report.getTotalOfCourse() + 1);
                    }
                }
            } else {
                ListReport.add(newreport);
            }
        }
        System.out.println("===RESULT REPORT===");
        //Loop use to traverse each object report from 
        //first report to last report of ListReport array list.
        for (Report report : ListReport) {
            System.out.format("%-30s%-20s%-20s\n",report.getStudentName(),report.getCourseName(),report.getTotalOfCourse());
                   
        }

    }

}
