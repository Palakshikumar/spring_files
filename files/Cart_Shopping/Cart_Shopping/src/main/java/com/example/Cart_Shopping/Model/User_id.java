package com.example.Cart_Shopping.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "User_01")
public class User_id
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer User_id;

    @Column (name = "name")
    String name;

    @Column(name = "Email")
    String Email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address_id addressId;

}
