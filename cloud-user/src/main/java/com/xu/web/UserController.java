package com.xu.web;

import com.xu.config.PatternProperties;
import com.xu.pojo.User;
import com.xu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/user")
// @RefreshScope
public class UserController {

    @Autowired
    private UserService userService;
//    @Value("${hahaCeshi}")
//    private String hahaCeshi;
    @Autowired
    private PatternProperties patternProperties;

    // @Value("${pattern.dateformat}")
    // private String dateformat;

//    @Autowired
//    private PatternProperties properties;

//    @GetMapping("prop")
//    public PatternProperties properties(){
//        return properties;
//    }

//    @GetMapping("now")
//    public String now(){
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
//    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")

    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println("truth: " + truth);
//        System.out.println("hahaCeshi: " + hahaCeshi);
//        System.out.println("hahahaha:"+patternProperties.getHahah());
//        System.out.println("xixixi:"+patternProperties.getXixixi());
        return userService.queryById(id);
    }

}
