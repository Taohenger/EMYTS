package com.ruoyi.systemInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系统信息对象 system_info
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
public class SystemInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 系统信息ID */
    private Long systemId;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** 系统Logo路径 */
    @Excel(name = "系统Logo路径")
    private String systemLogo;

    /** 轮播图路径 */
    @Excel(name = "轮播图路径")
    private String systemCarousel;

    /** 关于我们 */
    @Excel(name = "关于我们")
    private String systemAboutus;

    /** 联系我们 */
    @Excel(name = "联系我们")
    private String systemContactus;

    /** 隐私政策 */
    @Excel(name = "隐私政策")
    private String systemPrivacypolicy;

    /** 服务条款 */
    @Excel(name = "服务条款")
    private String systemTermsofservice;

    public void setSystemId(Long systemId) 
    {
        this.systemId = systemId;
    }

    public Long getSystemId() 
    {
        return systemId;
    }
    public void setSystemName(String systemName) 
    {
        this.systemName = systemName;
    }

    public String getSystemName() 
    {
        return systemName;
    }
    public void setSystemLogo(String systemLogo) 
    {
        this.systemLogo = systemLogo;
    }

    public String getSystemLogo() 
    {
        return systemLogo;
    }
    public void setSystemCarousel(String systemCarousel) 
    {
        this.systemCarousel = systemCarousel;
    }

    public String getSystemCarousel() 
    {
        return systemCarousel;
    }
    public void setSystemAboutus(String systemAboutus) 
    {
        this.systemAboutus = systemAboutus;
    }

    public String getSystemAboutus() 
    {
        return systemAboutus;
    }
    public void setSystemContactus(String systemContactus) 
    {
        this.systemContactus = systemContactus;
    }

    public String getSystemContactus() 
    {
        return systemContactus;
    }
    public void setSystemPrivacypolicy(String systemPrivacypolicy) 
    {
        this.systemPrivacypolicy = systemPrivacypolicy;
    }

    public String getSystemPrivacypolicy() 
    {
        return systemPrivacypolicy;
    }
    public void setSystemTermsofservice(String systemTermsofservice) 
    {
        this.systemTermsofservice = systemTermsofservice;
    }

    public String getSystemTermsofservice() 
    {
        return systemTermsofservice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("systemId", getSystemId())
            .append("systemName", getSystemName())
            .append("systemLogo", getSystemLogo())
            .append("systemCarousel", getSystemCarousel())
            .append("systemAboutus", getSystemAboutus())
            .append("systemContactus", getSystemContactus())
            .append("systemPrivacypolicy", getSystemPrivacypolicy())
            .append("systemTermsofservice", getSystemTermsofservice())
            .toString();
    }
}
