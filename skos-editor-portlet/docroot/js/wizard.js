	
	var skos_Wizard = null;
	var skos_Wizard_SelectedURI = null;
	
	$(document).ready(function(){
		
		skos_Wizard = new SKOS_Wizard();
		
		$('#create-class-hierarchy').click(function(){
			skos_Wizard.open();
			return false;
		});
		
	});
	
	/**
	 *	Create Class Hierarchy Wizard
	 */

	function SKOS_Wizard() {
		
		var self = this;
		var formId = 'skos-wizard-popup';
		var form = $('#' + formId);
		
		// Wizard dialog
		form.dialog({
			title : 'Create Class Hierarchy',
			autoOpen : false,
			show : 'fade',
			hide : 'fade',
			modal : true,
			resizable : false,
			width : 900,
			minHeight: 10,
			open: function(event, ui) {
				self.load();
			}
		});

		this.open = function() {
			form.dialog('open');
		}
		
		this.close = function() {
			form.dialog('close');
		}
		
		this.load = function() {
			$('#skos-wizard-parent').html($('#tree-concepts').html());
			$('#skos-wizard-parent').val($('#selected-node-' + skos_SelectedNodeID).attr('skos-node-uri'));
			
			$('#skos-wizard-popup').find('.skos-dialog-buttons-waiting-block').hide();
			
			$('#skos-wizard-popup').find('textarea').val('');
			skos_AddTabSupport('skos-wizard-hierarchy');
			skos_applyDefaultMessage('skos-wizard-prefix');
			skos_applyDefaultMessage('skos-wizard-suffix');
			skos_applyDefaultMessage('skos-wizard-hierarchy');
		}
		
		this.save = function() {
			var hierarchy = $('#skos-wizard-hierarchy').val();
			if (hierarchy == $('#skos-wizard-hierarchy').attr('skos-default-text')) {
				return;
			}
			var prefix = $('#skos-wizard-prefix').val();
			if (prefix == $('#skos-wizard-prefix').attr('skos-default-text')) {
				prefix = '';
			}
			var suffix = $('#skos-wizard-suffix').val();
			if (suffix == $('#skos-wizard-suffix').attr('skos-default-text')) {
				suffix = '';
			}
			$('#skos-wizard-popup').find('.skos-dialog-buttons-waiting-block').show();
			var data = [
				{'name': 'action', 'value': 'save-wizard'},
				{'name': 'parent', 'value': $('#skos-wizard-parent').val()},
				{'name': 'hierarchy', 'value': hierarchy},
				{'name': 'prefix', 'value': prefix},
				{'name': 'suffix', 'value': suffix}
			];
			skos_loadAjaxData(data,
				function(data) {
					skos_CreateTree();
					self.close();
				}
			);
		}
		
	}
	
	function skos_TabKeyHandler(e) {
		var TABKEY = 9;
	    if (e.keyCode == TABKEY) {
	    	this.value += "    ";
	   		if (e.preventDefault) {
	    		e.preventDefault();
	    	}
	    	return false;
	 	}
	}

	function skos_AddTabSupport(id) {
		var myInput = document.getElementById(id);
	    if (myInput.addEventListener) {
	        myInput.addEventListener('keydown', skos_TabKeyHandler, false);
	    } else if(myInput.attachEvent) {
	        myInput.attachEvent('onkeydown', skos_TabKeyHandler);
	    }
	}