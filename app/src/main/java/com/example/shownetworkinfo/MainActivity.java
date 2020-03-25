package com.example.shownetworkinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call AsynTask for check the network
        new UpdateNetworkInformationTask().execute();
    }

    private class UpdateNetworkInformationTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... voids) {

            String[] result = new String[2];

            ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null) {
                result[0] = networkInfo.toString().split(",")[0] + "\n" +
                        networkInfo.toString().split(",")[1] + "\n" +
                        networkInfo.toString().split(",")[2] + "\n" +
                        networkInfo.toString().split(",")[3];

                if (networkInfo.isConnected()) {
                    if (networkInfo.getType() == connectivityManager.TYPE_WIFI) {
                        result[1] = "Wifi connected!";
                    }
                    if (networkInfo.getType() == connectivityManager.TYPE_MOBILE) {
                        result[1] = "Mobile connected!";
                    }
                }
                else {
                    result[1] = "No network connected!!";
                }
            }
            else {
                result[0] = "No details avaliable!!";
                result[1] = "No network operating!!";
            }
            return result;
        }

        @Override
        protected void onPostExecute(String[] result) {
            TextView detailsActiveNetwork, typeActiveNetwork;

            detailsActiveNetwork = findViewById(R.id.detailsActiveNetwork);
            typeActiveNetwork = findViewById(R.id.typeActiveNetwork);

            detailsActiveNetwork.setText(result[0]);
            typeActiveNetwork.setText(result[1]);
        }
    }
}
