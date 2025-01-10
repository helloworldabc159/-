package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/category")
@Slf4j
public class TypeController {
    @Autowired
    private TypeService typeService;
    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     * **/
    @GetMapping("/page")
    public Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO) {
        PageResult pageResult = typeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 增加新的种类
     * @param categoryDTO
     * @return
     * **/
    @PostMapping
    public Result addCategory(@RequestBody CategoryDTO categoryDTO) {
        typeService.addCategory(categoryDTO);
        return Result.success();
    }

    /**
     * 改变种类的状态
     * @param status
     * @return
     * **/
    @PostMapping("status/{status}")
    public Result changeStatus(@PathVariable Integer status,Long id) {
        typeService.changeStatus(status,id);
        return Result.success();
    }

    /**
     * 根据id来删除分类
     * @param id
     * @return
     * **/
    @DeleteMapping
    public Result deleteCategory(@RequestParam Long id) {
        log.info("进入删除的窗口");
        typeService.deleteCategory(id);
        return Result.success();
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     * **/
    @PutMapping
    public Result updateType(@RequestBody CategoryDTO categoryDTO) {
        typeService.updateType(categoryDTO);
        return Result.success();
    }


    @GetMapping("/list")
    public Result<Category> selectByTypeName(String name, Integer type) {
        Category category = typeService.selectByTypeName(name,type);
        return Result.success(category);
    }
}
