package com.teamword.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;


@Entity
@Table( name="Loaigiuongbenh")
public class Giuongbenh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column( name="name")
    @NotNull
    private  String name;

    @Column(name="price")
    @NotNull
    private BigDecimal price;

    @Column(name="description")
    @NotNull
    private String description;


    public  Giuongbenh( String name, BigDecimal price, String description){
        this.name = name;
        this.price = price;
        this.description = description;;
    }

    public Giuongbenh() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {this.description = description;
    }
}
