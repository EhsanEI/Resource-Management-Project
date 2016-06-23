/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package businesslogic.distribution.requirement;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class RequirementPriorityDAO {
	public static RequirementPriority loadRequirementPriorityByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return loadRequirementPriorityByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority getRequirementPriorityByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return getRequirementPriorityByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority loadRequirementPriorityByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return loadRequirementPriorityByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority getRequirementPriorityByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return getRequirementPriorityByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority loadRequirementPriorityByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (RequirementPriority) session.load(businesslogic.distribution.requirement.RequirementPriority.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority getRequirementPriorityByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (RequirementPriority) session.get(businesslogic.distribution.requirement.RequirementPriority.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority loadRequirementPriorityByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (RequirementPriority) session.load(businesslogic.distribution.requirement.RequirementPriority.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority getRequirementPriorityByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (RequirementPriority) session.get(businesslogic.distribution.requirement.RequirementPriority.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRequirementPriority(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return queryRequirementPriority(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRequirementPriority(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return queryRequirementPriority(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority[] listRequirementPriorityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return listRequirementPriorityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority[] listRequirementPriorityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return listRequirementPriorityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRequirementPriority(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.requirement.RequirementPriority as RequirementPriority");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRequirementPriority(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.requirement.RequirementPriority as RequirementPriority");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("RequirementPriority", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority[] listRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRequirementPriority(session, condition, orderBy);
			return (RequirementPriority[]) list.toArray(new RequirementPriority[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority[] listRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRequirementPriority(session, condition, orderBy, lockMode);
			return (RequirementPriority[]) list.toArray(new RequirementPriority[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority loadRequirementPriorityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return loadRequirementPriorityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority loadRequirementPriorityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return loadRequirementPriorityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority loadRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		RequirementPriority[] requirementPrioritys = listRequirementPriorityByQuery(session, condition, orderBy);
		if (requirementPrioritys != null && requirementPrioritys.length > 0)
			return requirementPrioritys[0];
		else
			return null;
	}
	
	public static RequirementPriority loadRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		RequirementPriority[] requirementPrioritys = listRequirementPriorityByQuery(session, condition, orderBy, lockMode);
		if (requirementPrioritys != null && requirementPrioritys.length > 0)
			return requirementPrioritys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRequirementPriorityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return iterateRequirementPriorityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRequirementPriorityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.accounting.user.OODPersistentManager.instance().getSession();
			return iterateRequirementPriorityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.requirement.RequirementPriority as RequirementPriority");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.requirement.RequirementPriority as RequirementPriority");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("RequirementPriority", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority createRequirementPriority() {
		return new businesslogic.distribution.requirement.RequirementPriority();
	}
	
	public static boolean save(businesslogic.distribution.requirement.RequirementPriority requirementPriority) throws PersistentException {
		try {
			businesslogic.accounting.user.OODPersistentManager.instance().saveObject(requirementPriority);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(businesslogic.distribution.requirement.RequirementPriority requirementPriority) throws PersistentException {
		try {
			businesslogic.accounting.user.OODPersistentManager.instance().deleteObject(requirementPriority);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(businesslogic.distribution.requirement.RequirementPriority requirementPriority) throws PersistentException {
		try {
			businesslogic.accounting.user.OODPersistentManager.instance().getSession().refresh(requirementPriority);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(businesslogic.distribution.requirement.RequirementPriority requirementPriority) throws PersistentException {
		try {
			businesslogic.accounting.user.OODPersistentManager.instance().getSession().evict(requirementPriority);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static RequirementPriority loadRequirementPriorityByCriteria(RequirementPriorityCriteria requirementPriorityCriteria) {
		RequirementPriority[] requirementPrioritys = listRequirementPriorityByCriteria(requirementPriorityCriteria);
		if(requirementPrioritys == null || requirementPrioritys.length == 0) {
			return null;
		}
		return requirementPrioritys[0];
	}
	
	public static RequirementPriority[] listRequirementPriorityByCriteria(RequirementPriorityCriteria requirementPriorityCriteria) {
		return requirementPriorityCriteria.listRequirementPriority();
	}
}
