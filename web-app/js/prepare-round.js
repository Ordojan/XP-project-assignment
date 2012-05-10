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
    
    console.log($btn.hasClass("active"));
    $.ajax({
        url: "/EESS/subject/getSubject/" + subjectId
    }).done(function (data) {
        if ($btn.hasClass("active")) {
            var subject = new Subject();
            subject.id = data["id"];
            subject.name = data["name"];
            subject.teacher = (data["teacher"] == null)? "":data["teacher"];
            subject.description = data["description"] == null ? "":data["teacher"];
            
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
	if (text != null) return $.trim(text.substring(0, length)) + '...';
	return "";
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
