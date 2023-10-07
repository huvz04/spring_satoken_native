package com.bridge.report.mapper;

import com.bridge.report.entity.SysRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    /**
     * 查询所有的角色
     * @return List<SysUser>
     */
    @Select("select id,name,value from role")
    List<SysRole> selectList();

    /**
     * id获取单独角色信息
     * @return SysUser
     */
    @Select("select id,name,value from role where id = #{id} limit 1")
    SysRole selectById(@Param("id") int id);
    /**
     * 查询指定名称的角色
     * @return SysUser
     */
    @Select("select id,name,data_range from role where name = #{name} limit 1")
    SysRole queryUserByName(@Param("name") String username);
    /**
     * 新增角色
     */
    void insert(SysRole sysRole);

    /**
     * 通过id获取用户的所有角色value
     * @return List<String>
     */
    List<String> selectRoleValueByList(@Param("id") Integer id);
    /**
     * 删除用户
     */
    @Delete("delete from role where id = #{id}")
    void delete(@Param("id") int id);


}