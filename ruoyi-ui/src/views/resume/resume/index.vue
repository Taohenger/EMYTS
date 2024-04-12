<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户ID" prop="resumeUserid">
        <el-input
          v-model="queryParams.resumeUserid"
          placeholder="请输入用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="resumeName">
        <el-input
          v-model="queryParams.resumeName"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出生日期" prop="resumeBirth">
        <el-date-picker clearable
          v-model="queryParams.resumeBirth"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出生日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="民族" prop="resumeNation">
        <el-input
          v-model="queryParams.resumeNation"
          placeholder="请输入民族"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系电话" prop="resumeTelephone">
        <el-input
          v-model="queryParams.resumeTelephone"
          placeholder="请输入联系电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="政治面貌" prop="resumePoliticaloutlook">
        <el-input
          v-model="queryParams.resumePoliticaloutlook"
          placeholder="请输入政治面貌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电子邮箱" prop="resumeEmail">
        <el-input
          v-model="queryParams.resumeEmail"
          placeholder="请输入电子邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="毕业学校" prop="resumeSchool">
        <el-input
          v-model="queryParams.resumeSchool"
          placeholder="请输入毕业学校"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系地址" prop="resumeAddress">
        <el-input
          v-model="queryParams.resumeAddress"
          placeholder="请输入联系地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['resume:resume:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['resume:resume:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['resume:resume:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['resume:resume:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="resumeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="简历ID" align="center" prop="resumeId" />
      <el-table-column label="用户ID" align="center" prop="resumeUserid" />
      <el-table-column label="姓名" align="center" prop="resumeName" />
      <el-table-column label="出生日期" align="center" prop="resumeBirth" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.resumeBirth, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="民族" align="center" prop="resumeNation" />
      <el-table-column label="联系电话" align="center" prop="resumeTelephone" />
      <el-table-column label="政治面貌" align="center" prop="resumePoliticaloutlook" />
      <el-table-column label="电子邮箱" align="center" prop="resumeEmail" />
      <el-table-column label="毕业学校" align="center" prop="resumeSchool" />
      <el-table-column label="联系地址" align="center" prop="resumeAddress" />
      <el-table-column label="教育背景" align="center" prop="resumeEducation" />
      <el-table-column label="学历背景" align="center" prop="resumeEducationalbackground" />
      <el-table-column label="实习经历" align="center" prop="resumeInternshipexperience" />
      <el-table-column label="校园经历" align="center" prop="resumeCampusexperience" />
      <el-table-column label="技能证书" align="center" prop="resumeSkillcertificate" />
      <el-table-column label="自我评价" align="center" prop="resumeSelfevaluation" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['resume:resume:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['resume:resume:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改简历信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户ID" prop="resumeUserid">
          <el-input v-model="form.resumeUserid" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="姓名" prop="resumeName">
          <el-input v-model="form.resumeName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="出生日期" prop="resumeBirth">
          <el-date-picker clearable
            v-model="form.resumeBirth"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="民族" prop="resumeNation">
          <el-input v-model="form.resumeNation" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="联系电话" prop="resumeTelephone">
          <el-input v-model="form.resumeTelephone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="政治面貌" prop="resumePoliticaloutlook">
          <el-input v-model="form.resumePoliticaloutlook" placeholder="请输入政治面貌" />
        </el-form-item>
        <el-form-item label="电子邮箱" prop="resumeEmail">
          <el-input v-model="form.resumeEmail" placeholder="请输入电子邮箱" />
        </el-form-item>
        <el-form-item label="毕业学校" prop="resumeSchool">
          <el-input v-model="form.resumeSchool" placeholder="请输入毕业学校" />
        </el-form-item>
        <el-form-item label="联系地址" prop="resumeAddress">
          <el-input v-model="form.resumeAddress" placeholder="请输入联系地址" />
        </el-form-item>
        <el-form-item label="教育背景" prop="resumeEducation">
          <el-input v-model="form.resumeEducation" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="学历背景" prop="resumeEducationalbackground">
          <el-input v-model="form.resumeEducationalbackground" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="实习经历" prop="resumeInternshipexperience">
          <el-input v-model="form.resumeInternshipexperience" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="校园经历" prop="resumeCampusexperience">
          <el-input v-model="form.resumeCampusexperience" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="技能证书" prop="resumeSkillcertificate">
          <el-input v-model="form.resumeSkillcertificate" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="自我评价" prop="resumeSelfevaluation">
          <el-input v-model="form.resumeSelfevaluation" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listResume, getResume, delResume, addResume, updateResume } from "@/api/resume/resume";

export default {
  name: "Resume",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 简历信息表格数据
      resumeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        resumeUserid: null,
        resumeName: null,
        resumeBirth: null,
        resumeNation: null,
        resumeTelephone: null,
        resumePoliticaloutlook: null,
        resumeEmail: null,
        resumeSchool: null,
        resumeAddress: null,
        resumeEducation: null,
        resumeEducationalbackground: null,
        resumeInternshipexperience: null,
        resumeCampusexperience: null,
        resumeSkillcertificate: null,
        resumeSelfevaluation: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        resumeUserid: [
          { required: true, message: "用户ID不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询简历信息列表 */
    getList() {
      this.loading = true;
      listResume(this.queryParams).then(response => {
        this.resumeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        resumeId: null,
        resumeUserid: null,
        resumeName: null,
        resumeBirth: null,
        resumeNation: null,
        resumeTelephone: null,
        resumePoliticaloutlook: null,
        resumeEmail: null,
        resumeSchool: null,
        resumeAddress: null,
        resumeEducation: null,
        resumeEducationalbackground: null,
        resumeInternshipexperience: null,
        resumeCampusexperience: null,
        resumeSkillcertificate: null,
        resumeSelfevaluation: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.resumeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加简历信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const resumeId = row.resumeId || this.ids
      getResume(resumeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改简历信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.resumeId != null) {
            updateResume(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addResume(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const resumeIds = row.resumeId || this.ids;
      this.$modal.confirm('是否确认删除简历信息编号为"' + resumeIds + '"的数据项？').then(function() {
        return delResume(resumeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('resume/resume/export', {
        ...this.queryParams
      }, `resume_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
