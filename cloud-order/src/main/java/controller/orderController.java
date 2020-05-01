package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cxw15 on 2020/4/28.
 */

@RestController
@RequestMapping(value = "/welcome")
public class orderController {

    private static final Logger Logger=LoggerFactory.getLogger(orderController.class);

    @RequestMapping(value = "/who/{name}",method =RequestMethod.GET)
    public String WelCome(@PathVariable String name){
        Logger.info("来了来了，他们来了33--"+name);
        return "欢迎你--"+name;
    }
}
