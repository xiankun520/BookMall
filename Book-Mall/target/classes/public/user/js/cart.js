$(function() {
	adddel();
	//全选
	$(".all").click(function() {
		if($('.all>span').hasClass('normal')){
			$('.all>span').addClass('true').removeClass('normal');
			$('.all>span>img').attr('src','../img/cart/product_true.png');
			$(".Each>span").each(function() {
				$(this).addClass('true').removeClass('normal');
				$(this).children('img').attr('src','../img/cart/product_true.png');
			})
		totl();
		}else{
			$('.all>span').addClass('normal').removeClass('true');
			$('.all>span>img').attr('src','../img/cart/product_normal.png');
			$('.Each>span').addClass('normal').removeClass('true');
			$('.Each>span>img').attr('src','../img/cart/product_normal.png');
			$(".susum").text(0.00);
			$(".susumOne").text(0.00);
			$('.total').text(0);
			$('.totalOne').text(0);
		}
	})
	//单选
	$('.Each>span').click(function(){
		amountadd();
		$('.all>span').addClass('normal').removeClass('true');
		$('.all>span>img').attr('src','../img/cart/product_normal.png');
		if($(this).hasClass('normal')){
			$(this).addClass('true').removeClass('normal');
			$(this).children('img').attr('src','../img/cart/product_true.png');
			var amou=parseInt($('.total').text());
			amou++;
			$('.total').text(amou);
			$('.totalOne').text(amou);
			amountadd();
		}else{
			$(this).addClass('normal').removeClass('true');
			$(this).children('img').attr('src','../img/cart/product_normal.png');
			var amou=parseInt($('.total').text());
			amou--;
			$('.total').text(amou);
			$('.totalOne').text(amou);
			var newamo=parseInt($('.susum').text())-parseInt($(this).parent().parent().siblings('.totle').children('.totle_information').text());
			$('.susum').text(newamo.toFixed(2));
			$('.susumOne').text(newamo.toFixed(2));
		}
	})	
})



