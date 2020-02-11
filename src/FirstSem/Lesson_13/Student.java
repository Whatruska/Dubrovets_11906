package FirstSem.Lesson_13;

public class Student extends User {

    private Marks marks;

    public Student(String surname, String name, String patronym, String password, String login) {
        super(surname, name, patronym, password, login);
        this.marks = new Marks(0,0,0);
    }

    public Student(String surname, String name, String patronym, String password, String login, Marks marks) {
        this(surname, name, patronym, password, login);
        this.marks = marks;
    }

    public Student() {
    }

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + patronym + "\nMarks :\n" + marks.toString();
    }
}
