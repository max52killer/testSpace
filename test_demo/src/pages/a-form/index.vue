<template>
  <div>
    <a-form :form="form" @submit="getValue">
      <a-form-item
        :labelCol="{lg:{span:7},sm:{span:7}}"
        :wrapperCol="{lg:{span:10},sm:{span:17}}"
        label="选择监听："
      >
        <a-select v-model="selModel">
          <a-select-option value="01">显示</a-select-option>
          <a-select-option value="02">隐藏</a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item
        :labelCol="{lg:{span:7},sm:{span:7}}"
        :wrapperCol="{lg:{span:10},sm:{span:17}}"
        label="姓名："
      >
        <a-input
          v-decorator="['name',
        {
          rules: [
            { required: true, message: '请输入客户名称!' }, 
          ]
        }]"
        ></a-input>
      </a-form-item>
      <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="性别：">
        <a-input v-decorator="['age',{initialValue:age}]" v-show="isShow"></a-input>
        <a-input v-decorator="['sex']"></a-input>
      </a-form-item>
      <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="RangePicker">
        <a-range-picker v-decorator="['range-picker', rangeConfig]" />
      </a-form-item>
      <a-form-item :labelCol="{lg:{span:7},sm:{span:7}}" :wrapperCol="{lg:{span:10},sm:{span:17}}">
        <a-button type="primary" @click="getValue">取表单值</a-button>
        取值结果：{{vueValue}}
      </a-form-item>
    </a-form>
  </div>
</template>
<script>
export default {
  name: "form-index",
  beforeCreate() {
    this.form = this.$form.createForm(this);
  },
  created() {
    this.setValue();
  },
  data() {
    return {
      vueValue: "",
      // form: , // 只有这样注册后，才能通过表单拉取数据
      age: 19,
      selModel: "",
      labelCol: { lg: { span: 7 }, sm: { span: 7 } },
      wrapperCol: { lg: { span: 10 }, sm: { span: 17 } },
      isShow: false,
      rangeConfig: {
        rules: [
          { type: "array", required: true, message: "Please select time!" }
        ]
      }
    };
  },
  watch: {
    selModel() {
      if (this.selModel == "01") {
        this.isShow = true;
      } else {
        this.isShow = false;
      }
    }
  },
  methods: {
    setValue() {
      // this.form.setFieldsValue({
      //   name: "张三",
      //   sex: "男",
      // });
    },
    getValue() {
      this.form.validateFields((err, fieldsValue) => {
        this.vueValue=fieldsValue;
        console.log("结果值：", fieldsValue);
      });
    }
  }
};
</script>
