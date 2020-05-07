package SecondSem.ADS.Lesson_11;
import SecondSem.Informatics.Lesson_6.StoreInFile;

import java.util.StringTokenizer;

@StoreInFile(name = "specializations.txt")
public class Specialization {
    private String specialization;
    private int id;

    public Specialization() {
    }

    public int getId() {
        return id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Specialization(String specializationLine){
        StringTokenizer st = new StringTokenizer(specializationLine);
        this.specialization=st.nextToken();
        this.id = Integer.parseInt(st.nextToken());
    }
}
