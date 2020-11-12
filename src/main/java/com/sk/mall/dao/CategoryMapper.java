package com.sk.mall.dao;


import com.sk.mall.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
//    long countByExample(CategoryExample example);
//
//    int deleteByExample(CategoryExample example);

    void deleteById(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> getAllCate();

    Category selectByPrimaryKey(Integer cateid);

//    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);
//
//    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}