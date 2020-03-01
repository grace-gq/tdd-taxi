package com.jiker.keju;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {
    @Test
    public void should_get_params() {
        Calculate calculate = new Calculate();
        int[] params = calculate.getParam("1公里,等待0分钟");
        assertThat(params[0] + "/" + params[1]).isEqualTo("1/0");
    }

    @Test
    public void should_calculate_all() {
        ReadFile readFile = new ReadFile("testData.txt");
        List<String> content = readFile.getFileContent(readFile.readDataFile());
        Calculate calculate = new Calculate();
        assertThat(calculate.calculateAll(content)).isEqualTo("收费6元" +"\n"+"收费7元"+"\n"+"收费13元"+"\n"+"收费7元"+"\n");
    }
}
