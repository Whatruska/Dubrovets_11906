package Tutor;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Semestrovke {
    public static LinkedList<Film> filmsList = new LinkedList<>();
    public static LinkedList<Actor> actorsList = new LinkedList<>();
    public static LinkedList<Producer> producersList = new LinkedList<>();
    public static LinkedList<Role> rolesList = new LinkedList<>();

    public static LinkedList<Film> getFilmsByProducerAndYear(Producer p, int year){
//        int producerId = p.getId();
//        LinkedList<Film> result = new LinkedList<>();
//        for (Film film : filmsList){
//            int prodId = film.getProducerId();
//            if (prodId == producerId && film.getYear() <= year){
//                result.add(film);
//            }
//        }
//        return result;

        return (LinkedList<Film>)filmsList.stream().filter(film -> film.getProducerId() == p.getId() && film.getYear() <= year).collect(Collectors.toList());
    }

    public static void printPairs(){
        for (Producer producer : producersList){
            int producerId = producer.getId();
            for (Actor actor : actorsList){
                int actorId = actor.getId();
                System.out.println(producer + " " + actor);
                for (Role role : rolesList){
                    int filmId = role.getFilmId();
                    if (role.getActorId() == actorId){
                        for (Film film : filmsList){
                            if (film.getId() == filmId && film.getProducerId() == producerId){
                                System.out.println(film.getTitle());
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static LinkedList<Actor> getActors(int year){
        LinkedList<Actor> result = new LinkedList<>();
        skip : for (Actor actor : actorsList){
            int prodId = -1;
            int actorId = actor.getId();
            for (Role role : rolesList){
                if (role.getActorId() == actorId){
                    int filmId = role.getFilmId();
                    for (Film film : filmsList){
                        if (film.getId() == filmId && film.getYear() >= year){
                            if (prodId == -1){
                                prodId = film.getProducerId();
                            } else if (prodId != film.getProducerId()){
                                continue skip;
                            }
                        }
                    }
                }
            }
            result.add(actor);
        }
        return result;
    }
}
