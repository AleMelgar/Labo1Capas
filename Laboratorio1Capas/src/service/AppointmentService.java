package service;

import model.entity.Doctor;
import model.entity.Patient;
import model.entity.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentService {
    private List<Appointment> appointments;

    public AppointmentService(){
        this.appointments = new ArrayList<>();
    }

    public void book(Doctor doctor, Patient patient, String specialty, LocalDate date, boolean today, LocalTime hourEntered){
        LocalTime hourAssigned;

        if (today){
            hourAssigned = hourEntered;

            if(conflict(doctor, patient, date, hourAssigned)){
                System.out.println("This appointment is already booked");
                return;
            }
        } else {
            hourAssigned = getFreeHour(date, doctor, patient);

            if (hourAssigned == null){
                System.out.println("No free hours available");
                return;
            }
        }

        Appointment newAppointment = new Appointment(doctor, patient, specialty, date, hourAssigned);
        appointments.add(newAppointment);
        System.out.println("Appointment booked");
        System.out.println(newAppointment.showInfo());
    }

    private boolean conflict(Doctor doctor, Patient patient, LocalDate date, LocalTime hour){
        return appointments.stream().anyMatch(c ->c.getDate().equals(date) && c.getHour().equals(hour) &&
                (c.getDoctor().getEpicCode().equals(doctor.getEpicCode()) || c.getPatient().getDui().equals(patient.getDui())));
    }

    private LocalTime getFreeHour(LocalDate date, Doctor doctor, Patient patient){
        LocalTime hour = LocalTime.of(8, 0);
        LocalTime hourEnd = LocalTime.of(16, 0);

        while (!hour.isAfter(hourEnd.minusMinutes(1))){
            if (!conflict(doctor, patient, date, hour)){
                return hour;
            }
            hour = hour.plusHours(1);
        }
        return null;
    }

    public List<Appointment> getAllAppointments(){
        return appointments;
    }

    public List<Appointment> getAppointmentsByDoctor(String epicCode){
        return appointments.stream().filter(c -> c.getDoctor().getEpicCode().equalsIgnoreCase(epicCode)).collect(Collectors.toList());
    }

    public List<Appointment> getAppointmentsByDate(LocalDate date){
        return appointments.stream().filter(c -> c.getDate().equals(date)).collect(Collectors.toList());
    }

    public void listAllAppointments(){
        if (appointments.isEmpty()){
            System.out.println("No appointments registered");
            return;
        }
        for (Appointment appointment : appointments) {
          System.out.println(appointment.showInfo());
        }
    }
}
