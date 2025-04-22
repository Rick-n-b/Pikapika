package com.example.pikapika.poke;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

@JsonIgnoreProperties
public class PokemonBase {

    public int count;
    public URL next;
    public URL previous;
    private String name;
    private URL url;
    public result[] results;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    public String[] resultsToString(){
        ArrayList<String> res = new ArrayList<>();
        for(result result : results){
            res.add(result.toString());
        }
        String[] str = new String[res.toArray().length];
        return res.toArray(str);
    }

    @Override
    public String toString() {
        String str = "count: " + count +
                "\nnext: " + next +
                "\nprevious: " + previous +
                "\nresults: " + Arrays.toString(results) + "\n---------------\n";
        return str;
    }
}
