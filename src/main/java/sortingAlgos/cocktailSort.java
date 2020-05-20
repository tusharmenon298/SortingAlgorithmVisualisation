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

public class cocktailSort implements ISortAlgorithm{ 
    public void runAlgo(arrayDisplayer array) 
    { 
        boolean swapped = true; 
        int start = 0; 
        int end = array.arraySize(); 
  
        while (swapped == true) { 
            swapped = false; 
  
            // loop from bottom to top same as 
            // the bubble sort 
            for (int i = start; i < end - 1; ++i) { 
                if (array.getValue(i) > array.getValue(i+1)) { 
                    array.swap(i,i+1,2);
                    swapped = true; 
                } 
            } 
  
            // if nothing moved, then array is sorted. 
            if (swapped == false) 
                break; 
  
            // otherwise, reset the swapped flag so that it 
            // can be used in the next stage 
            swapped = false; 
  
            // move the end point back by one, because 
            // item at the end is in its rightful spot 
            end = end - 1; 
  
            // from top to bottom, doing the 
            // same comparison as in the previous stage 
            for (int i = end - 1; i >= start; i--) { 
                if (array.getValue(i) > array.getValue(i+1)) { 
                    array.swap(i,i+1,2);
                    swapped = true; 
                } 
            } 
  
            // increase the starting point, because 
            // the last stage would have moved the next 
            // smallest number to its rightful spot. 
            start = start + 1; 
        } 
    } 
  
//To get Alggorithm Name
    @Override
    public String getName() {
        return "Cockktail Sort";
    }
}
