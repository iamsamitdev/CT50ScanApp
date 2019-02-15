package com.itgenius.ct50scanapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// HoneyWell Library
import com.honeywell.aidc.AidcManager;
import com.honeywell.aidc.AidcManager.CreatedCallback;
import com.honeywell.aidc.BarcodeReader;

public class MainActivity extends AppCompatActivity {

    private static  BarcodeReader barcodeReader;
    private  AidcManager manager;

    private Button btnAutomaticBarcode;
    private Button btnClientBarcode;
    private Button btnScannerSelectBarcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // when orientation changes
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // create the AidcManager providing a Context and a
        // CreatedCallback implementation.
        AidcManager.create(this, new CreatedCallback() {
            @Override
            public void onCreated(AidcManager aidcManager) {
                manager = aidcManager;
                barcodeReader = manager.createBarcodeReader();
            }
        });

        btnScannerSelectBarcode = findViewById(R.id.buttonScannerSelectBarcode);
        btnScannerSelectBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent barcodeIntent = new Intent( "android.intent.action.SCANNERSELECTBARCODEACTIVITY");
                startActivity(barcodeIntent);
            }
        });

    }

    static BarcodeReader getBarcodeObject(){
        return  barcodeReader;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (barcodeReader != null) {
            // close BarcodeReader to clean up resources.
            barcodeReader.close();
            barcodeReader = null;
        }

        if (manager != null) {
            // close AidcManager to disconnect from the scanner service.
            // once closed, the object can no longer be used.
            manager.close();
        }
    }
}
