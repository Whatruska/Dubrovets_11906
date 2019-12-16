package Lesson_12;

import java.util.Date;
import java.util.GregorianCalendar;

public class Student {
    private String fio;
    private boolean isMale;
    private Date birthdate;
    private String degree;
    private int rating;

    public Student(String fio, boolean isMale, Date birthdate, String degree, int rating) {
        this.fio = fio;
        this.isMale = isMale;
        this.birthdate = birthdate;
        this.degree = degree;
        this.rating = rating;
    }

    public Student(){
        this("Олежа" , true, GregorianCalendar.getInstance().getTime(), "Среднее" , (int)(Math.random() * 100) + 30);
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "FIO : " + fio + "\n" + (isMale ? "Мужчина" : "Женщина") + "\nBirthdate : " + birthdate + "\nDegree : " + degree + "\nRating : " + rating;
    }

    public static void main(String[] args) {
        Student olega = new Student();
        System.out.println(olega.toString());
    }
}
