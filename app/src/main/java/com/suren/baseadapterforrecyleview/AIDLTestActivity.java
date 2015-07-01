package com.suren.baseadapterforrecyleview;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.material.mao.materialstudy.ICal;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by OA on 2015/6/25.
 */
public class AIDLTestActivity extends AppCompatActivity {


    @OnClick(R.id.btn_bind)
    void bind(){
        Intent intent = new Intent();
        intent.setAction("com.material.mao.materialstudy.ICal.aidl");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @OnClick(R.id.btn_unbind)
    void unbind(){
        unbindService(serviceConnection);
    }

    @OnClick(R.id.btn_add)
    void add(){
        try {
            if (mCalcAidl != null) {
                int addRes = 0;
                addRes = mCalcAidl.add(12, 12);
                Toast.makeText(getApplicationContext(), addRes + "", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "服务器被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT).show();
            }
        }catch(RemoteException e){
            e.printStackTrace();
        }
    }

    @OnClick(R.id.btn_min)
    void min(){
        try {
            if (mCalcAidl != null) {
                int minRes = 0;
                minRes = mCalcAidl.min(12, 12);
                Toast.makeText(getApplicationContext(), minRes + "", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "服务器被异常杀死，请重新绑定服务端", Toast.LENGTH_SHORT).show();
            }
        }catch(RemoteException e){
            e.printStackTrace();
        }
    }

    private ICal mCalcAidl;
    private ServiceConnection serviceConnection = new ServiceConnection()
    {
        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            Log.e("client", "onServiceDisconnected");
            mCalcAidl = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            Log.e("client", "onServiceConnected");
            mCalcAidl = ICal.Stub.asInterface(service);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        ButterKnife.inject(this);
    }
}
