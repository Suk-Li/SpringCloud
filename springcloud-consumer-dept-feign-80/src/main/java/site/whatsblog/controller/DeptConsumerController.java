package site.whatsblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import site.whatsblog.pojo.Dept;

import java.util.List;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/30 13:49</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@RestController
public class DeptConsumerController {
    /* 消费者不应该有service层
     RestTemplate ... 供我们直接调用！注册到Spring中
     (url,实体Map,Class<T> responseType)
     */

    @Autowired
    private RestTemplate restTemplate;
    //提供多种边界访问远程http服务的方法，简单的restful模板

//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    // Ribbon配置，这里的地址应该是一个变量，通过服务名访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public Integer addDept(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add/", dept, Integer.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }


}
