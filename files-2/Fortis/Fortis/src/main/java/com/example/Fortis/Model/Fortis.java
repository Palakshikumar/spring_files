package com.example.Fortis.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Ricked" )
public class Fortis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "double")
    Double marks;

    @Column(name = "Total_Marks")
    Double Total;
}
