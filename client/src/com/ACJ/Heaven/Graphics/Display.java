package com.ACJ.Heaven.Graphics;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Display {
    public static class ScreenDimensions{
        public static Dimension getScreenDimension(){
            return (Toolkit.getDefaultToolkit().getScreenSize());
        }
    }
}
