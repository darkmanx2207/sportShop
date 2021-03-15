package com.jdriven.ng2boot.entity;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Arrays;
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

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "type")
    private String type;

    public Protein () {}

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                Objects.equals(getPrice(), protein.getPrice()) &&
                Arrays.equals(getImage(), protein.getImage()) &&
                Objects.equals(getType(), protein.getType());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getTaste(), getDescription(), getPrice(), getType());
        result = 31 * result + Arrays.hashCode(getImage());
        return result;
    }

    @Override
    public String toString() {
        return "Protein{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taste='" + taste + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", image=" + Arrays.toString(image) +
                ", type='" + type + '\'' +
                '}';
    }
}
