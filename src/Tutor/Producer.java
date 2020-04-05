package Tutor;

public class Producer {
    private int id;
    private String fio;

    public Producer(int id, String fio) {
        this.id = id;
        this.fio = fio;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }
}
