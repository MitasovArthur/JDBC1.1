package JDBC.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Statements {
    private int id;
    private int workers_id;
    private String placeOfResidence;
    private Date dataOfBieth;
    private String mritalStatus;

    public Statements(int id, int workers_id, String placeOfResidence, Date dataOfBieth, String mritalStatus) {
        this.id = id;
        this.workers_id = workers_id;
        this.placeOfResidence = placeOfResidence;
        this.dataOfBieth = dataOfBieth;
        this.mritalStatus = mritalStatus;
    }
}
