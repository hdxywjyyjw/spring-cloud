package xu.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xu.pojo.Order;

public interface OrderMapper {
    
    @Select("select * from tb_order where id = #{id}")
    Order findById(@Param("id") Long id);
}