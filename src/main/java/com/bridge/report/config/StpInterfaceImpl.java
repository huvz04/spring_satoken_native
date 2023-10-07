package com.bridge.report.config;

import cn.dev33.satoken.stp.StpInterface;
import com.bridge.report.mapper.RoleMapper;
import com.bridge.report.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限加载接口实现类
 */
@Component // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RoleMapper roleMapper;


    @Resource
    private UserMapper  userMapper;

    /**
     * 返回一个账号所拥有的权限码集合 
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return new ArrayList<String>();
    }

    /**
     * 返回一个账号所拥有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {


        List<String> list = new ArrayList<>();
        List<String> roleList = roleMapper.selectRoleValueByList(Integer.parseInt(loginId.toString()));
        return roleList;
    }

}