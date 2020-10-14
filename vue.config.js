module.exports = {
  outputDir: 'dist',
  assetsDir: 'assets',
  indexPath: 'index.html',
  publicPath: '/',
  devServer: { // 开发环境下runtime
    open: true,
    port: 8080,
    proxy: { // 代理服务器
      // 接口地址为 http://139.155.237.181:8701 根
      '/api': { 
        target: 'http://139.155.237.181:8701',
        secure: false, //是否使用 Https安全传输协议
        changeOrigin: true ,
        pathRewrite: {
          '^/api': ''
        }
      },
    },
  },
  transpileDependencies: [
    'vue-echarts',
    'resize-detector'
  ]
}