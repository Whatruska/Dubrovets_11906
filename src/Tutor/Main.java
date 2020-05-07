package Tutor;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        (new MyThread()).start();
        (new MyThread()).start();
        (new MyThread()).start();
        (new MyThread()).start();
    }
}
