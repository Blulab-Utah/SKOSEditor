package edu.ucsd.nlp.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.semanticweb.skos.SKOSConcept;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import edu.ucsd.nlp.skos.SKOSProject;

@SuppressWarnings("boxing")
public class ImportUtil {

	private static final Log log = LogFactoryUtil.getLog(ImportUtil.class);

	private Map<String, Integer> headers = null;

	public int importExcel(SKOSProject project, File file) throws Exception {
		int count = 0;

		headers = new HashMap<String, Integer>();

	    Workbook wb = WorkbookFactory.create(file);
	    Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();

		// get headers
		Row row = rowIterator.next();
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			String cellName = cell.getStringCellValue();
			if (cellName == null || cellName.trim().isEmpty()) {
				continue;
			}
			try {
				cellName = cellName.replace("\n", "").replace("\r", "");
			} catch (Exception e) {
			}
			headers.put(cellName, cell.getColumnIndex());
		}

		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			
			String conceptName = (String) getCellValue(row, "Concept Name");
			if (conceptName == null || conceptName.isEmpty()) {
				continue;
			}

			try {
				boolean isSilent = true;
				
				SKOSConcept concept = project.addTopConcept(conceptName, isSilent);
				conceptName = concept.getURI().toString();
				
				String[] broaderConcepts = getString(row, "Broader Concept").split(";");
				for (String obj : broaderConcepts) {
					if (obj != null && !obj.isEmpty()) {
						SKOSConcept child = project.addConcept(obj, conceptName, isSilent);
						project.addBroaderConcept(child.getURI().toString(), conceptName, isSilent);
					}
				}
				
				String[] narrowerConcepts = getString(row, "Narrower Concept").split(";");
				for (String obj : narrowerConcepts) {
					if (obj != null && !obj.isEmpty()) {
						SKOSConcept child = project.addConcept(obj, conceptName, isSilent);
						project.addNarrowerConcept(child.getURI().toString(), conceptName, isSilent);
					}
				}
				
				String[] relatedConcepts = getString(row, "Related Concept").split(";");
				for (String obj : relatedConcepts) {
					if (obj != null && !obj.isEmpty()) {
						project.addObjectPropertyRelated(conceptName, obj);
					}
				}
				
				String type = "";
				
				String[] prefLabels = getString(row, "prefLabel").split(";");
				for (String obj : prefLabels) {
					if (obj != null && !obj.isEmpty()) {
						String[] data = getValueAndLanguage(obj);
						project.addDataPropertyPreferredLabel(conceptName, data[0], data[1], type);
					}
				}
				
				String[] altLabels = getString(row, "altLabel").split(";");
				for (String obj : altLabels) {
					if (obj != null && !obj.isEmpty()) {
						String[] data = getValueAndLanguage(obj);
						project.addDataPropertyAlternateLabel(conceptName, data[0], data[1], type);
					}
				}
				
				String[] hiddenLabels = getString(row, "hiddenLabel").split(";");
				for (String obj : hiddenLabels) {
					if (obj != null && !obj.isEmpty()) {
						String[] data = getValueAndLanguage(obj);
						project.addDataPropertyHiddenLabel(conceptName, data[0], data[1], type);
					}
				}
				
				String[] notations = getString(row, "Notations").split(";");
				for (String obj : notations) {
					if (obj != null && !obj.isEmpty()) {
						String[] data = getValueAndLanguage(obj);
						project.addDataPropertyNotation(conceptName, data[0], data[1], type);
					}
				}

				count++;
			} catch (Exception e) {
				log.error("Concept [" + conceptName + "] not imported: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		return count;
	}
	
	private String getString(Row row, String name) {
		String value = "";
		try {
			value = getCellValue(row, name);
		} catch (Exception e) {
			value = "";
		}
		return value;
	}

	private String getCellValue(Row row, String name) {
		String value = null;
		try {
			Cell cell = row.getCell(headers.get(name));
			int type = cell.getCellType();
			if (type == Cell.CELL_TYPE_STRING) {
				try {
	            	value = cell.getRichStringCellValue().getString();
	            	value = value == null ? "" : value.trim();
            	} catch (Exception e) {
            		value = "";
            	}
			} else if (type == Cell.CELL_TYPE_NUMERIC) {
				try {
                	value = "" + cell.getNumericCellValue();
                } catch (Exception e) {
            		value = "";
            	}
			} else if (type == Cell.CELL_TYPE_BOOLEAN) {
				try {
            		value = cell.getBooleanCellValue() ? "1" : "0";
            	} catch (Exception e) {
            		value = "";
            	}
			}
		} catch (Exception e) {
			value = "";
		}
		return value.trim();
	}
	
	private String[] getValueAndLanguage(String obj) {
		String[] data = new String[2];
		data[0] = obj.contains("@") ? obj.substring(0, obj.indexOf('@')) : obj;
		data[1] = obj.contains("@") ? obj.substring(obj.indexOf('@') + 1) : "";
		return data;
	}
}