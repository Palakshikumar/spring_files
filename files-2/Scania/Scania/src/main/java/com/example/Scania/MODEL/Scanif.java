package com.example.Scania.MODEL;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Material")
public class Scanif
{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 Integer id;

 @Column(name = "Price")
    Integer price;

 @Column(name = "Mileage")
    Integer mileage;

 @Column(name = "name")
 String name;

 @Column(name = "Speed")
    Integer Speed;
}
