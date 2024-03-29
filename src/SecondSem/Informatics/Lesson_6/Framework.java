package SecondSem.Informatics.Lesson_6;

import SecondSem.Informatics.Lesson_6.JSON.JsonEntity;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Framework {
    private static final String PATH_TO_DIRECTORY = "src/SecondSem/Informatics/Lesson_6/JSON/";
    public static List<Object> getInstances(Class c) {
        ArrayList<Object> result = new ArrayList<>();
        StoreInFile annotation = (StoreInFile) c.getAnnotation(StoreInFile.class);
        File file = new File(PATH_TO_DIRECTORY + annotation.name());
        boolean allFields = annotation.allFields();
        try {
            JsonEntity[] entities = JsonHelper.parseJsonFile(file);
            for (JsonEntity entity : entities){
                entity = editProperties(allFields, c, entity);
                TreeMap<String, String> properties = entity.getProperties();

                Object instance = c.getDeclaredConstructor().newInstance();
                for (String property : properties.keySet()){
                    Field field = c.getDeclaredField(property);
                    field.setAccessible(true);
                    if (field.getType() == String.class){
                        field.set(instance, properties.get(property));
                    } else if (field.getType() == int.class){
                        field.set(instance, Integer.parseInt(properties.get(property)));
                    }
                    field.setAccessible(false);
                }
                result.add(instance);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static JsonEntity editProperties(boolean allFields, Class c, JsonEntity entity){
        TreeMap<String, String> properties = entity.getProperties();
        if (!allFields) {
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields){
                OverrideFieldName override = field.getAnnotation(OverrideFieldName.class);
                if (override != null){
                    String jsonName = override.fieldname();
                    String value = properties.get(jsonName);
                    String trueName = field.getName();

                    properties.remove(jsonName);
                    properties.put(trueName, value);
                }
            }
        }
        return entity;
    }

    public static List<Object> getByField(Class c, Field field, String value){
        field.setAccessible(true);
        return getInstances(c).stream().filter(o -> {
            try {
                return field.get(o).toString().equals(value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());
    }

    public static void saveList(List<Object> list) {
        Class c = list.get(0).getClass();
        StoreInFile annotation = (StoreInFile) c.getAnnotation(StoreInFile.class);
        String fileName = PATH_TO_DIRECTORY + annotation.name();
        boolean allFields = annotation.allFields();
        File file = new File(fileName);
        List<JsonEntity> entities = new LinkedList<>();
        for (Object obj : list){
            JsonEntity entity = new JsonEntity();
            for (Field field : c.getDeclaredFields()){
                OverrideFieldName override = field.getAnnotation(OverrideFieldName.class);
                field.setAccessible(true);
                try {
                    String value = field.get(obj).toString();
                    String key = field.getName();
                    if (!allFields && override != null){
                        key = override.fieldname();
                    }
                    entity.addProperty(key,value);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        JsonHelper.writeEntitiesToFile(file, entities);
    }
}
