package com.pc.netctoss.service;

import com.pc.netctoss.dao.IAdminInfoDAO;
import com.pc.netctoss.entity.AdminInfo;
import com.pc.netctoss.exception.AdminCodeException;
import com.pc.netctoss.exception.PasswordException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * 管理员 Service
 * @author: Peter
 * @date: 2020/12/10 19:47
 */
@Service
public class AdminInfoService implements Serializable {

    @Resource
    private IAdminInfoDAO adminInfoDAO;

    /**
     * 校验登录名与密码
     * @param adminCode
     * @param password
     * @return
     * @throws SQLException
     */
    public AdminInfo checkAdminCodeAndPwd(String adminCode, String password) throws SQLException {
        AdminInfo adminInfo = adminInfoDAO.findByCode(adminCode);
        if(adminInfo == null){
            throw new AdminCodeException("登录名错误！");
        } else if (!adminInfo.getPassword().equals(password)){
            throw new PasswordException("密码错误！");
        } else {
            return adminInfo;
        }

    }
}
