package xu.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Order {
    private Long id;
    private String name;
    private String pice;
    private String userid;
    private Object user;
}