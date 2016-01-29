
function skos_InitLabelPopups() {
	$('#label-type').html($('#tree-label-types').html());
	$('#label-type-2').html($('#tree-label-types-2').html());
	$('#label-language').html($('#tree-label-languages').html());
}

function skos_loadLabels() {
	var data = [
	    {'name': 'module', 'value': 'labels'},
		{'name': 'action', 'value': 'load'},
		{'name': 'id', 'value': skos_SelectedNodeID}
	];
	skos_AsyncAjaxLoad(data,
		function (response) {
			$('#skos-linguistics-block').html(response);

			if (skos_IsNodeLocked) {
				$('.addIcon,.deleteIcon,').hide();
				$('#data-properties-table').find('a').each(function(){
					$(this).replaceWith($(this).text());
				});
			}
		}
	);
}

function skos_editLabel(labelId, title, labelValue, labelType, labelLanguage, labelCategory) {
	$('#label-category').val(labelCategory);
	$('#label-id').val(labelId);
	$('#ui-dialog-title-edit-label-popup').html((labelId ? 'Edit ' : 'New ') + title);
	$('#label-type').val(labelType);
	$('#label-language').val(labelLanguage);
	$('#label-type-block').css('display', (labelCategory == 'otherLabel') ? 'table-row' : 'none');
	$('#edit-label-popup').find('.error-box').hide();
	$('#edit-label-popup').dialog('open');
	$('#label-value').val(labelValue).trigger('keyup');
}

function skos_CloseEditLabel() {
	$('#edit-label-popup').dialog('close');
}

function skos_SaveLabel() {
	var error = $('#edit-label-popup').find('.error-box');
	var waiting = $('#edit-label-popup').find('.skos-dialog-buttons-waiting-block');
	error.hide();
	waiting.show();
	var data = [
	    {'name': 'module', 'value': 'labels'},
	    {'name': 'action', 'value': 'save'},
		{'name': 'label-category', 'value': $('#label-category').val()},
	    {'name': 'label-id', 'value': $('#label-id').val()},
	    {'name': 'label-value', 'value': $('#label-value').val()},
	    {'name': 'label-type', 'value': $('#label-type').val()},
	    {'name': 'label-type-2', 'value': $('#label-type-2').val()},
	    {'name': 'label-language', 'value': $('#label-language').val()}
	];
	skos_AsyncAjaxRequest(data,
		function() {
			skos_loadLabels();
			waiting.hide();
			skos_CloseEditLabel();
			skos_HasModified();
		},
		function(json) {
			error.html(json).show();
			waiting.hide();
		}
	);
}

function skos_DeleteLabel(labelId) {
	if (confirm('Remove this label?')) {
		var data = [
            {'name': 'module', 'value': 'labels'},
			{'name': 'action', 'value': 'remove'},
			{'name': 'label-id', 'value': labelId}
		];
		skos_AsyncAjaxRequest(data,
			function() {
				skos_HasModified();
			}
		);
		$('#data-properties-table').find('tr').each(function(){
			if ($(this).attr('skos-object-id') == labelId) {
				$(this).fadeOut('slow', function(){$(this).remove()});
			}
		});
	}
}