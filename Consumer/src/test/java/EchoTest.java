import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.hikvision.Application;
import com.hikvision.person.Person;
import com.hikvision.person.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zouzhilong
 * @date 2019/11/25 15:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EchoTest {
    @Reference(interfaceClass = PersonService.class,version = "1.0.1",group = "service2")
    private PersonService service;
    @Test
    public void echoTest() {
        System.out.println(service);
        EchoService echoService = (EchoService) service;
        String status = (String) echoService.$echo("ok");
        Person p = service.get(1);
        System.out.println(p);
        Assert.assertTrue("ok".equals(status));
    }

    @Test
    public void genericTest() {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setInterface("com.hikvision.person.PersonService");
        reference.setGeneric(true);
        reference.setVersion("1.0.1");
        reference.setGroup("service2");
        GenericService service = reference.get();
        Object person = service.$invoke("get", new String[]{"int"}, new Object[]{1});
        Assert.assertNotNull("返回结果非空", person);

    }

    @Test
    public void tokeTest() {
        ReferenceConfig reference = new ReferenceConfig();
        reference.setCheck(true);
        reference.setInterface("com.hikvision.person.PersonService");
        reference.setVersion("1.0.1");
        reference.setGroup("service2");
        RpcContext.getContext().setAttachment("token", "123456");

    }
}
