package com.hikvision.person;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hikvision.callback.CallBackService;
import com.hikvision.callback.CallbackListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zouzhilong
 * @date 2019/11/1 15:22
 */

@RestController
public class PersonController {

    /*@Reference(interfaceClass = PersonService.class, version = "1.0.1", check = true, group = "service2")*/
    @Autowired
    private PersonService personService;

    @Reference(interfaceClass = CallBackService.class, callbacks = 1000,check = false)
    private CallBackService callBackService;

    @GetMapping(value = "/person")
    public Person findById(@RequestParam("id") int id) {
        Person person = personService.get(id);
        return person;
    }

    @PostMapping(value = "/person")
    public String savePerson(@RequestBody Person person) {
        System.out.println(person);
        return person.toString();
    }

    @GetMapping(value = "/callback")
    public void testCallback() {
        callBackService.addListener("hik", new CallbackListener() {
            @Override
            public void changed(String message) {
                System.out.println("callback1:" + message);
            }
        });

    }
}
