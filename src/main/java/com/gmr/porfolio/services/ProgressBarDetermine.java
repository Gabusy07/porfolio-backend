package com.gmr.porfolio.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ProgressBarDetermine {
    /* ------------------------------------------------
        recoger la fecha en forma de string desde json y realiza los calculos para determinar
         el progressbar que debe guardarse en ddbb */

   public ProgressBarDetermine(){
        this.pattern= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.today = LocalDate.now();
    }


    /*
    public ArrayList getProgressbarType(String date){
        LocalDate formattedDate = LocalDate.parse(date, this.pattern);
        long noOfDaysBetween = ChronoUnit.DAYS.between(formattedDate, this.today);
        int maxLengthOfYear = 1095;
        int width = (int) (noOfDaysBetween*100/maxLengthOfYear);
        ArrayList list = new ArrayList<>();


        if (width >100 ){

            list.add("progress-bar bg-success");
            list.add(100);
            return  list;}
        else if (width >=75 ){

            list.add("progress-bar bg-success");
            list.add(width);
            return  list;
        }else if(width >=50 ){
            list.add("progress-bar bg-primary");
            list.add(width);
            return  list;
        }else if(width>=25 ){
            list.add("progress-bar bg-warning");
            list.add(width);
            return  list;
        }
        list.add("progress-bar bg-danger");
        list.add(width);
        return  list;

    }*/

    public ArrayList getProgressbarType(String date, String color){
        LocalDate formattedDate = LocalDate.parse(date, this.pattern);
        long noOfDaysBetween = ChronoUnit.DAYS.between(formattedDate, this.today);
        int maxLengthOfYear = 1095;
        int width = (int) (noOfDaysBetween*100/maxLengthOfYear);
        ArrayList list = new ArrayList<>();
        list.add("progress-bar bg-"+color);


        if (width >100 ){

            list.add(100);
            return  list;}
        else if (width >=75 ){

            list.add(width);
            return  list;
        }else if(width >=50 ){
            list.add(width);
            return  list;
        }else if(width>=25 ){
            list.add(width);
            return  list;
        }
        list.add(width);
        return  list;

    }


    private DateTimeFormatter pattern;
    private LocalDate today;

}
