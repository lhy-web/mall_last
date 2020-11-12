package com.sk.mall.service;


import com.sk.mall.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CateService")
public interface CateService {
    List<Category> getAllCate();

     void insertSelective(Category category);

//     List<Category> selectByExampleLimit(CategoryExample digCategoryExample);

     Category selectById(Integer category);

     void updateByPrimaryKeySelective(Category category);

     void deleteById(Integer id);
}
