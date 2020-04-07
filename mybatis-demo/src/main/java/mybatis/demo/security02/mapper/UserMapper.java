package mybatis.demo.security02.mapper;

import org.apache.ibatis.annotations.Mapper;
import mybatis.demo.security02.model.Role;
import mybatis.demo.security02.model.User;
import mybatis.demo.security02.model.user_role;

import java.util.List;

@Mapper
public interface UserMapper {
	
    User loadUserByUsername(String username);
    List<Role> getUserRolesByUid(Integer id);
    
    void addStudent(User user);
    void addTeacher(User user);
    
    void adduser_role2(user_role user_role);
    void adduser_role1(user_role user_role);
    

}
