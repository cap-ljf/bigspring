package org.capljf.bigspring.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.capljf.bigspring.dto.User;

import java.util.List;

/**
 * @author jifang.liu created on 2019/5/3 15:14
 */
@Mapper
public interface UserMapper {

//    @Select("SELECT * FROM USER WHERE NAME = #{name}")
//    User findByName(@Param("name") String name);
//
//    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
//    int insert(@Param("name") String name, @Param("age") Integer age);

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();

}
