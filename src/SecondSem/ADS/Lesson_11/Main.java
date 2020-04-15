package SecondSem.ADS.Lesson_11;

import java.io.*;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String strPath = "src/SecondSem/ADS/Lesson_11/";

    private static LinkedList<Timetable> timetables = new LinkedList<>();
    private static LinkedList<Room> rooms = new LinkedList<>();
    private static LinkedList<Doctor> doctors = new LinkedList<>();
    private static LinkedList<Specialization> specializations = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        PrintWriter first = getWriterByFileName("first");
        PrintWriter second = getWriterByFileName("second");
        timetables.forEach(timetable -> {
            first.append("Время : " + timetable.getTime() + "\n");
            int roomId = timetable.getRoomId();
            rooms.stream().filter(room -> room.getId() == roomId).forEach(room -> {
                first.append("Кабинет : " + room.getName() + "\n");
            });
            int doctorId = timetable.getDoctorId();
            doctors.stream().filter(doctor -> doctor.getId() == doctorId).forEach(doctor -> {
                doctor.incPeople();
                int specId = doctor.getSpecializationId();
                first.append("Доктор : " + doctor.getFullName() + "\n");
                specializations.stream().filter(specialization -> specialization.getId() == specId).forEach(specialization -> {
                    first.append("Специализация врача : " + specialization.getSpecialization() + "\n");
                });
            });
            first.append("==================\n");
        });

        List<Doctor> sorted = doctors.stream().sorted(Comparator.comparingInt(Doctor::getPeople)).collect(Collectors.toList());
        Doctor bestDoctor = sorted.get(sorted.size() - 1);
        Specialization specialization = specializations.stream().filter(spec -> spec.getId() == bestDoctor.getSpecializationId()).collect(Collectors.toList()).get(0);
        second.append(bestDoctor.getShortName() + " " + specialization.getSpecialization());

        first.close();
        second.close();
    }

    public static BufferedReader getReaderByFileName(String filename){
        try {
            return new BufferedReader(new FileReader(Paths.get(strPath + "Texts/" + filename + ".txt").toFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void input() throws IOException {
        BufferedReader timetable = getReaderByFileName("timetables");
        BufferedReader room = getReaderByFileName("rooms");
        BufferedReader doctor = getReaderByFileName("doctors");
        BufferedReader specialization = getReaderByFileName("specializations");

        timetables = new LinkedList<>();
        rooms = new LinkedList<>();
        doctors = new LinkedList<>();
        specializations = new LinkedList<>();

        String timetableLine = timetable.readLine();
        String roomLine = room.readLine();
        String doctorLine = doctor.readLine();
        String specializationLine = specialization.readLine();

        while(timetableLine!=null){
            timetables.add(new Timetable(timetableLine));
            timetableLine = timetable.readLine();
        }

        while (roomLine!=null){
            rooms.add(new Room(roomLine));
            roomLine = room.readLine();
        }

        while (doctorLine!=null){
            doctors.add(new Doctor(doctorLine));
            doctorLine = doctor.readLine();
        }

        while (specializationLine!=null){
            specializations.add(new Specialization(specializationLine));
            specializationLine = specialization.readLine();
        }

        timetable.close();
        doctor.close();
        specialization.close();
        room.close();
    }

    public static PrintWriter getWriterByFileName(String filename){
        try {
            return new PrintWriter(new FileWriter(Paths.get(strPath + "Outputs/" + filename + ".txt").toFile()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
