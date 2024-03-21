import java.util.*;
import java.io.*;

public class Main {
    static Student[] studentArray = new Student[4]; //array to hold list of all Students
    static Teacher[] teacherArray = new Teacher[5]; //array to hold list of all Teachers
    static Scanner input = new Scanner(System.in); //Scanner for input further down the in the code

    public static void main(String[] args) {
        //initiates demo Student objects.
        Student one = new Student("John", "Mikkelsen", 21, 1.85,true);
        Student two = new Student("Signe", "Conradsen", 28, 1.70, false);
        Student three = new Student("Bob", "Johnnysen", 23, 2.5, true);
        Student four = new Student();

        //inputs demo Student objects into the main student array.
        studentArray[0] = one;
        studentArray[1] = two;
        studentArray[2] = three;
        studentArray[3] = four;

        //studentArray[4] = createStudent(input); //earlier task - (prompts user to create student)

        //Lines below for testing changing student Address
        //printStudentArray(studentArray); //print student array as is before change
        //changeStudentAddressQuestionMark(input); //prompts user if they want to change an address of a student
        //printStudentArray(studentArray); //prints student array again after change

        //lines of code below to test Teacher Class
        //adding teachers to array
        Teacher t1 = new Teacher("Johnny",34,1);
        Teacher t2 = new Teacher("Bobby",55,2);
        Teacher t3 = new Teacher("Michael",54,3);
        String[] t4subjects = new String[] {"Math", "Science", "Danish", "English", "History"};
        Teacher t4 = new Teacher("Slemfyr",32,4,t4subjects);
        teacherArray[0] = t1;
        teacherArray[1] = t2;
        teacherArray[2] = t3;
        teacherArray[3] = t4;

        addTeacher(); //test adding teachers
        printTeachers(); //test printing teacher objects in teacher array
    }

    public static void printTeachers(){
        for(int i = 0; i <= teacherArray.length-1;i++){
            System.out.println(teacherArray[i].toString());
        }
    }

    public static void addTeacher() {
        System.out.println("Creating new Teacher object");
        System.out.println("Enter name of the new Teacher");
        String name = input.nextLine();
        System.out.println("Enter age of the new Teacher");
        int age = input.nextInt();
        System.out.println("Enter id of the new Teacher");
        int id = input.nextInt();
        input.nextLine(); //clears scanner
        String subject = "";
        String[] subjectsArray = new String[5];
        int count = 0;
        System.out.println("Enter new subject or type stop");
        subject = input.nextLine();
        if(!subject.equals("stop")){
            subjectsArray[count] = subject;
            count++;
        }
        while (!subject.equals("stop") && count < 5) {
            System.out.println("Enter the name of the next subject this teacher teaches or type \"stop\" to stop");
            subject = input.nextLine();
            if (!subject.equals("stop")) {
                subjectsArray[count] = subject;
                count++;
            }
        }

        Teacher newTeacher = new Teacher(name,age,id,subjectsArray);
        System.out.println("Created Teacher " + newTeacher.toString());
        for(int i = 0; i < teacherArray.length;i++){
            if(teacherArray[i] == null){
                teacherArray[i] = newTeacher;
                break;
            }
        }
    }


    //asks user if want to change address of student and ask which
    //then calls method to change student if answer "y".
    public static void changeStudentAddressQuestionMark(Scanner scan){
        System.out.println("Do you wish to change the address of a student? Answer with \"y/n\"");
        String answer = scan.next();
        if(answer.equals("y")){
            System.out.println("which student do you wish to change the address of? answer with their number on the list");
            int choice = scan.nextInt()-1;
            scan.nextLine();
            Student changedStudent = changeStudentAddress(studentArray[choice], scan);
            studentArray[choice] = changedStudent;
            System.out.println("Succesfully changed the student address");
        } else {
            System.out.println("ok, ggwp");
            System.exit(0);
        }

    }

    //Allows user to change address of parsed Student via input from Scanner object
    private static Student changeStudentAddress(Student student, Scanner scan) {
        System.out.print("Editing student: ");
        System.out.println(student.toString());
        System.out.println();
        System.out.println("Enter the new address of the student");
        String newAdress = scan.nextLine();
        student.setAddress(newAdress);
        return student;

    }

    //prints the entire student array
    public static void printStudentArray(Student[] studentArray){
        for(Student i : studentArray) {
            System.out.println(i.toString());
        }
    }

    //allows user to create a student via input from Scanner object
    public static Student createStudent(Scanner scan){
        try {
            System.out.println("Creating new student in database.");
            System.out.println("Enter firstname of student (String)");
            String firstName = scan.next();
            System.out.println("Enter the last name (String)");
            String lastname = scan.next();
            System.out.println("Enter the age of the student (int)");
            int age = scan.nextInt();
            System.out.println("Enter the height of the student (double)");
            double height = scan.nextDouble();
            System.out.println("If male enter true, else false");
            String genderInput = scan.next();
            boolean gender;
            if(genderInput.equals("true")){
                gender = true;
            } else {
                gender = false;
            }
            System.out.println("Enter the adress of the student (String)");
            scan.nextLine();
            String address = scan.nextLine();

            Student newStudent = new Student(firstName,lastname,age,height,gender,address);
            System.out.print("You have added Student: ");
            System.out.print(newStudent.toString());
            System.out.println();
            return newStudent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}