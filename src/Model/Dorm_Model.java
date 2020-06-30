package Model;

public class Dorm_Model {
    private String dorm_id;
    private Integer bed_num;
    private Integer student_num;

    public String getDorm_id() {
        return dorm_id;
    }
    public void setDorm_id(String dorm_id) {
        this.dorm_id = dorm_id;
    }

    public Integer getBed_num() {
        return bed_num;
    }
    public void setBed_num(Integer bed_num) {
        this.bed_num = bed_num;
    }

    public Integer getStudent_num() {
        return student_num;
    }
    public void setStudent_num(Integer student_num) {
        this.student_num = student_num;
    }
    
}