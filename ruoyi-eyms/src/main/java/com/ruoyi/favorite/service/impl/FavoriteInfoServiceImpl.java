package com.ruoyi.favorite.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.favorite.mapper.FavoriteInfoMapper;
import com.ruoyi.favorite.domain.FavoriteInfo;
import com.ruoyi.favorite.service.IFavoriteInfoService;

/**
 * 收藏信息Service业务层处理
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@Service
public class FavoriteInfoServiceImpl implements IFavoriteInfoService 
{
    @Autowired
    private FavoriteInfoMapper favoriteInfoMapper;

    /**
     * 查询收藏信息
     * 
     * @param favoriteId 收藏信息主键
     * @return 收藏信息
     */
    @Override
    public FavoriteInfo selectFavoriteInfoByFavoriteId(Long favoriteId)
    {
        return favoriteInfoMapper.selectFavoriteInfoByFavoriteId(favoriteId);
    }

    /**
     * 查询收藏信息列表
     * 
     * @param favoriteInfo 收藏信息
     * @return 收藏信息
     */
    @Override
    public List<FavoriteInfo> selectFavoriteInfoList(FavoriteInfo favoriteInfo)
    {
        return favoriteInfoMapper.selectFavoriteInfoList(favoriteInfo);
    }

    /**
     * 新增收藏信息
     * 
     * @param favoriteInfo 收藏信息
     * @return 结果
     */
    @Override
    public int insertFavoriteInfo(FavoriteInfo favoriteInfo)
    {
        return favoriteInfoMapper.insertFavoriteInfo(favoriteInfo);
    }

    /**
     * 修改收藏信息
     * 
     * @param favoriteInfo 收藏信息
     * @return 结果
     */
    @Override
    public int updateFavoriteInfo(FavoriteInfo favoriteInfo)
    {
        return favoriteInfoMapper.updateFavoriteInfo(favoriteInfo);
    }

    /**
     * 批量删除收藏信息
     * 
     * @param favoriteIds 需要删除的收藏信息主键
     * @return 结果
     */
    @Override
    public int deleteFavoriteInfoByFavoriteIds(Long[] favoriteIds)
    {
        return favoriteInfoMapper.deleteFavoriteInfoByFavoriteIds(favoriteIds);
    }

    /**
     * 删除收藏信息信息
     * 
     * @param favoriteId 收藏信息主键
     * @return 结果
     */
    @Override
    public int deleteFavoriteInfoByFavoriteId(Long favoriteId)
    {
        return favoriteInfoMapper.deleteFavoriteInfoByFavoriteId(favoriteId);
    }
}
