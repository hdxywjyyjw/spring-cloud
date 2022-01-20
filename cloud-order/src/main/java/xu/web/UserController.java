package xu.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xu.pojo.Order;
import xu.service.OrderService;


@Slf4j
@RestController
@RequestMapping("/order")
// @RefreshScope
public class UserController {

    @Autowired
    private OrderService orderService;

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
    public Order queryById(@PathVariable("id") Long id,
                           @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println("truth: " + truth);
        return orderService.queryById(id);
    }

    @GetMapping("/feign/{id}")
    public Order queryByIdForFeign(@PathVariable("id") Long id,
                           @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println("truth: " + truth);
        return orderService.queryByIdForFeign(id);
    }

}
