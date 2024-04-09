package gui.GUI_5.task3;


import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private List<Student> students;
    private int capacity;

    public Group(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.students = new ArrayList<>(capacity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return List.copyOf(this.students);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void assign(Student student) throws StudentAlreadyInGroupException, GroupIsFullException {
        if (student.getStudentGroup() != null && !student.getStudentGroup().getName().equals(this.name)) {
//            throw new StudentAlreadyInGroupException("Student " + student.getFullName() + " already exists in " + student.getStudentGroup().toString());
            System.out.println("Student " + student.getFullName() + " already exists in " + student.getStudentGroup().toString());
            return;
        }

//        if (student.getStudentGroup() != null && student.getStudentGroup().getName().equals(this.name)) {
//            System.out.println(student.getFullName() + " already exists in THIS group " + this.name);
//            return;
//        }

        if (this.students.size() == this.capacity) {
            throw new GroupIsFullException("Can't add student " + student.getFullName() + " to group " + this.toString() + ". Not enough space!!!");
        }

        this.students.add(student);
        student.setStudentGroup(this);
    }

    public void remove(Student student) {

        if (!this.students.contains(student) && student != null) {
//            throw new StudentDoesNotExistException("Student " + student.getFullName() + " not in " + this);
            System.out.println("Student " + student.getFullName() + " not in " + this);
        }

        if (!this.students.isEmpty() && student != null) {
            this.students.remove(student);
            student.removeFromGroup();
        }
    }

    @Override
    public String toString() {
        return "Group " + this.name;
    }
}
