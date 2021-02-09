package com.project.e_pharmacie_spring_client.models;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "command")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private Date date_command;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    // @OneToMany(mappedBy="user_id")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // @ManyToMany(cascade = {CascadeType.ALL})
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    ///////////////////////////////////// Getters setters/////////////////////
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Date getDate_command() {
        return date_command;
    }

    public void setDate_command(final Date date_command) {
        this.date_command = date_command;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}