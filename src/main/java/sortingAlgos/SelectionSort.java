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
public class SelectionSort implements ISortAlgorithm
{
    @Override
    public void runAlgo(arrayDisplayer array) {
        int len = array.arraySize();
        for (int i = 0; i < len - 1; i++) {
            int min_ind = i;
            for (int j = i + 1; j < len; j++) {
                if (array.getValue(j) < array.getValue(min_ind)) {
                    min_ind = j;
                }
            }
            array.swap(i, min_ind, 100);
        }
    }

    //Get Algo name
    @Override
    public String getName() {
        return "Selection Sort";
    }

}
