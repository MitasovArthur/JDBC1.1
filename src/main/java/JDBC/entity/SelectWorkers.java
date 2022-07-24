package JDBC.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SelectWorkers {
    private Date dataOfBieth;
    private int number;

    public SelectWorkers(Date dataOfBieth, int number) {
        this.dataOfBieth = dataOfBieth;
        this.number = number;
    }
}
