/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
class Report{
    private String id;
    private String StudentName;
    private String CourseName;
    private int totalOfCourse;

    public Report(){
        
    }

    public Report(String id, String StudentName, String CourseName, int totalOfCourse) {
        this.id = id;
        this.StudentName = StudentName;
        this.CourseName = CourseName;
        this.totalOfCourse = totalOfCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    public void setTotalOfCourse(int totalOfCourse) {
        this.totalOfCourse = totalOfCourse;
    }
    
    
    

    
     @Override
    public String toString() {
        return String.format("%-30s|%-15s|%-15d\n", StudentName,CourseName,totalOfCourse);
    }
    
}
