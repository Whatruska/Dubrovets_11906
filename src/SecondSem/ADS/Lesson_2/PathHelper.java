package SecondSem.ADS.Lesson_2;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class PathHelper {
    public static URI getPathTo(String str) throws URISyntaxException {
        return Paths.get(Task_1.class.getResource(str).toURI()).toUri();
    }
}
