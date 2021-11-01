package model;

public class Classroom {
    String name;
    int studentsQT;
    Student firstStudent;
    Student lastStudent;

    public Classroom(String name, int studentsQT) {
        this.name = name;
        this.studentsQT = studentsQT;
    }

    public Classroom(String name, int studentsQT, Student firstStudent) {
        this.name = name;
        this.studentsQT = studentsQT;
        this.firstStudent = firstStudent;
        lastStudent=firstStudent;
    }

    public void addStudent(Student newStudent){
        if(firstStudent==null){
            firstStudent=newStudent;
            lastStudent=newStudent;
        }
        else if(firstStudent==lastStudent){
            System.out.println("Entro al else if");
            firstStudent=newStudent;
            firstStudent.setNext(lastStudent);
            firstStudent.setLast(lastStudent);
            lastStudent.setNext(firstStudent);
            lastStudent.setLast(firstStudent);
        }
        else{
            System.out.println("Entro al else if segundo");
            Student temp=firstStudent;
            firstStudent=newStudent;
            newStudent.setNext(temp);
            newStudent.setLast(lastStudent);
            lastStudent.setNext(newStudent);
            temp.setLast(firstStudent);
        }
    }

    public int deleteStudent(String name) {
        int qtDeleted = 0;
        int size=0;
        if (firstStudent == lastStudent) {
            if (firstStudent.getName().equalsIgnoreCase(name)) {
                firstStudent = null;
                lastStudent = null;
                qtDeleted++;
            }
        } else if(firstStudent!=lastStudent){
            Student cicleSize=firstStudent;

            do {
                size++;
                cicleSize=cicleSize.getNext();
            }while(cicleSize!=firstStudent);

            for(int i=0; i<size;i++) {
                if (firstStudent.getName().equalsIgnoreCase(name)) {
                    firstStudent = firstStudent.getNext();
                    firstStudent.setLast(lastStudent);
                    lastStudent.setNext(firstStudent);
                    qtDeleted++;
                } else if (lastStudent.getName().equalsIgnoreCase(name) && lastStudent != null) {
                    lastStudent = lastStudent.getLast();
                    lastStudent.setNext(firstStudent);
                    firstStudent.setLast(lastStudent);
                    qtDeleted++;
                } else {
                    Student prev = firstStudent;
                    Student next = firstStudent.getNext();
                    do {
                        if (next.getNext() != null) {
                            if (next.getName().equalsIgnoreCase(name)) {
                                prev.setNext(next.getNext());
                                next.getNext().setLast(prev);
                                next.setLast(null);
                                next.setNext(null);
                                qtDeleted++;
                            } else {
                                next = next.getNext();
                            }
                            prev = prev.getNext();
                        } else {
                            prev = firstStudent;
                        }
                    } while (prev != firstStudent);
                }
            }

        }
        return qtDeleted;
    }

    public String printStudents(){
        Student temp=firstStudent;
        String msg="";
        if(temp==null){
            msg+="There are no students registered\n";
        }
        else if(firstStudent==lastStudent){
            msg+=firstStudent.toString();
        }
        else {
            do {
                msg += temp.toString() + "\n";
                temp = temp.getNext();
            } while (temp != firstStudent);
        }
        return msg;
    }

    public String printStudentsFromBack(){
        Student temp=lastStudent;
        String msg="";
        if(temp==null){
            msg+="There are no students registered\n";
        }
        else if(firstStudent==lastStudent){
            msg+=firstStudent.toString();
        }
        else {
            do {
                msg += temp.toString() + "\n";
                temp = temp.getLast();
            } while (temp != lastStudent);
        }
        return msg;
    }

    public void addStudentInOrder(Student newStudent){
        if(firstStudent ==null){
            firstStudent=newStudent;
            lastStudent=newStudent;
        }
        else{
            if(firstStudent==lastStudent){
                lastStudent=newStudent;
                firstStudent.setNext(lastStudent);
                newStudent.setNext(firstStudent);
            }
            else {
                newStudent.setNext(firstStudent);
                lastStudent.setNext(newStudent);
            }
        }
    }

    public String printStudentRecursivo(){
        Student temp=firstStudent;
        StringBuilder myString = new StringBuilder();
        do{
            System.out.println("entro");
            myString.append(temp.toString());
            temp=temp.getNext();
        }while(temp!=firstStudent);
        return myString.toString();
    }

    public void printGeneral(){

    }

    public void printStudentsRecursive(Student student){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentsQT() {
        return studentsQT;
    }

    public void setStudentsQT(int studentsQT) {
        this.studentsQT = studentsQT;
    }

    public Student getFirstStudent() {
        return firstStudent;
    }

    public void setFirstStudent(Student firstStudent) {
        this.firstStudent = firstStudent;
    }
}
