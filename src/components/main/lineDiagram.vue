<template>
  <div>
    <v-chart class="my-chart" :options="line"/>
  </div>
</template>
<script>
export default {
  name: "lineDiagram",
  components: {
  },
  data() {
    return {
      line: {
        itemStyle: {
            normal: {
                // color: 各异,
              label: {
                  show: false
                  // position: 默认自适应，水平布局为'top'，垂直布局为'right'，可选为
                  //           'inside'|'left'|'right'|'top'|'bottom'
                  // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
              },
              lineStyle: {
                  width: 2,
                  type: 'solid',
                  shadowColor : 'rgba(0,0,0,0)', //默认透明
                  shadowBlur: 5,
                  shadowOffsetX: 3,
                  shadowOffsetY: 3
              }
            },
            emphasis: {
              // color: 各异,
              label: {
                  show: false
                  // position: 默认自适应，水平布局为'top'，垂直布局为'right'，可选为
                  //           'inside'|'left'|'right'|'top'|'bottom'
                  // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
              }
            }
        },
        //smooth : false,
        //symbol: null,         // 拐点图形类型
        symbolSize: 2,          // 拐点图形大小
        //symbolRotate : null,  // 拐点图形旋转控制
        showAllSymbol: false    // 标志图形默认只有主轴显示（随主轴标签间隔隐藏策略）
      },
    };
  }
};
</script>
<style scoped>
.my-chart {
  width: 500px;
  height: 300px;
}
</style>