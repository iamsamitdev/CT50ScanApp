package com.itgenius.ct50scanapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.honeywell.aidc.*;
import com.honeywell.aidc.AidcManager.BarcodeDeviceListener;
import com.honeywell.aidc.AidcManager.CreatedCallback;

public class ScannerSelectionBarcodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_selection_barcode);
    }
}
