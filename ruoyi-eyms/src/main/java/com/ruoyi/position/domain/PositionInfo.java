package com.ruoyi.position.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 职位信息对象 position_info
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public class PositionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 职位ID */
    private Long positionId;

    /** 职位名称 */
    @Excel(name = "职位名称")
    private String positionName;

    /** 招聘人数 */
    @Excel(name = "招聘人数")
    private String positionNumber;

    /** 职位要求 */
    @Excel(name = "职位要求")
    private String positionJobrequirements;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String positionCompanyname;

    /** 企业ID */
    @Excel(name = "企业ID")
    private Long positionCompanyid;

    public void setPositionId(Long positionId) 
    {
        this.positionId = positionId;
    }

    public Long getPositionId() 
    {
        return positionId;
    }
    public void setPositionName(String positionName) 
    {
        this.positionName = positionName;
    }

    public String getPositionName() 
    {
        return positionName;
    }
    public void setPositionNumber(String positionNumber) 
    {
        this.positionNumber = positionNumber;
    }

    public String getPositionNumber() 
    {
        return positionNumber;
    }
    public void setPositionJobrequirements(String positionJobrequirements) 
    {
        this.positionJobrequirements = positionJobrequirements;
    }

    public String getPositionJobrequirements() 
    {
        return positionJobrequirements;
    }
    public void setPositionCompanyname(String positionCompanyname) 
    {
        this.positionCompanyname = positionCompanyname;
    }

    public String getPositionCompanyname() 
    {
        return positionCompanyname;
    }
    public void setPositionCompanyid(Long positionCompanyid) 
    {
        this.positionCompanyid = positionCompanyid;
    }

    public Long getPositionCompanyid() 
    {
        return positionCompanyid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("positionId", getPositionId())
            .append("positionName", getPositionName())
            .append("positionNumber", getPositionNumber())
            .append("positionJobrequirements", getPositionJobrequirements())
            .append("positionCompanyname", getPositionCompanyname())
            .append("positionCompanyid", getPositionCompanyid())
            .toString();
    }
}
