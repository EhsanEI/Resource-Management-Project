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

public class ResourceRequirementPriorityDAO {
	public static ResourceRequirementPriority loadResourceRequirementPriorityByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadResourceRequirementPriorityByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority getResourceRequirementPriorityByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getResourceRequirementPriorityByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority loadResourceRequirementPriorityByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadResourceRequirementPriorityByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority getResourceRequirementPriorityByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getResourceRequirementPriorityByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority loadResourceRequirementPriorityByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ResourceRequirementPriority) session.load(businesslogic.distribution.requirement.ResourceRequirementPriority.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority getResourceRequirementPriorityByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ResourceRequirementPriority) session.get(businesslogic.distribution.requirement.ResourceRequirementPriority.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority loadResourceRequirementPriorityByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ResourceRequirementPriority) session.load(businesslogic.distribution.requirement.ResourceRequirementPriority.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority getResourceRequirementPriorityByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ResourceRequirementPriority) session.get(businesslogic.distribution.requirement.ResourceRequirementPriority.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResourceRequirementPriority(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryResourceRequirementPriority(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResourceRequirementPriority(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryResourceRequirementPriority(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority[] listResourceRequirementPriorityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listResourceRequirementPriorityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority[] listResourceRequirementPriorityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listResourceRequirementPriorityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResourceRequirementPriority(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.requirement.ResourceRequirementPriority as ResourceRequirementPriority");
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
	
	public static List queryResourceRequirementPriority(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.requirement.ResourceRequirementPriority as ResourceRequirementPriority");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ResourceRequirementPriority", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority[] listResourceRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryResourceRequirementPriority(session, condition, orderBy);
			return (ResourceRequirementPriority[]) list.toArray(new ResourceRequirementPriority[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority[] listResourceRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryResourceRequirementPriority(session, condition, orderBy, lockMode);
			return (ResourceRequirementPriority[]) list.toArray(new ResourceRequirementPriority[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority loadResourceRequirementPriorityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadResourceRequirementPriorityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority loadResourceRequirementPriorityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadResourceRequirementPriorityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority loadResourceRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ResourceRequirementPriority[] resourceRequirementPrioritys = listResourceRequirementPriorityByQuery(session, condition, orderBy);
		if (resourceRequirementPrioritys != null && resourceRequirementPrioritys.length > 0)
			return resourceRequirementPrioritys[0];
		else
			return null;
	}
	
	public static ResourceRequirementPriority loadResourceRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ResourceRequirementPriority[] resourceRequirementPrioritys = listResourceRequirementPriorityByQuery(session, condition, orderBy, lockMode);
		if (resourceRequirementPrioritys != null && resourceRequirementPrioritys.length > 0)
			return resourceRequirementPrioritys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateResourceRequirementPriorityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateResourceRequirementPriorityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResourceRequirementPriorityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateResourceRequirementPriorityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResourceRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.requirement.ResourceRequirementPriority as ResourceRequirementPriority");
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
	
	public static java.util.Iterator iterateResourceRequirementPriorityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.requirement.ResourceRequirementPriority as ResourceRequirementPriority");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ResourceRequirementPriority", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority createResourceRequirementPriority() {
		return new businesslogic.distribution.requirement.ResourceRequirementPriority();
	}
	
	public static boolean save(businesslogic.distribution.requirement.ResourceRequirementPriority resourceRequirementPriority) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().saveObject(resourceRequirementPriority);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(businesslogic.distribution.requirement.ResourceRequirementPriority resourceRequirementPriority) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().deleteObject(resourceRequirementPriority);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(businesslogic.distribution.requirement.ResourceRequirementPriority resourceRequirementPriority) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().refresh(resourceRequirementPriority);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(businesslogic.distribution.requirement.ResourceRequirementPriority resourceRequirementPriority) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().evict(resourceRequirementPriority);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceRequirementPriority loadResourceRequirementPriorityByCriteria(ResourceRequirementPriorityCriteria resourceRequirementPriorityCriteria) {
		ResourceRequirementPriority[] resourceRequirementPrioritys = listResourceRequirementPriorityByCriteria(resourceRequirementPriorityCriteria);
		if(resourceRequirementPrioritys == null || resourceRequirementPrioritys.length == 0) {
			return null;
		}
		return resourceRequirementPrioritys[0];
	}
	
	public static ResourceRequirementPriority[] listResourceRequirementPriorityByCriteria(ResourceRequirementPriorityCriteria resourceRequirementPriorityCriteria) {
		return resourceRequirementPriorityCriteria.listResourceRequirementPriority();
	}
}
