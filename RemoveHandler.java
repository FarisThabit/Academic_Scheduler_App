import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RemoveHandler extends Scene1 implements EventHandler<ActionEvent>{
    int count = 0;
    public void handle(ActionEvent ev){
        for(int i = 1 ; i < Scene1.buttArr.size(); i = i + 1){
             if(ev.getSource() == Scene1.buttArr.get(i)){
                Scene1.remsecArr.add(new Section(Scene1.gridpaneCourses.get(count * 10),Scene1.gridpaneCourses.get((count * 10)+6),Scene1.gridpaneCourses.get((count * 10)+7)));            
                count++;
                }
            else{
                count++;
            }
           
            
        }
    }
}