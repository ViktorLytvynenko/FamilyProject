package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LoggerService {

    public static void writeDataLogs(String message) {
        String filePath = "src/main/java/org/example/Data/application.log";
        String text = message + "\n";
        Path path = Paths.get(filePath);

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static String getFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(formatter);
    }

    public static void info(String message) {
        String info = getFormattedDateTime() + " [DEBUG] " + message;
        System.out.println(info);
        writeDataLogs(info);
    }

    public static void error(String message) {
        String info = getFormattedDateTime() + " [ERROR] " + message;
        System.out.println(info);
        writeDataLogs(info);
    }
}
