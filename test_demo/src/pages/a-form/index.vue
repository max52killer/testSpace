<template>
  <div>
    <a-form :form="form">
      <a-form-item
        :labelCol="{lg:{span:7},sm:{span:7}}"
        :wrapperCol="{lg:{span:10},sm:{span:17}}"
        label="测试"
      >
        <a-input v-decorator="['testName']"></a-input>
        <a-button type="primary" @click="getValue">取表单值</a-button>
        取值结果：{{vueValue}}
      </a-form-item>
    </a-form>
  </div>
</template>
<script>
export default {
  name: "",
  activited() {},
  data() {
    return {
      vueValue: "",
      form: this.$form.createForm(this) // 只有这样注册后，才能通过表单拉取数据
    };
  },
  methods: {
      setValue(){
          this.form.setFieldsValue({
              testName:"测试数据"
          })
      },
      getValue(){
          let listV=this.form.getFieldsValue();
          console.log("取的值：",listV.testName);
          this.vueValue=listV.testName;
      }
  }
};
</script>
