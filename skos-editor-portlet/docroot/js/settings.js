
	var skos_MySettings = null;
	
	$(document).ready(function(){
		
		skos_MySettings = new SKOS_Settings();
		
		$('#open-settings').click(function(){
			skos_MySettings.open();
			return false;
		});
	});
	
	function SKOS_Settings() {
		
		// Settings dialog
		$('#skos-settings').dialog({
			title : 'My Settings',
			autoOpen : false,
			show : 'fade',
			hide : 'fade',
			modal : true,
			resizable : false,
			width : 600,
			minHeight: 160,
			open: function(event, ui) {
				skos_MySettings.load();
			}
		});
		
		this.open = function() {
			$('#skos-settings').dialog('open');
		}
		
		this.close = function() {
			$('#skos-settings').dialog('close');
		}

		this.load = function() {
			var data = [
				{'name': 'action', 'value': 'load-settings'}
			];
			skos_loadAjaxData(data,
				function(data) {
					$('#skos-settings').html(data);
				}
			);
		}

		this.save = function(id) {
			$('#skos-settings').find('.skos-dialog-buttons-waiting-block').show();
			var data = [
				{'name': 'action', 'value': 'save-settings'},
				{'name': 'showConceptTitleAs', 'value': $('#settings-show-as').val()},
				{'name': 'showConceptTitleLanguageAs', 'value': $('#settings-show-as-lang').val()}
			];
			skos_loadAjaxData(data, 
				function(data) {
					skos_CreateTree();
					$('#skos-settings').find('.skos-dialog-buttons-waiting-block').hide();
					skos_MySettings.close();
				}
			);
		}

	}