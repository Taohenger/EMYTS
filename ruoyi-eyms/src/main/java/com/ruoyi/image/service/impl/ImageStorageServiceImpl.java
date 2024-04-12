package com.ruoyi.image.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.image.mapper.ImageStorageMapper;
import com.ruoyi.image.domain.ImageStorage;
import com.ruoyi.image.service.IImageStorageService;

/**
 * 图片存储Service业务层处理
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@Service
public class ImageStorageServiceImpl implements IImageStorageService 
{
    @Autowired
    private ImageStorageMapper imageStorageMapper;

    /**
     * 查询图片存储
     * 
     * @param imageId 图片存储主键
     * @return 图片存储
     */
    @Override
    public ImageStorage selectImageStorageByImageId(Long imageId)
    {
        return imageStorageMapper.selectImageStorageByImageId(imageId);
    }

    /**
     * 查询图片存储列表
     * 
     * @param imageStorage 图片存储
     * @return 图片存储
     */
    @Override
    public List<ImageStorage> selectImageStorageList(ImageStorage imageStorage)
    {
        return imageStorageMapper.selectImageStorageList(imageStorage);
    }

    /**
     * 新增图片存储
     * 
     * @param imageStorage 图片存储
     * @return 结果
     */
    @Override
    public int insertImageStorage(ImageStorage imageStorage)
    {
        return imageStorageMapper.insertImageStorage(imageStorage);
    }

    /**
     * 修改图片存储
     * 
     * @param imageStorage 图片存储
     * @return 结果
     */
    @Override
    public int updateImageStorage(ImageStorage imageStorage)
    {
        return imageStorageMapper.updateImageStorage(imageStorage);
    }

    /**
     * 批量删除图片存储
     * 
     * @param imageIds 需要删除的图片存储主键
     * @return 结果
     */
    @Override
    public int deleteImageStorageByImageIds(Long[] imageIds)
    {
        return imageStorageMapper.deleteImageStorageByImageIds(imageIds);
    }

    /**
     * 删除图片存储信息
     * 
     * @param imageId 图片存储主键
     * @return 结果
     */
    @Override
    public int deleteImageStorageByImageId(Long imageId)
    {
        return imageStorageMapper.deleteImageStorageByImageId(imageId);
    }
}
