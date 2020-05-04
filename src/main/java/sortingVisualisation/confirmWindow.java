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
import javax.swing.*;  
import java.awt.event.*;  
public class confirmWindow extends WindowAdapter{  
JFrame f;  
confirmWindow(){  
    f=new JFrame();   
    f.addWindowListener(this);  
    f.setSize(0, 0);
    
    f.setLayout(null);  
    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    f.setVisible(true);  
}  
public int runWindow(String s) {  
    int a=JOptionPane.showConfirmDialog(f,"Do you want to see "+s);  
    f.dispose();
return a;

}   
     
     
}  
