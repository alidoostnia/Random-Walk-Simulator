/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rape;

/**
 *
 * @author Mehran Alidoost Nia
 */
public class Assign {
    
    private int pack[]={174,129,48,75,201,401,228,184,69,71,548,411};
    
    public int[] Assign_Pack(int dim){
        int a[] = {0,0,0,0,0,0,0,0};//output
        int assign[] = {0,0,0,0,0,0,0,0,0,0,0,0};//temp and randomized
        Dispersion d=new Dispersion();
        assign=d.randomize(pack, 12);
        
        for(int i=0;i<2*dim;i++)//assign to output
            a[i]=assign[i];
        return a;
        
    }
    
    
    public int[][] Assign_Flow(){
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 
    }

    
    
    
}




