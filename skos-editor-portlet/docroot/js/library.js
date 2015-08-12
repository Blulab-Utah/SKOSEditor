
	var skos_MyLibrary = null;
	
	$(document).ready(function(){
		
		skos_MyLibrary = new SKOS_Library();
		
		$('#load-from-library').click(function(){
			skos_MyLibrary.open();
			return false;
		});
		
		$('#save-to-library').click(function(){
			skos_SaveFile();
			return false;
		});
		
		$('#save-to-library-as-new').click(function(){
			$('#skos-file-id').val('');
			skos_SaveFile();
			return false;
		});
		
	});
	
	function skos_HideDownloadLink() {
		$('#skos-download-link-menu').hide();
	}
	
	function skos_ShowDownloadLink(skosFileId) {
		$('#skos-download-link-menu').show();
		//skos_showQuickHelp('skos-download-link', 'Download Available!', 300);
	}
	
	function skos_LoadFile(skosFileId) {
		skos_CloseViewSharedFiles();
		skos_MyLibrary.close();
		skos_ShowWaiting('Loading file. Please wait ...');
		$('#skos-library-form-action').val('load');
		$('#skos-library-form-id').val(skosFileId);
		skos_submitAjaxForm('skos-library-form', 
			function(json) {
				skos_CleanupEditor();
				if (json.access == '0') {
					$('#node-actions-block').find('button').attr('disabled', true);
				} else if (json.access != '2') {
					$('#node-actions-block').find('.delete-button').attr('disabled', true);
				}
				skos_CreateTree();
				skos_ShowDownloadLink(json.skosFileId);
				skos_ShowFileDetails(json);
				skos_CloseViewSharedFiles();
				skos_StartLoadingHistory();
			}
		);
	}

	function skos_ShowFileDetails(json) {
		$('#skos-file-id').val(json.skosFileId);
		$('#skos-file-version').val(json.skosFileVersion);
		var name = json.skosFileName + ', version ' + json.skosFileVersion;
		$('#title-block').html(name);
	}

	function skos_SaveFile() {
		if (skos_FileLoaded) {
			var skosFileId = $('#skos-file-id').val();
			if (skosFileId > 0) {
				skos_ShowWaiting('Saving file. Please wait ...');
				$('#skos-library-form-action').val('update');
				$('#skos-library-form-id').val(skosFileId);
				skos_submitAjaxForm('skos-library-form', 
					function(json) {
						skos_ShowFileDetails(json);
						skos_ShowDownloadLink();
						skos_HideWaiting();
					}
				);
			} else {
				$('#skos-library-save-form').dialog('open');
			}
		} else {
			skos_ShowWaiting('Nothing to save!', 500);
		}
	}

	function skos_DownloadFile() {
		var skosFileId = $('#skos-file-id').val();
		if (skosFileId > 0) {
			skos_ShowWaiting('Please wait ...');
			$('#skos-library-form-action').val('save-before-download');
			$('#skos-library-form-id').val(skosFileId);
			skos_submitAjaxForm('skos-library-form', 
				function(json) {
					location.href = '/skos-editor-portlet/download?id=' + skosFileId;
					skos_HideWaiting();
				}
			);
		}
	}

	function skos_RemoveFile(skosFileId) {
		if(confirm('Remove this file?')) {
			$('#skos-library-form-action').val('delete');
			$('#skos-library-form-id').val(skosFileId);
			skos_submitAjaxForm('skos-library-form', 
				function(json) {
					skos_MyLibrary.loadData();	
				}
			);
		}
	}

	function SKOS_Library() {
		
		// Library dialog
		$('#skos-library-form').dialog({
			title : 'My Files',
			autoOpen : false,
			show : 'fade',
			hide : 'fade',
			modal : true,
			resizable : false,
			width : 900,
			height: 300,
			open: function(event, ui) {
				skos_MyLibrary.loadData();
			}
		});
		
		// SaveFile dialog
		$('#skos-library-save-form').dialog({
			title : 'Save New File',
			autoOpen : false,
			show : 'fade',
			hide : 'fade',
			modal : true,
			resizable : false,
			width : 500,
			minHeight: 10,
			create: function(event, ui) {
				
				$('#skos-library-save-form').submit(function(){return false;});
	
				// create Submit/Cancel buttons
				var wrapper = document.createElement('div');
				$(wrapper).addClass('skos-dialog-buttons-block');
				$('#skos-library-save-form table').parent().append(wrapper);
	
				var submitButton = document.createElement('button');
				$(wrapper).append(submitButton);
				$(submitButton).addClass('btn');
				$(submitButton).addClass('btn-primary');
				$(submitButton).html('Submit');
				$(submitButton).click(function(){
					$(wrapper).find('.skos-dialog-buttons-waiting-block').show();
					$('#skos-library-form-action').val('add');
					var fileName = $('#skos-library-save-form-fileName').val();
					$('#skos-library-form-fileName').val(fileName);
					skos_submitAjaxForm('skos-library-form', 
						function(json) {
							$('#skos-file-id').val(json.skosFileId);
							$(wrapper).find('.skos-dialog-buttons-waiting-block').hide();
							skos_ShowDownloadLink();
							skos_ShowFileDetails(json);
							$('#skos-library-save-form').dialog('close');
						}
					);
					return false;
				});
	
				var cancelButton = document.createElement('button');
				$(wrapper).append(cancelButton);
				$(cancelButton).addClass('btn');
				$(cancelButton).addClass('btn-cancel');
				$(cancelButton).css('margin-left', '10px');
				$(cancelButton).html('Cancel');
				$(cancelButton).click(function(){
					$('#skos-library-save-form').dialog('close');
					return false;
				});
					
				var waitingImage = document.createElement('div');
				$(wrapper).append(waitingImage);
				$(waitingImage).addClass('skos-dialog-buttons-waiting-block');
			},
			open: function(event, ui) {
				skos_CleanupDialog('skos-library-save-form');	
			}
		});
		
		this.open = function() {
			$('#skos-library-form').dialog('open');
		}
		
		this.close = function() {
			$('#skos-library-form').dialog('close');
		}

		this.loadData = function() {
			$('#skos-library').html("<div style='text-align: center;'><img src='/html/themes/_unstyled/images/progress_bar/loading_animation.gif' style='margin: 10% auto;' /></div>");
			var data = [
			    {'name': 'action', 'value': 'load-library'}
			];
			skos_AsyncAjaxLoad(data, 
				function(html) {
					$('#skos-library').html(html);
				}
			);
		}

		this.add = function(id) {
			$('#skos-library-form-action').val('add');
			skos_submitAjaxForm('#skos-library-form', 
				function(data) {
					skos_MyLibrary.loadData();
				}
			);
		}

		this.load = function(id) {
			$('#skos-library-form-action').val('load');
			skos_submitAjaxForm('#skos-library-form', 
				function(data) {
					//
				}
			);
		}

		this.remove = function(id) {
			$('#skos-library-form-action').val('remove');
			$('#skos-library-form-id').val(id);
			skos_submitAjaxForm('#skos-library-form', 
				function(data) {
					skos_MyLibrary.loadData();
				}
			);
		}

		this.removeAll = function() {
			$('#skos-library-form-action').val('remove-all');
			$('#skos-library-form-id').val();
			skos_submitAjaxForm('#skos-library-form', 
				function(data) {
					skos_MyLibrary.loadData();
				}
			);
		}

	}