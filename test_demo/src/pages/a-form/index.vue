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
<<<<<<< HEAD
      <!--<a-form-item label='时间:'>-->
        <!--<a-range-picker-->
          <!--v-decorator="['time', {initialValue: [moment(moment().startOf('day'), dateFormat), moment(moment().endOf('day'), dateFormat)]}]"-->
          <!--style="width:350px;"-->
          <!--format="YYYY-MM-DD HH:mm:ss"-->
          <!--:allowClear="false"-->
          <!--:showTime="{-->
                        <!--hideDisabledOptions: true,-->
                        <!--defaultValue: [moment('00:00:00', 'HH:mm:ss'), moment('23:59:59', 'HH:mm:ss')]-->
                      <!--}"-->
          <!--:placeholder="['开始日期', '结束日期']"-->
        <!--/>-->
      <!--</a-form-item>-->
=======
      <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="RangePicker">
        <a-range-picker v-decorator="['range-picker', rangeConfig]" />
      </a-form-item>
>>>>>>> f3ed2d3b15e64c61d3df497b5f9e6c6cfbd603d8
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
        let rangePicker=fieldsValue['range-picker'];
        let beginTime=rangePicker[0].format('YYYY-MM-DD HH:mm:ss');
        let endTime=rangePicker[1].format('YYYY-MM-DD HH:mm:ss');
        console.log("开始时间：",beginTime);
        console.log("结束时间：",endTime);
      });
    }
  }
};
</script>
