package xu.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xu.pojo.User;

@FeignClient(value = "userserver")
public interface UserClient {

    @GetMapping("/user/{id}")
    User queryByIdForFeign(@PathVariable("id") Long id);
}
