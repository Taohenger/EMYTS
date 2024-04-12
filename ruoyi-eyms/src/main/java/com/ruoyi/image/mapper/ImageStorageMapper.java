package com.ruoyi.image.mapper;

import java.util.List;
import com.ruoyi.image.domain.ImageStorage;

/**
 * 图片存储Mapper接口
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public interface ImageStorageMapper 
{
    /**
     * 查询图片存储
     * 
     * @param imageId 图片存储主键
     * @return 图片存储
     */
    public ImageStorage selectImageStorageByImageId(Long imageId);

    /**
     * 查询图片存储列表
     * 
     * @param imageStorage 图片存储
     * @return 图片存储集合
     */
    public List<ImageStorage> selectImageStorageList(ImageStorage imageStorage);

    /**
     * 新增图片存储
     * 
     * @param imageStorage 图片存储
     * @return 结果
     */
    public int insertImageStorage(ImageStorage imageStorage);

    /**
     * 修改图片存储
     * 
     * @param imageStorage 图片存储
     * @return 结果
     */
    public int updateImageStorage(ImageStorage imageStorage);

    /**
     * 删除图片存储
     * 
     * @param imageId 图片存储主键
     * @return 结果
     */
    public int deleteImageStorageByImageId(Long imageId);

    /**
     * 批量删除图片存储
     * 
     * @param imageIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImageStorageByImageIds(Long[] imageIds);
}
