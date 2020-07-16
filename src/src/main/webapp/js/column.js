var chart = Highcharts.chart('container', {
    chart: {
		background:null,
        type: 'column'
    },
    title: {
        text: '十大人气美食欢迎度'
    },
    subtitle: {
        text: '数据截止 2020-07'
    },
    xAxis: {
        type: 'category',
        labels: {
            rotation: -0  // 设置轴标签旋转角度
        }
    },
    yAxis: {
        min: 0,
        title: {
            text: '欢迎度'
        }
    },
    legend: {
        enabled: false
    },
    tooltip: {
        pointFormat: '人口总量: <b>{point.y:.1f} 百万</b>'
    },
    series: [{
        name: '总人口',
        data: [
            ['冰拿铁', 29.41],
            [ '意式黑椒牛排', 21.84],
            ['蜂蜜松饼', 17.85],
            ['鸡肉披萨', 14.67],
            ['摩卡咖啡', 6.18],
            ['扬州炒饭', 3.64],
            ['盐焗鸡翅', 2.6],
            ['炸牛奶', 1.2],
            ['其他',  2.61]
        ],
        dataLabels: {
            enabled: true,
            rotation: -90,
            color: '#FFFFFF',
            align: 'right',
            format: '{point.y:.1f}', // :.1f 为保留 1 位小数
            y: 10
        }
    }]
});