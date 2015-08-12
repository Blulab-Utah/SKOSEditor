
function skos_InitAssertionPopups() {
	var concepts = $('#tree-concepts').html();
	$('#assertion-concept-uri').html(concepts);
	$('#assertion-scheme-uri').html($('#tree-schemes').html());
	$('#assertion-type-2').html($('#tree-assertion-types').html());
}

function skos_loadAssertions() {
	var data = [
	    {'name': 'module', 'value': 'relations'},
		{'name': 'action', 'value': 'load'},
		{'name': 'id', 'value': skos_SelectedNodeID}
	];
	skos_AsyncAjaxLoad(data,
		function (response) {
			$('#skos-relations-block').html(response);
			
			if (skos_IsNodeLocked) {
				$('.addIcon,.deleteIcon,').hide();
				$('#object-properties-table').find('a').each(function(){
					$(this).replaceWith($(this).text());
				});
			}
		}
	);
}

function skos_editAssertion(type, label, uri, assertionId) {
	
	$('#assertion-id').val(assertionId);
	
	$('#edit-assertion-popup').find('.title').html(uri ? 'Edit Assertion' : 'Create Assertion');
	
	$('#assertion-type').removeAttr('disabled').val(type).attr('disabled', true);
	$('#assertion-label').html(label);

	if (type == 'InScheme' || type == 'TopConceptOf') {
		$('#assertion-concept-uri').hide();
		$('#assertion-scheme-uri').show().val(uri ? uri : '');
	} else {
		$('#assertion-concept-uri').show().val(uri ? uri : '');
		$('#assertion-scheme-uri').hide();
	}
	
	if (type == 'Other') {
		$('#assertion-type').hide();
		$('#assertion-type-2').show();
	} else {
		$('#assertion-type').show();
		$('#assertion-type-2').hide();
	}

	$('#edit-assertion-popup').find('.error-box').hide();
	$('#edit-assertion-popup').dialog('open');
}

function skos_CloseEditAssertion() {
	$('#edit-assertion-popup').dialog('close');
}

function skos_SaveAssertion() {
	var error = $('#edit-assertion-popup').find('.error-box');
	var waiting = $('#edit-assertion-popup').find('.skos-dialog-buttons-waiting-block');
	error.hide();
	waiting.show();
	var data = [
	    {'name': 'module', 'value': 'relations'},
	    {'name': 'action', 'value': 'save'},
	    {'name': 'assertion-id', 'value': $('#assertion-id').val()},
	    {'name': 'scheme-uri', 'value': $('#assertion-scheme-uri').val()},
	    {'name': 'concept-uri', 'value': $('#assertion-concept-uri').val()},
	    {'name': 'assertion-type', 'value': $('#assertion-type').val()},
	    {'name': 'assertion-type-2', 'value': $('#assertion-type-2').val()}
	];
	skos_AsyncAjaxRequest(data,
		function() {
			skos_loadAssertions();
			waiting.hide();
			skos_CloseEditAssertion();
			skos_HasModified();
		},
		function(json) {
			error.html(json.error).show();
			waiting.hide();
		}
	);
}

function skos_DeleteAssertion(assertionId) {
	if (confirm('Remove this assertion?')) {
		var data = [
            {'name': 'module', 'value': 'relations'},
			{'name': 'action', 'value': 'remove'},
			{'name': 'assertion-id', 'value': assertionId}
		];
		skos_AsyncAjaxRequest(data,
			function() {
				skos_HasModified();
			}
		);
		$('#object-properties-table').find('tr').each(function(){
			if ($(this).attr('skos-object-id') == assertionId) {
				$(this).fadeOut('slow', function(){$(this).remove()});
			}
		});
	}
}