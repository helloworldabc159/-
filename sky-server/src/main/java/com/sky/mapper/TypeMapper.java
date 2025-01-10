package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

@Mapper
public interface TypeMapper {
    /**
     * 分页查询
     * @param employeePageQueryDTO
     * **/
    @Select("select * from category")
    Page<Category> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 新增菜品种类
     * @param category
     * **/
    @AutoFill(value = OperationType.INSERT)
    @Insert("insert into category (type, name, sort, status, create_time, update_time, create_user, update_user) values (#{type},#{name},#{sort}," +
            "#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void addCategory(Category category);

    /**
     * 改变套餐的状态
     * @param status
     * **/
    @AutoFill(value = OperationType.UPDATE)
    @Update("update category set status=#{status} where id = #{id}")
    void changeStatus(Integer status,Long id);

    /**
     * 根据id来删除分类
     * @param id
     * **/
    @Delete("delete from category where id=#{id}")
    void deleteCategory(Long id);

    /**
     * 更新种类信息
     * @param category
     * **/
    @AutoFill(value = OperationType.UPDATE)
    void updateType(Category category);

    /**
     * 更新种类信息
     * @param name
     * @param type
     * **/
    Category selectByTypeName(String name, Integer type);
}
