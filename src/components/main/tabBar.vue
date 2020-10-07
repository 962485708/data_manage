<template>
  <div class="tab-bar">
    <el-row>
      <el-col :span="12">
        <div class="left">
          <div class="left-content">
            <img src="../../assets/icon/logo.png" alt="">
          </div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="right">
            <img class="more" src="../../assets/icon/main/more.png" alt="">
            <div>
              <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" :size="50"></el-avatar>
            </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
}
</script>

<style>
.tab-bar {
  width: 1200px;
  height: 60px;
  background-color: #fff;
  box-shadow: 0 1px 2px #ccc;
  position: fixed;
  top: 0;
  z-index: 999;
}
.left,
.right {
  height: 60px;
  display: flex;
  align-items: center;
}
.left-content {
  height: 60px;
  padding: 0 40px 0 40px;
  background-color: rgba(231, 241, 255, 62%);
  display: flex;
  align-items: center;
}
.left-content img {
  height: 50px;
}
.right {
  display: flex;
  flex-direction: row-reverse;
  margin-right: 30px;
}
.more {
  margin-left: 10px;
  width: 20px;
}
</style>