package com.jiker.keju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadFile {
    private String fileName;
    public ReadFile (String fileName) {
        this.fileName = fileName;
    }

    public BufferedReader readDataFile() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
            return new BufferedReader(inputStreamReader);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getFileContent(BufferedReader bufferedReader) {
        String line; List<String> lines = new ArrayList<>();
        try {
            while ((line = Objects.requireNonNull(bufferedReader).readLine()) != null) {
                lines.add(line);
            }
        }
        catch (IOException e) { e.printStackTrace(); }
        return lines;
    }
}
