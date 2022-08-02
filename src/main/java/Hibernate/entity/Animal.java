package Hibernate.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Animal {
    @Id
private  int id;
private String name;
private int age;
private boolean tail;
}
