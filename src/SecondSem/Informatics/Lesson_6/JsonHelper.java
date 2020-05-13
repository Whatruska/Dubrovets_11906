package SecondSem.Informatics.Lesson_6;

import SecondSem.Informatics.Lesson_6.JSON.JsonEntity;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class JsonHelper {
    public static JsonEntity[] parseJsonFile(File file) throws IOException {
        long entitiesCount = Files.lines(file.toPath()).count();
        JsonEntity[] entities = new JsonEntity[(int)entitiesCount];
        int freeIndex = 0;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();

        while (line != null){
            String formatedString = line.substring(line.indexOf("{") + 1, line.lastIndexOf("}") - 1);
            StringTokenizer tokenizer = new StringTokenizer(formatedString);
            JsonEntity entity = new JsonEntity();
            while (tokenizer.hasMoreTokens()){
                String pair = tokenizer.nextToken(";").trim();
                String formatedPair = pair.replaceAll("[\"\\;]","");
                int index = formatedPair.indexOf(':');
                String field = formatedPair.substring(0, index);
                String value = formatedPair.substring(index + 1);
                entity.addProperty(field, value);
            }
            entities[freeIndex++] = entity;
            line = reader.readLine();
        }
        return entities;
    }

    public static void writeEntitiesToFile(File file, List<JsonEntity> entities){
        try {
            PrintWriter writer = new PrintWriter(file);
            int entityCount = 0;
            for (JsonEntity entity : entities){
                writer.append("{");
                TreeMap<String, String> props = entity.getProperties();
                int propsCount = 0;
                for (String prop : props.keySet()){
                    writer.append(prop + ":\"" + props.get(prop) + "\"");
                    if (propsCount < props.size() - 1){
                        writer.append("; ");
                    }
                    propsCount++;
                }
                writer.append("}");
                if (entityCount < entities.size() - 1){
                    writer.append(",\n");
                }
                entityCount++;
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
