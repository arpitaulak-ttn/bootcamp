package classes;

public class Student {
    private int id;
    private String name;
    private int marksObtained;
    private int age;

    public Student(int id,String name,int marksObtained,int age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.marksObtained=marksObtained;
    }
    Student(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marksObtained=" + marksObtained +
                ", age=" + age +
                '}';
    }
}
