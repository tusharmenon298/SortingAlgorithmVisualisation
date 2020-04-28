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
public class MergeSort implements ISortAlgorithm
{
    private int[] getSubArray(arrayDisplayer array, int begin, int size) {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = array.getValue(begin + i);
        }
        return arr;
    }

    //Merges sorted sub arrays
    private void merge(arrayDisplayer array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int leftArray[]  = getSubArray(array, left, leftSize);
        int rightArray[] = getSubArray(array, middle + 1, rightSize);

        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array.updateSingle(k, leftArray[i], 5);
                i++;
            }
            else {
                array.updateSingle(k, rightArray[j], 5);
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array.updateSingle(k, leftArray[i], 5);
            i++;
            k++;
        }
        while (j < rightSize) {
            array.updateSingle(k, rightArray[j], 5);
            j++;
            k++;
        }
    }

    private void mergeSort(arrayDisplayer array, int left, int right) {
        if (left < right) {
            int middleIndex = (left + right) / 2;

            mergeSort(array, left, middleIndex);
            mergeSort(array, middleIndex + 1, right);

            merge(array, left, middleIndex, right);
        }
    }

    @Override
    public void runAlgo(arrayDisplayer array) {
        int left = 0;
        int right = array.arraySize() - 1;
        mergeSort(array, left, right);
    }
    //Gets name of algo
    @Override
    public String getName() {
        return "Merge Sort";
    }


}
