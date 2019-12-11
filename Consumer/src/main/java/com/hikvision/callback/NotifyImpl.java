package com.hikvision.callback;

import com.hikvision.person.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zouzhilong
 * @date 2019/11/25 19:08
 */

public class NotifyImpl implements Notify {
    public Map<Integer, Person> ret = new HashMap<Integer, Person>();
    public Map<Integer, Throwable> errors = new HashMap<Integer, Throwable>();

    @Override
    public void onreturn(Person msg, Integer id) {
        System.out.println("onreturn: " + msg);
        ret.put(id, msg);
    }

    @Override
    public void onthrow(Throwable ex, Integer id) {
        errors.put(id, ex);
    }
}
