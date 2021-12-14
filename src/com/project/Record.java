package com.project;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;

public abstract class Record implements Serializable {

    @Serial
    private static final long serialVersionUID = 42L;

    protected LocalTime startTime;
    protected LocalTime endTime;
    protected double duration;

    public Record() {
        startTime = LocalTime.now();
        endTime = LocalTime.now();
        setDuration();
    }

    public Record(String startTime, String endTime) {
        // Format of String: hr:min:sec
        // code to set default 0 sec
        startTime = startTime + ":00";
        endTime = endTime + ":00";
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
        setDuration();
    }

    public void setDuration() {
        duration = Duration.between(startTime, endTime).getSeconds() / 3600.0;
    }

    public double getDuration() {
        return duration;
    }
}