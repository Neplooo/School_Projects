public class HomeschoolStudent extends Student {

    private int hoursStudied;
    private int hoursPerDay;
    private int daysStudied;

    public HomeschoolStudent(int studyHours){
        hoursPerDay = studyHours;
    }

    public int getHoursStudied(){
        return hoursStudied;
    }

    public void setStudyHours(int hours){
        hoursPerDay = hours;
    }

    public void studyDay(){
        hoursStudied += hoursPerDay;
        daysStudied++;
    }


    
}
