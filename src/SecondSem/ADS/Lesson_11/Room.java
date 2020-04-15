package SecondSem.ADS.Lesson_11;

import java.util.StringTokenizer;

public class Room {
    private final String name;
    private final int id;

    public Room(String roomLine){
        StringTokenizer st = new StringTokenizer(roomLine);
        this.name = st.nextToken();
        this.id = Integer.parseInt(st.nextToken());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
