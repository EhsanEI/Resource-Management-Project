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
package businesslogic.distribution.resource;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class ResourceStateDAO {
	public static ResourceState loadResourceStateByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadResourceStateByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState getResourceStateByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getResourceStateByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState loadResourceStateByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadResourceStateByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState getResourceStateByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getResourceStateByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState loadResourceStateByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ResourceState) session.load(businesslogic.distribution.resource.ResourceState.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState getResourceStateByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ResourceState) session.get(businesslogic.distribution.resource.ResourceState.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState loadResourceStateByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ResourceState) session.load(businesslogic.distribution.resource.ResourceState.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState getResourceStateByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ResourceState) session.get(businesslogic.distribution.resource.ResourceState.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResourceState(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryResourceState(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResourceState(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryResourceState(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState[] listResourceStateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listResourceStateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState[] listResourceStateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listResourceStateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryResourceState(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ResourceState as ResourceState");
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
	
	public static List queryResourceState(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ResourceState as ResourceState");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ResourceState", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState[] listResourceStateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryResourceState(session, condition, orderBy);
			return (ResourceState[]) list.toArray(new ResourceState[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState[] listResourceStateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryResourceState(session, condition, orderBy, lockMode);
			return (ResourceState[]) list.toArray(new ResourceState[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState loadResourceStateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadResourceStateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState loadResourceStateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadResourceStateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState loadResourceStateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ResourceState[] resourceStates = listResourceStateByQuery(session, condition, orderBy);
		if (resourceStates != null && resourceStates.length > 0)
			return resourceStates[0];
		else
			return null;
	}
	
	public static ResourceState loadResourceStateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ResourceState[] resourceStates = listResourceStateByQuery(session, condition, orderBy, lockMode);
		if (resourceStates != null && resourceStates.length > 0)
			return resourceStates[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateResourceStateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateResourceStateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResourceStateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateResourceStateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateResourceStateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ResourceState as ResourceState");
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
	
	public static java.util.Iterator iterateResourceStateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ResourceState as ResourceState");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ResourceState", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState createResourceState() {
		return new businesslogic.distribution.resource.ResourceState();
	}
	
	public static boolean save(businesslogic.distribution.resource.ResourceState resourceState) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().saveObject(resourceState);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(businesslogic.distribution.resource.ResourceState resourceState) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().deleteObject(resourceState);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(businesslogic.distribution.resource.ResourceState resourceState) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().refresh(resourceState);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(businesslogic.distribution.resource.ResourceState resourceState) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().evict(resourceState);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ResourceState loadResourceStateByCriteria(ResourceStateCriteria resourceStateCriteria) {
		ResourceState[] resourceStates = listResourceStateByCriteria(resourceStateCriteria);
		if(resourceStates == null || resourceStates.length == 0) {
			return null;
		}
		return resourceStates[0];
	}
	
	public static ResourceState[] listResourceStateByCriteria(ResourceStateCriteria resourceStateCriteria) {
		return resourceStateCriteria.listResourceState();
	}
}
