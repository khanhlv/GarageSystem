package com.garage.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "service", schema = "garage_system")
public class Service {
    private int id;
    private String name;
    private Double price;
    private Integer parents;
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
    @Column(name = "name", nullable = true, length = 500)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "parents", nullable = true)
    public Integer getParents() {
        return parents;
    }

    public void setParents(Integer parents) {
        this.parents = parents;
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
        Service service = (Service) o;
        return id == service.id &&
                Objects.equals(name, service.name) &&
                Objects.equals(price, service.price) &&
                Objects.equals(parents, service.parents) &&
                Objects.equals(status, service.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, parents, status);
    }
}
