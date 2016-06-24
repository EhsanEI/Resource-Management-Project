CREATE TABLE [User] (ID int IDENTITY NOT NULL, UserID2 int NOT NULL, UserID int NOT NULL, Username varchar(255) NULL, Password varchar(255) NULL, Email varchar(255) NULL, Approved bit NOT NULL, CreatorUser int NULL, Discriminator varchar(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE User_jobs (UserID int NOT NULL, UserIndex int NOT NULL, Jobs int NULL, PRIMARY KEY (UserID, UserIndex));
CREATE TABLE User_permissions (UserID int NOT NULL, UserIndex int NOT NULL, Permissions int NULL, PRIMARY KEY (UserID, UserIndex));
CREATE TABLE Job (ID int IDENTITY NOT NULL, UserID int NOT NULL, Discriminator varchar(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Job_permissions (JobID int NOT NULL, JobIndex int NOT NULL, Permissions int NULL, PRIMARY KEY (JobID, JobIndex));
CREATE TABLE Job_informationResources (JobID int NOT NULL, JobIndex int NOT NULL, InformationResources int NULL, PRIMARY KEY (JobID, JobIndex));
CREATE TABLE Job_notifications (JobID int NOT NULL, JobIndex int NOT NULL, Notifications int NULL, PRIMARY KEY (JobID, JobIndex));
CREATE TABLE Job_specialties (JobID int NOT NULL, JobIndex int NOT NULL, Specialties int NULL, PRIMARY KEY (JobID, JobIndex));
CREATE TABLE Specialty (ID int IDENTITY NOT NULL, JobID2 int NOT NULL, JobID int NULL, Title varchar(255) NULL, ProficiencyLevel int NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Resource (ID2 int IDENTITY NOT NULL, DateID int NULL, ResourceStateID int NOT NULL, JobID4 int NULL, JobID3 int NULL, ResourceID23 int NULL, ResourceID22 int NULL, ResourceID2 int NULL, JobID2 int NOT NULL, JobID int NULL, Id int NOT NULL, Name2 varchar(255) NULL, Attribute int NULL, State2 int NULL, Name varchar(255) NULL, State int NULL, Description varchar(255) NULL, StartDate datetime NULL, EndDate datetime NULL, LinesOfCode int NULL, Technologies int NULL, Budget int NULL, Programming int NULL, FinancialValue int NULL, Specs int NULL, Discriminator varchar(255) NOT NULL, PRIMARY KEY (ID2));
CREATE TABLE Resource_requirements (ResourceID2 int NOT NULL, ResourceIndex int NOT NULL, Requirements int NULL, PRIMARY KEY (ResourceID2, ResourceIndex));
CREATE TABLE Resource_allocations (ResourceID2 int NOT NULL, ResourceIndex int NOT NULL, Allocations int NULL, PRIMARY KEY (ResourceID2, ResourceIndex));
CREATE TABLE Resource_systems (ResourceID2 int NOT NULL, ResourceIndex int NOT NULL, Systems int NULL, PRIMARY KEY (ResourceID2, ResourceIndex));
CREATE TABLE Requirement (ID int IDENTITY NOT NULL, RequirementPriorityID int NOT NULL, JobID int NOT NULL, ResourceID2 int NOT NULL, [Allocation ID] int NULL, ResourceName varchar(255) NULL, ResourceType varchar(255) NULL, Quantity int NULL, StartDate datetime NULL, EndDate datetime NULL, Priority int NULL, ProjectManager int NULL, PRIMARY KEY (ID));
CREATE TABLE ModuleChange (ID int IDENTITY NOT NULL, DateID int NOT NULL, JobID int NOT NULL, ResourceID2 int NOT NULL, Description varchar(255) NULL, StartDate datetime NULL, EndDate datetime NULL, PRIMARY KEY (ID));
CREATE TABLE SystemConfiguration (ID int IDENTITY NOT NULL, UserID int NOT NULL, [Date] datetime NULL, BackupPreiodDays int NOT NULL, BackupFormat int NULL, PRIMARY KEY (ID));
CREATE TABLE Allocation (ID int IDENTITY NOT NULL, JobID int NOT NULL, ResourceID2 int NOT NULL, Requirement int NULL, Allocated bit NOT NULL, PRIMARY KEY (ID));
CREATE TABLE [Allocation _resources] ([Allocation ID] int NOT NULL, [Allocation Index] int NOT NULL, Resources int NULL, PRIMARY KEY ([Allocation ID], [Allocation Index]));
CREATE TABLE Permission (ID int IDENTITY NOT NULL, Title varchar(255) NULL, PRIMARY KEY (ID));
CREATE TABLE [Date] (ID int IDENTITY NOT NULL, Second int NOT NULL, Minute int NOT NULL, Hour int NOT NULL, Day int NOT NULL, Month int NOT NULL, Year int NOT NULL, Attribute int NULL, PRIMARY KEY (ID));
CREATE TABLE Notification (ID int IDENTITY NOT NULL, JobID int NOT NULL, Content varchar(255) NULL, PRIMARY KEY (ID));
CREATE TABLE RequirementPriority (ID int IDENTITY NOT NULL, PRIMARY KEY (ID));
CREATE TABLE ResourceState (ID int IDENTITY NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Email (ID int IDENTITY NOT NULL, UserID int NOT NULL, Content varchar(255) NULL, Address varchar(255) NULL, PRIMARY KEY (ID));
CREATE TABLE UserJob (ID int IDENTITY NOT NULL, JobID int NOT NULL, UserID int NOT NULL, [User] int NULL, Job int NULL, PRIMARY KEY (ID));
CREATE TABLE ResourceAllocation (ID int IDENTITY NOT NULL, ResourceID2 int NOT NULL, [Allocation ID] int NOT NULL, Resource int NULL, Allocation int NULL, PRIMARY KEY (ID));
CREATE TABLE Resource_Specialty (ResourceID2 int NOT NULL, SpecialtyID int NOT NULL, PRIMARY KEY (ResourceID2, SpecialtyID));
ALTER TABLE User_jobs ADD CONSTRAINT FKUser_jobs688007 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE User_permissions ADD CONSTRAINT FKUser_permi162680 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE Job_permissions ADD CONSTRAINT FKJob_permis11120 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Job_informationResources ADD CONSTRAINT FKJob_inform62592 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Job_notifications ADD CONSTRAINT FKJob_notifi82851 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Job_specialties ADD CONSTRAINT FKJob_specia156557 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Resource_requirements ADD CONSTRAINT FKResource_r804981 FOREIGN KEY (ResourceID2) REFERENCES Resource (ID2);
ALTER TABLE Resource_allocations ADD CONSTRAINT FKResource_a592548 FOREIGN KEY (ResourceID2) REFERENCES Resource (ID2);
ALTER TABLE Resource_systems ADD CONSTRAINT FKResource_s517221 FOREIGN KEY (ResourceID2) REFERENCES Resource (ID2);
ALTER TABLE [Allocation _resources] ADD CONSTRAINT FKAllocation100116 FOREIGN KEY ([Allocation ID]) REFERENCES Allocation (ID);
ALTER TABLE Resource ADD CONSTRAINT has FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Resource ADD CONSTRAINT adds FOREIGN KEY (JobID2) REFERENCES Job (ID);
ALTER TABLE Resource ADD CONSTRAINT has2 FOREIGN KEY (ResourceID2) REFERENCES Resource (ID2);
ALTER TABLE Resource ADD CONSTRAINT has3 FOREIGN KEY (ResourceID22) REFERENCES Resource (ID2);
ALTER TABLE Resource ADD CONSTRAINT has4 FOREIGN KEY (ResourceID23) REFERENCES Resource (ID2);
ALTER TABLE Resource_Specialty ADD CONSTRAINT needs FOREIGN KEY (ResourceID2) REFERENCES Resource (ID2);
ALTER TABLE Resource_Specialty ADD CONSTRAINT needs2 FOREIGN KEY (SpecialtyID) REFERENCES Specialty (ID);
ALTER TABLE Allocation ADD CONSTRAINT allocated FOREIGN KEY (ResourceID2) REFERENCES Resource (ID2);
ALTER TABLE Allocation ADD CONSTRAINT creates FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Requirement ADD CONSTRAINT relatedTo FOREIGN KEY ([Allocation ID]) REFERENCES Allocation (ID);
ALTER TABLE ModuleChange ADD CONSTRAINT has5 FOREIGN KEY (ResourceID2) REFERENCES Resource (ID2);
ALTER TABLE SystemConfiguration ADD CONSTRAINT creates2 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE Job ADD CONSTRAINT creates3 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE Specialty ADD CONSTRAINT has6 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Resource ADD CONSTRAINT manages FOREIGN KEY (JobID3) REFERENCES Job (ID);
ALTER TABLE Specialty ADD CONSTRAINT creates4 FOREIGN KEY (JobID2) REFERENCES Job (ID);
ALTER TABLE Resource ADD CONSTRAINT changeState FOREIGN KEY (JobID4) REFERENCES Job (ID);
ALTER TABLE ModuleChange ADD CONSTRAINT creates5 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE Requirement ADD CONSTRAINT needs3 FOREIGN KEY (ResourceID2) REFERENCES Resource (ID2);
ALTER TABLE Requirement ADD CONSTRAINT creates6 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE [User] ADD CONSTRAINT approves FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE Requirement ADD CONSTRAINT FKRequiremen877753 FOREIGN KEY (RequirementPriorityID) REFERENCES RequirementPriority (ID);
ALTER TABLE Resource ADD CONSTRAINT has7 FOREIGN KEY (ResourceStateID) REFERENCES ResourceState (ID);
ALTER TABLE Email ADD CONSTRAINT sends FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE [User] ADD CONSTRAINT creates7 FOREIGN KEY (UserID2) REFERENCES [User] (ID);
ALTER TABLE UserJob ADD CONSTRAINT FKUserJob15306 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE UserJob ADD CONSTRAINT FKUserJob322807 FOREIGN KEY (JobID) REFERENCES Job (ID);
ALTER TABLE ResourceAllocation ADD CONSTRAINT FKResourceAl209355 FOREIGN KEY ([Allocation ID]) REFERENCES Allocation (ID);
ALTER TABLE ResourceAllocation ADD CONSTRAINT FKResourceAl703895 FOREIGN KEY (ResourceID2) REFERENCES Resource (ID2);
ALTER TABLE Resource ADD CONSTRAINT FKResource625189 FOREIGN KEY (DateID) REFERENCES [Date] (ID);
ALTER TABLE ModuleChange ADD CONSTRAINT FKModuleChan171992 FOREIGN KEY (DateID) REFERENCES [Date] (ID);
ALTER TABLE Notification ADD CONSTRAINT FKNotificati374970 FOREIGN KEY (JobID) REFERENCES Job (ID);