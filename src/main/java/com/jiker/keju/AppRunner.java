package com.jiker.keju;

import java.util.List;

public class AppRunner {

    public static void main(String[] args) {
        String testDataFile = args[0];
        String receipt = "";
        ReadFile readFile = new ReadFile(testDataFile);
        List<String> content = readFile.getFileContent(readFile.readDataFile());
        Calculate calculate = new Calculate();
        receipt = calculate.calculateAll(content);
        System.out.println(receipt);
    }
}
