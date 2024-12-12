package com.sky.service;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {



    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);
    /**
     * 新添员工
     * @param employeeDTO
     * @return
     */
    void save(EmployeeDTO employeeDTO);
    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 修改员工状态
     * @param status,id
     * @return
     */
    void saveOrStop(Integer status, Long id);
    /**
     * 根据id来返回员工
     * @param id
     * @return
     */
     Employee searchById(Long id);
    /**
     * 根据id来修改员工
     * @param employeeDTO
     * @return
     */
    void changeById(EmployeeDTO employeeDTO);
}
