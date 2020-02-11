package FirstSem.Tutor;

public class Student {
    protected String name;

    private static final String BATTLE_CRY = "ARSLANOV ONE LOVE";

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    //Меняем логику родителя - переопределение
    @Override
    public String toString() {
        return "Name : " + name;
    }

    //Создаем похожий по логике метод, но с другими параметрами - перегрузка
    public String toString(String something){
        return "Name : " + something;
    }

    public String toString(int num){
        return "Num : " + num;
    }
}
