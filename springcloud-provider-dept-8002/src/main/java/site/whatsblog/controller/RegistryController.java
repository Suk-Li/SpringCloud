package site.whatsblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/30 15:51</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@RestController
@RequestMapping("/registry")
public class RegistryController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/services")
    public Object getServices(){
        return discoveryClient.getServices();
    }
    @RequestMapping("/instances/{serviceId}")
    public Object getInstances(@PathVariable String serviceId){
        return discoveryClient.getInstances(serviceId);
    }
}
