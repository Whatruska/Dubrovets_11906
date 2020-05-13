package SecondSem.Informatics.Lesson_7;

import SecondSem.ADS.Lesson_11.Doctor;
import SecondSem.ADS.Lesson_11.Room;
import SecondSem.ADS.Lesson_11.Specialization;
import SecondSem.ADS.Lesson_11.Timetable;
import SecondSem.Informatics.Lesson_6.Framework;

import java.util.Collections;
import java.util.Comparator;
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

        Doctor bestDoctorInEntireUniverse =  doctors.stream().map(doctor -> {
            int id = doctor.getId();
            timetable.forEach(timetable1 -> {
                if (timetable1.getDoctorId() == id){
                    doctor.incPeople();
                }
            });
            return doctor;
        }).max(Comparator.comparingInt(Doctor::getPeople)).orElse(null);

        specs.forEach(specialization -> {
            if (specialization.getId() == bestDoctorInEntireUniverse.getSpecializationId()){
                System.out.println(bestDoctorInEntireUniverse.getShortName() + " " + specialization.getSpecialization());
            }
        });

        Room mostLoadedRoom = rooms.stream().max((room1,room2) -> {
            int count1 = (int) timetable.stream().filter(timetable1 -> timetable1.getRoomId() == room1.getId()).count();
            int count2 = (int) timetable.stream().filter(timetable1 -> timetable1.getRoomId() == room2.getId()).count();
            return count1 - count2;
        }).orElse(null);

        List<Doctor> docs = timetable.stream().filter(timetable1 -> timetable1.getRoomId() == mostLoadedRoom.getId()).map(timetable1 -> doctors.stream().filter(doctor -> doctor.getId() == timetable1.getDoctorId()).findFirst().orElse(null)).distinct().collect(Collectors.toList());
        docs.forEach(doctor -> {
            System.out.println(doctor.getFullName());
        });
    }
}
