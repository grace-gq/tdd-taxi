package com.jiker.keju;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadFileTest {
    @Test
    public void should_has_data() {
        ReadFile readFile = new ReadFile("testData.txt");
        BufferedReader bufferedReader = readFile.readDataFile();
        assertThat(bufferedReader == null).isEqualTo(false);
    }

    @Test
    public void should_has_no_data() {
        ReadFile readFile = new ReadFile("test.txt");
        BufferedReader bufferedReader = readFile.readDataFile();
        assertThat(bufferedReader == null).isEqualTo(true);
    }

    @Test
    public void should_read_lines() {
        ReadFile readFile = new ReadFile("testData.txt");
        List<String> lines = readFile.getFileContent(readFile.readDataFile());
        assertThat(lines.isEmpty()).isEqualTo(false);
    }
}
