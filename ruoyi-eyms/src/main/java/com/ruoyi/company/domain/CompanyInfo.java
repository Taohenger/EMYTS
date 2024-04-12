package com.ruoyi.company.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 企业信息对象 company_info
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public class CompanyInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 企业ID */
    private Long companyId;

    /** 企业用户名 */
    @Excel(name = "企业用户名")
    private String companyUsername;

    /** 企业密码 */
    @Excel(name = "企业密码")
    private String companyPassword;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String companyName;

    /** 企业地址 */
    @Excel(name = "企业地址")
    private String companyAddress;

    /** 注册资金 */
    @Excel(name = "注册资金")
    private String companyRegisteredcapital;

    /** 所属行业 */
    @Excel(name = "所属行业")
    private String companyIndustry;

    /** 企业人数 */
    @Excel(name = "企业人数")
    private String companyNumberofenterprises;

    public void setCompanyId(Long companyId) 
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }
    public void setCompanyUsername(String companyUsername) 
    {
        this.companyUsername = companyUsername;
    }

    public String getCompanyUsername() 
    {
        return companyUsername;
    }
    public void setCompanyPassword(String companyPassword) 
    {
        this.companyPassword = companyPassword;
    }

    public String getCompanyPassword() 
    {
        return companyPassword;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanyAddress(String companyAddress) 
    {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress() 
    {
        return companyAddress;
    }
    public void setCompanyRegisteredcapital(String companyRegisteredcapital) 
    {
        this.companyRegisteredcapital = companyRegisteredcapital;
    }

    public String getCompanyRegisteredcapital() 
    {
        return companyRegisteredcapital;
    }
    public void setCompanyIndustry(String companyIndustry) 
    {
        this.companyIndustry = companyIndustry;
    }

    public String getCompanyIndustry() 
    {
        return companyIndustry;
    }
    public void setCompanyNumberofenterprises(String companyNumberofenterprises) 
    {
        this.companyNumberofenterprises = companyNumberofenterprises;
    }

    public String getCompanyNumberofenterprises() 
    {
        return companyNumberofenterprises;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("companyUsername", getCompanyUsername())
            .append("companyPassword", getCompanyPassword())
            .append("companyName", getCompanyName())
            .append("companyAddress", getCompanyAddress())
            .append("companyRegisteredcapital", getCompanyRegisteredcapital())
            .append("companyIndustry", getCompanyIndustry())
            .append("companyNumberofenterprises", getCompanyNumberofenterprises())
            .toString();
    }
}
