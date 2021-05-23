import java.util.*;

class Faculty {
    private String name;
    private Set<Student> students;
    private Map<String, Double> studentMarks = new HashMap<String, Double>();

    public Faculty(String name) {
        this.name = name;
        students = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public Double getStudentMarksById(String id) {
        return studentMarks.get(id);
    }

    public String getBestStudent() {
        double maxGrade = 0;
        String bestStudent = "";
        Set<String> studentsTmp = studentMarks.keySet();
        for (String student : studentsTmp) {
            double currentMark = studentMarks.get(student);
            if (currentMark > maxGrade) {
                maxGrade = currentMark;
                bestStudent = student;
            }
        }
        return bestStudent + " " + maxGrade;
    }

    public void addStudent(Student student) throws FacultyException {
        if (student == null) {
            throw new NullPointerException("Null value cannot be added");
        }
        if (students.contains(student)) {
            throw new IllegalArgumentException("This student is already in list");
        }
        if (students.size() > 3) {
            throw new FacultyException("Number of students can't be more than 4");
        }
        students.add(student);
        studentMarks.put(student.getGradebookId(), student.getAverageMark());
    }

    public void addStudent(String firstName, String lastName, String gradeBookId, double averageMark) throws FacultyException {
        Student student = new Student(firstName, lastName, gradeBookId, averageMark);
        addStudent(student);
    }

    public void removeStudent(Student student) {
        if (students.isEmpty()) {
            throw new NullPointerException("List of students of faculty: " + name + " is empty");
        }
        if (student == null) {
            throw new NullPointerException("Null value cannot be removed");
        }
        students.remove(student);
    }

    @Override
    public String toString() {
        return "Name of the faculty: " + name + ". Number of students: " + getNumberOfStudents();
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
        return Objects.equals(name, ((Faculty) obj).getName());
    }

    @Override
    public int hashCode() {
        int res = 0;
        if (name == null) {
            return res;
        }
        for (int i = 0; i < name.length(); i++) {
            res += 31 * i * name.charAt(i);
        }
        return res;
    }

}
