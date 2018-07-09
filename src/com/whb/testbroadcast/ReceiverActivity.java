package com.whb.testbroadcast;  
  
import android.app.Activity;  
import android.content.BroadcastReceiver;  
import android.content.Context;  
import android.content.Intent;  
import android.content.IntentFilter;  
import android.net.wifi.WifiManager;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
  
public class ReceiverActivity extends Activity {  
     private IntentFilter mIntentFilter;  
      
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  
        mIntentFilter = new IntentFilter();  
        mIntentFilter.addAction("com.android.my.action");  
        mIntentFilter.addAction("com.android.my.action.sticky");  
  
              
    }  
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {  
  
        @Override  
        public void onReceive(Context context, Intent intent) {  
            final String action = intent.getAction();  
            System.out.println("action="+action);  
              
        }  
    };  
      
    @Override  
    protected void onResume() {  
        // TODO Auto-generated method stub  
        super.onResume();  
        registerReceiver(mReceiver, mIntentFilter);  
    }  
      
    @Override  
    protected void onPause() {  
        // TODO Auto-generated method stub  
        super.onPause();  
        unregisterReceiver(mReceiver);  
    }  
            
}