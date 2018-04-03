/*** 
	banner图片效果 
	Version 2
***/
var img = document.getElementById("banner").getElementsByTagName("img"); //img对象
var sign = 0;		//标记最左图的img索引号
var run = 0;		//标记运行改变透明度的图片

//图片更换函数
function changeImg(){
	for(var i = 0; i < img.length; i++){
		if(i==sign){
			img[i].className="img"+(img.length-1);
		}		
		if (i>sign){
			img[i].className="img"+(i-sign-1);
		}
		if(i<sign){
			img[i].className="img"+(i+img.length-sign-1);
		}
	}
	if(++sign==5){
		sign=0;
	}
}

//改变透明度函数
function changeOpacity(){
	var start =1;
	var end =0.5;
	var delay =80;
	var dropID = setInterval(drop,delay);	
	// 透明度减小函数
	function drop(){
		start = (Math.round((start-0.1)*10))/10;
		if (start > end){
			// console.log(start);
			img[run].style.opacity=start;
			img[run].style.filter="alpha(opacity="+100*start+")";
		}
		else{
			clearInterval(dropID);
			var riseID = setInterval(rise,delay);
			//透明度增大函数
			function rise(){
				end = (Math.round((end+0.1)*10))/10;
				if (end <= 1){
					img[run].style.opacity=end;
					img[run].style.filter="alpha(opacity="+100*end+")";
				}
				else{
					clearInterval(riseID);
					if(++run==5){
						run=0;
					}
				}
			}
		}
	}
}

setInterval(changeImg,5500);		
setInterval(changeOpacity,900);



