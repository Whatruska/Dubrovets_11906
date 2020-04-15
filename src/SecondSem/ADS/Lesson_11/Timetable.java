package SecondSem.ADS.Lesson_11;

import java.util.StringTokenizer;

public class Timetable {
    private final String time;
    private final int doctorId;
    private final int roomId;

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
