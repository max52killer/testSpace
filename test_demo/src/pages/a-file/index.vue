<template>
  <div><!--action部分填写后端接收文件上传的接口地址  可填写完整地址  此处有用代理-->
    <a-upload name="file" :multiple="true" action="/api/test/uploadFile" :headers="headers" @change="handleChange">
      <a-button>
        <a-icon type="upload" /> 点击上传文件
      </a-button>
    </a-upload>
  </div>
</template>

<script>
    export default {
        name: "index",
        props: {},
        computed: {},
        watch: {},
        //引用其它组件注册
        components: {},
        created() {
        },
        mounted() {
        },
        //设置当前全局使用的变量
        data() {
            return {
              headers: {
                authorization: 'authorization-text',
              }
            };
        },
        //定义组件中调用的函数
        methods: {
          handleChange(info) {
            if (info.file.status !== 'uploading') {
              console.log(info.file, info.fileList);
            }
            if (info.file.status === 'done') {
              this.$message.success(`${info.file.name} 上传成功`);
            } else if (info.file.status === 'error') {
              this.$message.error(`${info.file.name} 上传失败.`);
            }
          },
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
