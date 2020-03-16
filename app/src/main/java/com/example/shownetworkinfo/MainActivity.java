package com.example.shownetworkinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView detailsActiveNetwork, typeActiveNetwork;

        //Obtain TextViews
        detailsActiveNetwork = findViewById(R.id.detailsActiveNetwork);
        typeActiveNetwork = findViewById(R.id.typeActiveNetwork);

        //Get connectivity service
        ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        //Get information of the active Network
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null) {
            typeActiveNetwork.setText("Any network avaliable");
        } else if (networkInfo.getType() == connectivityManager.TYPE_WIFI) {
            typeActiveNetwork.setText("Connected by Wifi");
        } else if (networkInfo.getType() == connectivityManager.TYPE_MOBILE) {
            typeActiveNetwork.setText("Connected by Mobile");
        } else {
            typeActiveNetwork.setText("Any network connected");
        }
    }
}
