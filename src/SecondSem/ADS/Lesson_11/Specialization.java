package SecondSem.ADS.Lesson_11;
import java.util.StringTokenizer;

public class Specialization {
    private final String specialization;
    private final int id;

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
