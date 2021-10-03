package Model;

public class RegistrationModel {
    private StudentModel theStudent;
    private CourseOfferingModel theOffering;
    // private char grade;

    public RegistrationModel(StudentModel theStudent, CourseOfferingModel theOffering){
        this.theStudent = theStudent;
        this.theOffering = theOffering;
    }

    public void addRegistration() {
        theStudent.addRegistration(this);
        theOffering.addRegistration(this);
    }

    public void removeRegistration(){
        theStudent.removeRegistration(this);
        theOffering.removeRegistration(this);
    }

    public StudentModel getStudent(){
        return theStudent;
    }

    public CourseOfferingModel getOffering(){
        return theOffering;
    }
}
