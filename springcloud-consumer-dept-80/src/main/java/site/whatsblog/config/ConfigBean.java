package site.whatsblog.config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/30 13:53</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@Configuration
public class ConfigBean {
    //配置负载均衡实现RestTemplate
    @Bean
    @LoadBalanced  //Ribbon  IRule  AvailabilityFilterRule:先过滤掉跳闸的服务，对剩下的进行轮询 RoundRobinRule:轮询 RetryRule:先找轮询获取服务，如果服务获取失败，会在指定时间内进行重试
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
