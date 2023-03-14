package com.example.Cart_Shopping.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Address_01")
public class Address_id
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer Add_id;
    @Column(name = "model")
    String name;






}
