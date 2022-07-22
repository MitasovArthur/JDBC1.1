package JDBC.entity;

import lombok.Data;

@Data
public class Info {
    private int id;
    private String name;
    private int number;

    public Info(int id, String name, int string) {
        this.id = id;
        this.name = name;
        this.number = string;
    }
}
