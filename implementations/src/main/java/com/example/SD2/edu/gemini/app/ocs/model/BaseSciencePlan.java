/*
 * Copyright (c) 2020. Chaiyong Ragkhitwetsagul
 * All rights reserved.
 */

package com.example.SD2.edu.gemini.app.ocs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jparsec.ephem.Target;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
public class BaseSciencePlan {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int planNo;
    private String creator;
    private String submitter;
    private double fundingInUSD;
    private String objectives;
    private Target.TARGET starSystem;
    private String startDate;
    private String endDate;
    private TELESCOPELOC telescopeLocation;
    private int durutionOfObservation;
    //    implement
    private DataProcRequirement.TYPE fileType;
    private double fileQuality;
    private double bw;
    private double colors;
    private double contrast;
    private double brightness;
    private double saturation;

//    private ArrayList<DataProcRequirement> dataProcRequirements;
////
//    private BaseObservingProgram observingProgram;


    private STATUS status;

    public enum TELESCOPELOC {
        HAWAII, CHILE
    }

    public enum STATUS {
        COMPLETE, RUNNING, SUBMITTED,TESTED,REJECTED,OPERATED
    }
    public enum TYPE {
        RAW, PNG, JPEG, TIFF
    }

    public BaseSciencePlan() {

    }

    //    public BaseSciencePlan(String creator, String submitter, double fundingInUSD,
//                           String objectives, Target.TARGET starSystem, Date startDate,
//                           Date endDate, TELESCOPELOC telescopeLocation
////            ,ArrayList<DataProcRequirement> dataProcRequirements
//    )
    public BaseSciencePlan(String creator, String submitter, double fundingInUSD,
                           String objectives, Target.TARGET starSystem, String startDate,
                           String endDate, TELESCOPELOC telescopeLocation, String fileType, double fileQuality,
                           double bw, double colors, double contrast,
                           double brightness, double saturation,int durutionOfObservation
    )


    {
        this.creator = creator;
        this.submitter = submitter;
        this.fundingInUSD = fundingInUSD;
        this.objectives = objectives;
        this.starSystem = starSystem;
        this.startDate = startDate;
        this.endDate = endDate;
        this.telescopeLocation = telescopeLocation;
        this.durutionOfObservation = durutionOfObservation;
//        this.dataProcRequirements = dataProcRequirements;
        this.setFileType(fileType);
        this.fileQuality = fileQuality;
        this.bw = bw;
        this.colors = colors;
        this.contrast = contrast;
        this.brightness = brightness;
        this.saturation = saturation;



    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public double getFundingInUSD() {
        return fundingInUSD;
    }

    public void setFundingInUSD(double fundingInUSD) {
        this.fundingInUSD = fundingInUSD;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public Target.TARGET getStarSystem() {
        return starSystem;
    }

    public void setStarSystem(Target.TARGET starSystem) {
        this.starSystem = starSystem;
    }

    public String getStartDate() {
        return startDate.toString();
    }

    public void setStartDate(String startDate) {
        try {
            DateFormat inFormat2 = new SimpleDateFormat( "dd/MM/yyyy");
            DateFormat outFormat = new SimpleDateFormat( "dd/MM/yyyy");
            Date date2 = inFormat2.parse(startDate);
            String myDate2 = outFormat.format(date2);
            this.startDate =myDate2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getEndDate() {
        return endDate.toString();
    }

    public void setEndDate(String endDate) {
        try {
            DateFormat inFormat2 = new SimpleDateFormat( "dd/MM/yyyy");
            DateFormat outFormat = new SimpleDateFormat( "dd/MM/yyyy");
            Date date2 = inFormat2.parse(endDate);
            String myDate2 = outFormat.format(date2);
            this.endDate =myDate2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public TELESCOPELOC getTelescopeLocation() {
        return telescopeLocation;
    }

    public void setTelescopeLocation(TELESCOPELOC telescopeLocation) {
        this.telescopeLocation = telescopeLocation;
    }

//    public ArrayList<DataProcRequirement> getDataProcRequirements() {
//        return dataProcRequirements;
//    }
//
//    public void setDataProcRequirements(ArrayList<DataProcRequirement> dataProcRequirements) {
//        this.dataProcRequirements = dataProcRequirements;
//    }

//    public BaseObservingProgram getObservingProgram() {
//        return observingProgram;
//    }
//
//    public void setObservingProgram(BaseObservingProgram observingProgram) {
//        this.observingProgram = observingProgram;
//    }

    public int getPlanNo() {
        return planNo;
    }

    public void setPlanNo(int planNo) {
        this.planNo = planNo;
    }



    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

//    implement

    public int getDurutionOfObservation() {
        return durutionOfObservation;
    }

    public void setDurutionOfObservation(int durutionOfObservation) {
        this.durutionOfObservation = durutionOfObservation;
    }

    public void setFileType(String type) {
        this.fileType = DataProcRequirement.TYPE.valueOf(type);
    }
    public String getDataProcRequirements() {

        return "[fileType] : " + this.fileType + "; [fileQuality] : " + fileQuality +
                "; [bw] : " + bw+"; [colors] : " + colors + "[contrast] : " + contrast +
                "; [brightness] : " + this.brightness + "; [saturation] : " + saturation;
    }

    public DataProcRequirement.TYPE getFileType() {
        return fileType;
    }

    public void setFileType(DataProcRequirement.TYPE fileType) {
        this.fileType = fileType;
    }

    public double getFileQuality() {
        return fileQuality;
    }

    public void setFileQuality(double fileQuality) {
        this.fileQuality = fileQuality;
    }

    public double getBw() {
        return bw;
    }

    public void setBw(double bw) {
        this.bw = bw;
    }

    public double getColors() {
        return colors;
    }

    public void setColors(double colors) {
        this.colors = colors;
    }

    public double getContrast() {
        return contrast;
    }

    public void setContrast(double contrast) {
        this.contrast = contrast;
    }

    public double getBrightness() {
        return brightness;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
    }

    public double getSaturation() {
        return saturation;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseSciencePlan that = (BaseSciencePlan) o;
        return
//                planNo == that.planNo &&
                Double.compare(that.fundingInUSD, fundingInUSD) == 0 &&
//                creator.equals(that.creator) &&
//                submitter.equals(that.submitter) &&
                        objectives.equals(that.objectives) &&
                        starSystem == that.starSystem &&
                        startDate.equals(that.startDate) &&
                        endDate.equals(that.endDate) &&
                        telescopeLocation.equals(that.telescopeLocation);
    }

    //    @Override
//    public int hashCode() {
//        return Objects.hash(planNo, creator, submitter, fundingInUSD, objectives, starSystem,
//                startDate, endDate, telescopeLocation
//                ,dataProcRequirements, observingProgram
//        );
//    }
    public String getDataProcRequirement() {
        return "DataProcRequirement{" +
                "fileType=" + fileType +
                ", fileQuality=" + fileQuality +
                ", bw=" + bw +
                ", colors=" + colors +
                ", contrast=" + contrast +
                ", brightness=" + brightness +
                ", saturation=" + saturation +
                '}';
    }
    @Override
    public String toString() {
        return "BaseSciencePlan{" +
                "planNo=" + planNo +
                ", creator='" + creator + '\'' +
                ", submitter='" + submitter + '\'' +
                ", fundingInUSD=" + fundingInUSD +
                ", objectives='" + objectives + '\'' +
                ", starSystem=" + starSystem +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", telescopeLocation='" + telescopeLocation + '\'' +
                ", dataProcRequirements: '" + getDataProcRequirements() + '\'' +
                '}';
    }
}