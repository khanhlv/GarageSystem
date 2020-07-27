package com.garage.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "category_garage", schema = "garage_system")
public class CategoryGarage {
    private int id;
    private Integer categoyId;
    private Integer garageId;

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
    @Column(name = "categoy_id", nullable = true)
    public Integer getCategoyId() {
        return categoyId;
    }

    public void setCategoyId(Integer categoyId) {
        this.categoyId = categoyId;
    }

    @Basic
    @Column(name = "garage_id", nullable = true)
    public Integer getGarageId() {
        return garageId;
    }

    public void setGarageId(Integer garageId) {
        this.garageId = garageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryGarage that = (CategoryGarage) o;
        return id == that.id &&
                Objects.equals(categoyId, that.categoyId) &&
                Objects.equals(garageId, that.garageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoyId, garageId);
    }
}
