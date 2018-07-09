package com.whb.testbroadcast;

import android.view.Menu;
import android.app.Activity;  
import android.content.Context;  
import android.content.Intent;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
  
public class MainActivity extends Activity {  
    Button btnSendi;  
    Button btnSends;  
    Button btnStart;  
    Context mContext;  
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        btnSendi=(Button) findViewById(R.id.sendi);  
        btnSends=(Button) findViewById(R.id.sends);  
        btnStart=(Button) findViewById(R.id.start);  
        mContext=getApplicationContext();  
        btnSendi.setOnClickListener(new OnClickListener(){  
 
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                Intent intent = new Intent();  
                intent.setAction("com.android.my.action");  
                intent.setFlags(1);  
                mContext.sendBroadcast(intent);  
            }  
              
        });  
          
        btnStart.setOnClickListener(new OnClickListener(){  
  
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                Intent intent = new Intent(MainActivity.this,ReceiverActivity.class);  
                 
                startActivity(intent);  
            }  
              
        });  
          
        btnSends.setOnClickListener(new OnClickListener(){  
  
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                Intent intent = new Intent();  
                intent.setAction("com.android.my.action.sticky");  
                intent.setFlags(2);  
                mContext.sendStickyBroadcast(intent);  
            }  
              
        });  
    }  
}

/*
 * 
 * 在MainActivity里面会有sendBroadcast和sendStickyBroacat
 * 在ReceverActivity里面通 过BroadcastReceiver来接收这两个消息，
 * 在ReceiverActivity里是通过代码来注册Receiver而不是在 Manifest里面注册的。
 * 所以通过sendBroadcast中发出的intent在ReceverActivity不处于Resume状态是无法接受到的，
 * 即使后面再次使其处于该状态也无法接收到。而sendStickyBroadcast发出的Intent
 * 当ReceverActivity重 新处于Resume状态之后就能重新接受到其Intent.
 * 这就是the Intent will be held to be re-broadcast to future receivers这句话的表现。
 * 也就是说sendStickyBroadcast发出的最后一个Intent会被保留，下次当Receiver处于活跃的时候，
 * 又会接收到它
 * 
 * */
