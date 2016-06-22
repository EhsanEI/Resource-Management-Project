CREATE TABLE User (ID int IDENTITY NOT NULL,  Username varchar(255) NULL, Password varchar(255) NULL, Email varchar(255) NULL, Approved bit NOT NULL, Discriminator varchar(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Job (ID int IDENTITY NOT NULL,  Discriminator varchar(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Specialty (ID int IDENTITY NOT NULL,  Title varchar(255) NULL, ProficiencyLevel int NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Resource (ID int IDENTITY NOT NULL, UniqueIdentifier varchar(255) NOT NULL, Name2 varchar(255) NULL, Name varchar(255) NULL, Description varchar(255) NULL, LinesOfCode int NULL, Technologies varchar(255) NULL, Budget int NULL, FinancialValue int NULL, Discriminator varchar(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Requirement (ID int IDENTITY NOT NULL,  ResourceName varchar(255) NULL, ResourceType varchar(255) NULL, Quantity int NOT NULL, PRIMARY KEY (ID));
CREATE TABLE ModuleChange (ID int IDENTITY NOT NULL,  Description varchar(255) NULL, PRIMARY KEY (ID));
CREATE TABLE SystemConfiguration (ID int IDENTITY NOT NULL, BackupFormat Date  BackupPreiodDays int NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Allocation (ID int IDENTITY NOT NULL,  Allocated bit NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Permission (ID int IDENTITY NOT NULL, Job User  Title varchar(255) NULL, PRIMARY KEY (ID));
CREATE TABLE Date (ID int IDENTITY NOT NULL, Requirement  Second int NOT NULL, Minute int NOT NULL, Hour int NOT NULL, Day int NOT NULL, Month int NOT NULL, Year int NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Notification (ID int IDENTITY NOT NULL, Job  Content varchar(255) NULL, PRIMARY KEY (ID));
CREATE TABLE RequirementPriority (ID int IDENTITY NOT NULL,  PRIMARY KEY (ID));
CREATE TABLE ResourceState (ID int IDENTITY NOT NULL,  PRIMARY KEY (ID));
CREATE TABLE BackupFormat (ID int IDENTITY NOT NULL,  PRIMARY KEY (ID));
CREATE TABLE ResourceRequirementPriority (ID int IDENTITY NOT NULL,  PRIMARY KEY (ID));
CREATE TABLE Email (ID int IDENTITY NOT NULL,  Content varchar(255) NULL, Address varchar(255) NULL, PRIMARY KEY (ID));
CREATE TABLE UserJob (ID int IDENTITY NOT NULL,  PRIMARY KEY (ID));
CREATE TABLE ResourceAllocation (ID int IDENTITY NOT NULL,  PRIMARY KEY (ID));
CREATE TABLE ModuleState (ID int IDENTITY NOT NULL,  PRIMARY KEY (ID));
CREATE TABLE ModuleSpecialty (ID int IDENTITY NOT NULL, Specialty Resource PRIMARY KEY (ID));
ALTER TABLE Permission ADD CONSTRAINT FKPermission905621 FOREIGN KEY (UserID) REFERENCES User (ID);
ALTER TABLE Permission ADD CONSTRAINT FKPermission914453 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Notification ADD CONSTRAINT FKNotificati208518 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Date ADD CONSTRAINT FKDate979293 FOREIGN KEY (RequirementID) REFERENCES Requirement (ID);
ALTER TABLE SystemConfiguration ADD CONSTRAINT FKSystemConf492901 FOREIGN KEY (DateID) REFERENCES Date (ID);
ALTER TABLE SystemConfiguration ADD CONSTRAINT FKSystemConf236823 FOREIGN KEY (BackupFormatID) REFERENCES BackupFormat (ID);
ALTER TABLE ModuleSpecialty ADD CONSTRAINT FKModuleSpec422243 FOREIGN KEY (ResourceID) REFERENCES Resource (ID);
ALTER TABLE ModuleSpecialty ADD CONSTRAINT FKModuleSpec268542 FOREIGN KEY (SpecialtyID) REFERENCES Specialty (ID);
