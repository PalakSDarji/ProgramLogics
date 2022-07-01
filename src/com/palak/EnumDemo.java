package com.palak;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class EnumDemo {

    public static void main(String[] args) {
        WEEK_DAYS monday = WEEK_DAYS.MONDAY;

        monday.setExtra(3);
        System.out.println(monday.getExtra());

        System.out.println(monday.ordinal());
        System.out.println(Arrays.toString(WEEK_DAYS.values()));
    }

    private enum WEEK_DAYS{
        SUNDAY(1), MONDAY(2);

        int extra;

        WEEK_DAYS(int e){
            this.extra = e;
        }

        public int getExtra() {
            return extra;
        }

        public void setExtra(int extra) {
            this.extra = extra;
        }
    }
}
