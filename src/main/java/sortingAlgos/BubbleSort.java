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

//Bubble Sort
public class BubbleSort implements ISortAlgorithm
{
    @Override
    public void runAlgo(arrayDisplayer array) {
        int l = array.arraySize();
        for(int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (array.getValue(j) > array.getValue(j + 1)) {
                    array.swap(j, j + 1, 2);
                }
            }
        }
    }
//To get Alggorithm Name
    @Override
    public String getName() {
        return "Bubble Sort";
    }

}
