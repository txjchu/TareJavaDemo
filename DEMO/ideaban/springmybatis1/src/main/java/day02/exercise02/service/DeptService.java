package day02.exercise02.service;

import day02.exercise02.dao.IDeptDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: Peter
 * @date: 2020/12/3 1:02
 */
@Service("deptServiceDay02")
public class DeptService {


    private IDeptDAO dao;

    @Resource       // 会自动注入 DAO 的实现类
    public void setDao(IDeptDAO dao) {
        this.dao = dao;
    }

    public void addDept(){
        System.out.println(this.getClass().getName() +": "+ "添加部门操作");
        dao.add();
    }

    public void deleteDept(){
        System.out.println(this.getClass().getName() +": "+ "删除部门操作");
        dao.delete();
    }

    public void updateDept(){
        System.out.println(this.getClass().getName() +": "+ "更新部门操作");
        dao.update();
    }
}
