package SecondSem.ADS.Lesson_11;

import SecondSem.Informatics.Lesson_6.StoreInFile;

import java.util.StringTokenizer;

@StoreInFile(name = "rooms.txt")
public class Room {
    private String name;
    private int id;

    public Room() {
    }

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
