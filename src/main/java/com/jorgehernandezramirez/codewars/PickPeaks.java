package com.jorgehernandezramirez.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickPeaks {

    public static Map<String,List<Integer>> getPeaks(int[] arr) {
        final Map<String, List<Integer>> mapToReturn = new HashMap<String, List<Integer>>(){{
            put("pos", new ArrayList<Integer>());
            put("peaks", new ArrayList<Integer>());
        }};
        Integer counter = 0;
        Integer counterCantidate = 0;
        Boolean someDescent = false;
        while(counter < arr.length - 1){
            while(counter < arr.length - 1 && arr[counter + 1] > arr[counter]){
                counter++;
                counterCantidate = counter;
            }
            while(counter < arr.length - 1 && arr[counter + 1] <= arr[counter]){
                someDescent = someDescent | arr[counter + 1] < arr[counter];
                counter++;
            }
            if(counterCantidate > 0 && counterCantidate < arr.length - 1 && someDescent) {
                mapToReturn.get("pos").add(counterCantidate);
                mapToReturn.get("peaks").add(arr[counterCantidate]);
            }
            someDescent = false;
        }
        return mapToReturn;
    }
}
