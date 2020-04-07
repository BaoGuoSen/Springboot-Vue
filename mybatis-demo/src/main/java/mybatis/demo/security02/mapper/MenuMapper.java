package mybatis.demo.security02.mapper;

import org.apache.ibatis.annotations.Mapper;
import mybatis.demo.security02.model.Menu;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> getAllMenus();
}
