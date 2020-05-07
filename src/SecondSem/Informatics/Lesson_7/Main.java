package SecondSem.Informatics.Lesson_7;

import SecondSem.ADS.Lesson_11.Doctor;
import SecondSem.ADS.Lesson_11.Room;
import SecondSem.ADS.Lesson_11.Specialization;
import SecondSem.ADS.Lesson_11.Timetable;
import SecondSem.Informatics.Lesson_6.Framework;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Doctor> doctors = Framework.getInstances(Doctor.class).stream().map((obj) -> (Doctor) obj).collect(Collectors.toList());
        List<Room> rooms = Framework.getInstances(Room.class).stream().map((obj) -> (Room) obj).collect(Collectors.toList());
        List<Specialization> specs = Framework.getInstances(Specialization.class).stream().map((obj) -> (Specialization) obj).collect(Collectors.toList());
        List<Timetable> timetable = Framework.getInstances(Timetable.class).stream().map((obj) -> (Timetable) obj).collect(Collectors.toList());

        List<Room> usedRooms = timetable.stream().map(timetable1 -> {
            int roomId = timetable1.getRoomId();
            return rooms.stream().filter(r -> r.getId() == roomId).distinct().findFirst().orElse(null);
        }).distinct().collect(Collectors.toList());

        usedRooms.forEach(System.out::println);
    }
}
