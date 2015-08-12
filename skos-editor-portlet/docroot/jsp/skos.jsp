<%@ include file="init.jsp"%>

<h3 id="title-block"></h3>

<ul id="mbmcpebul_table" class="mbmcpebul_menulist css_menu">
	<li class="topitem spaced_li">
		<div class="buttonbg gradient_button gradient36">
			<div class="arrow"><a href="#" class="button_2">File</a></div>
		</div>
 	 	<ul class="gradient_menu gradient188">
  			<li><a id="create-new-kb" href="#">Create New</a></li>
  			<li><a id="load-from-library" href="#">Load File</a></li>
			<li><a id="save-to-library" href="#">Save Changes</a></li>
			<li><a id="save-to-library-as-new" href="#">Save As New</a></li>
	  	</ul>
	</li>
  	<li class="topitem spaced_li">
		<div class="buttonbg gradient_button gradient36">
			<div class="arrow"><a href="#">Upload</a></div>
		</div>
		<ul class="gradient_menu gradient188">
  			<li><a id="upload-from-url-link" href="#">From URL</a></li>
  			<li><a id="upload-skos-file-link" href="#">From Local File</a></li>
	  	</ul>
	</li>
	<li id="skos-share-tools" class="topitem spaced_li">
		<div class="buttonbg gradient_button gradient36">
			<div class="arrow"><a href="#">Share</a></div>
		</div>
		<ul class="gradient_menu gradient188">
  			<li><a href="#" onclick="skos_OpenShareNow(); return false;">Share Now</a></li>
  			<li><a href="#" onclick="skos_OpenViewSharedFiles(); return false;">View Files</a></li>
	  	</ul>
	</li>
	<li id="skos-menu-tools" class="topitem spaced_li" style="display: none;">
		<div class="buttonbg gradient_button gradient36">
			<div class="arrow"><a href="#">Tools</a></div>
		</div>
		<ul class="gradient_menu gradient188">
			<li><a id="create-class-hierarchy" href="#">Create Class Hierarchy</a></li>
			<li><a id="open-settings" href="#">Settings</a></li>
	  	</ul>
	</li>
  	<li class="topitem spaced_li">
		<div class="buttonbg gradient_button gradient36">
			<a id="interface-help-link" href="#">Help</a>
		</div>
	</li>
	<li id="skos-download-link-menu" class="topitem spaced_li" style="float: right; display: none;">
		<div class="buttonbg gradient_button gradient36">
			<a id="skos-download-link" href="#" onclick='skos_DownloadFile(); return false;'>Download</a>
		</div>
	</li>
</ul>

<div id="skos-editor">
	<table class="skos-editor">
		<tr>
			<td style="width: 33%; vertical-align: top;">
				<div class="skos-editor-content-block">
					<div id="node-actions-block" style='height: 30px; margin: 10px; position: relative;'>
						<div id="scheme-actions-block" style="position: absolute; left: 0; top: 0; opacity: 0;">
							<button class='btn btn-primary' onclick="skos_EditTreeNode('add-top-concept');">Add Top Concept</button>
					  		<button class='btn btn-primary' onclick="skos_EditTreeNode('rename-scheme');">Rename Scheme</button>
						</div>
						<div id="concept-actions-block" style="position: absolute; left: 0; top: 0; opacity: 0;">
							<button class='btn btn-primary' onclick="skos_EditTreeNode('add-concept');">Add Concept</button>
							<button class='btn btn-primary' onclick="skos_EditTreeNode('rename-concept');">Rename</button>
							<button class='btn btn-primary' onclick="skos_EditTreeNode('move-concept-to-top');">Move To Top</button>
							<button class='btn btn-primary' onclick="skos_EditTreeNode('move-concept');">Move</button>
							<button class='btn btn-primary delete-button' onclick="skos_EditTreeNode('remove-concept');">Delete</button>
						</div>
					</div>
					<div id="skos-tree-block" style="height: 350px; overflow: auto;"></div>
				</div>
			</td>
			<td style="width: 33%; vertical-align: top;">
				<div id="skos-relations-block" class="skos-editor-content-block"></div>
			</td>
			<td style="width: 33%; vertical-align: top;">
				<div id="skos-linguistics-block" class="skos-editor-content-block"></div>
			</td>
		</tr>
	</table>
	<div id="skos-history-block" style="display: none; margin-bottom: 20px;">
		<table class='skos-table' style="width: 97%; margin: 30px auto 0;">
			<thead>
				<tr>
					<th style='text-align: left; text-indent: 10px; padding-top: 8px;'>
						Modifications History (last 100 records)
						<div style="float: right; margin-right: 10px;">
							<a href="#" onclick="skos_ToggleHistory(); return false;">Show/Hide</a>
						</div>
					</th>
				</tr>
			</thead>
		</table>
		<div id="skos-history" style="width: 97%; margin: 0 auto; overflow: auto; height: 165px; display: none;">
			<div style='text-align: center;'><img src='/html/themes/_unstyled/images/progress_bar/loading_animation.gif' style='margin: 60px auto;' /></div>
		</div>
	</div>
</div>

<div style="visibility: hidden; height: 0px;">
	
	<portlet:actionURL var="createNewKB" name="createNewKB" />
	<form method='post' id='create-new-kb-form' action='<%= createNewKB %>'>
		<table class="skos-table">
			<tbody class="vertical">
				<tr>
					<td>KB URI: </td>
					<td><input type="text" name="baseURI" id="base-uri" /> </td>
				</tr>
				<tr>
					<td>KB Name: </td>
					<td><input type="text" name="kbName" id="kb-name" /> </td> 
				</tr>
				<tr>
					<td>Title: </td>
					<td><input type="text" name="title"/></td>
				</tr>		
				<tr>
					<td style="vertical-align: top;">Description: </td>
					<td><textarea name="description" rows="3"/></textarea></td>
				</tr>	
				<tr>
					<td>Subject: </td>
					<td><input type="text" name="subject"/></td>
				</tr>		
				<tr>
					<td>Audience: </td>
					<td><input type="text" name="audience"/></td>
				</tr>
				<tr>
					<td>Language: </td>
					<td><input type="text" name="language"/></td>
				</tr>
				<tr>
					<td>Creator: </td>
					<td><input type="text" name="creator"/></td>
				</tr>
				<tr>
					<td>Created: </td>
					<td><input type="text" name="created"/></td>
				</tr>
				<tr>
					<td>Version: </td>
					<td><input type="text" name="version" /></td>
				</tr>	
			</tbody>
	  	</table>
	</form>
	
	<portlet:actionURL var="uploadFromURL" name="uploadFromURL" />
	<form method='post' id='upload-from-url-form' action='<%= uploadFromURL %>'>
		<div class="portlet-msg-alert">
			Examples (click to run)
		  	<ul style="font-size: 12px; margin-top: 10px; color: #666666; list-style-type: lower-roman;">
				<li><a href="#" class="skos-upload-url-example">http://ss-ontology.googlecode.com/svn/trunk/skos/esso.xml</a></li>
				<li><a href="#" class="skos-upload-url-example">http://users.sdsc.edu/~fariba/esso-subset.rdf.xml</a></li>
		  	</ul>
		</div>
		<table>
			<tr>
				<td>URL:</td> 
				<td>
					<input type="text" name="url" value="" id="upload-url" /> 
				</td>
			</tr>
		</table>
	</form>

	<portlet:actionURL var="uploadSKOSFile" name="uploadSKOSFile" />
	<form method='post' id='upload-skos-file-form' action='<%= uploadSKOSFile %>' enctype='multipart/form-data'>
		<div class="portlet-msg-alert">Please select a valid SKOS file from your computer</div>
		<table>
			<tr>
				<td>
					<input type="file" name="skosFile" id="upload-skos-file" title="" /> 
				</td>
			</tr>
		</table>   
	</form>

	<portlet:actionURL var="updateLibraryVar" name="updateLibrary" />
	<form method='post' id='skos-library-form' action='<%= updateLibraryVar %>'>
		<div id='skos-library'></div>
		<input type="hidden" name="action" id="skos-library-form-action" />
		<input type="hidden" name="schemeURI" id="skos-library-form-schemeURI" />
		<input type="hidden" name="fileName" id="skos-library-form-fileName" />
		<input type="hidden" name="id" id="skos-library-form-id" />
	</form>
	
	<form method='post' id="skos-library-save-form" action='<%= updateLibraryVar %>'>
	 	<table>
			<tr>
				<td>Name:</td>
				<td>
					<input type="text" name="fileName" id="skos-library-save-form-fileName" /> 
				</td>
			</tr>
		</table>
	</form>
	
		<div id='skos-wizard-popup'>
			<div class='portlet-msg-alert' style="margin-bottom: 10px; text-align: center; padding: 8px 0px;">
				Please select the root concept and enter the hierarchy that you want to create. Use tabs to indent names!
			</div>
			<table class="skos-table">
				<tbody class="vertical">
					<tr>
						<td style="width: 20%;">
							<span style='color: #990000; position: relative; top: 4px;'>*</span> Parent Node
						</td>
						<td>
							<select id='skos-wizard-parent' name="parent"></select>
						</td>
					</tr>
					<tr>
						<td>
							Prefix
						</td>
						<td>
						  <input id="skos-wizard-prefix" name="prefix" type="text" skos-default-text='Enter a prefix here ...' />
						</td>
					</tr>
					<tr>
						<td>
						  	Suffix
						</td>
						<td>
						  <input id="skos-wizard-suffix" name="suffix" type="text" skos-default-text='Enter a suffix here ...' />
						</td>
					</tr>
					<tr>
						<td style='vertical-align: top;'>
							<span style='color: #990000; position: relative; top: 4px;'>*</span> Hierarchy
						</td>
						<td>
					  	<textarea id="skos-wizard-hierarchy" name="hierarchy" style='width: 97%; padding-left: 10px; padding-right: 10px;' rows='10' skos-default-text='Concept-1
    Concept-1.1
    Concept-1.2
        Concept-1.2.1
        Concept-1.2.2'></textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="skos-dialog-buttons-block">
				<a href="#" onclick="skos_Wizard.close(); return false;">Cancel</a>
				<button class="btn btn-primary" onclick="skos_Wizard.save(); return false;">Create Hierarchy</button>
				<div style="display: none;" class="skos-dialog-buttons-waiting-block"></div>
			</div>
		</div>
</div>

<div id='skos-settings'></div>

<div id="skos-default-buttons-block" style="display: none;">
	<div style="width: 320px; margin: 30% auto;">
		<button class="btn btn-primary" style="margin-right: 10px;" onclick="$('#create-new-kb').click(); return false;">Create New File</button> 
			or 
		<button class="btn btn-primary" style="margin-left: 10px;" onclick="$('#load-from-library').click(); return false;">Load From Library</button>
	</div>
</div>