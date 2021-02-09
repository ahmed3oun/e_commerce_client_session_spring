package com.project.e_pharmacie_spring_client.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;
    @Column(name = "number")
    private long number;
    @Column(name = "one_time_password")
    private String one_time_password;
    @Column(name = "otp_requested_time")
    private Date otp_requested_time;
    @OneToMany(mappedBy = "user")
    private List<Command> commands = new ArrayList<Command>();

    public boolean isOTPRequired() {
        if (this.getOne_time_password() == null) {
            return false;
        }

        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis = this.otp_requested_time.getTime();

        if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
            // OTP expires
            return false;
        }

        return true;
    }

    ///////////////////////////// Getters setters////////////////////////////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public String getOne_time_password() {
        return one_time_password;
    }

    public void setOne_time_password(String one_time_password) {
        this.one_time_password = one_time_password;
    }

    public Date getOtp_requested_time() {
        return otp_requested_time;
    }

    public void setOtp_requested_time(Date otp_requested_time) {
        this.otp_requested_time = otp_requested_time;
    }

}