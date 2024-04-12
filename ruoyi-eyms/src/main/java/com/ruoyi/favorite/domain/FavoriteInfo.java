package com.ruoyi.favorite.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收藏信息对象 favorite_info
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public class FavoriteInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收藏ID */
    private Long favoriteId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long favoriteUserid;

    /** 收藏类型 */
    @Excel(name = "收藏类型")
    private String favoriteType;

    /** 目标ID（职位ID或企业ID） */
    @Excel(name = "目标ID", readConverterExp = "职=位ID或企业ID")
    private Long favoriteTargetid;

    public void setFavoriteId(Long favoriteId) 
    {
        this.favoriteId = favoriteId;
    }

    public Long getFavoriteId() 
    {
        return favoriteId;
    }
    public void setFavoriteUserid(Long favoriteUserid) 
    {
        this.favoriteUserid = favoriteUserid;
    }

    public Long getFavoriteUserid() 
    {
        return favoriteUserid;
    }
    public void setFavoriteType(String favoriteType) 
    {
        this.favoriteType = favoriteType;
    }

    public String getFavoriteType() 
    {
        return favoriteType;
    }
    public void setFavoriteTargetid(Long favoriteTargetid) 
    {
        this.favoriteTargetid = favoriteTargetid;
    }

    public Long getFavoriteTargetid() 
    {
        return favoriteTargetid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("favoriteId", getFavoriteId())
            .append("favoriteUserid", getFavoriteUserid())
            .append("favoriteType", getFavoriteType())
            .append("favoriteTargetid", getFavoriteTargetid())
            .toString();
    }
}
