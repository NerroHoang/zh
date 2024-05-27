package model;

public class SeniorCareer extends Player {

    private String teamName;
    private int joinedDate;
    private int leftDate;

    public SeniorCareer() {

    }

    public SeniorCareer(String teamName, int joinedDate, int leftDate) {
        this.teamName = teamName;
        this.joinedDate = joinedDate;
        this.leftDate = leftDate;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(int joinedDate) {
        this.joinedDate = joinedDate;
    }

    public int getLeftDate() {
        return leftDate;
    }

    public void setLeftDate(int leftDate) {
        this.leftDate = leftDate;
    }

    @Override
    public String toString() {
        return "SeniorCareer{" + "teamName=" + teamName + ", joinedDate=" + joinedDate + ", leftDate=" + leftDate + '}';
    }

    
    
    
}