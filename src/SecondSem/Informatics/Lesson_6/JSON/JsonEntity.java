package SecondSem.Informatics.Lesson_6.JSON;

import java.util.TreeMap;

public class JsonEntity {
    private TreeMap<String, String> fieldMap = new TreeMap<>();

    public JsonEntity() {}

    public void addProperty(String field, String value){
        fieldMap.put(field, value);
    }

    public TreeMap<String, String> getProperties() {
        return fieldMap;
    }
}
