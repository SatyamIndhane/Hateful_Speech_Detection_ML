package Preprocess;

import com.connection.Dbconn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RemoveStopwords {

    static int maxno;
    public static String slang = null;
 
    @SuppressWarnings("resource")
     public String RemoveWords(String data) throws FileNotFoundException {
        boolean flag = false;
        Scanner sc;

        StringBuilder sb = new StringBuilder();

        String[] tokens = data.split("\\P{Alpha}+");// \\p is use for space and
        // {Alpha for (')eg it's}

        for (String s : tokens) {
            sc = new Scanner(new File(Dbconn.stopwordspath));

            while (sc.hasNext()) {
                if (sc.next().toLowerCase().equals(s.toLowerCase())) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }

            }
            if (flag == false) {

                sb.append(s + ",");
            }
        }
        return sb.toString();
    }
    public static int hatefultopics(String data) throws FileNotFoundException {
        boolean flag = false;
        Scanner sc;
        int a = 1;
        StringBuilder sb = new StringBuilder();

        String[] tokens = data.split("\\P{Alpha}+");// \\p is use for space and
        // {Alpha for (')eg it's}

        for (String s : tokens) {
            sc = new Scanner(new File(Dbconn.hateful));

            while (sc.hasNext()) {
                String word = sc.next();
                if (word.toLowerCase().equals(s.toLowerCase())) {
                    flag = true;
                    a++;
                    
                } else {
                    flag = false;
                }

            }
            if (flag == false) {

                //sb.append(a);
            }
        }
        return a;
    }
    @SuppressWarnings("resource")
	public static int Offensivetopics(String data) throws FileNotFoundException {
        boolean flag = false;
        Scanner sc;
        int a = 1;
        StringBuilder sb = new StringBuilder();

        String[] tokens = data.split("\\P{Alpha}+");// \\p is use for space and
        // {Alpha for (')eg it's}

        for (String s : tokens) {
            sc = new Scanner(new File(Dbconn.Offensive));

            while (sc.hasNext()) {
                String word = sc.next();
                if (word.toLowerCase().equals(s.toLowerCase())) {
                    flag = true;
                    a++;
                    
                } else {
                    flag = false;
                }

            }
            if (flag == false) {

                //sb.append(a);
            }
        }
        return a;
    }
    
   
}
