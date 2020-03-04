package Services;

import classes.Student;
import org.osgi.service.component.annotations.Component;

public interface StudentServices{
    void addStudent(Student student);
    Student getStudent(int id);
    void isStudentPassed(int id);
}
