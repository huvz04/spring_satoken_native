package com.bridge.report.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.bridge.report.entity.SysUser;
import com.bridge.report.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysUserController{


    @Resource
    private UserMapper userMapper;


    @GetMapping("/doLogin")
    public SaResult doLogin(@RequestParam("username") String username, @RequestParam("password") String pwd){
        SysUser sysUser = userMapper.queryUserByName(username);
        if(sysUser==null) return SaResult.error("登录失败，用户不存在");
        if( sysUser.getPassword().equals(pwd)) {
            // 第二步：根据账号id，进行登录
            StpUtil.login(sysUser.getId());
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登陆失败，请检查密码是否正确");
    }

    @GetMapping("/getLoginRole")
    public  SaResult loginroleList(){
        return new SaResult(200,"请求成功",StpUtil.getRoleList());
    }

    @GetMapping("/listUser")
    public  SaResult listUser(){
        List<SysUser> list = userMapper.selectList();
        System.out.println(list);
        return new SaResult(200,"请求成功",list);
    }

    @GetMapping("/throw")
    public SaResult throwU(String str) throws Exception {
        if(str==null) throw new Exception("测试全局异常拦截");
        return SaResult.ok("正常");
    }

    @PostMapping("/insertUser")
    public  SaResult init(@RequestParam("name") String name,@RequestParam("password") String password){
        try {
            name = name.trim();
            password = password.trim();
            if(name.equals("admin")) return SaResult.error("不允许添加管理员");
            userMapper.insert(name,password);
        }catch (Exception e)
        {
            return SaResult.error("添加失败，请检查是否存在相同用户");
        }

        return SaResult.ok("插入成功");
    }
}