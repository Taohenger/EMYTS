package com.ruoyi.image.controller;

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
import com.ruoyi.image.domain.ImageStorage;
import com.ruoyi.image.service.IImageStorageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片存储Controller
 * 
 * @author 陈秋媛
 * @date 2024-04-12
 */
@RestController
@RequestMapping("/image/image")
public class ImageStorageController extends BaseController
{
    @Autowired
    private IImageStorageService imageStorageService;

    /**
     * 查询图片存储列表
     */
    @PreAuthorize("@ss.hasPermi('image:image:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImageStorage imageStorage)
    {
        startPage();
        List<ImageStorage> list = imageStorageService.selectImageStorageList(imageStorage);
        return getDataTable(list);
    }

    /**
     * 导出图片存储列表
     */
    @PreAuthorize("@ss.hasPermi('image:image:export')")
    @Log(title = "图片存储", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImageStorage imageStorage)
    {
        List<ImageStorage> list = imageStorageService.selectImageStorageList(imageStorage);
        ExcelUtil<ImageStorage> util = new ExcelUtil<ImageStorage>(ImageStorage.class);
        util.exportExcel(response, list, "图片存储数据");
    }

    /**
     * 获取图片存储详细信息
     */
    @PreAuthorize("@ss.hasPermi('image:image:query')")
    @GetMapping(value = "/{imageId}")
    public AjaxResult getInfo(@PathVariable("imageId") Long imageId)
    {
        return success(imageStorageService.selectImageStorageByImageId(imageId));
    }

    /**
     * 新增图片存储
     */
    @PreAuthorize("@ss.hasPermi('image:image:add')")
    @Log(title = "图片存储", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImageStorage imageStorage)
    {
        return toAjax(imageStorageService.insertImageStorage(imageStorage));
    }

    /**
     * 修改图片存储
     */
    @PreAuthorize("@ss.hasPermi('image:image:edit')")
    @Log(title = "图片存储", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImageStorage imageStorage)
    {
        return toAjax(imageStorageService.updateImageStorage(imageStorage));
    }

    /**
     * 删除图片存储
     */
    @PreAuthorize("@ss.hasPermi('image:image:remove')")
    @Log(title = "图片存储", businessType = BusinessType.DELETE)
	@DeleteMapping("/{imageIds}")
    public AjaxResult remove(@PathVariable Long[] imageIds)
    {
        return toAjax(imageStorageService.deleteImageStorageByImageIds(imageIds));
    }
}
