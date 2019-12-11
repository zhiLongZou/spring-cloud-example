package com.hikvision.stub;

import com.hikvision.person.Person;
import com.hikvision.person.PersonService;

/**
 * @author zouzhilong
 * @date 2019/11/26 9:56
 */

public class PersonServiceStub implements PersonService {
    private PersonService service;

    public PersonServiceStub(PersonService service) {
        this.service = service;
    }

    @Override
    public Person get(int i) {
        if (i < 10) {
            System.out.println("年龄不能小于10");
            return null;
        }
        return service.get(i);
    }
}
