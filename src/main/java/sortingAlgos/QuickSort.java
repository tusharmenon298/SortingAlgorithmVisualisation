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
public class QuickSort implements ISortAlgorithm
{
    private int partition(arrayDisplayer array, int low, int high) {
        int part;
        part= array.getValue(high);
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (array.getValue(j) <= part) {
                i++;
                array.swap(i, j, 30);
            }
        }
        array.swap(i + 1, high, 30);
        return i + 1;
    }

    private void quickSort(arrayDisplayer array, int low, int high) {
        if (low < high) {
            int part;
            part = partition(array, low, high);
            quickSort(array, low, part - 1);
            quickSort(array, part + 1, high);
        }
    }

    @Override
    public void runAlgo(arrayDisplayer array) {
        quickSort(array, 0, array.arraySize() - 1);
    }
    //Get Algo Name
    @Override
    public String getName() {
        return "Quick Sort";
    }

}
