package SecondSem.Informatics.Lesson_6;

@StoreInFile(name = "TestClass.txt", allFields = false)
public class TestClass {
    private String name;

    @OverrideFieldName(fieldname = "familia")
    private String surname;

    @OverrideFieldName(fieldname = "otchestvo")
    private String patronim;

    private int age;
    private String gender;

    public TestClass(String name, String surname, String patronim, int age, String gender) {
        this.name = name;
        this.surname = surname;
        this.patronim = patronim;
        this.age = age;
        this.gender = gender;
    }

    public TestClass() {}

    public void out(){
        System.out.println("F");
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestClass{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", patronim='").append(patronim).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gender='").append(gender).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
