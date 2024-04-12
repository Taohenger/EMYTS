package com.ruoyi.favorite.service;

import java.util.List;
import com.ruoyi.favorite.domain.FavoriteInfo;

/**
 * 收藏信息Service接口
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public interface IFavoriteInfoService 
{
    /**
     * 查询收藏信息
     * 
     * @param favoriteId 收藏信息主键
     * @return 收藏信息
     */
    public FavoriteInfo selectFavoriteInfoByFavoriteId(Long favoriteId);

    /**
     * 查询收藏信息列表
     * 
     * @param favoriteInfo 收藏信息
     * @return 收藏信息集合
     */
    public List<FavoriteInfo> selectFavoriteInfoList(FavoriteInfo favoriteInfo);

    /**
     * 新增收藏信息
     * 
     * @param favoriteInfo 收藏信息
     * @return 结果
     */
    public int insertFavoriteInfo(FavoriteInfo favoriteInfo);

    /**
     * 修改收藏信息
     * 
     * @param favoriteInfo 收藏信息
     * @return 结果
     */
    public int updateFavoriteInfo(FavoriteInfo favoriteInfo);

    /**
     * 批量删除收藏信息
     * 
     * @param favoriteIds 需要删除的收藏信息主键集合
     * @return 结果
     */
    public int deleteFavoriteInfoByFavoriteIds(Long[] favoriteIds);

    /**
     * 删除收藏信息信息
     * 
     * @param favoriteId 收藏信息主键
     * @return 结果
     */
    public int deleteFavoriteInfoByFavoriteId(Long favoriteId);
}
