package View;

import View.LoginPage;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LoginPage login = new LoginPage();
        login.displayGUI();

        StudentCoursesPage student = new StudentCoursesPage();
        student.displayGUI();
    }
}
