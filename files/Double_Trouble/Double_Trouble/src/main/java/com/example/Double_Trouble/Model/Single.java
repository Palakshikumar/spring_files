package com.example.Double_Trouble.Model;

import lombok.*;

import javax.persistence.*;
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Single")
public class Single {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;


        @Column(name = "Marks_table")
        Integer marks;

        @Column(name = "Father")
        String father;


    }


