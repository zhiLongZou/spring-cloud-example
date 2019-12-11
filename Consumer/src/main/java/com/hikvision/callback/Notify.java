package com.hikvision.callback;

import com.hikvision.person.Person;

/**
 * @author zouzhilong
 * @date 2019/11/25 19:07
 */

public interface Notify {
    public void onreturn(Person msg, Integer id);

    public void onthrow(Throwable ex, Integer id);
}
