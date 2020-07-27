package com.garage.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "garage", schema = "garage_system")
public class Garage {
    private int id;
    private String email;
    private String password;
    private String phone;
    private String name;
    private String description;
    private String imageAvatar;
    private String imageCover;
    private String address;
    private Integer rate;
    private String workingHour;
    private String content;
    private String latLong;
    private Integer status;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image_avatar", nullable = true, length = 255)
    public String getImageAvatar() {
        return imageAvatar;
    }

    public void setImageAvatar(String imageAvatar) {
        this.imageAvatar = imageAvatar;
    }

    @Basic
    @Column(name = "image_cover", nullable = true, length = 255)
    public String getImageCover() {
        return imageCover;
    }

    public void setImageCover(String imageCover) {
        this.imageCover = imageCover;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "rate", nullable = true)
    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "working_hour", nullable = true, length = 255)
    public String getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(String workingHour) {
        this.workingHour = workingHour;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "lat_long", nullable = true, length = 255)
    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return id == garage.id &&
                Objects.equals(email, garage.email) &&
                Objects.equals(password, garage.password) &&
                Objects.equals(phone, garage.phone) &&
                Objects.equals(name, garage.name) &&
                Objects.equals(description, garage.description) &&
                Objects.equals(imageAvatar, garage.imageAvatar) &&
                Objects.equals(imageCover, garage.imageCover) &&
                Objects.equals(address, garage.address) &&
                Objects.equals(rate, garage.rate) &&
                Objects.equals(workingHour, garage.workingHour) &&
                Objects.equals(content, garage.content) &&
                Objects.equals(latLong, garage.latLong) &&
                Objects.equals(status, garage.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, phone, name, description, imageAvatar, imageCover, address, rate, workingHour, content, latLong, status);
    }
}
