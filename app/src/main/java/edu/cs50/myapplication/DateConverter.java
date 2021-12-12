package edu.cs50.myapplication;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long time)
    {
        return time==null? null:new Date(time);
    }
    @TypeConverter
    public static Long toLong(Date time)
    {
        return time==null ? null:time.getTime();
    }
}
