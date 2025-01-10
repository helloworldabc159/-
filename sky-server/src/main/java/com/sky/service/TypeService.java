package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

public interface TypeService {
    /**
     * 查询分类
    * @param employeePageQueryDTO
    * **/
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 新增分类
     * @param categoryDTO
     * **/
    void addCategory(CategoryDTO categoryDTO);

    /**
     * 改变菜品类型的状态
     * @param status
     * **/
    void changeStatus(Integer status,Long id);

    /**
     * 根据id删除分类
     * @param id
     * **/
    void deleteCategory(Long id);

    /**
     * 修改种类信息
     * @param categoryDTO
     * **/
    void updateType(CategoryDTO categoryDTO);

    /**
     * 根据名字与套现类型查询
     * @param name
     * @param type
     * **/
    Category selectByTypeName(String name,Integer type);
}
