package edu.spring.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id_user;
    public String name;
    public String last_name;

    public User(){}

    public User(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
    }
    
}
