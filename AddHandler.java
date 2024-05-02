import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AddHandler  extends Scene1 implements EventHandler<ActionEvent>{
    // for count the sourse event
    int count = 0;
    public void handle(ActionEvent ev){
        for(int i = 0 ; i < Scene1.buttArr.size(); i = i +2){
             if(ev.getSource() == Scene1.buttArr.get(i)){
                Scene1.secArr.add(new Section(Scene1.gridpaneCourses.get(count * 10),Scene1.gridpaneCourses.get((count * 10)+6),Scene1.gridpaneCourses.get((count * 10)+7)));            
                count++;
                System.out.println("Hello");
                }
            else{
                count++;
            }
           
            
        }
    }
 
}
