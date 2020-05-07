package SecondSem.ADS.Lesson_11;

import SecondSem.Informatics.Lesson_6.StoreInFile;

import java.util.StringTokenizer;

@StoreInFile(name = "doctors.txt", allFields = true)
public class Doctor {

    private int id;
    private String fullName;
    private int specializationId;
    private int people = 0;

    public Doctor() {
    }

    public Doctor(String doctorLine){
        StringTokenizer st = new StringTokenizer(doctorLine);
        this.id = Integer.parseInt(st.nextToken());
        String surname = st.nextToken();
        String name = st.nextToken();
        String patronymic = st.nextToken();
        this.fullName = String.join(" ", surname, name, patronymic);
        this.specializationId = Integer.parseInt(st.nextToken());
    }

    public int getPeople() {
        return people;
    }

    public void incPeople(){
        people++;
    }

    public int getId() {
        return id;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        StringTokenizer token = new StringTokenizer(fullName);
        String result = "";
        result += token.nextToken() + " ";
        result += token.nextToken().charAt(0) + ".";
        result += token.nextToken().charAt(0) + ".";
        return result;
    }

}
