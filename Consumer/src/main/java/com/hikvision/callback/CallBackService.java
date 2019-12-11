package com.hikvision.callback;

/**
 * @author zouzhilong
 * @date 2019/11/25 16:06
 */

public interface CallBackService {
    void addListener(String key, CallbackListener listener);

}
