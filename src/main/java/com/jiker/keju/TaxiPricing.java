package com.jiker.keju;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxiPricing {
    private int distance;
    private int waitingTime;
    AppConfig appConfig = new AppConfig();

    public TaxiPricing(int distance, int waitingTime) {
        this.distance = distance;
        this.waitingTime = waitingTime;
    }

    public double getDistanceFee() {
        if (distance <= appConfig.getBasicDist()) {
            return appConfig.getBasicFee();
        }
        else if (distance <= appConfig.getDistThreshold()) {
            return appConfig.getBasicFee() + appConfig.getExtraFee(distance);
        } else {
            return appConfig.getBasicFee() + appConfig.getExtraFee(distance) + appConfig.getLongDistFee(distance);
        }
    }

    public double getWaitingFee() {
        return waitingTime * appConfig.getWaitingPrice();
    }

    public int getFinalFee() {
        double sumFee = getDistanceFee() + getWaitingFee();
        BigDecimal finalFee = new BigDecimal(Double.toString(sumFee));
        return finalFee.setScale(0, RoundingMode.HALF_UP).intValue();
    }
}
