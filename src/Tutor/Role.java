package Tutor;

public class Role {
    private int filmId;
    private int actorId;
    private String person;

    public Role(int filmId, int actorId, String person) {
        this.filmId = filmId;
        this.actorId = actorId;
        this.person = person;
    }

    public int getFilmId() {
        return filmId;
    }

    public int getActorId() {
        return actorId;
    }

    public String getPerson() {
        return person;
    }
}
