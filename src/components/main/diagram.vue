<template>
  <div class="diagram">
    <div class="diagram-select">
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
    </div>
    <div>
      <v-chart class="my-chart" :options="diaOption"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'diagram',
  props: {
    diagramdata: {}
  },
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
          name: 'Income', 
          axisLabel: {rotate: 50, interval: 0},
          data: [12, 14, 16, 18, 20, 22, 24]
        },
        yAxis: {name: 'Life Expectancy',},
        series: [{
          type: 'scatter',
          data: [35, 60, 76, 50, 65, 48, 80]
        }]
      }
    }
  },
  mounted: {
    
  },
  methods: {
    onSubmit() {
      if(this.values.diaType != 'pie') {
        this.diaOption.series[0].type = this.values.diaType
      }
    }
  }
}
</script>

<style scoped>
  .diagram-select {
    margin: 30px auto 0 auto;
    text-align: center;
  }
  .diagram>>>.el-form--inline {
    display: inline-block;
    width: fit-content;
  }
  .my-chart {
    width: 700px;
    height: 500px;
    margin-left: 160px;
  }
</style>