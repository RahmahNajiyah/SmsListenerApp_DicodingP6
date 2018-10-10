package com.hafidzqode.smslistenerapp_dicodingp6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//latihan broadcast sederhana dalam 2 bagian (part 1 & 2)

//todo 2 part 2
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnDownload;
    public static final String ACTION_DOWNLOAD_STATUS = "download_status";
    private BroadcastReceiver downloadReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Incoming Message");
        btnDownload = (Button) findViewById(R.id.btn_download);
        btnDownload.setOnClickListener(this);
        downloadReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Download Selesai", Toast.LENGTH_SHORT).show();
            }
        };
        IntentFilter downloadIntentFilter = new IntentFilter(ACTION_DOWNLOAD_STATUS);
        registerReceiver(downloadReceiver, downloadIntentFilter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_download){
            //todo 4 part2
            Intent downloadServiceIntent = new Intent(this, DownloadService.class);
            startService(downloadServiceIntent);

        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (downloadReceiver != null){
            unregisterReceiver(downloadReceiver);
        }
    }
}

//hasil latihan broadcast sederhana 1
//Silakan jalankan aplikasi Anda.
//Cobalah mengirim SMS ke device Android Anda dan perhatikan hasilnya.
//Setiap SMS yang masuk akan ditampilkan langsung dilayar. Keren bukan?!


//hasil latihan broadcast sederhana 2
//Sekarang jalankan aplikasi Anda dan klik pada tombol ‘Download File’
//dan lihat pada log Android Monitor di Android Studio Anda.
//Pada log akan ada output sepert ini.
//D/DownloadService: Download Service d ijalankan