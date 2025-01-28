package day01linkedlist.singlylinkedlist.studentrecordmanagement;

public class StudentRecordManagement {
    Student head;

    public StudentRecordManagement() {
        this.head = null;
    }

    public void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addStudentAtPosition(int rollNumber, String name, int age, String grade, int position) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 0) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public Student searchStudentByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No records found");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public void updateStudentGrade(int rollNumber, String newGrade) {
        Student student = searchStudentByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        } else {
            System.out.println("Student not found");
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement srm = new StudentRecordManagement();

        srm.addStudentAtBeginning(1, "Ankit Patel", 24, "A");
        srm.addStudentAtEnd(2, "Ankit kumar", 22, "B");
        srm.addStudentAtPosition(3, "Anand Soni", 21, "A", 1);

        srm.displayAllStudents();

        srm.updateStudentGrade(2, "A+");

        srm.displayAllStudents();

        srm.deleteStudentByRollNumber(1);

        srm.displayAllStudents();

        Student student = srm.searchStudentByRollNumber(3);
        if (student != null) {
            System.out.println("Found student: " + student.name);
        } else {
            System.out.println("Student not found");
        }
    }
}
