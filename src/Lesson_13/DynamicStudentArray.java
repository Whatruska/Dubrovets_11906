package Lesson_13;

public class DynamicStudentArray {
    private Student[] arr;
    private int freeIndex;

    public DynamicStudentArray(int length) {
        this.arr = new Student[length];
        freeIndex = 0;
    }

    public void addNewStudent(Student student){
        if (freeIndex == arr.length){
            increaseCapacity(1);
        }
        arr[freeIndex] = student;
        freeIndex++;
    }

    public void removeStudentBySurname(String surname){
        int index = indexOfStudBySurname(surname);
        if (index != -1){
            arr[index] = null;
        }
        for (int i = index + 1; i < arr.length; i++){
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = null;
        freeIndex--;
    }

    public Student getStudentBySurname(String surname) {
        int index = indexOfStudBySurname(surname);
        if (isValidIndex(index)){
            return arr[index];
        }
        return new Student();
    }

    public Student getStudent(int index){
        if (isValidIndex(index)){
            return arr[index];
        }
        return new Student();
    }

    public int size(){
        return arr.length;
    }

    public void setStudent(int index, Student student){
        if (isValidIndex(index)){
            arr[index] = student;
        }
    }

    public void setStudent(String surname, Student student){
        int index = indexOfStudBySurname(surname);
        setStudent(index, student);
    }

    public void setStudent(Student student){
        setStudent(student.getSurname(), student);
    }

    private boolean isValidIndex(int index){
        return index < arr.length && index > -1;
    }

    private int indexOfStudBySurname(String surname){
        int index = -1;
        for (int i = 0; i < arr.length; i++){
            Student student = arr[i];
            if (student.getSurname().equals(surname)){
                return i;
            }
        }
        return index;
    }

    private void increaseCapacity(int inc){
        Student[] newArr = new Student[arr.length + inc];
        for (int i = 0; i < freeIndex; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
