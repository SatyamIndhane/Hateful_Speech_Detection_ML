package com.algo;
import java.util.ArrayList;

/**
 *
 * @author Sunsoft
 */
public class NBold {

    public double FindOffensive(String TestComment, ArrayList<String> TrainData) throws Exception {
        int tot = 0;
        double Mastercount = 0.0;
        double positiveProbability = 0.0;
        
        {
            String[] TestWset = TestComment.toString().split(",");
            for (int initialPoint = 0; initialPoint < TestWset.length; initialPoint++) //input layer
            {
                System.out.println(TestComment + "\n");
                for (int startpoint = 0; startpoint < TrainData.size(); startpoint++) // Hidden layer
                {
                    String[] dataparts = TrainData.get(startpoint).toString().split("#");
                    if (dataparts[1].equalsIgnoreCase("Offensive")) {
                        String[] dataparts1 = dataparts[0].toString().split(",");
                        for (int wpoint = 0; wpoint < dataparts1.length; wpoint++) {
                            tot++;
                            String w1 = TestWset[initialPoint];
                            String w2 = dataparts1[wpoint];
//                 System.out.println(w1);
//                 System.out.println(w2);
                            if (w1.equalsIgnoreCase(w2)) {
                                Mastercount = Mastercount + 1;
                            }
                        }
                    }
                    positiveProbability = Mastercount / tot; // weight calculation
                }
            }
        }
        return positiveProbability;
    }

    public double findHateful(int id,String TestComment, ArrayList<String> TrainData) throws Exception {
        int tot = 0;
        double Mastercount = 0.0;
        double positiveProbability = 0.0;
        String[] TestWset = TestComment.split(",");
        for (String w1 : TestWset) {
         
            for (int startpoint = 0; startpoint < TrainData.size(); startpoint++) {
                String w2 = TrainData.get(startpoint).toString();
                tot++;
               
                if (w1.toLowerCase().equalsIgnoreCase(w2.toLowerCase())) {
                    Mastercount = Mastercount + 1;
                    
                }// condition
            }// training for loop
        }// test for loop
        
        double s=(double)(Mastercount*100);
        positiveProbability = s/ tot;
System.out.println("ID"+id+"\t MasterCount=>"+Mastercount+"\t Total=>"+tot+"\tpositiveProbability=>"+positiveProbability);
    return positiveProbability ;
}

}
