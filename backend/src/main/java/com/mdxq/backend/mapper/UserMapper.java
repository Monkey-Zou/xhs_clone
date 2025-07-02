package com.mdxq.backend.mapper;

import com.mdxq.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {
//    通过id寻找用户
    User selectById(Long id);

    User selectByUsername(String username);

    int insertUser(User user);

    //更改用户信息
    int updateUser(User user);



    int updateProfile(@Param("id") Long id,
                      @Param("nickname") String nickname,
                      @Param("avatar") String avatar,
                      @Param("gender") Integer gender,
                      @Param("bio") String bio,
                      @Param("email") String email);
}
