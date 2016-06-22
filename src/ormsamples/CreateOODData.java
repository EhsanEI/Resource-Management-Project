/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateOODData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = businesslogic.distribution.resource.OODPersistentManager.instance().getSession().beginTransaction();
		try {
			businesslogic.accounting.user.User businessLogicAccountingUserUser = businesslogic.accounting.user.UserDAO.createUser();
			
			businesslogic.accounting.job.Job businessLogicAccountingJobJob = businesslogic.accounting.job.JobDAO.createJob();
			
			businesslogic.distribution.resource.Resource businessLogicDistributionResourceResource = businesslogic.distribution.resource.ResourceDAO.createResource();
			businessLogicDistributionResourceResource.setUniqueIdentifier("FG982NSA1");
			
			businesslogic.distribution.resource.InformationResource businessLogicDistributionResourceInformationResource = businesslogic.distribution.resource.InformationResourceDAO.createInformationResource();
			businessLogicDistributionResourceInformationResource.setUniqueIdentifier("VD982AL1");
			
			businesslogic.distribution.resource.Project businessLogicDistributionResourceProject = businesslogic.distribution.resource.ProjectDAO.createProject();
			businessLogicDistributionResourceProject.setUniqueIdentifier("KA982IF1");

			businesslogic.distribution.resource.System businessLogicDistributionResourceSystem = businesslogic.distribution.resource.SystemDAO.createSystem();
			businessLogicDistributionResourceSystem.setUniqueIdentifier("UB198PK1");
			
			businesslogic.distribution.resource.Subsystem businessLogicDistributionResourceSubsystem = businesslogic.distribution.resource.SubsystemDAO.createSubsystem();
			businessLogicDistributionResourceSubsystem.setUniqueIdentifier("VH289JF2");

			businesslogic.distribution.resource.Module businessLogicDistributionResourceModule = businesslogic.distribution.resource.ModuleDAO.createModule();
			businessLogicDistributionResourceModule.setUniqueIdentifier("SN983Q1");
			businesslogic.distribution.resource.ModuleDAO.save(businessLogicDistributionResourceModule);

			businesslogic.accounting.job.Specialty businessLogicAccountingJobSpecialty = businesslogic.accounting.job.SpecialtyDAO.createSpecialty();
			businesslogic.accounting.job.SpecialtyDAO.save(businessLogicAccountingJobSpecialty);

			businesslogic.distribution.resource.HumanResource businessLogicDistributionResourceHumanResource = businesslogic.distribution.resource.HumanResourceDAO.createHumanResource();
			businessLogicDistributionResourceHumanResource.setUniqueIdentifier("JF982L5");
			
			businesslogic.distribution.requirement.Requirement businessLogicDistributionRequirementRequirement = businesslogic.distribution.requirement.RequirementDAO.createRequirement();
			
			businesslogic.distribution.resource.FinancialResource businessLogicDistributionResourceFinancialResource = businesslogic.distribution.resource.FinancialResourceDAO.createFinancialResource();
			businessLogicDistributionResourceFinancialResource.setUniqueIdentifier("PO933A1");
			
			

			businesslogic.distribution.resource.PhysicalResource businessLogicDistributionResourcePhysicalResource = businesslogic.distribution.resource.PhysicalResourceDAO.createPhysicalResource();
			businessLogicDistributionResourcePhysicalResource.setUniqueIdentifier("PA982E1");
			
			businesslogic.accounting.user.Admin businessLogicAccountingUserAdmin = businesslogic.accounting.user.AdminDAO.createAdmin();
			
			businesslogic.accounting.user.Manager businessLogicAccountingUserManager = businesslogic.accounting.user.ManagerDAO.createManager();
			
			businesslogic.accounting.user.MiddleLevelManager businessLogicAccountingUserMiddleLevelManager = businesslogic.accounting.user.MiddleLevelManagerDAO.createMiddleLevelManager();
			
			businesslogic.accounting.user.Employee businessLogicAccountingUserEmployee = businesslogic.accounting.user.EmployeeDAO.createEmployee();
			
			businesslogic.accounting.job.ProjectManagement businessLogicAccountingJobProjectManagement = businesslogic.accounting.job.ProjectManagementDAO.createProjectManagement();
			
			businesslogic.accounting.ResourceManagement businessLogicAccountingResourceManagement = businesslogic.accounting.ResourceManagementDAO.createResourceManagement();
			
			businesslogic.accounting.job.Programming businessLogicAccountingJobProgramming = businesslogic.accounting.job.ProgrammingDAO.createProgramming();
			
			businesslogic.distribution.resource.ModuleChange businessLogicDistributionResourceModuleChange = businesslogic.distribution.resource.ModuleChangeDAO.createModuleChange();
			
			businesslogic.support.SystemConfiguration businessLogicSupportSystemConfiguration = businesslogic.support.SystemConfigurationDAO.createSystemConfiguration();
			
			businesslogic.distribution.Allocation businessLogicDistributionAllocation = businesslogic.distribution.AllocationDAO.createAllocation();
			
			businesslogic.accounting.user.HighLevelManager businessLogicAccountingUserHighLevelManager = businesslogic.accounting.user.HighLevelManagerDAO.createHighLevelManager();
			
			businesslogic.accounting.Permission businessLogicAccountingPermission = businesslogic.accounting.PermissionDAO.createPermission();
			
			businesslogic.utility.Date businessLogicUtilityDate = businesslogic.utility.DateDAO.createDate();
			
			businesslogic.utility.Notification businessLogicUtilityNotification = businesslogic.utility.NotificationDAO.createNotification();
			
			businesslogic.distribution.requirement.RequirementPriority businessLogicDistributionRequirementRequirementPriority = businesslogic.distribution.requirement.RequirementPriorityDAO.createRequirementPriority();
			
			businesslogic.distribution.resource.ResourceState businessLogicDistributionResourceResourceState = businesslogic.distribution.resource.ResourceStateDAO.createResourceState();
			
			businesslogic.support.BackupFormat businessLogicSupportBackupFormat = businesslogic.support.BackupFormatDAO.createBackupFormat();
			
			businesslogic.distribution.requirement.ResourceRequirementPriority businessLogicDistributionRequirementResourceRequirementPriority = businesslogic.distribution.requirement.ResourceRequirementPriorityDAO.createResourceRequirementPriority();
			
			network.Email networkEmail = network.EmailDAO.createEmail();
			
			businesslogic.accounting.job.UserJob businessLogicAccountingJobUserJob = businesslogic.accounting.job.UserJobDAO.createUserJob();
			
			businesslogic.distribution.ResourceAllocation businessLogicDistributionResourceAllocation = businesslogic.distribution.ResourceAllocationDAO.createResourceAllocation();
			
			businesslogic.distribution.resource.ModuleState businessLogicDistributionResourceModuleState = businesslogic.distribution.resource.ModuleStateDAO.createModuleState();
			
			businesslogic.distribution.resource.ModuleSpecialty businessLogicDistributionResourceModuleSpecialty = businesslogic.distribution.resource.ModuleSpecialtyDAO.createModuleSpecialty();
			
			
			
			
			
			businesslogic.accounting.user.UserDAO.save(businessLogicAccountingUserUser);
			businesslogic.accounting.job.JobDAO.save(businessLogicAccountingJobJob);
			businesslogic.distribution.resource.ResourceDAO.save(businessLogicDistributionResourceResource);
			businesslogic.distribution.resource.InformationResourceDAO.save(businessLogicDistributionResourceInformationResource);
			businesslogic.distribution.resource.ProjectDAO.save(businessLogicDistributionResourceProject);
			businesslogic.distribution.resource.SystemDAO.save(businessLogicDistributionResourceSystem);
			businesslogic.distribution.resource.SubsystemDAO.save(businessLogicDistributionResourceSubsystem);
			businesslogic.distribution.resource.HumanResourceDAO.save(businessLogicDistributionResourceHumanResource);
			businesslogic.distribution.requirement.RequirementDAO.save(businessLogicDistributionRequirementRequirement);
			businesslogic.distribution.resource.FinancialResourceDAO.save(businessLogicDistributionResourceFinancialResource);
			businesslogic.distribution.resource.PhysicalResourceDAO.save(businessLogicDistributionResourcePhysicalResource);
			businesslogic.accounting.user.AdminDAO.save(businessLogicAccountingUserAdmin);
			businesslogic.accounting.user.ManagerDAO.save(businessLogicAccountingUserManager);
			businesslogic.accounting.user.MiddleLevelManagerDAO.save(businessLogicAccountingUserMiddleLevelManager);
			businesslogic.accounting.user.EmployeeDAO.save(businessLogicAccountingUserEmployee);
			businesslogic.accounting.job.ProjectManagementDAO.save(businessLogicAccountingJobProjectManagement);
			businesslogic.accounting.ResourceManagementDAO.save(businessLogicAccountingResourceManagement);
			businesslogic.accounting.job.ProgrammingDAO.save(businessLogicAccountingJobProgramming);
			businesslogic.distribution.resource.ModuleChangeDAO.save(businessLogicDistributionResourceModuleChange);
			businesslogic.support.SystemConfigurationDAO.save(businessLogicSupportSystemConfiguration);
			businesslogic.distribution.AllocationDAO.save(businessLogicDistributionAllocation);
			businesslogic.accounting.user.HighLevelManagerDAO.save(businessLogicAccountingUserHighLevelManager);
			businesslogic.accounting.PermissionDAO.save(businessLogicAccountingPermission);
			businesslogic.utility.DateDAO.save(businessLogicUtilityDate);
			businesslogic.utility.NotificationDAO.save(businessLogicUtilityNotification);
			businesslogic.distribution.requirement.RequirementPriorityDAO.save(businessLogicDistributionRequirementRequirementPriority);
			businesslogic.distribution.resource.ResourceStateDAO.save(businessLogicDistributionResourceResourceState);
			businesslogic.support.BackupFormatDAO.save(businessLogicSupportBackupFormat);
			businesslogic.distribution.requirement.ResourceRequirementPriorityDAO.save(businessLogicDistributionRequirementResourceRequirementPriority);
			network.EmailDAO.save(networkEmail);
			businesslogic.accounting.job.UserJobDAO.save(businessLogicAccountingJobUserJob);
			businesslogic.distribution.ResourceAllocationDAO.save(businessLogicDistributionResourceAllocation);
			businesslogic.distribution.resource.ModuleStateDAO.save(businessLogicDistributionResourceModuleState);
			businesslogic.distribution.resource.ModuleSpecialtyDAO.save(businessLogicDistributionResourceModuleSpecialty);
			
			
			
			
			
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateOODData createOODData = new CreateOODData();
			try {
				createOODData.createTestData();
			}
			finally {
				businesslogic.distribution.resource.OODPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
