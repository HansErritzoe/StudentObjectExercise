public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private double height;
    private boolean isMale;
    private String address;

    //default constructor
    public Student(){
        this("Jane","Doe",18,1.75,false);
    }
    //constructor without address
    public Student(String firstName, String lastName, int age, double height, boolean isMale){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.isMale = isMale;
    }
    //new constructor with address
    public Student(String firstName, String lastName, int age, double height, boolean isMale, String address){
        this(firstName,lastName,age,height,isMale);
        this.address = address;
    }

    public String toString(){
        return ""+firstName + " " + lastName + " " + age + "yo " +height+"m " + "Gender male = " + isMale + ". Address: " + address;
    }

    public void setAddress(String address){
        this.address = address;
    }
}
