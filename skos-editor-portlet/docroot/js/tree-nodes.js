
var skos_SelectedNodeParentId = 0;
var skos_IsNodeLocked = false;

function skos_InitTreePopups() {
	$('#edit-tree-node-popup').find('#tree-add-top-concept-scheme').html($('#tree-schemes').html());
	$('#edit-tree-node-popup').find('#tree-move-concept-uri').html($('#tree-concepts').html());
	$('#skos-wizard-parent').html($('#tree-concepts').html());
}

function skos_OnClickNode(obj) {
	$('.selected-node').removeClass('selected-node');
	$(obj).parent().addClass('selected-node');

	var obj2 = $(obj).prev();
	if (obj2.hasClass('schema')) {
		skos_ShowSchemeActionsBlock();
	} else if (obj2.hasClass('topConcept')) {
		skos_ShowConceptActionsBlock();
	} else if (obj2.hasClass('concept')) {
		skos_ShowConceptActionsBlock();
	}

	skos_SelectedNodeID = $(obj).attr('skos-node-id');
	skos_SelectedNodeParentId = $(obj).attr('skos-node-parent-id');

	skos_loadAssertions();
	skos_loadLabels();
	
	skos_IsNodeLocked = $(obj).prev().hasClass('skos-locked');
	if (skos_IsNodeLocked) {
		$('#node-actions-block').find('button').attr('disabled', true);
	} else {
		$('#node-actions-block').find('button').removeAttr('disabled', true);
	}
}

function skos_ToggleNode(id) {
	var obj = $('#expand-node-' + id);
	var block = $('#tree-children-block-' + id);
	if (obj.hasClass('expandNode')) {
		obj.removeClass('expandNode').addClass('collapseNode');
		block.html('<img style="margin: 0px auto 3px 30px;" src="/html/themes/_unstyled/images/aui/loading_indicator.gif" />').show();
		data = [
		    {'name': 'action', 'value': 'load-tree-node-children'},
		    {'name': 'id', 'value': id}
		];
		skos_SyncAjaxLoad(data,
			function(response) {
				block.html($.trim(response));
			}
		);
	} else if (obj.hasClass('collapseNode')) {
		obj.removeClass('collapseNode').addClass('expandNode');
		block.slideToggle('fast');
		block.html('');
	}
}

function skos_ExpandNode(id) {
	var obj = $('#expand-node-' + id);
	obj.css('visibility', 'visible');
	var block = $('#tree-children-block-' + id);
	obj.removeClass('expandNode').addClass('collapseNode');
	block.html('<img style="margin: 0px auto 3px 30px;" src="/html/themes/_unstyled/images/aui/loading_indicator.gif" />').show();
	data = [
	    {'name': 'action', 'value': 'load-tree-node-children'},
	    {'name': 'id', 'value': id}
	];
	skos_SyncAjaxLoad(data,
		function(response) {
			block.html($.trim(response));
		}
	);
}

function skos_LoadTreeNode(nodeId) {
	var obj = $('#skos-tree-node-' + nodeId);
	obj.html('<img style="margin: 0px auto 3px 30px;" src="/html/themes/_unstyled/images/aui/loading_indicator.gif" />');
	data = [
	    {'name': 'action', 'value': 'load-tree-node'},
	    {'name': 'id', 'value': nodeId}
	];
	skos_SyncAjaxLoad(data,
		function(response) {
			obj.replaceWith($.trim(response));
		}
	);
}

function skos_EditTreeNode(action) {
	if (action == 'move-concept-to-top') {
		skos_MoveTreeNodeToTop()
	} else if (action == 'remove-concept') {
		skos_DeleteTreeNode();
	} else {
		$('#tree-node-action-type').val(action);
		$('#edit-tree-node-popup').find('.action-block').hide();
		$('#' + action + '-block').show();
		var label = 'Edit Tree';
		if (action == 'rename-scheme') {
			label = 'Rename Scheme';
			$('#tree-rename-scheme-name').val($('.skos-node-title').first().attr('skos-node-title'));
		} else if (action == 'add-top-concept') {
			label = 'Add Top Concept';
			$('#tree-add-top-concept-name').val('');
		} else if (action == 'add-concept') {
			label = 'Add Concept';
			$('#tree-add-concept-parent').removeAttr('disabled').val($('#selected-node-' + skos_SelectedNodeID).attr('skos-node-uri')).attr('disabled', true);
			$('#tree-add-concept-name').val('');
		} else if (action == 'rename-concept') {
			label = 'Rename Concept';
			$('#tree-rename-concept-name').val($('#selected-node-' + skos_SelectedNodeID).attr('skos-node-title'));
		} else if (action == 'move-concept') {
			label = 'Move Concept';
			$('#tree-move-concept-parent').val($('#selected-node-' + skos_SelectedNodeID).attr('skos-node-parent-uri'));
		}
		$('#ui-dialog-title-edit-tree-node-popup').html(label);
		
		$('#edit-tree-node-popup').find('.error-box').hide();
		$('#edit-tree-node-popup').dialog('open');
	}
}

function skos_CloseEditTreeNode() {
	$('#edit-tree-node-popup').dialog('close');
}

function skos_SaveTreeNode() {
	var errorBox = $('#edit-tree-node-popup').find('.error-box');
	errorBox.hide();
	var actionType = $('#tree-node-action-type').val();
	var data = null;
	if (actionType == 'add-top-concept') {
		data = [
		    {'name': 'module', 'value': 'tree'},
		    {'name': 'action', 'value': 'save'},
		    {'name': 'action-type', 'value': actionType},
			{'name': 'scheme-uri', 'value': $('#tree-add-top-concept-scheme').val()},
		    {'name': 'concept-name', 'value': $('#tree-add-top-concept-name').val()}
		];
	} else if (actionType == 'rename-scheme') {
		data = [
		    {'name': 'module', 'value': 'tree'},
		    {'name': 'action', 'value': 'save'},
		    {'name': 'action-type', 'value': actionType},
			{'name': 'scheme-name', 'value': $('#tree-rename-scheme-name').val()}
		];
	} else if (actionType == 'add-concept') {
		data = [
		    {'name': 'module', 'value': 'tree'},
		    {'name': 'action', 'value': 'save'},
		    {'name': 'action-type', 'value': actionType},
			{'name': 'parent-concept-uri', 'value': $('#tree-add-concept-parent').val()},
			{'name': 'concept-name', 'value': $('#tree-add-concept-name').val()}
		];
	} else if (actionType == 'rename-concept') {
		data = [
		    {'name': 'module', 'value': 'tree'},
		    {'name': 'action', 'value': 'save'},
		    {'name': 'action-type', 'value': actionType},
			{'name': 'concept-uri', 'value': $('#selected-node-' + skos_SelectedNodeID).attr('skos-node-uri')},
			{'name': 'concept-name', 'value': $('#tree-rename-concept-name').val()}
		];
	} else if (actionType == 'move-concept') {
		data = [
		    {'name': 'module', 'value': 'tree'},
		    {'name': 'action', 'value': 'save'},
		    {'name': 'action-type', 'value': actionType},
			{'name': 'concept-uri', 'value': $('#selected-node-' + skos_SelectedNodeID).attr('skos-node-uri')},
			{'name': 'parent-concept-uri', 'value': $('#selected-node-' + skos_SelectedNodeID).attr('skos-node-parent-uri')},
			{'name': 'new-parent-concept-uri', 'value': $('#tree-move-concept-uri').val()}
		];
	}
	skos_AsyncAjaxRequest(data,
		function() {
			skos_HasModified();
			skos_CloseEditTreeNode();
			if (actionType == 'add-top-concept') {
				skos_ExpandNode(1);
			} else if (actionType == 'rename-scheme') {
				var name = $('#tree-rename-scheme-name').val();
				name = name.substring(name.indexOf('#') + 1).replace(' ', '_');
				$('#selected-node-1').html(name);
			} else if (actionType == 'add-concept') {
				skos_ExpandNode(skos_SelectedNodeID);
			} else if (actionType == 'rename-concept') {
				var name = $('#tree-rename-concept-name').val().replace(' ', '_');
				$('#selected-node-' + skos_SelectedNodeID).html(name);
			} else if (actionType == 'move-concept') {
				skos_CreateTree();
			}
			skos_ReloadDropdowns();
		},
		function(error) {
			errorBox.html(error).show();
		}
	);
}

function skos_MoveTreeNodeToTop() {
	var data = [
	    {'name': 'module', 'value': 'tree'},
	    {'name': 'action', 'value': 'save'},
	    {'name': 'action-type', 'value': 'move-concept-to-top'},
		{'name': 'concept-uri', 'value': $('#selected-node-' + skos_SelectedNodeID).attr('skos-node-uri')},
		{'name': 'parent-concept-uri', 'value': $('#selected-node-' + skos_SelectedNodeID).attr('skos-node-parent-uri')},
		{'name': 'scheme-uri', 'value': $('.skos-node-title').first().attr('skos-node-uri')}
	];
	skos_AsyncAjaxRequest(data, 
		function(){
			skos_CreateTree();
			skos_HasModified();
		}
	);
}

function skos_DeleteTreeNode() {
	if (confirm('Remove this node?')) {
		var data = [
            {'name': 'module', 'value': 'tree'},
		    {'name': 'action', 'value': 'save'},
		    {'name': 'action-type', 'value': 'remove-concept'},
			{'name': 'concept-uri', 'value': $('#selected-node-' + skos_SelectedNodeID).attr('skos-node-uri')}
		];
		skos_AsyncAjaxRequest(data, 
			function(){
				$('#skos-tree-node-' + skos_SelectedNodeID).fadeOut('slow', 
					function(){
						$(this).remove();
						if ($('#tree-children-block-' + skos_SelectedNodeParentId).is(':empty')) {
							$('#expand-node-' + skos_SelectedNodeParentId).css('visibility', 'hidden');
						}
					});
				skos_HasModified();
				skos_ReloadDropdowns();
			}
		);
	}
}

function skos_ReloadDropdowns() {
	data = [
	    {'name': 'action', 'value': 'load-dropdowns'}
	];
	skos_SyncAjaxLoad(data,
		function(response) {
			$('#skos-dropdowns').html($.trim(response));
			skos_InitAssertionPopups();
			skos_InitLabelPopups();
		}
	);
}