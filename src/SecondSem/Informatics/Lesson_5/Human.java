package SecondSem.Informatics.Lesson_5;

public class Human {
    private String fullName;
    private String group;

    public Human(String fullName, String group) {
        this.fullName = fullName;
        this.group = group;
    }

    public Human(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
