package DTO;

import java.sql.Date;

public class MemberInfoDTO {
    private String id;
    private int weight;
    private int height;
    private Date sdate; // java.util.Date 또는 java.sql.Date 사용
	private String formattedSDate;

    // Getter와 Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public String getFormattedSDate() {
        return formattedSDate;
    }

    public void setFormattedSDate(String formattedSDate) {
        this.formattedSDate = formattedSDate;
    }
}
