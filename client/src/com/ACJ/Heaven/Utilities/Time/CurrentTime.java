package com.ACJ.Heaven.Utilities.Time;

public class CurrentTime {
    public static long getNanoSeconds(){
        return System.nanoTime();
    }

    public static long getMilliSeconds(){
        return (long)(getNanoSeconds() / 1e6);
    }

    public static long getSeconds(){
        return (long)(getNanoSeconds() / 1e9);
    }


}

