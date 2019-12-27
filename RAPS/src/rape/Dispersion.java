/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rape;

import java.util.Random;

/**
 *
 * @author Mehran Alidoost Nia
 */
public class Dispersion {
    private int t[]={163,263,503,88,132,251,128,256};

   
    public int Crypt_Dispersion(int type[],int length, int plain){
        //type is array of crypto-types, length is length of array and plain is size of plaintext
        int a[]= null;
        int total=0;
        int seq[]=new int[100];//sequence of crypto-types
        int round=0;
        plain=plain*1024*8;//paintext in bit
        int temp=0;
        //System.out.println(NTRU167());
        while(temp<plain)//until encrypted data is less than plaintext
        {
            a=this.randomize(type, length);
            for(int i=0; i<length;i++)
            {
                total=total+enc(type[i]);
                temp=temp+pplus(type[i]);
                //seq[round]=type[i];
                round++;
                if(temp<plain)
                    break;
            }
 
        }
         
        return total;
    }
    
    
    
    public int [] randomize ( int arr[], int n ){
    Random rand=new Random();
    int tmp;
    for (int i = n-1; i > 0; i--)
    {
        // Pick a random index from 0 to i
        int j = rand.nextInt(10000) % (i+1);
 
        // Swap arr[i] with the element at random index
        tmp=arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;
    }
    return arr;
}

    
    
    
    private int enc(int i) {
        int encrypt=0;
        if (i==1)
            encrypt=NTRU167();
        else if (i==2)
            encrypt=NTRU263();
        else if (i==3)
            encrypt=NTRU503();
        else if (i==4)
            encrypt=ETRU88();
        else if (i==5)
            encrypt=ETRU132();
        else if (i==6)
            encrypt=ETRU251();
        else if (i==7)
            encrypt=LWE128();
        else if (i==8)
            encrypt=LWE256();
        else
            System.out.print("not found");
        return encrypt;
    }

    private int NTRU167() {
        int n=167;
        int q=128;
        double x=n*(Math.log(q) / Math.log(2));
        n=(int) Math.ceil(x);
        return n;
                
    }

    private int NTRU263() {
        int n=263;
        int q=256;
        double x=n*(Math.log(q) / Math.log(2));
        n=(int) Math.ceil(x);
        return n; 
    }

    private int NTRU503() {
        int n=503;
        int q=500;
        double x=n*(Math.log(q) / Math.log(2));
        n=(int) Math.ceil(x);
        return n; 
    }

    private int ETRU88() {
        int n=88;
        int q=256;
        double x=n*(Math.log(q) / Math.log(2));
        n=(int) Math.ceil(x);
        return n; 
    }

    private int ETRU132() {
        int n=132;
        int q=512;
        double x=n*(Math.log(q) / Math.log(2));
        n=(int) Math.ceil(x);
        return n;  
    }

    private int ETRU251() {
        int n=251;
        int q=1000;
        double x=n*(Math.log(q) / Math.log(2));
        n=(int) Math.ceil(x);
        return n;
    }

    private int LWE128() {
        int n=128;
        int q=5000;
        double x=2*n*(Math.log(q) / Math.log(2));
        n=(int) Math.ceil(x);
        return n;
    }

    private int LWE256() {
        int n=256;
        int q=5000;
        double x=2*n*(Math.log(q) / Math.log(2));
        n=(int) Math.ceil(x);
        return n;
    }

    private int pplus(int i) {//sum of the current processed data
        int pp=0;
        if (i==1)
            pp=167;
        else if (i==2)
            pp=263;
        else if (i==3)
            pp=503;
        else if (i==4)
            pp=88;
        else if (i==5)
            pp=132;
        else if (i==6)
            pp=251;
        else if (i==7)
            pp=128;
        else if (i==8)
            pp=256;
        else
            System.out.print("not found");
        return pp;    }
    
}
