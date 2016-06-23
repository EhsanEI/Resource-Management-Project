/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import businesslogic.distribution.Allocation;
import org.orm.*;
public class DeleteOODData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = businesslogic.accounting.user.OODPersistentManager.instance().getSession().beginTransaction();
		try {
			businesslogic.accounting.user.User businessLogicAccountingUserUser = businesslogic.accounting.user.UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.user.UserDAO.delete(businessLogicAccountingUserUser);
			businesslogic.accounting.job.Job businessLogicAccountingJobJob = businesslogic.accounting.job.JobDAO.loadJobByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.job.JobDAO.delete(businessLogicAccountingJobJob);
			businesslogic.distribution.resource.Resource businessLogicDistributionResourceResource = businesslogic.distribution.resource.ResourceDAO.loadResourceByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.ResourceDAO.delete(businessLogicDistributionResourceResource);
			businesslogic.distribution.resource.InformationResource businessLogicDistributionResourceInformationResource = businesslogic.distribution.resource.InformationResourceDAO.loadInformationResourceByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.InformationResourceDAO.delete(businessLogicDistributionResourceInformationResource);
			businesslogic.distribution.resource.Project businessLogicDistributionResourceProject = businesslogic.distribution.resource.ProjectDAO.loadProjectByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.ProjectDAO.delete(businessLogicDistributionResourceProject);
			businesslogic.distribution.resource.System businessLogicDistributionResourceSystem = businesslogic.distribution.resource.SystemDAO.loadSystemByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.SystemDAO.delete(businessLogicDistributionResourceSystem);
			businesslogic.distribution.resource.Subsystem businessLogicDistributionResourceSubsystem = businesslogic.distribution.resource.SubsystemDAO.loadSubsystemByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.SubsystemDAO.delete(businessLogicDistributionResourceSubsystem);
			businesslogic.distribution.resource.Module businessLogicDistributionResourceModule = businesslogic.distribution.resource.ModuleDAO.loadModuleByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.ModuleDAO.delete(businessLogicDistributionResourceModule);
			businesslogic.accounting.job.Specialty businessLogicAccountingJobSpecialty = businesslogic.accounting.job.SpecialtyDAO.loadSpecialtyByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.job.SpecialtyDAO.delete(businessLogicAccountingJobSpecialty);
			businesslogic.distribution.resource.HumanResource businessLogicDistributionResourceHumanResource = businesslogic.distribution.resource.HumanResourceDAO.loadHumanResourceByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.HumanResourceDAO.delete(businessLogicDistributionResourceHumanResource);
			businesslogic.distribution.requirement.Requirement businessLogicDistributionRequirementRequirement = businesslogic.distribution.requirement.RequirementDAO.loadRequirementByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.requirement.RequirementDAO.delete(businessLogicDistributionRequirementRequirement);
			businesslogic.distribution.resource.FinancialResource businessLogicDistributionResourceFinancialResource = businesslogic.distribution.resource.FinancialResourceDAO.loadFinancialResourceByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.FinancialResourceDAO.delete(businessLogicDistributionResourceFinancialResource);
			businesslogic.distribution.resource.PhysicalResource businessLogicDistributionResourcePhysicalResource = businesslogic.distribution.resource.PhysicalResourceDAO.loadPhysicalResourceByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.PhysicalResourceDAO.delete(businessLogicDistributionResourcePhysicalResource);
			businesslogic.accounting.user.Admin businessLogicAccountingUserAdmin = businesslogic.accounting.user.AdminDAO.loadAdminByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.user.AdminDAO.delete(businessLogicAccountingUserAdmin);
			businesslogic.accounting.user.Manager businessLogicAccountingUserManager = businesslogic.accounting.user.ManagerDAO.loadManagerByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.user.ManagerDAO.delete(businessLogicAccountingUserManager);
			businesslogic.accounting.user.MiddleLevelManager businessLogicAccountingUserMiddleLevelManager = businesslogic.accounting.user.MiddleLevelManagerDAO.loadMiddleLevelManagerByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.user.MiddleLevelManagerDAO.delete(businessLogicAccountingUserMiddleLevelManager);
			businesslogic.accounting.user.Employee businessLogicAccountingUserEmployee = businesslogic.accounting.user.EmployeeDAO.loadEmployeeByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.user.EmployeeDAO.delete(businessLogicAccountingUserEmployee);
			businesslogic.accounting.job.ProjectManagement businessLogicAccountingJobProjectManagement = businesslogic.accounting.job.ProjectManagementDAO.loadProjectManagementByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.job.ProjectManagementDAO.delete(businessLogicAccountingJobProjectManagement);
			businesslogic.accounting.ResourceManagement businessLogicAccountingResourceManagement = businesslogic.accounting.ResourceManagementDAO.loadResourceManagementByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.ResourceManagementDAO.delete(businessLogicAccountingResourceManagement);
			businesslogic.accounting.job.Programming businessLogicAccountingJobProgramming = businesslogic.accounting.job.ProgrammingDAO.loadProgrammingByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.job.ProgrammingDAO.delete(businessLogicAccountingJobProgramming);
			businesslogic.distribution.resource.ModuleChange businessLogicDistributionResourceModuleChange = businesslogic.distribution.resource.ModuleChangeDAO.loadModuleChangeByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.ModuleChangeDAO.delete(businessLogicDistributionResourceModuleChange);
			businesslogic.support.SystemConfiguration businessLogicSupportSystemConfiguration = businesslogic.support.SystemConfigurationDAO.loadSystemConfigurationByQuery(null, null);
			// Delete the persistent object
			businesslogic.support.SystemConfigurationDAO.delete(businessLogicSupportSystemConfiguration);
			Allocation businessLogicDistributionAllocation_ = businesslogic.distribution.Allocation_DAO.loadAllocation_ByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.Allocation_DAO.delete(businessLogicDistributionAllocation_);
			businesslogic.accounting.user.HighLevelManager businessLogicAccountingUserHighLevelManager = businesslogic.accounting.user.HighLevelManagerDAO.loadHighLevelManagerByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.user.HighLevelManagerDAO.delete(businessLogicAccountingUserHighLevelManager);
			businesslogic.accounting.Permission businessLogicAccountingPermission = businesslogic.accounting.PermissionDAO.loadPermissionByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.PermissionDAO.delete(businessLogicAccountingPermission);
			businesslogic.utility.Date businessLogicUtilityDate = businesslogic.utility.DateDAO.loadDateByQuery(null, null);
			// Delete the persistent object
			businesslogic.utility.DateDAO.delete(businessLogicUtilityDate);
			businesslogic.utility.Notification businessLogicUtilityNotification = businesslogic.utility.NotificationDAO.loadNotificationByQuery(null, null);
			// Delete the persistent object
			businesslogic.utility.NotificationDAO.delete(businessLogicUtilityNotification);
			businesslogic.distribution.requirement.RequirementPriority businessLogicDistributionRequirementRequirementPriority = businesslogic.distribution.requirement.RequirementPriorityDAO.loadRequirementPriorityByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.requirement.RequirementPriorityDAO.delete(businessLogicDistributionRequirementRequirementPriority);
			businesslogic.distribution.resource.ResourceState businessLogicDistributionResourceResourceState = businesslogic.distribution.resource.ResourceStateDAO.loadResourceStateByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.resource.ResourceStateDAO.delete(businessLogicDistributionResourceResourceState);
			network.Email networkEmail = network.EmailDAO.loadEmailByQuery(null, null);
			// Delete the persistent object
			network.EmailDAO.delete(networkEmail);
			businesslogic.accounting.job.UserJob businessLogicAccountingJobUserJob = businesslogic.accounting.job.UserJobDAO.loadUserJobByQuery(null, null);
			// Delete the persistent object
			businesslogic.accounting.job.UserJobDAO.delete(businessLogicAccountingJobUserJob);
			businesslogic.distribution.ResourceAllocation businessLogicDistributionResourceAllocation = businesslogic.distribution.ResourceAllocationDAO.loadResourceAllocationByQuery(null, null);
			// Delete the persistent object
			businesslogic.distribution.ResourceAllocationDAO.delete(businessLogicDistributionResourceAllocation);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteOODData deleteOODData = new DeleteOODData();
			try {
				deleteOODData.deleteTestData();
			}
			finally {
				businesslogic.accounting.user.OODPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
