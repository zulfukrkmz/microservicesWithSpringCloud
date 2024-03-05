package com.microservices.limitsservice.bean;

public class Limits {
    private int maximum;
    private int min;

    public int getMaximum() {
        return maximum;
    }

    public Limits() {
    }

    public Limits(int maximum, int min) {
        this.maximum = maximum;
        this.min = min;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
