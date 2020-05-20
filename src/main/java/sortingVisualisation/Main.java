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


import java.util.ArrayList;
import javax.swing.JFrame;
import sortingAlgos.BubbleSort;
import sortingAlgos.ISortAlgorithm;
import sortingAlgos.MergeSort;
import sortingAlgos.QuickSort;
import sortingAlgos.SelectionSort;
import sortingAlgos.cocktailSort;
import static util.Sleep.secondsToNano;
import static util.Sleep.sleepFor;
import sortingAlgos.BogoSort;


public class Main {
    private final JFrame window;
    private final arrayDisplayer algoArray;
    private final ArrayList<ISortAlgorithm> sortQueue;

    /**
     * Creates the GUI
     */
    public Main() {
      //Creates window
        window = new JFrame("Sort Visualiser");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        algoArray = new arrayDisplayer();
        window.add(algoArray);
        window.pack();
        window.setVisible(true);

        //Creates an array of the sorting algorithms to be implemented
        sortQueue = new ArrayList<>();


        sortQueue.add(new SelectionSort());
        sortQueue.add(new BubbleSort());
        sortQueue.add(new MergeSort());
        sortQueue.add(new QuickSort());
        sortQueue.add(new cocktailSort());
        sortQueue.add(new BogoSort());
    }

   //Bar array randomized
    private void shuffleAndWait() {
        algoArray.shuffle();
        algoArray.resetColours();
        sleepFor(secondsToNano(1));
    }

    public void run() {
      //for loop for each algo
      confirmWindow c=new confirmWindow();
        for (ISortAlgorithm algorithm : sortQueue) {
            sleepFor(secondsToNano(1));
            int response=c.runWindow(algorithm.getName());
            if(response == 0)
            {
                shuffleAndWait();
                System.out.println(algorithm.getName()+" is starting");
                algorithm.runAlgo(algoArray);
                System.out.println("completed sorting");
                algoArray.resetColours();
                algoArray.highlightArray();
                algoArray.resetColours();
            }
            else if(response == 1)
            {
                continue;
            }
            else
            {   
                window.dispose();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Main sortVisualiser = new Main();
        sortVisualiser.run();
    }
}
