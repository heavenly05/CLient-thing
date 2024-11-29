package com.ACJ.Heaven.Utilities;

public class TrashMath {
    public abstract class Vector{
        protected int value1;
        protected int Value2;


        public Vector(int Value1, int Value2){
            this.value1 = Value1;
            this.Value2 = Value2;
        }

        public int getValue1() {
            return value1;
        }
        public int getValue2() {
            return Value2;
        }
        public void setValue1(int value1) {
            this.value1 = value1;
        }
        public void setValue2(int value2) {
            Value2 = value2;
        }
    }
    public class Vector2D extends Vector{
        public Vector2D(int x, int y){
            super(x, y);
        }
    }
    

    public static class Random{
        protected static final byte[] minAsciiRange = {65, 90};
        protected static final byte[] maxAsciiRange = {97, 122};

        protected static final byte[][] asciiRanges = {minAsciiRange, maxAsciiRange};
        
        public static String generateRandomString(int length){

            String randomString = "";

            for(int i = 0; i < length; i++){

                 byte[] range = asciiRanges[Math.random() <= 0.5 ? 0 : 1];
        
                char charCode = (char)(Math.floor(Math.random() * (range[1] - range[0] + 1)) + range[0]);
        
                randomString += (charCode);
            } 
            return randomString;
        }

        public static long generateRandomNumber(long length){
            String randomString = "";

            for(int i = 0; i < length; i++){
                byte number = (byte)(Math.floor(Math.random() * 9));
                randomString += number;
            }
            return (Long.parseLong(randomString));
        }


        public static int generateRandomNumber(int length){
            String randomString = "";

            for(int i = 0; i < length; i++){
                int number = (int)(Math.floor(Math.random() * 9));
                randomString += number;
            }
            return (int)(Long.parseLong(randomString));
        }

        public static String getRandomMixedString(int length){
            String mixedString = "";
            for(int i = 0; i < length; i++){
                String random = (Math.random() <= 0.5 ? String.valueOf(generateRandomNumber(1)) : generateRandomString(1));
                mixedString += random;
            }
        return mixedString;
     }

    
}
public static class Percentage{
        public static int percentToNum(int percent, int of){
            return ((int)((percent * of) / 100));
        }

        public static int numToPercent(int isWhat, int of){
            return ((int)(isWhat / of) * 100);
        }
    }
}