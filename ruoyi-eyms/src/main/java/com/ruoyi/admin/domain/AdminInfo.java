package com.ruoyi.admin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 管理员信息对象 admin_info
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public class AdminInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 管理员ID */
    private Long adminId;

    /** 管理员姓名 */
    @Excel(name = "管理员姓名")
    private String adminName;

    /** 管理员用户名 */
    @Excel(name = "管理员用户名")
    private String adminUsername;

    /** 管理员密码 */
    @Excel(name = "管理员密码")
    private String adminPassword;

    public void setAdminId(Long adminId) 
    {
        this.adminId = adminId;
    }

    public Long getAdminId() 
    {
        return adminId;
    }
    public void setAdminName(String adminName) 
    {
        this.adminName = adminName;
    }

    public String getAdminName() 
    {
        return adminName;
    }
    public void setAdminUsername(String adminUsername) 
    {
        this.adminUsername = adminUsername;
    }

    public String getAdminUsername() 
    {
        return adminUsername;
    }
    public void setAdminPassword(String adminPassword) 
    {
        this.adminPassword = adminPassword;
    }

    public String getAdminPassword() 
    {
        return adminPassword;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("adminId", getAdminId())
            .append("adminName", getAdminName())
            .append("adminUsername", getAdminUsername())
            .append("adminPassword", getAdminPassword())
            .toString();
    }
}
