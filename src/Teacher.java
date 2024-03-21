import java.util.Arrays;

public class Teacher {
    private String name;
    private int age;
    private int id;
    private String[] subjects;


    public String toString(){
        String subjectsFormattet = Arrays.toString(getSubjects()).replaceAll("[\\[\\]]","");
        String formatedString = String.format("Name: %-18s Age: %-4d ID: %-4d %s",
                                                    getName(), getAge(),getId(),subjectsFormattet);
        return formatedString;
    }

    //constructors bellow
    public Teacher(String name, int age, int id, String[] subjects){
        this(name,age,id);
        this.subjects = subjects;
    }

    public Teacher(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    //getters and setters below
    public void setName(String newName){
        this.name = newName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int newID){
        this.id = newID;
    }

    public void setSubjects(String[] newSubjects){
        this.subjects = newSubjects;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getId() {
        return id;
    }

    public String[] getSubjects(){
        return subjects;
    }
}


