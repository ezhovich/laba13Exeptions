
import java.util.*;

class Institute {
    private String name;
    private Set<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    //Метод додавання факультету
    public void addFaculty(Faculty faculty) {
        if (faculty == null) {
            throw new NullPointerException("Faculty cannot be null!");
        }
        if (faculties.contains(faculty)) {
            throw new IllegalArgumentException("This faculty already exists!");
        }
        faculties.add(faculty);
    }

    //Метод видалення факультету
    public void removeFaculty(Faculty faculty) {
        if (faculty == null) {
            throw new NullPointerException("Null value cannot be removed!");
        }
        faculties.remove(faculty);
    }

    @Override
    public String toString() {
        return "Name ot the institute: " + name + ". List of the faculties: " + faculties;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Institute other = (Institute) obj;
        return Objects.equals(this.getName(), other.getName());
    }

    @Override
    public int hashCode() {
        int res = 0;
        if (name == null) {
            return res;
        }
        for (int i = 0; i < name.length(); i++) {
            res += 31 ^ i * name.charAt(i);
        }
        return res;
    }

    //Метод знаходження загального числа студентів
    public int getTotalNumberOfStudents() {
        if (faculties.isEmpty()) {
            throw new NullPointerException("There is no faculties");
        }
        int number = 0;
        for (Faculty faculty : faculties) {
            number += faculty.getNumberOfStudents();
        }
        return number;
    }

    //Метод знаходження факультету з найбільшим числом студентів
    public Faculty getbiggestFaculty() {
        if (faculties.isEmpty()) {
            throw new NullPointerException("There is no faculties");
        }
        Faculty max = new Faculty("Empty");
        Faculty faculty;
        for (Iterator<Faculty> i = faculties.iterator(); i.hasNext(); ) {
            faculty = i.next();
            if (max.getNumberOfStudents() < faculty.getNumberOfStudents()) {
                max = faculty;
            }
        }
        return max;
    }

    //Метод знаходження студентів з найвищими балами
    public ArrayList<Student> getStudentWithHighestMarks() {
        if (faculties.isEmpty()) {
            throw new NullPointerException("There is no faculties");
        }
        ArrayList<Student> highMarks = new ArrayList<>();
        for (Iterator i = faculties.iterator(); i.hasNext(); ) {
            Object obj = i.next();
            if (obj instanceof Faculty) {
                Faculty faculty = (Faculty) obj;
                Set<Student> students = faculty.getStudents();
                for (Iterator j = students.iterator(); j.hasNext(); ) {
                    Object o = j.next();
                    if (o instanceof Student) {
                        Student student = (Student) o;
                        if (student.getAverageMark() >= 95 && student.getAverageMark() <= 100) {
                            highMarks.add(student);
                        }
                    }
                }
            }
        }
        return highMarks;
    }


}