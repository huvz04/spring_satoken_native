package com.bridge.report.mapper;

import com.bridge.report.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper{
    /**
     * 查询所有的用户 selectList
     * @return List<SysUser>
     */
    @Select("select id,name,password from user")
    List<SysUser> selectList();
    /**
     * 查询指定名称的用户 select
     * @return SysUser
     */
    @Select("select id,name,password from user where name = #{name} limit 1")
    SysUser queryUserByName(@Param("name") String username);
    /**
     * 新增用户 insert into
     */
    @Insert(" insert into user (name, password) values (#{name}, #{password})")
    void insert(@Param("name") String name,@Param("password") String password);

    /**
     * 删除用户
     */
    @Delete("delete from user where id = #{id}")
    void delete(@Param("id") int id);

    /**
     * 查询指定名称的用户 select
     * @return List
     */
    @Select("select role_id from role_user where user_id = #{id}")
    List<Integer> selectRoleList(@Param("id") int id);
    /**
     * 更新密码
     */
    @Delete("update user set password = #{password} where id = #{id}")
    void update(@Param("id") int id,@Param("password")String password);
}