package com.example.cetakfotoku;

import java.util.ArrayList;
import java.util.List;

public class KatalogFotoUtil {

    private  static int[] ridArray = {
            R.drawable.illustration1,
            R.drawable.illustration2,
            R.drawable.illustration3,
            R.drawable.illustration4,
            R.drawable.illustration5
    };

    private static String[] filenameArray = {
            "illustration1",
            "illustration2",
            "illustration3",
            "illustration4",
            "illustration5"
    };

    private static List<KatalogFoto> katalogFotoList;

    public static void init(){
        katalogFotoList = new ArrayList<>();
        int nArray = ridArray.length;
        for (int i = 0; i < nArray; i++){
            katalogFotoList.add(new KatalogFoto(ridArray[i], filenameArray[i]));
        }
    }

    public static List<KatalogFoto> getKatalogFotoList(){
        return katalogFotoList;
    }

    public static KatalogFoto getKatalogFotoAt(int i){
        return katalogFotoList.get(i);
    }
}
