package Services;

import classes.Student;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component(service = StudentServices.class, immediate = true)
public class StudentClassService implements StudentServices{
    List<Student> students=new ArrayList<Student>();
    Iterator<Student> iterator=students.iterator();

    @Reference
    ConfigurationService configurationService;

    public void addStudent(Student student){
        if(configurationService.isClassLimitReached(students)) {
            students.add(student);
            System.out.println("Student "+student.getId()+" added");
        }
    }

    public Student getStudent(int id){
        return students.stream().filter(e->e.getId()==id).findFirst().get();
    }

    public List<Student> getAllStudents(){
        return students;
    }
    public void isStudentPassed(int id){
        if(getStudent(id).getMarksObtained()>configurationService.getPassingMarks()){
            System.out.println("Student "+id+" has Passed");
        }
        else {
            System.out.println("Student "+id+" has Failed");
        }
    }
    public void deleteStudent(int  id){
        students.removeIf(e->e.getId()==id);
    }
    @Activate
    public void activate(){
        Student std = new Student(1,"arpit",90,21);
        addStudent(std);
        Student std1 = new Student(2,"ishrat",70,22);
        addStudent(std1);
        Student std2 = new Student(3,"deora",50,23);
        addStudent(std2);
        isStudentPassed(1);
        isStudentPassed(2);
        isStudentPassed(3);
        System.out.println(getStudent(1));
        System.out.println(getAllStudents());
    }
    @Deactivate
    public void deactivate(){
        deleteStudent(2);
        System.out.println(getAllStudents());
    }
}
