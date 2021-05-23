import java.util.Objects;

public class Lab10 {


    public static void main(String[] args) {
        Institute kpi = new Institute("NTUU KPI");
        Faculty fict = new Faculty("FICT");
        addStudent(fict, "Ivan", "Ivanov", "IT-321", 90.1);
        addStudent(fict, "Petro", "Fedorenko", "IT-232", 95.9);
        addStudent(fict, "Ivan", "Oleksandrenko", "IT-21", 75);
        addStudent(fict, "Anastasiya", "Vasileva", "IL -001", 95.0);
        addStudent(fict, "Anna", "Makarenko", "UI-301", 100.0);
        System.out.println(fict.getBestStudent());


    }

    private static void addStudent(Faculty faculty, String name, String surname, String id, double mark) {
        System.out.println("Adding new student: " + name + ", " + surname + ", " + id + ", " + mark);
        try {
            faculty.addStudent(new Student(name, surname, id, mark));
        } catch (FacultyException e) {
            System.out.println("Got error: " + e.getMessage());
        } finally {
            System.out.println("Number of students: " + faculty.getNumberOfStudents());

        }
    }
}

