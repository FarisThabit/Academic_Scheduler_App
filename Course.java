import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Course {
    
    String Course;
    String Prerequisitecourses;
    String Corequisitecourses;
    public Course(){}
    public Course(String Course,String Prerequisitecourses, String Corequisitecourses){
        this.Course = Course;
        this.Prerequisitecourses = Prerequisitecourses;
        this.Corequisitecourses = Corequisitecourses;
    }
    public  String getPrerequisitecourses(){
        return Prerequisitecourses;
    }
    public String getCourseName(){
        return Course;
    }
   
    
}
