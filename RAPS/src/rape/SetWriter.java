/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rape;

import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author Mehran Alidoost Nia
 */
public class SetWriter {
          private Formatter out;



   public void OpenFile(){

      try{
            out=new Formatter("Setting.txt");
        }
        catch(FileNotFoundException fileNotFoundException){
          System.err.println("Error opening file!");
          System.exit(1);
        }
    }


   public void WriteFile(int a, int b,int c,int d,int e,int f,int g,int h,int i,int j){
      // for(int i=0;a[i]!=null;i++){
      // String setting    =a[i];
       out.format("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", a,b,c,d,e,f,g,h,i,j);
       
       
      // }
   }
   public void CloseFile(){
       out.close();

   }


}
