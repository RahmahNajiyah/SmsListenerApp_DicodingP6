package com.hafidzqode.smslistenerapp_dicodingp6;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */

//todo 3 part 2 make a IntentService
//package utama project ⇒ new ⇒ Service ⇒ IntentService.
public class DownloadService extends IntentService {
    public static final String TAG = "DownloadService";
    public DownloadService(){
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "Download Service dijalankan");
        if (intent != null){
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent notifyFinishIntent = new Intent(MainActivity.ACTION_DOWNLOAD_STATUS);
            sendBroadcast(notifyFinishIntent);
        }
    }
}
