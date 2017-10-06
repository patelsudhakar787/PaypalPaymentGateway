$(function(){
	var navPillsAdjust = function(){
		$('.nav.nav-tabs').each(function(){
			var liGroup = $(this).children('li');
			//console.log( liGroup.length );
			var liLength= liGroup.length;
			liGroup.each(function(){
				var liWidth = 100/liLength-1;
				$(this).css({'min-width': liWidth+'%','margin-left':'0px','margin-right':'0px'});
			});
		});
	};
	navPillsAdjust();
	
	/*-------------------------------------------------------------------------------------------------*/
	    var placesAutocomplete = places({
		  container: document.querySelector('#address-input')
		});
		
});
