/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualisation;

/**
 *
 * @author Tushar
 */



import static util.Sleep.millisecondsToNano;
import static util.Sleep.sleepFor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;

public class arrayDisplayer extends JPanel {
    public int WIN_WIDTH = 1500;    //Defining window width
    public  int WIN_HEIGHT = 720;   //Defining window height
    private int BAR_WIDTH = 5;      //Defining width for each bar
    private  int NUM_BARS = WIN_WIDTH / BAR_WIDTH; //Calculating number of bars that can fit the screen. This will be our array size

    private final int[] array;      //This is actual array
    private final int[] barColours; //This represents array color


    public arrayDisplayer() {
        setBackground(Color.black);                   //Background will be black
        array = new int[NUM_BARS];
        barColours = new int[NUM_BARS];
        //Array is initialized and bar color is set to 1
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i;
            barColours[i] = 0;
        }
    }

    //methods to get size of array(i.e NUM_BARS) and retrieve array element at a position
    public int arraySize() {
        return array.length;
    }

    public int getValue(int index) {
        return array[index];
    }

    //repaints basically clears the window and calls the paintComponent function

    //Swap, its the basic operation for sorting algos
    public void swap(int firstIndex, int secondIndex, long milliSecDelay) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        //Highlights which elements are being swapped
        barColours[firstIndex] = 120;
        barColours[secondIndex] = 120;
        repaint();
        sleepFor(millisecondsToNano(milliSecDelay));
    }


    public void updateSingle(int index, int value, long millisecondDelay) {
        array[index] = value;
        barColours[index] = 100;
        repaint();
        sleepFor(millisecondsToNano(millisecondDelay));
    }

    //Randomly shuffles array elements
    public void shuffle() {
        Random rng = new Random(10);
        for (int i = 0; i < arraySize(); i++) {
            int swapWithIndex = rng.nextInt(arraySize() - 1);
            swap(i, swapWithIndex, 5);
        }
    }

    //After sorting is done, this function highlights the array elements left to right
    public void highlightArray() {
        for (int i = 0; i < arraySize(); i++) {
            updateSingle(i, getValue(i), 5);
        }
    }

    /**
     * Gets the canvas size
     * @return size
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }

    //Resets colors after sort completed
    public void resetColours() {
        for (int i = 0; i < NUM_BARS; i++) {
            barColours[i] = 0;
        }
        repaint();
    }

    //Paint
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
       //Initialize bar as white
        graphics.setColor(Color.white);
        for (int x = 0; x < NUM_BARS; x++) {
            int height = getValue(x)*2 ;
            int xBegin = x + (BAR_WIDTH - 1)*x ;
            int yBegin = WIN_HEIGHT - height;

            int val = barColours[x] * 2;
            //This is for blue. #rgb. Since b remains 255,color will be blue
            graphics.setColor(new Color(255 - val, 255-val, 255));
            graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
            if (barColours[x] > 0) {
                barColours[x]-= 10;
            }
        }
    }
}
