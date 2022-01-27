package com.example.seminarmobileprojectexam.HospitalData;

import java.time.LocalDate;

public class VaccineAnnouncement {
    private LocalDate injectedDate;
    String injectedLocation;
    String duration;
    String subject;
    int vaccineCount;

    public VaccineAnnouncement(LocalDate injectedDate, String injectedLocation, String duration, String subject, int vaccineCount) {
        this.injectedDate = injectedDate;
        this.injectedLocation = injectedLocation;
        this.duration = duration;
        this.subject = subject;
        this.vaccineCount = vaccineCount;
    }

    public LocalDate getInjectedDate() {
        return injectedDate;
    }

    public void setInjectedDate(LocalDate injectedDate) {
        this.injectedDate = injectedDate;
    }

    public String getInjectedLocation() {
        return injectedLocation;
    }

    public void setInjectedLocation(String injectedLocation) {
        this.injectedLocation = injectedLocation;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getVaccineCount() {
        return vaccineCount;
    }

    public void setVaccineCount(int vaccineCount) {
        this.vaccineCount = vaccineCount;
    }
}
