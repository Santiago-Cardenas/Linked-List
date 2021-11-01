package model;

public class Student {
    String code;
    String name;
    Student next;
    Student last;

    public Student(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }

    public Student getLast() {
        return last;
    }

    public void setLast(Student last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Student\n" +
                "code: " + code + "\n" +
                "name: " + name + "\n";
    }
}
