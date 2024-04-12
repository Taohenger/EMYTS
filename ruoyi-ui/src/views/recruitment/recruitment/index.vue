<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="招聘职位" prop="recruitmentPositionname">
        <el-input
          v-model="queryParams.recruitmentPositionname"
          placeholder="请输入招聘职位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="招聘方名称" prop="recruitmentName">
        <el-input
          v-model="queryParams.recruitmentName"
          placeholder="请输入招聘方名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系电话" prop="recruitmentTelephone">
        <el-input
          v-model="queryParams.recruitmentTelephone"
          placeholder="请输入联系电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="招聘人数" prop="recruitmentNumber">
        <el-input
          v-model="queryParams.recruitmentNumber"
          placeholder="请输入招聘人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="薪资待遇" prop="recruitmentSalary">
        <el-input
          v-model="queryParams.recruitmentSalary"
          placeholder="请输入薪资待遇"
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
          v-hasPermi="['recruitment:recruitment:add']"
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
          v-hasPermi="['recruitment:recruitment:edit']"
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
          v-hasPermi="['recruitment:recruitment:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['recruitment:recruitment:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="recruitmentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="招聘ID" align="center" prop="recruitmentId" />
      <el-table-column label="招聘职位" align="center" prop="recruitmentPositionname" />
      <el-table-column label="招聘方名称" align="center" prop="recruitmentName" />
      <el-table-column label="联系电话" align="center" prop="recruitmentTelephone" />
      <el-table-column label="招聘人数" align="center" prop="recruitmentNumber" />
      <el-table-column label="薪资待遇" align="center" prop="recruitmentSalary" />
      <el-table-column label="招聘要求" align="center" prop="recruitmentRequirement" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['recruitment:recruitment:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['recruitment:recruitment:remove']"
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

    <!-- 添加或修改招聘信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="招聘职位" prop="recruitmentPositionname">
          <el-input v-model="form.recruitmentPositionname" placeholder="请输入招聘职位" />
        </el-form-item>
        <el-form-item label="招聘方名称" prop="recruitmentName">
          <el-input v-model="form.recruitmentName" placeholder="请输入招聘方名称" />
        </el-form-item>
        <el-form-item label="联系电话" prop="recruitmentTelephone">
          <el-input v-model="form.recruitmentTelephone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="招聘人数" prop="recruitmentNumber">
          <el-input v-model="form.recruitmentNumber" placeholder="请输入招聘人数" />
        </el-form-item>
        <el-form-item label="薪资待遇" prop="recruitmentSalary">
          <el-input v-model="form.recruitmentSalary" placeholder="请输入薪资待遇" />
        </el-form-item>
        <el-form-item label="招聘要求" prop="recruitmentRequirement">
          <el-input v-model="form.recruitmentRequirement" type="textarea" placeholder="请输入内容" />
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
import { listRecruitment, getRecruitment, delRecruitment, addRecruitment, updateRecruitment } from "@/api/recruitment/recruitment";

export default {
  name: "Recruitment",
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
      // 招聘信息表格数据
      recruitmentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        recruitmentPositionname: null,
        recruitmentName: null,
        recruitmentTelephone: null,
        recruitmentNumber: null,
        recruitmentSalary: null,
        recruitmentRequirement: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询招聘信息列表 */
    getList() {
      this.loading = true;
      listRecruitment(this.queryParams).then(response => {
        this.recruitmentList = response.rows;
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
        recruitmentId: null,
        recruitmentPositionname: null,
        recruitmentName: null,
        recruitmentTelephone: null,
        recruitmentNumber: null,
        recruitmentSalary: null,
        recruitmentRequirement: null
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
      this.ids = selection.map(item => item.recruitmentId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加招聘信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recruitmentId = row.recruitmentId || this.ids
      getRecruitment(recruitmentId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改招聘信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.recruitmentId != null) {
            updateRecruitment(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecruitment(this.form).then(response => {
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
      const recruitmentIds = row.recruitmentId || this.ids;
      this.$modal.confirm('是否确认删除招聘信息编号为"' + recruitmentIds + '"的数据项？').then(function() {
        return delRecruitment(recruitmentIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('recruitment/recruitment/export', {
        ...this.queryParams
      }, `recruitment_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
