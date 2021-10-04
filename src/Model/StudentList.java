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
    public StudentModel searchStudentList(int studentId) throws NoSuchElementException{

        for (StudentModel s : studentList){
            // student found
            if(s.getStudentId() == studentId){
                return s;
            }
        }
        // student not found
        throw new NoSuchElementException();
    }
}
