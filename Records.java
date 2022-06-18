package Modal;

import java.io.Serializable;

public class Records  implements Serializable {

    int id;
    String name;
    String course;
    String mobile;
    int totalfee;
    int fee_paid;

    public Records(int id, String name, String course, String mobile, int totalfee, int fee_paid) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.mobile = mobile;
        this.totalfee = totalfee;
        this.fee_paid = fee_paid;
    }

    public Records(String name, String course, String mobile, int totalfee, int fee_paid) {
        this.name = name;
        this.course = course;
        this.mobile = mobile;
        this.totalfee = totalfee;
        this.fee_paid = fee_paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(int totalfee) {
        this.totalfee = totalfee;
    }

    public int getFee_paid() {
        return fee_paid;
    }

    public void setFee_paid(int fee_paid) {
        this.fee_paid = fee_paid;
    }
}
