package day01.service;

import day01.dao.DeptDAO;

/**
 * @author: Peter
 * @date: 2020/12/1 19:58
 */
public class DeptService {

    private DeptDAO dao;
    public void setDao(DeptDAO dao){
        this.dao = dao;
    }

    public void addDept(){
        System.out.println(this.getClass().getName() +" : "+ "添加部门操作");
        dao.save();
    }
    public void updateDept(){
        System.out.println(this.getClass().getName() +" : "+ "更新部门操作");
        dao.update();
    }

    public void deleteDept(){
        System.out.println(this.getClass().getName() +" : "+ "删除部门操作");
        dao.delete();
    }

}
