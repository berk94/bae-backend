package com.kurye.kurye.network;

/**
 * Generic callback for network requests
 *
 * Handles basic success and failure scenarios
 *
 * Created by ahmet on 2/4/2018.
 */
public abstract class NetworkCallback<R> {
    public abstract void onSuccess(R response);

    public abstract void onServiceFailure(int httpResponseCode, String message);

    public abstract void onNetworkFailure(Throwable message);
}
