public class Section {
    private String course;
    private String time;
    private String location;
    public Section(){}
    public Section(String course, String time, String location){
        this.course = course;
        this.time = time;
        this.location = location;
    }
    public String toString(){
        return course +" " + time +" " + location;
    }
    public static void main(String[] args) {
        System.out.println(Scene1.secArr);
    }

}
