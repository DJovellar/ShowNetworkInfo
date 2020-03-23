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

        detailsActiveNetwork = findViewById(R.id.detailsActiveNetwork);
        typeActiveNetwork = findViewById(R.id.typeActiveNetwork);

        ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null) {
            detailsActiveNetwork.setText(
                    networkInfo.toString().split(",")[0] + "\n" +
                    networkInfo.toString().split(",")[1] + "\n" +
                    networkInfo.toString().split(",")[2] + "\n" +
                    networkInfo.toString().split(",")[3]);

            if (networkInfo.isConnected()) {
                if (networkInfo.getType() == connectivityManager.TYPE_WIFI) {
                    typeActiveNetwork.setText("Wifi connected!");
                }
                if (networkInfo.getType() == connectivityManager.TYPE_MOBILE) {
                    typeActiveNetwork.setText("Mobile connected!");
                }
            }
            else {
                typeActiveNetwork.setText("No network connected!!");
            }
        }
        else {
            typeActiveNetwork.setText("No network operating!!");
        }
    }
}
