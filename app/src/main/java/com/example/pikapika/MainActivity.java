package com.example.pikapika;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pikapika.poke.Pokemon;

public class MainActivity extends AppCompatActivity  implements ListFragment.OnFragmentSendDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSendData(Pokemon selectedItem) {
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailFragment);
        System.out.println("Hello");
        if (fragment != null)
            fragment.setSelectedItem(selectedItem);
    }
}
