function Subject() {
    this.id;
    this.name;
    this.description;
    this.teacher;
	this.pool;
}

$(function () {
	$('#subjects').on('click.button.data-api', '[data-toggle^=button]', function ( e ) {
	var $btn = $(e.target);
    var subject = $btn.closest('th');
    var subjectId = subject.data("id");
    
    var pool = null;
    if($btn.text() === "A")
        pool = $("#pool-a");
    else
        pool = $("#pool-b");

    $.ajax({
        url: ""
    }).done(function (data) {
        data = { 
                    "subject" : 
                        {
                            "id" : 1, 
                            "name" : "Machine Learning", 
                            "teacher" : "Lars Larsansonnn",
                            "description" : "The Earth is a very small stage in a vast cosmic arena. Think of the rivers of blood spilled by all those generals and emperors so that, in glory and triumph, they could become the momentary masters of a fraction of a dot."
                        }
                };
                
        if ($btn.hasClass("active")) {
            var subject = new Subject();
            subject.id = data["subject"]["id"];
            subject.name = data["subject"]["name"];
            subject.teacher = data["subject"]["teacher"];
            subject.description = data["subject"]["description"];
            
            addToPool(subject, pool);
            
            if (pool.attr('id') === $("#pool-a").attr('id')) {
                removeFromPool(subjectId, $("#pool-b"));
            }
            else {
                removeFromPool(subjectId, $("#pool-a"));
            }
        }
        else {
            removeFromPool(subjectId, pool);
        }
        });
	})
});

function removeFromPool(subjectId, pool) {
    var allSubjects = pool.children('tbody').children('tr');
    
    $.each(allSubjects, function(i, val) { 
        if ($(this).data('id') === subjectId) {
            $(this).remove();
            return;
        }
    });
}

function addToPool (subject, pool) {
    var descriptionLength = 25;
    var entryCount = pool.children('tbody').children().length;
  
    pool.append("<tr data-id=\"" + subject.id + "\">"
                    + "<td>" + (entryCount + 1) + "</td>"
                    + "<td>" + subject.name + "</td>"
                    + "<td>" + Truncate(subject.description, descriptionLength) + "</td>"
                    + "<td>" + subject.teacher + "</td>"
                    + "<td>"
                        + ' <a class="btn btn-small details-btn" href="#"> Details</a>'
                    + "</td>"
                + "</tr>");
}   

function Truncate (text, length) {
    return $.trim(text.substring(0, length)) + '...';
}

$('#start-round-btn').click(function () {
  var subjects = new Array();

  $('#pool-a tbody tr').each(function(i, value) {
	var subject = new Subject();
	subject.id = $(this).data('id');
	subject.pool = 'A';
	
	subjects[subjects.length] = subject;
  });
  
  $('#pool-b tbody tr').each(function(index) {
	var subject = new Subject();
	subject.id = $(this).data('id')
	subject.pool = 'B'
	
	subjects[subjects.length] = subject;
  });

  var output = {"subjects": subjects}
  var json_text = JSON.stringify(output, null, 2);
  console.log(json_text);
});

$('.details-btn').click(function () {
  var proposal = $(this).closest('tr');
});
