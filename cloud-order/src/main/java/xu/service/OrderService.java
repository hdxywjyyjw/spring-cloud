package xu.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xu.mapper.OrderMapper;
import xu.pojo.Order;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Order queryById(Long id) {
        Order byId = orderMapper.findById(id);
        Object map = restTemplate.getForObject("http://userserver/user/"+byId.getUserid(),Object.class);
        byId.setUser(map);
        return byId;
    }
}