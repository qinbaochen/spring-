package top.noobchen.springshiro.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.noobchen.springshiro.entry.User;

@Repository
@Mapper
public interface UserMapper {
    @Select("select * from user where name = #{name}")
    User findUserByName(String name);
}
