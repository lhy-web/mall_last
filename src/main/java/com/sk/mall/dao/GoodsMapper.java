package com.sk.mall.dao;

import com.sk.mall.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
//    long countByExample(GoodsExample example);
//
//    int deleteByExample(GoodsExample example);
//
//    int deleteByPrimaryKey(Integer goodsid);
//
//    int insert(Goods record);
//
//    int insertSelective(Goods record);
//
//    List<Goods> selectByExampleWithBLOBs(GoodsExample example);
//
//    List<Goods> selectByExample(GoodsExample example);
//
//    Goods selectByPrimaryKey(Integer goodsid);
//
//    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);
//
//    int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);
//
//    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);
//
//    int updateByPrimaryKeySelective(Goods record);
//
//    int updateByPrimaryKeyWithBLOBs(Goods record);
//
//    int updateByPrimaryKey(Goods record);
//
//    List<Goods> selectByExampleWithBLOBsLimit(GoodsExample digGoodsExample);
//

    /**
     * 根据用户id来查找喜欢的商品
     *
     * @param userId 用户id
     * @return List<Goods>
     */
    List<Goods> selectFavByUserId(Integer userId);
}