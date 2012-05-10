$(function () {
	$('body').on('click.button.data-api', '[data-toggle^=button]', function ( e ) {
  		var $btn = $(e.target);
     	
		var switchesContainer = $btn.parent();
  		if(switchesContainer.hasClass('switches')) {
  			var switches = switchesContainer.children('.btn');

  			switches.each(function(index) {
  				if($(this).hasClass('active') && $(this).text() !== $btn.text()) {
  					$(this).button('toggle');
  				}
			});
  		}
	})
})