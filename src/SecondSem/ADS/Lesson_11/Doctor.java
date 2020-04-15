package SecondSem.ADS.Lesson_11;

import java.util.StringTokenizer;

public class Doctor {

    private final int id;
    private final String fullName;
    private final String shortName;
    private final int specializationId;
    private int people = 0;

    public Doctor(String doctorLine){
        StringTokenizer st = new StringTokenizer(doctorLine);
        this.id = Integer.parseInt(st.nextToken());
        String surname = st.nextToken();
        String name = st.nextToken();
        String patronymic = st.nextToken();
        this.fullName = String.join(" ", surname, name, patronymic);
        this.shortName = surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
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
        return shortName;
    }

}
