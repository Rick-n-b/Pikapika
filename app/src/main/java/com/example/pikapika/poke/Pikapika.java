package com.example.pikapika.poke;



import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;

import com.example.pikapika.ListFragment;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class Pikapika extends AsyncTask<Void, Void, ArrayList<Pokemon>> {

    @Override
    protected ArrayList<Pokemon> doInBackground(Void... voids) {
        try {
            pokemons.clear();
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            pokemonBase = objectMapper.readValue(new URL("https://pokeapi.co/api/v2/pokemon/"), PokemonBase.class);
            str = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pokemonBase);
            System.out.println(str);
            for (result result : pokemonBase.results) {
                JsonNode jsonNode = objectMapper.readTree(new URL(result.url.toString()));
                pokemons.add(new Pokemon(jsonNode.get("name").asText(), jsonNode.get("weight").asInt(), jsonNode.get("height").asInt()));
            }
            return pokemons;
        }catch (Exception e){
            throw new ClassCastException("aaaaaaaaaaaaaaaaaa");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onPostExecute(ArrayList<Pokemon> pokemons) {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(listView.getContext(), android.R.layout.simple_list_item_1, pokemonBase.resultsToString());
        System.out.print(Arrays.toString(pokemonBase.resultsToString()));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Pokemon pokemon = pokemons.get(position);
                //String selectedItem = (String)parent.getItemAtPosition(position);
                fragmentSendDataListener.onSendData(pokemon);
            }
        });
    }

    String str;
    public ListView listView;
    public PokemonBase pokemonBase = new PokemonBase();
    public ArrayList<Pokemon> pokemons = new ArrayList<>();

    public ListFragment.OnFragmentSendDataListener fragmentSendDataListener;
    public void conf()  {

    }


}
