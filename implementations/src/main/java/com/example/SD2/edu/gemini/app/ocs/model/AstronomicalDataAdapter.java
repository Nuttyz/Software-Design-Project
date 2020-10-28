package com.example.SD2.edu.gemini.app.ocs.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@SuppressWarnings("ALL")
public class AstronomicalDataAdapter {
    @Id
    private int planNo;
    private String imagefile;
    private String comment;
    private int angle;
    private String telescope;
    private String validity ;
    private String constellation;
    private Boolean operateResult;

    public AstronomicalDataAdapter() {

    }

    public Boolean getOperateResult() {
        return operateResult;
    }

    public void setOperateResult(Boolean operateResult) {
        this.operateResult = operateResult;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPlanNo() {
        return planNo;
    }

    public void setPlanNo(int planNo) {
        this.planNo = planNo;
    }

    public String getImagefile() {
        return imagefile;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile;
    }

    public String getTelescope() {
        return telescope;
    }

    public void setTelescope(String telescope) {
        this.telescope = telescope;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}