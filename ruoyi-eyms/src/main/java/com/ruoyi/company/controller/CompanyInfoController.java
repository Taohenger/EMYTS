package com.ruoyi.company.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.company.domain.CompanyInfo;
import com.ruoyi.company.service.ICompanyInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 企业信息Controller
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@RestController
@RequestMapping("/company/company")
public class CompanyInfoController extends BaseController
{
    @Autowired
    private ICompanyInfoService companyInfoService;

    /**
     * 查询企业信息列表
     */
    @PreAuthorize("@ss.hasPermi('company:company:list')")
    @GetMapping("/list")
    public TableDataInfo list(CompanyInfo companyInfo)
    {
        startPage();
        List<CompanyInfo> list = companyInfoService.selectCompanyInfoList(companyInfo);
        return getDataTable(list);
    }

    /**
     * 导出企业信息列表
     */
    @PreAuthorize("@ss.hasPermi('company:company:export')")
    @Log(title = "企业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CompanyInfo companyInfo)
    {
        List<CompanyInfo> list = companyInfoService.selectCompanyInfoList(companyInfo);
        ExcelUtil<CompanyInfo> util = new ExcelUtil<CompanyInfo>(CompanyInfo.class);
        util.exportExcel(response, list, "企业信息数据");
    }

    /**
     * 获取企业信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('company:company:query')")
    @GetMapping(value = "/{companyId}")
    public AjaxResult getInfo(@PathVariable("companyId") Long companyId)
    {
        return success(companyInfoService.selectCompanyInfoByCompanyId(companyId));
    }

    /**
     * 新增企业信息
     */
    @PreAuthorize("@ss.hasPermi('company:company:add')")
    @Log(title = "企业信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CompanyInfo companyInfo)
    {
        return toAjax(companyInfoService.insertCompanyInfo(companyInfo));
    }

    /**
     * 修改企业信息
     */
    @PreAuthorize("@ss.hasPermi('company:company:edit')")
    @Log(title = "企业信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CompanyInfo companyInfo)
    {
        return toAjax(companyInfoService.updateCompanyInfo(companyInfo));
    }

    /**
     * 删除企业信息
     */
    @PreAuthorize("@ss.hasPermi('company:company:remove')")
    @Log(title = "企业信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{companyIds}")
    public AjaxResult remove(@PathVariable Long[] companyIds)
    {
        return toAjax(companyInfoService.deleteCompanyInfoByCompanyIds(companyIds));
    }
}
