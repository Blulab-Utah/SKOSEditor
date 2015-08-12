
	function skos_OpenShareNow() {
		$('#share-now-popup').find('.error-box').html('').hide();
		$('#share-access').val('');
		$('#share-email').val('');
		$('#share-file-title').removeAttr('disabled').val($('#title-block').html()).attr('disabled', true);
		$('#share-now-popup').find('button').show();

		if (!skos_FileLoaded) {
			$('#share-now-popup').find('.error-box').html('No file selected').show();
			$('#share-now-popup').find('button').hide();
		}
		
		$('#share-now-popup').dialog('open');
	}
	
	function skos_CloseShareNow() {
		$('#share-now-popup').dialog('close');
	}
	
	function skos_ShareNow() {
		var errorBox = $('#share-now-popup').find('.error-box');
		var waiting = $('#share-now-popup').find('.skos-dialog-buttons-waiting-block');
		errorBox.hide();
		waiting.show();
		var data = [
		    {'name': 'module', 'value': 'share'},
		    {'name': 'action', 'value': 'share'},
			{'name': 'skosFileId', 'value': $('#skos-file-id').val()},
			{'name': 'access', 'value': $('#share-access').val()},
			{'name': 'email', 'value': $('#share-email').val()}
		];
		skos_AsyncAjaxRequest(data,
			function() {
				waiting.hide();
				skos_CloseShareNow();
				skos_OpenViewSharedFiles();
			},
			function(error) {
				errorBox.html(error).show();
				waiting.hide();
			}
		);
	}
	
	function skos_LoadSharedFiles() {
		$('#skos-share').html("<div style='text-align: center;'><img src='/html/themes/_unstyled/images/progress_bar/loading_animation.gif' style='margin: 10% auto;' /></div>");
		var data = [
		    {'name': 'module', 'value': 'share'},
		    {'name': 'action', 'value': 'load'}
		];
		skos_AsyncAjaxLoad(data, 
			function(html) {
				$('#skos-share').html(html);
			}
		);
	}
	
	function skos_OpenViewSharedFiles() {
		$('#shared-files-popup').dialog('open');
		skos_LoadSharedFiles();
	}

	function skos_CloseViewSharedFiles() {
		$('#shared-files-popup').dialog('close');
	}
	
	function skos_ChangeFileAccess(skosFileId, access) {
		if ((access == -1) && !confirm('Stop sharing this file?')) {
			return;
		}
		var data = [
		    {'name': 'module', 'value': 'share'},
		    {'name': 'action', 'value': 'change-access'},
			{'name': 'skosFileId', 'value': skosFileId},
			{'name': 'access', 'value': access}
		];
		skos_AsyncAjaxRequest(data,
			function() {
				if (access == -1) {
					skos_LoadSharedFiles();
				} else {
					skos_ShowQuickMessage('access-updated-message');
				}
			}
		);
	}
	
	function skos_ShowQuickMessage(id) {
		$('#' + id).animate({
			opacity: '1'
		});
		setTimeout(function(){skos_HideQuickMessage(id)}, 2000);
	}
	
	function skos_HideQuickMessage(id) {
		$('#' + id).animate({
			opacity: '0'
		});
	}
