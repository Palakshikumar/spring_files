package com.example.Item_Mapping.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user_01")
public class Item
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;


  @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
