<template>
  <div id="IndexMain" class="Main">
    <h1>首页</h1>
    <button @click="qqGet">点击请求数据</button>
    <select v-model="sel">
      <option value="01">表格1</option>
      <option value="02">表格2</option>
      <option value='03'>表单验证</option>
      <option value='04'>文件上传</option>
    </select>
    <!--<ant-table></ant-table>-->
    <ant-table1 v-if="sel=='01'"></ant-table1>
    <ant-table v-if="sel=='02'"></ant-table>
    <ant-form v-if="sel=='03'"></ant-form>
    <file-upload v-if="sel=='04'"></file-upload>

    <div class="get-code" @click="refreshCode()">
      <identity :identifyCode="identifyCode"></identity>
    </div>
  </div>
</template>

<script>
  import demoApi from "../api/demoApi";
  import antTable from "./a-table/index";
  import antTable1 from "./a-table/index1";
  import identity from "./identity/index";
  import antForm from "./a-form/index";
  import fileUpload from "./a-file/index";

  export default {
    name: "index",
    props: {},
    computed: {},
    watch: {},
    //引用其它组件注册
    components: {antTable, antTable1, identity, antForm,fileUpload},
    created() {
      this.refreshCode();
    },
    mounted() {
    },
    //设置当前全局使用的变量
    data() {
      return {
        sel: "",
        identifyCode: "",
        identifyCodes: "0123456789abcdwerwshdjeJKDHRJHKOOPLMKQ",//随便打的
      };
    },
    //定义组件中调用的函数
    methods: {
      handleExport() {
        demoApi.exportBqxx().then(resp => {
          console.log("下载成功！",resp);
        });
      },
      qqGet() {
        demoApi.queryAll().then(resp => {
          console.log("请求结果：", resp);
        });
      },
      refreshCode() {//
        this.identifyCode = "";
        this.makeCode(this.identifyCodes, 4);
      },
      randomNum(min, max) {
        max = max + 1;
        return Math.floor(Math.random() * (max - min) + min)
      },
      // 随机生成验证码字符串
      makeCode(data, len) {
        for (let i = 0; i < len; i++) {
          this.identifyCode += data[this.randomNum(0, data.length - 1)]
        }
        console.log(this.identifyCode)
      }
    },
    //过滤器，用于对展示的数据进行处理  value|method
    filters: {},
    updated() {
    },
    destroyed() {
    }
  }
</script>

<style scoped>

</style>
