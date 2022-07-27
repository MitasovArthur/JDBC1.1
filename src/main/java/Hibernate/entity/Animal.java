package Hibernate.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Animal {
private  int id;
private String name;
private int age;
private boolean tail;
}
