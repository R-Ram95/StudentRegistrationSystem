package Model;

import App.DataBase;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StudentList {

    private ArrayList<StudentModel> studentList;

    public StudentList(){
        DataBase db = new DataBase();
        studentList = db.loadStudentsFromDB();
    }

    /**
     * Search student list by the student's id
     * @param studentId
     * @return the Student
     * @throws NoSuchElementException student not found
     */
    public StudentModel searchStudentList(String studentName, int studentId){

        for (StudentModel s : studentList){
            // student found
            if(s.getStudentId() == studentId && s.getStudentName().equals(studentName)){
                return s;
            }
        }
        // student was not found
        throw new NullPointerException();
    }
}
