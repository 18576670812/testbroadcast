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
 * ��MainActivity�������sendBroadcast��sendStickyBroacat
 * ��ReceverActivity����ͨ ��BroadcastReceiver��������������Ϣ��
 * ��ReceiverActivity����ͨ��������ע��Receiver�������� Manifest����ע��ġ�
 * ����ͨ��sendBroadcast�з�����intent��ReceverActivity������Resume״̬���޷����ܵ��ģ�
 * ��ʹ�����ٴ�ʹ�䴦�ڸ�״̬Ҳ�޷����յ�����sendStickyBroadcast������Intent
 * ��ReceverActivity�� �´���Resume״̬֮��������½��ܵ���Intent.
 * �����the Intent will be held to be re-broadcast to future receivers��仰�ı��֡�
 * Ҳ����˵sendStickyBroadcast���������һ��Intent�ᱻ�������´ε�Receiver���ڻ�Ծ��ʱ��
 * �ֻ���յ���
 * 
 * */
