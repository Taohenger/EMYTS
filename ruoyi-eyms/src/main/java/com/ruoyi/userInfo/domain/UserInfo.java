package com.ruoyi.userInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 user_info
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public class UserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 用户密码 */
    @Excel(name = "用户密码")
    private String userPassword;

    /** 毕业学校 */
    @Excel(name = "毕业学校")
    private String userSchool;

    /** 用户性别 */
    @Excel(name = "用户性别")
    private String userSex;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String userTelephone;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String userEmail;

    /** 所学专业 */
    @Excel(name = "所学专业")
    private String userMajor;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userUsername;

    /** 个人介绍 */
    @Excel(name = "个人介绍")
    private String userIntroduce;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserPassword(String userPassword) 
    {
        this.userPassword = userPassword;
    }

    public String getUserPassword() 
    {
        return userPassword;
    }
    public void setUserSchool(String userSchool) 
    {
        this.userSchool = userSchool;
    }

    public String getUserSchool() 
    {
        return userSchool;
    }
    public void setUserSex(String userSex) 
    {
        this.userSex = userSex;
    }

    public String getUserSex() 
    {
        return userSex;
    }
    public void setUserTelephone(String userTelephone) 
    {
        this.userTelephone = userTelephone;
    }

    public String getUserTelephone() 
    {
        return userTelephone;
    }
    public void setUserEmail(String userEmail) 
    {
        this.userEmail = userEmail;
    }

    public String getUserEmail() 
    {
        return userEmail;
    }
    public void setUserMajor(String userMajor) 
    {
        this.userMajor = userMajor;
    }

    public String getUserMajor() 
    {
        return userMajor;
    }
    public void setUserUsername(String userUsername) 
    {
        this.userUsername = userUsername;
    }

    public String getUserUsername() 
    {
        return userUsername;
    }
    public void setUserIntroduce(String userIntroduce) 
    {
        this.userIntroduce = userIntroduce;
    }

    public String getUserIntroduce() 
    {
        return userIntroduce;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userPassword", getUserPassword())
            .append("userSchool", getUserSchool())
            .append("userSex", getUserSex())
            .append("userTelephone", getUserTelephone())
            .append("userEmail", getUserEmail())
            .append("userMajor", getUserMajor())
            .append("userUsername", getUserUsername())
            .append("userIntroduce", getUserIntroduce())
            .toString();
    }
}
