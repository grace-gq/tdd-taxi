package com.jiker.keju;

public class AppConfig {
    private int basicFee = 6;
    private int basicDist = 2;
    private double extraPrice = 0.8;
    private int distThreshold = 8;
    private double longDistInterest = 0.5;
    private double waitingPrice = 0.25;

    public int getBasicFee() {
        return basicFee;
    }

    public int getBasicDist() {
        return basicDist;
    }

    public double getExtraPrice() {
        return extraPrice;
    }

    public int getDistThreshold() {
        return distThreshold;
    }

    public double getLongDistInterest() {
        return longDistInterest;
    }

    public double getWaitingPrice() {
        return waitingPrice;
    }

    public double getExtraFee(double distance) {
        return (distance - getBasicDist()) * getExtraPrice();
    }

    public double getLongDistFee(double distance) {
        double fee;
        fee = (distance - getDistThreshold()) * getExtraPrice() * getLongDistInterest();
        return fee;
    }
}
