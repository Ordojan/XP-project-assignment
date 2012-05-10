$(function () {
	$('#proposals').on('click.button.data-api', '[data-toggle^=button]', function ( e ) {
		var $btn = $(e.target);
   	var proposal = $btn.closest('tr');

		var pool = null;
 		if($btn.text() === "A")
      pool = $("#pool-a");
   	else
   		pool = $("#pool-b");

    proposal.children('.pool-switches').children().children().button('toggle');
		moveToPool(proposal, pool);
    sortProposals();
	})
});

function sortProposals () {
  var numbers = $('#proposals tbody > tr').children('.number');
  numbers.each(function(index) {
      $(this).text(index + 1);
  });
}

function moveToPool (proposal, pool) {
  proposal.children('.pool-switches').toggle();
  var entryCount = pool.children('tbody').children().length;
  proposal.children('.number').text(entryCount + 1);
  
  proposal.children('.actions').append('<a class="btn btn-small move-back-btn" href="#"><i class="icon-remove icon-black"></i> Move Back</a>')
 
  pool.append(proposal);
}

$(".move-back-btn").live("click", function(e) {
  var proposal = $(e.target).closest('tr');
  
  $('#proposals').append(proposal);

  proposal.children('.pool-switches').toggle();
  proposal.children('.actions').remove('a .move-back-btn');
  proposal.children('.actions').children('.move-back-btn').remove();
  sortProposals();
});

$('#start-round-btn').click(function () {
  var pools = new Array();
  var poolA = new Array();
  var poolB = new Array();

  $('#pool-a tbody tr').each(function(index) {
    poolA[index] = {'name' : $(this).children('.name').text(),
                    'description' : $(this).children('.description').text(),
                    'teacher' : $(this).children('.teacher').text(),
                    'submiter' :$(this).children('.submiter').text()};
  });

  $('#pool-b tbody tr').each(function(index) {
    poolB[index] = {'name' : $(this).children('.name').text(),
                    'description' : $(this).children('.description').text(),
                    'teacher' : $(this).children('.teacher').text(),
                    'submiter' :$(this).children('.submiter').text()};
  });

  pools[0] = {'Pool' : {'id': 'A', 'entries': poolA} };
  pools[1] = {'Pool': {'id': 'B', 'entries': poolB} };

  var json_text = JSON.stringify(pools, null, 2);
  console.log(json_text);
});

$('.details-btn').click(function () {
  var proposal = $(this).closest('tr');
    
});

$('#proposal-modal').on('shown', function () {
  alert('shown');
})
