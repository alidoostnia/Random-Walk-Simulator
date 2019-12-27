/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Mehran Alidoost Nia
 */
public class SetReader {
    private Scanner input;






    public void OpenFile()
    {
     try{
            File f2=new File("Setting.txt");
            input=new Scanner(f2);
        }
        catch(FileNotFoundException fileNotFoundException){
          System.err.println("Error opening file !");
          System.exit(1);
        }
    }



    public int[] ReadFile()
    {
       int a[]=new int[10];
       int i=0;
      try{
           while(input.hasNext()){
               a[i]=input.nextInt();
               i++;
           }
        }catch(NoSuchElementException elementException){
         System.err.println("file is peroperly forms");
         input.close();
         System.exit(1);
        }
      return a;
      }





    public void CloseFile()
    {

    }

}
