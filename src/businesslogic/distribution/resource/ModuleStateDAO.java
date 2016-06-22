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

public class ModuleStateDAO {
	public static ModuleState loadModuleStateByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadModuleStateByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState getModuleStateByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getModuleStateByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState loadModuleStateByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadModuleStateByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState getModuleStateByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getModuleStateByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState loadModuleStateByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ModuleState) session.load(businesslogic.distribution.resource.ModuleState.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState getModuleStateByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ModuleState) session.get(businesslogic.distribution.resource.ModuleState.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState loadModuleStateByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ModuleState) session.load(businesslogic.distribution.resource.ModuleState.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState getModuleStateByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ModuleState) session.get(businesslogic.distribution.resource.ModuleState.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryModuleState(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryModuleState(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryModuleState(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryModuleState(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState[] listModuleStateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listModuleStateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState[] listModuleStateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listModuleStateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryModuleState(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ModuleState as ModuleState");
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
	
	public static List queryModuleState(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ModuleState as ModuleState");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ModuleState", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState[] listModuleStateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryModuleState(session, condition, orderBy);
			return (ModuleState[]) list.toArray(new ModuleState[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState[] listModuleStateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryModuleState(session, condition, orderBy, lockMode);
			return (ModuleState[]) list.toArray(new ModuleState[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState loadModuleStateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadModuleStateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState loadModuleStateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadModuleStateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState loadModuleStateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ModuleState[] moduleStates = listModuleStateByQuery(session, condition, orderBy);
		if (moduleStates != null && moduleStates.length > 0)
			return moduleStates[0];
		else
			return null;
	}
	
	public static ModuleState loadModuleStateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ModuleState[] moduleStates = listModuleStateByQuery(session, condition, orderBy, lockMode);
		if (moduleStates != null && moduleStates.length > 0)
			return moduleStates[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateModuleStateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateModuleStateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateModuleStateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateModuleStateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateModuleStateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ModuleState as ModuleState");
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
	
	public static java.util.Iterator iterateModuleStateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ModuleState as ModuleState");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ModuleState", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState createModuleState() {
		return new businesslogic.distribution.resource.ModuleState();
	}
	
	public static boolean save(businesslogic.distribution.resource.ModuleState moduleState) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().saveObject(moduleState);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(businesslogic.distribution.resource.ModuleState moduleState) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().deleteObject(moduleState);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(businesslogic.distribution.resource.ModuleState moduleState) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().refresh(moduleState);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(businesslogic.distribution.resource.ModuleState moduleState) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().evict(moduleState);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleState loadModuleStateByCriteria(ModuleStateCriteria moduleStateCriteria) {
		ModuleState[] moduleStates = listModuleStateByCriteria(moduleStateCriteria);
		if(moduleStates == null || moduleStates.length == 0) {
			return null;
		}
		return moduleStates[0];
	}
	
	public static ModuleState[] listModuleStateByCriteria(ModuleStateCriteria moduleStateCriteria) {
		return moduleStateCriteria.listModuleState();
	}
}
