package edu.ucsd.nlp.service.impl;

import edu.ucsd.nlp.model.SKOSSetting;
import edu.ucsd.nlp.service.base.SKOSSettingLocalServiceBaseImpl;

/**
 * @author http://nlp-app.ucsd.edu
 * 
 * @see edu.ucsd.nlp.service.base.SKOSSettingLocalServiceBaseImpl
 * @see edu.ucsd.nlp.service.SKOSSettingLocalServiceUtil
 */
public class SKOSSettingLocalServiceImpl extends SKOSSettingLocalServiceBaseImpl {

	public SKOSSetting findByUserName(long userId, String name) throws Exception {
		SKOSSetting obj = null;
		try {
			obj = skosSettingPersistence.findByUserName(userId, name);
		} catch (Exception e) {
			obj = skosSettingPersistence.create(counterLocalService.increment());
			obj.setUserId(userId);
			obj.setName(name);
			obj.setValue("");
			obj = updateSKOSSetting(obj);
		}
		return obj;
	}
	
	public SKOSSetting updateByUserName(long userId, String name, String value) throws Exception {
		SKOSSetting obj = findByUserName(userId, name);
		obj.setValue(value);
		obj = updateSKOSSetting(obj);
		return obj;
	}
}