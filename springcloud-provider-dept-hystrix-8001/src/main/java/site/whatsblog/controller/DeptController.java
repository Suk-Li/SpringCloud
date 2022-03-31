package site.whatsblog.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.whatsblog.pojo.Dept;
import site.whatsblog.service.DeptService;

import java.util.List;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/30 11:10</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;



    @PostMapping("/add")
    public Integer addDept(Dept dept){
        if (!StringUtil.isEmpty(dept.getDname())) {
            return deptService.insert(dept);
        }
        return 0;
    }

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable long id){
        Dept dept = deptService.selectByPrimaryKey(id);
        if (dept==null){
            throw new RuntimeException("id=>"+id+",不存在该用户！");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable long id){
        return new Dept()
                .setDeptno(id)
                .setDname("不存在该用户,null--@Hystrix")
                .setDbSource("没哟这个数据库！");
    }

    @GetMapping("/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

}
