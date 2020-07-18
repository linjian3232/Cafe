function change(result){
	var chart = $('#container').highcharts();

	var data=[];
	data.push({
		name: '12312312',
		y: 10}
	);
	data.push({
		name: '13463772882',
		y: 20}
	);
	data.push({
		name: '234534623412',
		y: 20
	});
	data.push({
		name: '13474',
		y:15}
	);
	data.push({
		name: '5698',
		y: 35}
	);
	
	
	for (var i=0;i<data.length;i++){
		console.log(data[i].name);
	}
	
	chart.addSeries({
		"name": 'kkkkk',
		"colorByPoint": true,
		"data":data
	});
}