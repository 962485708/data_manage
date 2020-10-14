<template>
  <div>
    <el-form :inline="true" :model="values" class="demo-form-inline">
      <el-form-item label="x轴：">
        <el-select v-model="values.xAxis" placeholder="请选择属性">
          <el-option
            v-for="item in xy_options"
            :key="item.value"
            :label="item.label"
            :value="item.label"
            :disabled="item.disabled">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="y轴：">
        <el-select v-model="values.yAxis" placeholder="请选择属性">
          <el-option
            v-for="item in xy_options"
            :key="item.value"
            :label="item.label"
            :value="item.label"
            :disabled="item.disabled">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="图像：">
        <el-select v-model="values.diaType" placeholder="请选择类型">
          <el-option
            v-for="item in dia_options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
            :disabled="item.disabled">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-color-picker v-model="diaOption.color[0]"></el-color-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">确认</el-button>
      </el-form-item>
    </el-form>
    <div>
      <v-chart class="my-chart" :options="diaOption"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'diagram',
  data() {
    return {
      xy_options: [{
        value: 'xy_1',
        label: '黄金糕'
      }, {
        value: 'xy_2',
        label: '双皮奶'
      }, {
        value: 'xy_3',
        label: '蚵仔煎'
      }],
      dia_options: [{
          value: 'bar',
          label: 'bar (柱状图)'
        }, {
          value: 'line',
          label: 'line (折线图)'
        }, {
          value: 'pie',
          label: 'pie (饼状图)'
        }, {
          value: 'scatter',
          label: 'scatter (散点图)'
        }, 
      ],
      values:{
        xAxis: '',
        yAxis: '',
        diaType: ''
      },
      //图表参数
      diaOption: {
        color: ['#60ACFC'],
        legend: { data:['销量'] },
        toolbox: {
            left: 'center',
            feature: {
                dataZoom: {}
            }
        },
        tooltip: {
          trigger: 'item',
          triggerOn:"mousemove",
          enterable: true, 
        },
        xAxis: {
          type: 'value', 
          // gridIndex: 0, 
          name: 'Income', 
          axisLabel: {rotate: 50, interval: 0},
          data: [12, 14, 16, 18, 20, 22, 24]
        },
        yAxis: {name: 'Life Expectancy',},
        series: [{
          type: 'bar',
          data: [35, 60, 76, 50, 65, 48, 80]
        }]
      }
    }
  },
  methods: {
    onSubmit() {
      if(this.values.diaType != 'pie') {
        this.diaOption.series[0].type = this.values.diaType
      } else {
        this.series = [
          {
            name: '访问来源',
            type: 'pie',    // 设置图表类型为饼图
            radius: '50px',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
            data:[          // 数据数组，name 为数据项名称，value 为数据项值
                {value:235, name:'视频广告'},
                {value:274, name:'联盟广告'},
                {value:310, name:'邮件营销'},
                {value:335, name:'直接访问'},
                {value:400, name:'搜索引擎'}
            ]
          }
        ]
        this.xAxis = {}
        this.yAxis = {}
      }
    }
  }
}
</script>

<style scoped>
  .my-chart {
    width: 700px;
    height: 500px;
  }
</style>