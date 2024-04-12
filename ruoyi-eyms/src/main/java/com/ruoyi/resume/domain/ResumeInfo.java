package com.ruoyi.resume.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 简历信息对象 resume_info
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public class ResumeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 简历ID */
    private Long resumeId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long resumeUserid;

    /** 姓名 */
    @Excel(name = "姓名")
    private String resumeName;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date resumeBirth;

    /** 民族 */
    @Excel(name = "民族")
    private String resumeNation;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String resumeTelephone;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String resumePoliticaloutlook;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String resumeEmail;

    /** 毕业学校 */
    @Excel(name = "毕业学校")
    private String resumeSchool;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String resumeAddress;

    /** 教育背景 */
    @Excel(name = "教育背景")
    private String resumeEducation;

    /** 学历背景 */
    @Excel(name = "学历背景")
    private String resumeEducationalbackground;

    /** 实习经历 */
    @Excel(name = "实习经历")
    private String resumeInternshipexperience;

    /** 校园经历 */
    @Excel(name = "校园经历")
    private String resumeCampusexperience;

    /** 技能证书 */
    @Excel(name = "技能证书")
    private String resumeSkillcertificate;

    /** 自我评价 */
    @Excel(name = "自我评价")
    private String resumeSelfevaluation;

    public void setResumeId(Long resumeId) 
    {
        this.resumeId = resumeId;
    }

    public Long getResumeId() 
    {
        return resumeId;
    }
    public void setResumeUserid(Long resumeUserid) 
    {
        this.resumeUserid = resumeUserid;
    }

    public Long getResumeUserid() 
    {
        return resumeUserid;
    }
    public void setResumeName(String resumeName) 
    {
        this.resumeName = resumeName;
    }

    public String getResumeName() 
    {
        return resumeName;
    }
    public void setResumeBirth(Date resumeBirth) 
    {
        this.resumeBirth = resumeBirth;
    }

    public Date getResumeBirth() 
    {
        return resumeBirth;
    }
    public void setResumeNation(String resumeNation) 
    {
        this.resumeNation = resumeNation;
    }

    public String getResumeNation() 
    {
        return resumeNation;
    }
    public void setResumeTelephone(String resumeTelephone) 
    {
        this.resumeTelephone = resumeTelephone;
    }

    public String getResumeTelephone() 
    {
        return resumeTelephone;
    }
    public void setResumePoliticaloutlook(String resumePoliticaloutlook) 
    {
        this.resumePoliticaloutlook = resumePoliticaloutlook;
    }

    public String getResumePoliticaloutlook() 
    {
        return resumePoliticaloutlook;
    }
    public void setResumeEmail(String resumeEmail) 
    {
        this.resumeEmail = resumeEmail;
    }

    public String getResumeEmail() 
    {
        return resumeEmail;
    }
    public void setResumeSchool(String resumeSchool) 
    {
        this.resumeSchool = resumeSchool;
    }

    public String getResumeSchool() 
    {
        return resumeSchool;
    }
    public void setResumeAddress(String resumeAddress) 
    {
        this.resumeAddress = resumeAddress;
    }

    public String getResumeAddress() 
    {
        return resumeAddress;
    }
    public void setResumeEducation(String resumeEducation) 
    {
        this.resumeEducation = resumeEducation;
    }

    public String getResumeEducation() 
    {
        return resumeEducation;
    }
    public void setResumeEducationalbackground(String resumeEducationalbackground) 
    {
        this.resumeEducationalbackground = resumeEducationalbackground;
    }

    public String getResumeEducationalbackground() 
    {
        return resumeEducationalbackground;
    }
    public void setResumeInternshipexperience(String resumeInternshipexperience) 
    {
        this.resumeInternshipexperience = resumeInternshipexperience;
    }

    public String getResumeInternshipexperience() 
    {
        return resumeInternshipexperience;
    }
    public void setResumeCampusexperience(String resumeCampusexperience) 
    {
        this.resumeCampusexperience = resumeCampusexperience;
    }

    public String getResumeCampusexperience() 
    {
        return resumeCampusexperience;
    }
    public void setResumeSkillcertificate(String resumeSkillcertificate) 
    {
        this.resumeSkillcertificate = resumeSkillcertificate;
    }

    public String getResumeSkillcertificate() 
    {
        return resumeSkillcertificate;
    }
    public void setResumeSelfevaluation(String resumeSelfevaluation) 
    {
        this.resumeSelfevaluation = resumeSelfevaluation;
    }

    public String getResumeSelfevaluation() 
    {
        return resumeSelfevaluation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resumeId", getResumeId())
            .append("resumeUserid", getResumeUserid())
            .append("resumeName", getResumeName())
            .append("resumeBirth", getResumeBirth())
            .append("resumeNation", getResumeNation())
            .append("resumeTelephone", getResumeTelephone())
            .append("resumePoliticaloutlook", getResumePoliticaloutlook())
            .append("resumeEmail", getResumeEmail())
            .append("resumeSchool", getResumeSchool())
            .append("resumeAddress", getResumeAddress())
            .append("resumeEducation", getResumeEducation())
            .append("resumeEducationalbackground", getResumeEducationalbackground())
            .append("resumeInternshipexperience", getResumeInternshipexperience())
            .append("resumeCampusexperience", getResumeCampusexperience())
            .append("resumeSkillcertificate", getResumeSkillcertificate())
            .append("resumeSelfevaluation", getResumeSelfevaluation())
            .toString();
    }
}
