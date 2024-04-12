package com.ruoyi.image.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图片存储对象 image_storage
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public class ImageStorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片ID */
    private Long imageId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long imageUserid;

    /** 企业ID */
    @Excel(name = "企业ID")
    private Long imageCompanyid;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String imagePath;

    /** 图片类型 */
    @Excel(name = "图片类型")
    private String imageType;

    public void setImageId(Long imageId) 
    {
        this.imageId = imageId;
    }

    public Long getImageId() 
    {
        return imageId;
    }
    public void setImageUserid(Long imageUserid) 
    {
        this.imageUserid = imageUserid;
    }

    public Long getImageUserid() 
    {
        return imageUserid;
    }
    public void setImageCompanyid(Long imageCompanyid) 
    {
        this.imageCompanyid = imageCompanyid;
    }

    public Long getImageCompanyid() 
    {
        return imageCompanyid;
    }
    public void setImagePath(String imagePath) 
    {
        this.imagePath = imagePath;
    }

    public String getImagePath() 
    {
        return imagePath;
    }
    public void setImageType(String imageType) 
    {
        this.imageType = imageType;
    }

    public String getImageType() 
    {
        return imageType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("imageId", getImageId())
            .append("imageUserid", getImageUserid())
            .append("imageCompanyid", getImageCompanyid())
            .append("imagePath", getImagePath())
            .append("imageType", getImageType())
            .toString();
    }
}
