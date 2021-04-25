
package com.algo;

import java.util.ArrayList;

/**
 *
 * @author Sunsoft
 */
public class NB {
    
    public double FindOffensive(String TestComment, ArrayList TrainData) throws Exception
    {
        int tot=0;
         double Mastercount=0.0;
         double positiveProbability=0.0;
         String[] TestWset=  TestComment.toString().split(",");
         for(int initialPoint=0; initialPoint<TestWset.length; initialPoint++) //input layer
        {
           
        for(int startpoint=0; startpoint<TrainData.size();startpoint++) // Hidden layer
        {
           String[] dataparts =TrainData.get(startpoint).toString().split("#");
           if(dataparts[1].equalsIgnoreCase("Offensive"))
           {
             String[] dataparts1 =dataparts[0].toString().split(",");
             for(int wpoint=0; wpoint < dataparts1.length; wpoint++)
             { tot++;
                 String w1=TestWset[initialPoint];
                 String w2=dataparts1[wpoint];
//                 System.out.println(w1);
//                 System.out.println(w2);
                 if(w1.equalsIgnoreCase(w2))
                 {
                    Mastercount =Mastercount+1;  
                  }
             }
           }
       positiveProbability =Mastercount/ tot; // weight calculation
        }
     }
        return positiveProbability;
    }
    
    public double findHateful(String TestComment, ArrayList TrainData) throws Exception
    {
        int tot=0;
        double Mastercount=0.0;
         double positiveProbability=0.0;
          String[] TestWset=  TestComment.toString().split(",");
        for(int initialPoint=0; initialPoint<TestWset.length; initialPoint++)
        {
           
        for(int startpoint=0; startpoint<TrainData.size();startpoint++)
        {
           String[] dataparts =TrainData.get(startpoint).toString().split("#");
           // System.out.println(TrainData.get(startpoint).toString());
           if(dataparts[1].equalsIgnoreCase("Hateful"))
           {
               String[] dataparts1 =dataparts[0].toString().split(",");
             for(int wpoint=0; wpoint < dataparts1.length; wpoint++)
             {
                 tot++;
                 String w1=TestWset[initialPoint];
                 String w2=dataparts1[wpoint];
//                 System.out.println(w1);
//                 System.out.println(w2);
                 if(w1.equalsIgnoreCase(w2))
                 {
                    Mastercount =Mastercount+1;  
                  }
             }
           }
       positiveProbability =Mastercount/ tot;
        }
     }
         
        return positiveProbability;
    }
    
     
}
