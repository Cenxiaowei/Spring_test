package controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * Created by cxw15 on 2020/4/28.
 */
@RestController
@RequestMapping(value = "/in")
public class userController {

    private static final Logger logger = LoggerFactory.getLogger(userController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test")
    public String test2(){
        logger.info("--疯狂输出啦----------");
        return  "666666";

    }

    @GetMapping(value = "/info/{name}")
    @HystrixCommand(fallbackMethod = "fallBackXiaoWei")
    public String test(@PathVariable String name){
//        String name ="岑校炜66";
        logger.info(name+"--疯狂输出啦----------");
        return  this.restTemplate.getForObject("http://eureka-order/welcome/who/"+name,String.class);

    }



    public  String fallBackXiaoWei(@PathVariable String name){
        logger.info("断路器生效-------");
        return name+"---返回良好信息";
    }
}
