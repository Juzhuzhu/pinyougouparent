package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService {
    /**
     * 返回全部列表
     * @return
     */
    public List<TbBrand> findAll();
    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum,int pageSize);
    /**
     * 增加
     */
    public void add(TbBrand brand);
    /**
     * 修改
     */
    public void update(TbBrand brand);
    /**
     * 根据id获取实体
     */
    public TbBrand findOne(Long id);
    /**
     * 批量删除
     */
    public void delete(Long [] ids);
    /**
     * 查询
     */
    public PageResult findPage(TbBrand brand,int pageNum,int pageSize);
    /**
     * 品牌下拉框数据
     */
    List<Map> selectOptionList();
}
