package com.palak;

import java.util.Calendar;

public class LeapYearFinder {

    private boolean isLeapYear(int year){

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);

        if(calendar.getActualMaximum(Calendar.DAY_OF_YEAR) > 365){
            return true;
        }

        return false;
    }

    private boolean isLeapYearManually(int year){
        if(year%400 == 0 || (year%100 !=0 && year%4 ==0)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeapYearFinder leapYearFinder = new LeapYearFinder();
        System.out.println(leapYearFinder.isLeapYear(2008));
        System.out.println(leapYearFinder.isLeapYearManually(2008));
    }
}
