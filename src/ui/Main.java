package ui;

import model.Classroom;
import model.Student;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    private Scanner sc;
    private Classroom classroom;
    private boolean exit;

    public Main() {
        sc = new Scanner(System.in);
        Student newStudent = new Student("3","Luis");   //cola
        classroom= new Classroom("A-1",1,newStudent);
        classroom.addStudent(new Student("2","Santiago"));
        classroom.addStudent(new Student("1","Santiago"));
        classroom.addStudent(new Student("0","Pedro")); //cabeza
        System.out.println(classroom.getFirstStudent().toString());
        exit=false;
    }

    public static void main (String args []){
        Main main = new Main();
        while(main.exit==false){
            main.menu();
        }
    }

    public void menu() {
        System.out.println("Please select an option\n"+
                "1)Register a student\n"+
                "2)Delete a student\n"+
                "3)Show students list\n"+
                "4)Exit\n");
        int option=sc.nextInt();
        exit=false;
        sc.nextLine();
        switch(option) {

            case 1:
                registerStudent();
                break;

            case 2:
               deleteStudent();
               break;

            case 3:
                printStudent();
                break;
            case 4:
                System.out.println("Goodbye\n");
                exit=true;
                break;

        }
    }

    private void registerStudent() {
        System.out.println("What is the name of the student?\n");
        String name= sc.nextLine();
        System.out.println("What is the student code?\n");
        String code=sc.nextLine();
        System.out.println("Do you wish to add the student to the front or back?\n"+
                            "1)Front\n"+
                            "2)Back\n");
        int option = sc.nextInt();
        sc.nextLine();
        Student newStudent = new Student(code,name);
        if(option==1){
            classroom.addStudent(newStudent);
        }
        else if(option==2){
            classroom.addStudentInOrder(newStudent);
        }
        else{
            System.out.println("Invalid option\n");
        }
    }

    private void deleteStudent(){
        System.out.println("What is the student name?\n");
        String code=sc.nextLine();
        System.out.println("A total of: " + classroom.deleteStudent(code) + " students were deleted\n");
    }

    private void printStudent() {
        System.out.println("How do you wish to print the student list?\n"+
                "1)Front to Back\n"+
                "2)Back to Front\n");
        int option = sc.nextInt();
        sc.nextLine();
        if(option==1){
            System.out.println(classroom.printStudents());
        }
        else if(option==2){
            System.out.println(classroom.printStudentsFromBack());
        }
        else{
            System.out.println("Invalid option\n");
        }
    }


}
