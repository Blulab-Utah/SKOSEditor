create index IX_24CA4F7 on SKOS_CollaborationEntry (skosFileId, userId);

create index IX_DBA51CFF on SKOS_File (userId);
create index IX_F91B8F58 on SKOS_File (userId, parentId);

create index IX_557500B9 on SKOS_LockedObject (skosFileId);
create index IX_301DAA7 on SKOS_LockedObject (skosFileId, objectId);

create index IX_E9B8E57F on SKOS_ObjectHistory (skosFileId);
create index IX_DD8A3E57 on SKOS_ObjectHistory (skosFileId, conceptURI);
create index IX_95E5FE5 on SKOS_ObjectHistory (skosFileId, lock_);
create index IX_379AFFED on SKOS_ObjectHistory (skosFileId, objectId);
create index IX_113845CE on SKOS_ObjectHistory (skosFileId, type_, conceptURI);
create index IX_E7257EC3 on SKOS_ObjectHistory (skosFileId, updatedBy);
create index IX_A0B44EB9 on SKOS_ObjectHistory (skosFileId, userId);
create index IX_766F016B on SKOS_ObjectHistory (skosFileId, userId, lock_);
create index IX_2F65C8FC on SKOS_ObjectHistory (skosFileId, userId, type_);

create index IX_4D1710ED on SKOS_Setting (userId);
create index IX_A14A3AEC on SKOS_Setting (userId, name);

create index IX_910E35A on SKOS_SharedFile (sharedBy);
create index IX_2B7C87C9 on SKOS_SharedFile (sharedWith);
create index IX_7237C411 on SKOS_SharedFile (skosFileId);
create index IX_45697510 on SKOS_SharedFile (skosFileId, sharedWith);