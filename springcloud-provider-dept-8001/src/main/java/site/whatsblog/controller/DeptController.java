package site.whatsblog.controller;

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
    public Dept get(@PathVariable long id){
        return deptService.selectByPrimaryKey(id);
    }

    @GetMapping("/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

}
