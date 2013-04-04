var carroussel={
		
		nbSlide : 0,
		nbCurrent : 1,
		elemCurrent : null,
		elem : null,
		timer : null,
		

		init : function(elem){
			this.nbSlide =  elem.find('.slide').length;
			
			//creer la pagination
			
			elem.append('<div class="navigation"></div>');
			for(var i=1; i<=this.nbSlide;i++){
				elem.find('.navigation').append('<span>'+i+'</span>');
			}
			
			elem.find('.navigation span').click(function(){carroussel.gotoSlide($(this).text());});
			//initialisation du carroussel
			
			this.elem = elem;
			elem.find('.slide').hide();
			elem.find('.slide:first').show();
			this.elemCurrent = elem.find('.slide:first');
			this.elem.find('.navigation span:first').addClass('active');
			
			//On crée le timer			
//			carroussel.play();
//			this.timer = window.setInterval('carroussel.next()', 5000);
			
			//Stop quand on passe dessus			
//			elem.mouseover(carroussel.stop);
//			elem.mouseout(carroussel.play);
		},
		
		gotoSlide : function(num){
			if(num==this.nbCurrent) {return false;}
			
			//Animation en fadeIn fadeOut
			
			this.elemCurrent.fadeOut();
			this.elem.find('#slide'+num).fadeIn();
		
			this.elem.find('.navigation span').removeClass('active');			
			this.elem.find('.navigation span:eq('+(num-1)+')').addClass('active');
			this.nbCurrent = num;
			this.elemCurrent = this.elem.find('#slide'+num);
		},
		
		next : function(){
			var num = this.nbCurrent+1;
			if(num>this.nbSlide){
				num = 1;
			}
			this.gotoSlide(num);
		},
		
		prev : function(){
			var num = this.nbCurrent-1;
			if(num<1){
				num = this.nbSlide;
			}
			this.gotoSlide(num);
		},
		
		stop : function(){
			window.clearInterval(carroussel.timer);
		},
		
		play : function(){
			this.timer = window.setInterval('carroussel.next()', 5000);
		}
}

$(function() {
//	window.clearInterval(carroussel.timer);
	carroussel.init($('#carrousel'));
});











