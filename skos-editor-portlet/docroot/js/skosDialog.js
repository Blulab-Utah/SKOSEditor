/*!
 * Author: Artem Khojoyan
 * jQuery SKOS Dialog Plugin
 * artem.khojoyan@gmail.com
 * Date: July 17, 2014
 */
(function($) {

	$.fn.SKOSDialog = function(options) {

		var defaults = {
			'formId': '',
			'title': 'SKOS Dialog',
			'width': 560,
			'beforeSubmitHandler': null,
			'submitHandler': null,
			'cancelHandler' : null,
			'requestURL' : null,
			'clickHandler': false,
			'method': 'POST'
		};

		var options =  $.extend(defaults, options);

		return this.each(function(){
			$('#' + options.formId).submit(function(){return false;});

			var popupId = options.formId + '-popup';
			if(!document.getElementById(options.formId + '-popup')) {
				$('#' + options.formId).wrap('<div id="' + popupId + '"></div>');
			}

			$(this).click(function(){
				$('#' + popupId).dialog({
					title : options.title,
					autoOpen : false,
					show : null,
					hide : null,
					modal : true,
					resizable : false,
					width : options.width,
					minHeight: 10,
					create: function(event, ui) {
						// create Submit/Cancel buttons
						var wrapper = document.createElement('div');
						$(wrapper).addClass('skos-dialog-buttons-block');
						$('#' + options.formId + ' table').parent().append(wrapper);
						
						var cancelButton = document.createElement('a');
						$(wrapper).append(cancelButton);
						$(cancelButton).attr('href', '#');
						$(cancelButton).html('Cancel');
						$(cancelButton).click(function(){
							$('#' + popupId).dialog('close');
							return false;
						});

						var submitButton = document.createElement('button');
						$(wrapper).append(submitButton);
						$(submitButton).addClass('btn');
						$(submitButton).addClass('btn-primary');
						$(submitButton).html('Submit');
						if(options.clickHandler) {
							$(submitButton).click(function(){
								options.clickHandler();
							});
						} else if(options.submitHandler) {
							$(submitButton).click(function(){
								$(wrapper).find('.skos-dialog-buttons-waiting-block').show();
								skos_submitAjaxForm(options.formId, 
									function(data){
										options.submitHandler(data);
										$(wrapper).find('.skos-dialog-buttons-waiting-block').hide();
										$('#' + popupId).dialog('close');
									},
									function(data){
										var errorInfo = data.error.split(';');
										if(errorInfo[0]) {
											skos_ShowInputError(errorInfo[0], errorInfo[1]);
										} else {
											// attach error to the first textfield by default
											var id = $('#' + options.formId + ' input').get(0).attr('id');
											skos_ShowInputError(id, data.error);
										}
										$(wrapper).find('.skos-dialog-buttons-waiting-block').hide();
									},
									options.method
								);
							});
						}

						var waitingImage = document.createElement('div');
						$(wrapper).append(waitingImage);
						$(waitingImage).addClass('skos-dialog-buttons-waiting-block');
					},
					open: function(event, ui) {
						skos_CleanupDialog(options.formId);
						
						// custom initialization
						if(options.beforeSubmitHandler) {
							options.beforeSubmitHandler();
						}
					}
				}).dialog('open');
				return false;
			});
		});
	};

})(jQuery);

function skos_submitAjaxForm(formId, successHandler, errorHandler, method) {
	var form = $('#' + formId);
	$.ajax({
		type: 'POST',
		url: form.attr('action'),
		data: form.serialize(),
		dataType: 'json',
		success: function(data) {
			if(data.error) {
				if(errorHandler) {
					errorHandler(data);
				} else {
					alert('Error: ' + data.error);
				}
			} else if(successHandler) {
				successHandler(data);
			}
		}
	});
}

function skos_processAjaxRequest(postData, successHandler, errorHandler) {
	$.ajax({
		type: 'POST',
		url: ajaxURL,
		data: postData,
		dataType: 'json',
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

function skos_loadAjaxData(postData, successHandler, errorHandler) {
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