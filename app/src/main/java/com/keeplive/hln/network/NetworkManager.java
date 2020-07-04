package com.keeplive.hln.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;

import com.keeplive.hln.App;
import com.keeplive.hln.receiver.NetStateReceiver;


public class NetworkManager {

    private NetStateReceiver receiver;
    private ConnectivityManager cmgr;
    private NetworkCallbackImpl networkCallback;
    private static volatile NetworkManager instance;

    private NetworkManager() {
       // receiver = new NetStateReceiver();
    }

    public static NetworkManager getInstance() {
        if (instance == null) {
            synchronized (NetworkManager.class) {
                if (instance == null) {
                    instance = new NetworkManager();
                }
            }
        }
        return instance;
    }

    public NetworkManager init() {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            IntentFilter filter = new IntentFilter();
//            filter.addAction(Constants.ACTION_CONNECTIVITY_CHANGE);
//            App.applicationContext.registerReceiver(receiver, filter);
//        } else {
//            networkCallback = new NetworkCallbackImpl();
//            NetworkRequest request = new NetworkRequest.Builder().build();
//            cmgr = (ConnectivityManager) App.applicationContext
//                    .getSystemService(Context.CONNECTIVITY_SERVICE);
//            if (cmgr != null) {
//                cmgr.registerNetworkCallback(request,networkCallback);
//            }
//        }
        networkCallback = new NetworkCallbackImpl();
        NetworkRequest request = new NetworkRequest.Builder().build();
        cmgr = (ConnectivityManager) App.applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cmgr != null) {
            NetworkInfo networkInfo= cmgr.getActiveNetworkInfo();
            cmgr.registerNetworkCallback(request, networkCallback);
        }
        return this;
    }

    /**
     * isConnected()	判断网络连接是否存在
     isAvailable()	判断网络连接（注：isConnected为true，不代表isAvailable为true）
     getDetailedState()	（详细）报告当前网络状态 getState()报告当前网络状态
     getExtrInfo()	报告关于网络状态的额外信息，由较低的网络层提供的
     getType()	获取当前网络的类型 和ConnectivityManager.TYPE_**对比
     getTypeName()	获取当前网络的类型名如 “WIFI” or “MOBILE”
     * @return
     */

    public ConnectivityManager getConnectivityManager() {
        return cmgr;
    }

    public void registerObserver(Object object) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            receiver.registerObserver(object);
//        } else {
//        }
        networkCallback.registerObserver(object);

    }

    public void unRegisterObserver(Object object) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            receiver.unRegisterObserver(object);
//        }else{
//        }
        networkCallback.unRegisterObserver(object);

    }

    public void unRegisterAllObserver() {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            receiver.unRegisterAllObserver();
//        }else {
//        }
        networkCallback.unRegisterAllObserver();

    }


}
