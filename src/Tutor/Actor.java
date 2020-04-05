package Tutor;

public class Actor {
    private int id;
    private String fio;
    private int age;

    public Actor(int id, String fio, int age) {
        this.id = id;
        this.fio = fio;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }
}
