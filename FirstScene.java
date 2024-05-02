import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

public class FirstScene extends Application{
    String[] corses = new String[1000];
    public void start(Stage primaryStage){
        ArrayList<String> AllwoableCourses = new ArrayList<>();
        ArrayList<String> FinshCor = new ArrayList<>();
        Course[] courseArr= new Course[11];
        courseArr[0] = new Course("Math201","Math102","");
        courseArr[1] = new Course("Math208","Math102","");
        courseArr[2] = new Course("ISE291","Math102,ICS104","");
        courseArr[3] = new Course("SWE206 ","ICS108","");
        courseArr[4] = new Course("ICS202","ICS108","");
        courseArr[5] = new Course("CHEM101","","");
        courseArr[6] = new Course("COE292","ISE291","");
        courseArr[7] = new Course("SWE216","SWE206 ","");
        courseArr[8] = new Course("ICS253","ICS104","");
        courseArr[9] = new Course("COE233","ICS108","");
        courseArr[10] = new Course("IAS212","","");
        File FinshedCor = new File("C:\\Users\\mhaah\\Desktop\\semester 221\\ICS-108\\Project 221\\JavaFx Project\\src\\New CourseOffering.csv");
        try{
        File corseOffering = new File("C:\\Users\\mhaah\\Desktop\\semester 221\\ICS-108\\Project 221\\JavaFx Project\\src\\New CourseOffering.csv");
        Scanner corseOfferingScanner = new Scanner(corseOffering);
        corseOfferingScanner.useDelimiter(", | \n");
        Scanner finsCorScanner = new Scanner(FinshedCor);
        finsCorScanner.useDelimiter(",|\n");
        for(int i = 0; finsCorScanner.hasNext();i++){
            if(i % 3 == 0){
                FinshCor.add(finsCorScanner.next());
            }
            else{
                String Unwanted = finsCorScanner.next();
            }
        }
        // creat course offreing corsses array list
        int k = 0;
        while(corseOfferingScanner.hasNext()){
            corses[k] = corseOfferingScanner.next();
            k++;
        }

        } // end of try block
        catch(FileNotFoundException ex){
            System.out.println(ex);
        }
        for(int k =0; k<courseArr.length;k++){
            if((courseArr[k].getPrerequisitecourses()).contains(",")){
               int indcomma = (courseArr[k].getPrerequisitecourses()).indexOf(",");
               String preReq1 =  (courseArr[k].getPrerequisitecourses()).substring(0,indcomma);
               String preReq2 =  (courseArr[k].getPrerequisitecourses()).substring(indcomma+1,(courseArr[k].getPrerequisitecourses()).length());
               if(FinshCor.contains(preReq1) && FinshCor.contains(preReq2)){
                    AllwoableCourses.add(courseArr[k].getCourseName());
                }
            }
            else if(FinshCor.contains(courseArr[k].getPrerequisitecourses())){
                    AllwoableCourses.add(courseArr[k].getCourseName());
                }
            else if(courseArr[k].getPrerequisitecourses() == "")
            {
                AllwoableCourses.add(courseArr[k].getCourseName());

            }         
        }

        System.out.println(Arrays.toString(corses));
        System.out.println(corses[0]);

     }
    // public static void creatCorsesArray(ArrayList<String> corArray){
    //     File corrseOfrring = new File("C:\\Users\\faris\\Desktop\\CourseOffering.csv");
    //     try{
    //         Scanner CorseOfferingScanner = new Scanner(corrseOfrring);
    //         CorseOfferingScanner.useDelimiter(", | \n");
    //         String UnuseLine = CorseOfferingScanner.nextLine();
    //         for(int i =0; CorseOfferingScanner.hasNext();i++){
    //             corArray.add(CorseOfferingScanner.next());
    //         }

    //     }
    //     catch(FileNotFoundException ex){
    //         System.out.println(ex);
    //     }
     

    // }
    public static void main(String[] args) {
        launch();
    }
}
