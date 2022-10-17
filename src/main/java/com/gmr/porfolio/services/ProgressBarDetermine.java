package com.gmr.porfolio.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ProgressBarDetermine {
    /* ------------------------------------------------
        recoger la fecha en forma de string desde json y realiza los calculos para determinar
         el progressbar que debe guardarse en ddbb */

   public ProgressBarDetermine(){
        this.pattern= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.today = LocalDate.now();
    }

    public  String getProgressbarType(String date){
        LocalDate formattedDate = LocalDate.parse(date, this.pattern);
        long noOfDaysBetween = ChronoUnit.DAYS.between(formattedDate, this.today);
        int maxLengthOfYear = 730;

        if (noOfDaysBetween*100/maxLengthOfYear >=75 ){
            return "progress-bar bg-success";
        }else if(noOfDaysBetween*100/maxLengthOfYear >=50 ){
            return "progress-bar bg-primary";
        }else if(noOfDaysBetween*100/maxLengthOfYear >=25 ){
            return "progress-bar bg-warning";
        }
        return "progress-bar bg-danger";

    }

    private DateTimeFormatter pattern;
    private LocalDate today;

}
