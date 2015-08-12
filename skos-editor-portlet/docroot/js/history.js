
var skos_HistoryActive = false;
var skos_HistoryRefreshInterval = 5000;
var skos_HistoryTimer = null;

function skos_StartLoadingHistory() {
	$('#skos-history-block').show();
	skos_RefreshHistory();
}

function skos_RefreshHistory() {
	clearTimeout(skos_HistoryTimer);
	var data = [
	    {'name': 'action', 'value': 'load-history'}
   	];
	skos_SyncAjaxLoad(data,
   		function (response) {
   			$('#skos-history').html(response);
   			skos_HistoryTimer = setTimeout(function(){skos_RefreshHistory();}, skos_HistoryRefreshInterval);
   			
   			skos_ProcessCollaboration();
   		}
   	);
}

function skos_StopLoadingHistory() {
	clearTimeout(skos_HistoryTimer);
}

function skos_ToggleHistory() {
	$('#skos-history').toggle();
	skos_HistoryActive = !skos_HistoryActive;
}

function skos_ProcessCollaboration() {

	$('input[name="collaboration"]').each(function(){
		var updateType = $(this).attr('skos-update-type');
		var schemeURI = $(this).attr('skos-schemeURI');
		var conceptURI = $(this).attr('skos-conceptURI');
		var value = $(this).attr('skos-value');
		console.log('Performing [' + updateType + '] with value=[' + value + ']');
		if (updateType == 'rename-scheme') {
			$('#selected-node-1').html(value);
		} else if (updateType == 'rename-concept') {
			$('.skos-node-title').each(function(){
				if ($(this).attr('skos-node-uri') == conceptURI) {
					$(this).html(value);
				}
			});
		} else if ((updateType == 'add-related-assertion') 
					|| (updateType == 'add-inscheme-assertion')
					|| (updateType == 'add-topconceptof-assertion')
					|| (updateType == 'add-broader-assertion')
					|| (updateType == 'add-narrower-assertion')
					|| (updateType == 'add-other-assertion')
					|| (updateType == 'remove-assertion')) {
			if ($('#selected-node-' + skos_SelectedNodeID).attr('skos-node-uri') == conceptURI) {
				skos_loadAssertions();
			}
		} else if ((updateType == 'add-preferred-label') 
					|| (updateType == 'add-notation-label')
					|| (updateType == 'add-altlabel-label')
					|| (updateType == 'add-hidden-label')
					|| (updateType == 'add-other-label')
					|| (updateType == 'remove-label')) {
			if ($('#selected-node-' + skos_SelectedNodeID).attr('skos-node-uri') == conceptURI) {
				skos_loadLabels();
			}
		} else if (updateType == 'remove-concept') {
			$('.skos-node-title').each(function(){
				if ($(this).attr('skos-node-uri') == conceptURI) {
					var id = $(this).attr('skos-node-id');
					var parentId = $(this).attr('skos-node-parent-id');
					$('#skos-tree-node-' + id).fadeOut('slow', 
						function(){
							$(this).remove();
							if ($('#tree-children-block-' + parentId).is(':empty')) {
								$('#expand-node-' + parentId).removeClass('skos-locked').css('visibility', 'hidden');
							}
						});
				}
			});			
		} else if ((updateType == 'add-concept') || (updateType == 'remove-concept')) {
			$('.skos-node-title').each(function(){
				if ($(this).attr('skos-node-uri') == conceptURI) {
					var id = $(this).attr('skos-node-id');
					skos_ExpandNode(id);
					$('#selected-node-' + skos_SelectedNodeID).parent().addClass('selected-node');
				}
			});
		}
	});

	$('.skos-locked').removeClass('skos-locked');
	$('input[name="lock"]').each(function(){
		var uri = this.value;
		$('.skos-node-title').each(function(){
			if ($(this).attr('skos-node-uri') == uri) {
				$(this).prev().addClass('skos-locked');
			}
		});
	});
}
