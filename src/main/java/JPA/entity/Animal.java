package JPA.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Entity
public class Animal {
        @Id
        @GeneratedValue
        private  int id;
        private String name;
        private int age;
        private boolean tail;

}
