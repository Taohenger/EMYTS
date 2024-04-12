package com.ruoyi.recruitment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 招聘信息对象 recruitment_info
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public class RecruitmentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 招聘ID */
    private Long recruitmentId;

    /** 招聘职位 */
    @Excel(name = "招聘职位")
    private String recruitmentPositionname;

    /** 招聘方名称 */
    @Excel(name = "招聘方名称")
    private String recruitmentName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String recruitmentTelephone;

    /** 招聘人数 */
    @Excel(name = "招聘人数")
    private String recruitmentNumber;

    /** 薪资待遇 */
    @Excel(name = "薪资待遇")
    private String recruitmentSalary;

    /** 招聘要求 */
    @Excel(name = "招聘要求")
    private String recruitmentRequirement;

    public void setRecruitmentId(Long recruitmentId) 
    {
        this.recruitmentId = recruitmentId;
    }

    public Long getRecruitmentId() 
    {
        return recruitmentId;
    }
    public void setRecruitmentPositionname(String recruitmentPositionname) 
    {
        this.recruitmentPositionname = recruitmentPositionname;
    }

    public String getRecruitmentPositionname() 
    {
        return recruitmentPositionname;
    }
    public void setRecruitmentName(String recruitmentName) 
    {
        this.recruitmentName = recruitmentName;
    }

    public String getRecruitmentName() 
    {
        return recruitmentName;
    }
    public void setRecruitmentTelephone(String recruitmentTelephone) 
    {
        this.recruitmentTelephone = recruitmentTelephone;
    }

    public String getRecruitmentTelephone() 
    {
        return recruitmentTelephone;
    }
    public void setRecruitmentNumber(String recruitmentNumber) 
    {
        this.recruitmentNumber = recruitmentNumber;
    }

    public String getRecruitmentNumber() 
    {
        return recruitmentNumber;
    }
    public void setRecruitmentSalary(String recruitmentSalary) 
    {
        this.recruitmentSalary = recruitmentSalary;
    }

    public String getRecruitmentSalary() 
    {
        return recruitmentSalary;
    }
    public void setRecruitmentRequirement(String recruitmentRequirement) 
    {
        this.recruitmentRequirement = recruitmentRequirement;
    }

    public String getRecruitmentRequirement() 
    {
        return recruitmentRequirement;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recruitmentId", getRecruitmentId())
            .append("recruitmentPositionname", getRecruitmentPositionname())
            .append("recruitmentName", getRecruitmentName())
            .append("recruitmentTelephone", getRecruitmentTelephone())
            .append("recruitmentNumber", getRecruitmentNumber())
            .append("recruitmentSalary", getRecruitmentSalary())
            .append("recruitmentRequirement", getRecruitmentRequirement())
            .toString();
    }
}
