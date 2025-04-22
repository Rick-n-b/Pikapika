package com.example.pikapika;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.pikapika.poke.Pikapika;
import com.example.pikapika.poke.Pokemon;

import java.io.IOException;
import java.util.Arrays;

public class ListFragment extends Fragment {

     public interface OnFragmentSendDataListener {
        void onSendData(Pokemon data);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Pikapika pikapika = new Pikapika();
        View view = inflater.inflate(R.layout.list, container, false);
        ListView countriesList = view.findViewById(R.id.countriesList);
        pikapika.listView = countriesList;
        pikapika.fragmentSendDataListener = fragmentSendDataListener;
        pikapika.execute();
        return view;
    }

}
