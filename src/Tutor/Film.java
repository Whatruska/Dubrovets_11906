package Tutor;

public class Film {
    private String title;
    private int id;
    private int year;
    private int producerId;

    public Film(String title, int year, int producerId, int id) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.producerId = producerId;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getProducerId() {
        return producerId;
    }

    public int getId() {
        return id;
    }
}
