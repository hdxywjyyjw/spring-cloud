package xu.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xu.clients.UserClient;
import xu.mapper.OrderMapper;
import xu.pojo.Order;
import xu.pojo.User;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;

    public Order queryById(Long id) {
        Order byId = orderMapper.findById(id);
        Object map = restTemplate.getForObject("http://userserver/user/"+byId.getUserid(),Object.class);
        byId.setUser(map);
        return byId;
    }

    public Order queryByIdForFeign(Long id) {
        Order byId = orderMapper.findById(id);
        User user = userClient.queryByIdForFeign(Long.parseLong(byId.getUserid()));
        byId.setUser(user);
        return byId;
    }
}