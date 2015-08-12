create table SKOS_CollaborationEntry (
	id_ LONG not null primary key,
	skosFileId LONG,
	userId LONG,
	updateType VARCHAR(75) null,
	schemeURI STRING null,
	conceptURI STRING null,
	value VARCHAR(75) null,
	type_ VARCHAR(75) null,
	type2 VARCHAR(75) null,
	lang VARCHAR(75) null
);

create table SKOS_File (
	skosFileId LONG not null primary key,
	userId LONG,
	parentId LONG,
	lastModifiedBy LONG,
	created DATE null,
	modified DATE null,
	name VARCHAR(75) null,
	contents STRING null,
	version DOUBLE
);

create table SKOS_LockedObject (
	id_ LONG not null primary key,
	skosFileId LONG,
	lockedBy LONG,
	lockedOn DATE null,
	objectId VARCHAR(75) null
);

create table SKOS_ObjectHistory (
	id_ LONG not null primary key,
	skosFileId LONG,
	userId LONG,
	recorded DATE null,
	type_ VARCHAR(75) null,
	schemeURI STRING null,
	conceptURI STRING null,
	value VARCHAR(75) null,
	objectType VARCHAR(75) null,
	objectType2 VARCHAR(75) null,
	lang VARCHAR(75) null,
	details STRING null
);

create table SKOS_Setting (
	skosSettingId LONG not null primary key,
	userId LONG,
	name VARCHAR(75) null,
	value VARCHAR(75) null
);

create table SKOS_SharedFile (
	id_ LONG not null primary key,
	skosFileId LONG,
	sharedBy LONG,
	sharedWith LONG,
	sharedOn DATE null,
	status INTEGER,
	access_ INTEGER
);