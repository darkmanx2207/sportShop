package com.jdriven.ng2boot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "protein")
public class Protein {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "taste")
    private String taste;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;

    public Protein () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Protein)) return false;
        Protein protein = (Protein) o;
        return Objects.equals(getId(), protein.getId()) &&
                Objects.equals(getName(), protein.getName()) &&
                Objects.equals(getTaste(), protein.getTaste()) &&
                Objects.equals(getDescription(), protein.getDescription()) &&
                Objects.equals(getPrice(), protein.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTaste(), getDescription(), getPrice());
    }

    @Override
    public String toString() {
        return "Protein{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taste='" + taste + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
