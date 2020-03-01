package com.jiker.keju;

import java.util.List;

public class Calculate {

    public String calculateAll(List<String> content) {
        String result = "";
        for (int i = 0; i < content.size(); i++) {
            String line = content.get(i);
            int[] param = getParam(line);
            TaxiPricing taxiPricing = new TaxiPricing(param[0], param[1]);
            result += "收费" + taxiPricing.getFinalFee() + "元" + "\n";
        }
        return result;
    }

    public int[] getParam(String content) {
        String[] lines = content.split(",");
        int[] param = new int[2];
        String regEx = "[^0-9]";
        param[0] = Integer.parseInt(lines[0].replaceAll(regEx,""));
        param[1] = Integer.parseInt(lines[1].replaceAll(regEx,""));
        return param;
    }
}
