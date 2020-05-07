package SecondSem.Informatics.Lesson_6;

import SecondSem.Informatics.Lesson_6.JSON.JsonEntity;

import java.io.*;
import java.nio.file.Files;
import java.util.StringTokenizer;

public class JsonParser {
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
}
