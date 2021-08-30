package com.shen.login.controller;


import com.shen.login.dao.TbUserDao;
import com.shen.login.entity.TbUser;
import com.shen.login.request.UserInfoRequest;
import com.shen.login.utils.ResultDto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
public class UserController {

    @Autowired
    TbUserDao tbUserDao;

    @Autowired
    MapperFacade mapperFacade;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/user")
    public ResultDto<List<TbUser>> allUser(){
        List<TbUser> tbUsers = tbUserDao.queryAll(new TbUser());
        ResultDto<List<TbUser>> tbUserResultDto = new ResultDto<List<TbUser>>(tbUsers);
        return tbUserResultDto;
    }


    /**
     * @param userinfoRequest
     */
    @PostMapping("/registerUser")
    public ResultDto registerUser(@RequestBody UserInfoRequest userinfoRequest){

        TbUser tbUser = tbUserDao.queryByUsername(userinfoRequest.getUsername());
        if (tbUser!=null){
            return new ResultDto("用户名已经存在");

        }else{
            if (userinfoRequest.getPassword()==null)

            {
                return new ResultDto("密码不能为空");

            }
            else {

                TbUser map = mapperFacade.map(userinfoRequest, TbUser.class);
//                密码加密
                map.setPassword(passwordEncoder.encode(userinfoRequest.getPassword()));
                tbUserDao.insert(map);
                ResultDto<Object> resultDto = new ResultDto<>("注册成功");
                return resultDto;
            }
        }


    }
}
