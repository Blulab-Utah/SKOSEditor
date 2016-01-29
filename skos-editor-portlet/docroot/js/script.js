var skos_FileLoaded = false;
var skos_SelectedNodeID = null;

$(document).ready(function() {
	
	var buttons = $('#skos-default-buttons-block');
 	$('#skos-relations-block').append(buttons);
	$(buttons).show();
						   
	// setup upload examples
	$('.skos-upload-url-example').click(function(e){
		e.stopPropagation();
		$('#upload-url').val($(this).text());
		$('#upload-from-url-form').find('.btn-primary').trigger('click');
		return false;
	});
	
	// 'Create New KB' dialog
	$('#create-new-kb').SKOSDialog({ 
		formId: 'create-new-kb-form',
		title: 'Create New SKOS Knowledge Base',
		width: 600,
		submitHandler: function(data) {
			skos_CleanupEditor();
			skos_CreateTree();
		}
	});
	
	// 'Upload From URL' dialog
	$('#upload-from-url-link').SKOSDialog({  
		formId: 'upload-from-url-form',
		title: 'Upload SKOS file from URL',
		width: 600,
		submitHandler: function(data){
			skos_CleanupEditor();
			skos_CreateTree();
		}
	});
	
	// 'Upload SKOS File' dialog
	$('#upload-skos-file-link').SKOSDialog({  
		formId: 'upload-skos-file-form',
		title: 'Upload a local SKOS file',
		width: 500,
		clickHandler: function(){
			skos_CleanupEditor();
			$('#upload-skos-file-form-popup').find('.skos-dialog-buttons-waiting-block').show();
			var formId = 'upload-skos-file-form';
			var url = $('#upload-skos-file-form').attr('action');
	        var file = $('#upload-skos-file').val();
			YUI().use('io-upload-iframe', 'json-parse', function(Y){
				Y.io(url,{
					method: 'POST',
					form: {
						id: formId,
						upload: true
					},
					on: {
						complete: function(id, response) {
							$('#upload-skos-file-form-popup').find('.skos-dialog-buttons-waiting-block').hide();
							skos_CreateTree();
							$('#upload-skos-file-form-popup').dialog('close');
						}
					}
				});
			});
		}
	});
	
	// 'Upload SKOS File' dialog
	$('#upload-excel-file-link').SKOSDialog({  
		formId: 'upload-excel-file-form',
		title: 'Upload a local Excel file',
		width: 500,
		clickHandler: function(){
			skos_CleanupEditor();
			$('#upload-excel-file-form-popup').find('.skos-dialog-buttons-waiting-block').show();
			var formId = 'upload-excel-file-form';
			var url = $('#upload-excel-file-form').attr('action');
	        var file = $('#upload-excel-file').val();
			YUI().use('io-upload-iframe', 'json-parse', function(Y){
				Y.io(url,{
					method: 'POST',
					form: {
						id: formId,
						upload: true
					},
					on: {
						complete: function(id, response) {
							$('#upload-excel-file-form-popup').find('.skos-dialog-buttons-waiting-block').hide();
							skos_CreateTree();
							$('#upload-excel-file-form-popup').dialog('close');
						}
					}
				});
			});
		}
	});
	
	$('#edit-tree-node-popup').dialog({
		title : 'Edit Tree',
		autoOpen : false,
		show : null,
		hide : null,
		modal : true,
		resizable : false,
		width : 800
	});
	
	$('#edit-assertion-popup').dialog({
		title : 'Edit Assertion',
		autoOpen : false,
		show : null,
		hide : null,
		modal : true,
		resizable : false,
		width : 800
	});
	
	$('#edit-label-popup').dialog({
		title : 'Edit Label',
		autoOpen : false,
		show : null,
		hide : null,
		modal : true,
		resizable : false,
		width : 800
	});
	
	$('#share-now-popup').dialog({
		title : 'Share Now',
		autoOpen : false,
		show : null,
		hide : null,
		modal : true,
		resizable : false,
		width : 500
	});
	
	$('#shared-files-popup').dialog({
		title : 'My Shared Files',
		autoOpen : false,
		show : 'fade',
		hide : 'fade',
		modal : true,
		resizable : false,
		width : 1000
	});
	
	$('textarea').autogrow({onInitialize: true});
	
	$('#register-popup').dialog({
		title : 'Register',
		autoOpen : false,
		show : 'fade',
		hide : 'fade',
		modal : true,
		resizable : false,
		width : 500
	});
	
	skos_InitAutoSave();
});

function skos_CleanupDialog(formId) {
	$('.skos-dialog-input-error').remove();
	$('.skos-dialog-buttons-waiting-block').hide();
	$('#' + formId + ' input[type=text]').val('');
	$('#' + formId + ' input[type=file]').val('');
	$('#' + formId + ' textarea').val('');
	$('#' + formId + ' select').val('');
}

function skos_CleanupEditor() {
	skos_StopLoadingHistory();
	$('#skos-file-id').val('');
	$('#object-properties-table,#selected-concept-object-properties,#data-properties-table,#selected-concept-data-properties').html('');
	skos_HideDownloadLink();
	$('.filename-label-block').remove();
	$('#node-actions-block').find('button').removeAttr('disabled');
}

function skos_ShowInputError(targetId, message) {
	$('#' + targetId).parent().append('<div class="skos-dialog-input-error" onmouseover="$(this).remove();">' + message + '</div>');
}

function skos_ShowWaiting(message, autoClose) {
	$.blockUI({
		message: message ? message : 'Please wait ...', 
		timeout: autoClose ? 2000 : 0, 
		css: {
			border: 'none', 
			padding: '15px', 
			backgroundColor: '#000000', 
			'-webkit-border-radius': '10px', 
			'-moz-border-radius': '10px', 
			opacity: .6, 
			color: '#ffffff' 
		} 
	});
}

function skos_HideWaiting() {
	$.unblockUI();
}

/**
 *	Quick help tooltip
 */
	
function skos_showQuickHelp(objectId, message, timeout) {
	setTimeout(function(){
		$('#' + objectId).attr('title', message).qtip({
			show: 'mouseover',
			hide: 'mouseout',
			position: {
				corner: {
					target: 'topLeft',
					tooltip: 'bottomRight'
				}
			},
			style: {
				width: {
					min: 200
				},
				background: '#FFFFFF',
				color: '#990000',
				border : {
					width: 2,
					radius : 4
				},
				textAlign: 'center',
				tip: 'bottomRight',
				name: 'red',
				fontWeight: 'bold',
				fontSize: '15px'
			}
		}).trigger("mouseover");
	}, timeout);
}

function skos_CreateTree() {
	$('#concept-actions-block').hide();
	$('#skos-relations-block').html('');
	$('#skos-linguistics-block').html('');
	$('#skos-tree-block').html("<div style='text-align: center;'><img src='/html/themes/_unstyled/images/progress_bar/loading_animation.gif' style='margin: 20% auto;' /></div>");
	var _DEBUG_START = new Date().getTime();
	skos_loadAjaxData([{'name': 'action', 'value': 'load-tree'}],
		function(html) {
			$('#skos-tree-block').html(html).promise().done(function(){
				
				$('#skos-default-buttons-block').remove();
				skos_HideWaiting();
				skos_FileLoaded = true;
				$('#skos-menu-tools').fadeIn('slow');
				$('#skos-share-tools').fadeIn('slow');

				// console.log('Tree loaded in ' + (new Date().getTime() - _DEBUG_START) / 1000 + ' seconds');
			
				if($('#selected-node-' + skos_SelectedNodeID)[0]) {
					$('#selected-node-' + skos_SelectedNodeID).trigger('click');
				} else {
					skos_SelectedNodeID = null;
					$('.skos-node-title').first().trigger('click');
				}
				
				$('#concept-actions-block').show();
				skos_ShowSchemeActionsBlock();
				
				skos_StartLoadingHistory();
				
				skos_HideWaiting();
				
				skos_InitTreePopups();
				skos_InitAssertionPopups();
				skos_InitLabelPopups();
				
				$('#save-to-library-menu').show();
				$('#save-to-library-as-new-menu').show();
				$('#share-now-menu').show();
			});
		}
	);
}

function skos_ShowSchemeActionsBlock() {
	$('#scheme-actions-block').show().animate({
		opacity: '1'
	});
	$('#concept-actions-block').hide().animate({
		opacity: '0'
	});
}

function skos_ShowConceptActionsBlock() {
	$('#scheme-actions-block').hide().animate({
		opacity: '0'
	});
	$('#concept-actions-block').show().animate({
		opacity: '1'
	});
}

function skos_applyDefaultMessage(id) {
	var obj = $('#' + id);
	var text = obj.attr('skos-default-text');
	if (obj.val() == '') {
		obj.val(text);
	}
	obj.focus(function(){
		if (this.value == $(this).attr('skos-default-text')) {
			this.value = '';
		}
	});
	obj.blur(function(){
		if (this.value == '') {
			this.value = $(this).attr('skos-default-text');
		}
	});
}

function skos_AsyncAjaxRequest(postData, successHandler, errorHandler) {
	$.ajax({
		type: 'POST',
		url: ajaxURL,
		data: postData,
		dataType: 'json',
		async: false,
		success: function(json) {
			if (json && json.error) {
				if (errorHandler) {
					errorHandler(json.error);
				} else {
					alert('Error: ' + json.error);
				}
			} else if (successHandler) {
				successHandler(json);
			}
		}
	});
}

function skos_AsyncAjaxLoad(postData, successHandler, errorHandler) {
	$.ajax({
		type: 'POST',
		url: ajaxURL,
		data: postData,
		async: true,
		success: function(json) {
			if (json && json.error) {
				if (errorHandler) {
					errorHandler(json.error);
				} else {
					alert('Error: ' + json.error);
				}
			} else if (successHandler) {
				successHandler(json);
			}
		}
	});
}

function skos_SyncAjaxLoad(postData, successHandler, errorHandler) {
	$.ajax({
		type: 'POST',
		url: ajaxURL,
		data: postData,
		async: false,
		success: function(json) {
			if (json && json.error) {
				if (errorHandler) {
					errorHandler(json.error);
				} else {
					alert('Error: ' + json.error);
				}
			} else if (successHandler) {
				successHandler(json);
			}
		}
	});
}

/**
 * Registration
 */

function skos_OpenRegister() {
	$('#register-popup').find('input').val('');
	$('#register-popup').dialog('open');
}

function skos_CloseRegister() {
	$('#register-popup').dialog('close');
}

function skos_SubmitRegister() {
	var error = $('#register-popup').find('.error-box');
	var waiting = $('#register-popup').find('.skos-dialog-buttons-waiting-block');
	error.hide();
	waiting.show();
	var data = [
	    {'name': 'action', 'value': 'register'},
		{'name': 'first-name', 'value': $('#register-first-name').val()},
	    {'name': 'last-name', 'value': $('#register-last-name').val()},
	    {'name': 'email', 'value': $('#register-email').val()},
	    {'name': 'password', 'value': $('#register-password').val()},
	    {'name': 'password-2', 'value': $('#register-password-2').val()}
	];
	skos_AsyncAjaxRequest(data,
		function() {
			skos_CloseRegister();
			$('#register-complete-popup').dialog({
				title : 'Registration Completed',
				autoOpen : true,
				show : 'fade',
				hide : 'fade',
				modal : true,
				resizable : false,
				width : 400
			});
		},
		function(errorText) {
			error.html(errorText).show();
			waiting.hide();
		}
	);
}

var skos_FileHasModified = false;
var skos_AutoSaveTimer = null;
var skos_AutoSaveInterval = 10000;

function skos_InitAutoSave() {
	skos_AutoSaveTimer = setInterval(skos_AutoSave, skos_AutoSaveInterval);
}

function skos_HasModified() {
	skos_FileHasModified = true;
}

function skos_AutoSave() {
	if (!skos_FileHasModified) {
		return;
	}
	skos_processAjaxRequest([{'name': 'action', 'value': 'auto-save'}], 
		function() {
			var now = new Date(); 
			console.log('Auto-saved at ' + now.getHours() + ":" + now.getMinutes());
			skos_FileHasModified = false;
		}
	);
}

function skos_PreloadImage(url) {
    var img = new Image();
    img.src = url;
}

function skos_UpdateTopMenu(items) {
	
}