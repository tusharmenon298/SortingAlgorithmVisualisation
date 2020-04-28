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
//Interface
public interface ISortAlgorithm
{
    public String getName();

    public void runAlgo(arrayDisplayer array);
}
