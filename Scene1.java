import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Scene1 extends Application{
    // Courses in course offering ArrayList
    ArrayList<String> CorseOffCourses = new ArrayList<>();
    // Courses that will appear in the gride pane ArrayList
    static ArrayList<String> gridpaneCourses = new ArrayList<>();
    // define the gride pane
    GridPane gp= new GridPane();
    // Text courses holder
    Text tx = new Text();
    //Scene 1 defenition
    Scene sc1;
    // Creat an ArrayList of Buttons & Hboxes
   static ArrayList<Button> buttArr = new ArrayList<>();
    ArrayList<HBox> hBoxArr = new ArrayList<>();
    // Creat the Scrool Pane
    ScrollPane sp = new ScrollPane();
    // Scene 1 title defenition
    Text title = new Text("Add courses to the Basket");
    // Array list of section to store the added courses 
        static ArrayList<Section> secArr = new ArrayList<>();
    // Array list of section to store the added courses 
    static ArrayList<Section> remsecArr = new ArrayList<>();
    // next button
    Button next = new Button("next");

    public void start(Stage primaryStage){
        try{
            File courseOff = new File("C:\\Users\\mhaah\\Desktop\\semester 221\\ICS-108\\Project 221\\JavaFx Project\\src\\New CourseOffering.csv");
            Scanner courseOffScanner = new Scanner(courseOff);
            courseOffScanner.useDelimiter(",|\n");
            String UnwantedLine = courseOffScanner.nextLine();
            while(courseOffScanner.hasNext()){
                CorseOffCourses.add(courseOffScanner.next());
            }
        }
        catch(FileNotFoundException ex){
            System.out.print(ex);
        
        }
        // Courses that students can register in 
        ArrayList<String> AllwoableCourses = new ArrayList<>();
        ArrayList<String> FinshCor = new ArrayList<>();
        Course[] courseArr= new Course[11];
        courseArr[0] = new Course("MATH201","Math102","");
        courseArr[1] = new Course("MATH208","Math102","");
        courseArr[2] = new Course("ISE291","Math102,ICS104","");
        courseArr[3] = new Course("SWE206 ","ICS108","");
        courseArr[4] = new Course("ICS202","ICS108","");
        courseArr[5] = new Course("CHEM101","","");
        courseArr[6] = new Course("COE292","ISE291","");
        courseArr[7] = new Course("SWE216","SWE206 ","");
        courseArr[8] = new Course("ICS253","ICS104","");
        courseArr[9] = new Course("COE233","ICS108","");
        courseArr[10] = new Course("IAS212","","");
        File FinshedCor = new File("C:\\Users\\mhaah\\Desktop\\semester 221\\ICS-108\\Project 221\\JavaFx Project\\src\\FinishedCourses.csv");
        try{
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
        }
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
      // find the courses that appear in the gride pane
      for(int i = 0; i<CorseOffCourses.size();i++){
            if(i % 10 ==0){
                String tempCourse = CorseOffCourses.get(i);
                int dashPos = tempCourse.indexOf("-");
                String course = tempCourse.substring(0, dashPos);
                if(AllwoableCourses.contains(course)){
                    gridpaneCourses.add(tempCourse);
                    gridpaneCourses.add(CorseOffCourses.get(i+1));
                    gridpaneCourses.add(CorseOffCourses.get(i+2));
                    gridpaneCourses.add(CorseOffCourses.get(i+3));
                    gridpaneCourses.add(CorseOffCourses.get(i+4));
                    gridpaneCourses.add(CorseOffCourses.get(i+5));
                    gridpaneCourses.add(CorseOffCourses.get(i+6));
                    gridpaneCourses.add(CorseOffCourses.get(i+7));
                    gridpaneCourses.add(CorseOffCourses.get(i+8));
                    gridpaneCourses.add(CorseOffCourses.get(i+9));
                ;

                }        
            }
           
      }
      // implemnt the scene and the grid
      gp.setHgap(30);
      gp.setVgap(0);
       for(int i = 0, j = 2, k = 0;i< gridpaneCourses.size(); i++){ //k represents coulmn & j represents rows                                    
             if(i % 10 != 0 || i == 0){                                           
                gp.add(new Text(gridpaneCourses.get(i)),k,j);
               k++; 
                
                
            }
        
            else{
                j = j + 1;
                k= 0;
               gp.add(new Text(gridpaneCourses.get(i)),k,j);
               k++;}}
               addButton();
                gp.add(title,4,0);
                gp.add(next,11,(gridpaneCourses.size()/10)+2);
               sp.setContent(gp);
               sc1 = new Scene(sp);
               primaryStage.setScene(sc1);
               primaryStage.show();


    }
    public void addButton(){
        // for filling the buttons Array with buttons
         for(int i = 0 ; i < ((gridpaneCourses.size()/10)*2);i++){
             if(i % 2 == 0){
                 buttArr.add(new Button("Add"));
                AddHandler handler = new AddHandler();
                 buttArr.get(i).setOnAction(handler);
             }
               else{
                 buttArr.add(new Button("Remove"));
                //  RemButtHandler handler = new RemButtHandler();
                //  buttArr[i].setOnAction(handler);
             }
        }
        // For filling the Hbox array with Hbox boxes
         for(int i = 0; i < (gridpaneCourses.size()/10); i++){
             hBoxArr.add(new HBox());
         }
         // for filling the Hbox boxes with buttons
         for(int i = 0, j = 0; i<hBoxArr.size();i++){
            HBox tembHbox = new HBox();
            tembHbox.getChildren().addAll( buttArr.get(j),buttArr.get(j+1));
            // hbArr[i].getChildren().addAll(buttArr[j],buttArr[j+1]);
            hBoxArr.set(i,tembHbox);
             j = j + 2; 
         }
    // distribute the boxes buttons to their correct positions
        for(int i = 0, j= 2,k = 11; i < hBoxArr.size(); i++,j++){
            gp.add(hBoxArr.get(i),k,j);
         }
    }
    public static void main(String[] args) {
        launch();
    }
}
