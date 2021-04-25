/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo;

import java.util.HashMap;
import java.util.Scanner;

public class document_distance {
//print the string array made from document
    
    
public static void printDoc(String[] doc) {
    System.out.println("=====printing doc words ====");
    int len = doc.length;
    for( int i=0; i<len; i++ )  {
        System.out.print(doc[i]+" ");
    }
    System.out.println();
}

public static void printMap(HashMap<String, Integer> dict) {
    System.out.println("=====printing dictionary (key,value) ====");
    for(String key: dict.keySet()) {
        System.out.println(key+" ->"+dict.get(key));
    }
}

public static double CalculateDistance(String args1,String args2) {

    String s1=  args1;
    String s2= args2;
    
    String doc1[] = s1.split(",");
    String doc2[] = s2.split(",");

    //create two dictionaries with keys as words and values as count of that word!
    HashMap<String, Integer> dict1 = new HashMap<String, Integer>();
    HashMap<String, Integer> dict2 = new HashMap<String, Integer>();

    //update counts for doc1 both dictionaries
    for(int i=0; i<doc1.length ;i++) {
        if(!dict1.containsKey(doc1[i])) { //word is not in dict1 yet
            dict1.put(doc1[i], 1);
        }
        else if(dict1.containsKey(doc1[i])) { //word is in dict1 
            dict1.put(doc1[i], dict1.get(doc1[i]) + 1);
        }

        if(!dict2.containsKey(doc1[i])) { //word is not in dict2 yet
            dict2.put(doc1[i], 0);
        }


    }

    //update counts for doc1 both dictionaries
    for(int i=0; i<doc2.length ;i++) {
        if(!dict2.containsKey(doc2[i])) { //word is not in dict2 yet
            dict2.put(doc2[i], 1);
        }
        else if(dict2.containsKey(doc2[i])) { //word is in dict2
            dict2.put(doc2[i], dict2.get(doc2[i]) + 1);
        }

        if(!dict1.containsKey(doc2[i])) { //word is not in dict1
            dict1.put(doc2[i], 0);
        }


    }
   

    int dotProduct =1;
    int doc1sq = 1;
    int doc2sq = 1;
    for(int i=0; i<doc1.length ;i++) {
        dotProduct = dotProduct + (dict1.get(doc1[i])) * (dict2.get(doc1[i]));
        doc1sq = doc1sq +  (dict1.get(doc1[i])) *  (dict1.get(doc1[i]));
        doc2sq = doc2sq +  (dict2.get(doc1[i])) *  (dict2.get(doc1[i]));    
    }

    double similarity = dotProduct / Math.sqrt(doc1sq*doc2sq);
    
    return similarity;

}

}