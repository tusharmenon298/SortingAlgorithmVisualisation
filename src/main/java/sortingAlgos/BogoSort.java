/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingAlgos;

/**
 *
 * @author Tushar
 */

import sortingVisualisation.arrayDisplayer;
import static util.Sleep.secondsToNano;
import static util.Sleep.sleepFor;

public class BogoSort implements ISortAlgorithm {
    
    
    //Sort Checker
    
    boolean isSorted(arrayDisplayer array)
    {
        for(int i=1; i< array.arraySize(); i++)
        {
            if( array.getValue(i) < array.getValue(i-1))
                return false;
        }
        
        return true;
    }
    //Bogo Sort
    @Override
    public void runAlgo(arrayDisplayer array)
    {
        while(isSorted(array) == false){
            array.shuffle();
            array.resetColours();
            sleepFor(secondsToNano(1));
        }
    }
    
    //To get Alggorithm Name
    @Override
    public String getName() {
        return "Bogo Sort";
    }
}
