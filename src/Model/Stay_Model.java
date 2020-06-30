package Model;

public class Stay_Model {
    private String student_id;
    private String name;
    private String dorm_id;
    private Integer bed_id;

    public String getStudent_id() {
        return student_id;
    }
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDorm_id() {
        return dorm_id;
    }
    public void setDorm_id(String dorm_id) {
        this.dorm_id = dorm_id;
    }

    public Integer getBed_id() {
        return bed_id;
    }
    public void setBed_id(Integer bed_id) {
        this.bed_id = bed_id;
    }

}