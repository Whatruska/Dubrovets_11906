package SecondSem.ADS.Lesson_11;

import SecondSem.Informatics.Lesson_6.StoreInFile;

import java.util.StringTokenizer;

@StoreInFile(name = "timetables.txt")
public class Timetable {
    private String time;
    private int doctorId;
    private int roomId;

    public Timetable() {
    }

    public Timetable(String timetableLine){
        StringTokenizer st = new StringTokenizer(timetableLine);
        this.time = st.nextToken();
        this.doctorId = Integer.parseInt(st.nextToken());
        this.roomId = Integer.parseInt(st.nextToken());
    }

    public String getTime() {
        return time;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public int getRoomId() {
        return roomId;
    }
}
