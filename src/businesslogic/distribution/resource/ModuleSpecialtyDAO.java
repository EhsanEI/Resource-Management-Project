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

public class ModuleSpecialtyDAO {
	public static ModuleSpecialty loadModuleSpecialtyByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadModuleSpecialtyByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty getModuleSpecialtyByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getModuleSpecialtyByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty loadModuleSpecialtyByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadModuleSpecialtyByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty getModuleSpecialtyByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getModuleSpecialtyByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty loadModuleSpecialtyByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ModuleSpecialty) session.load(businesslogic.distribution.resource.ModuleSpecialty.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty getModuleSpecialtyByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ModuleSpecialty) session.get(businesslogic.distribution.resource.ModuleSpecialty.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty loadModuleSpecialtyByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ModuleSpecialty) session.load(businesslogic.distribution.resource.ModuleSpecialty.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty getModuleSpecialtyByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ModuleSpecialty) session.get(businesslogic.distribution.resource.ModuleSpecialty.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryModuleSpecialty(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryModuleSpecialty(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryModuleSpecialty(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryModuleSpecialty(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty[] listModuleSpecialtyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listModuleSpecialtyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty[] listModuleSpecialtyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listModuleSpecialtyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryModuleSpecialty(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ModuleSpecialty as ModuleSpecialty");
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
	
	public static List queryModuleSpecialty(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ModuleSpecialty as ModuleSpecialty");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ModuleSpecialty", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty[] listModuleSpecialtyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryModuleSpecialty(session, condition, orderBy);
			return (ModuleSpecialty[]) list.toArray(new ModuleSpecialty[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty[] listModuleSpecialtyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryModuleSpecialty(session, condition, orderBy, lockMode);
			return (ModuleSpecialty[]) list.toArray(new ModuleSpecialty[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty loadModuleSpecialtyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadModuleSpecialtyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty loadModuleSpecialtyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadModuleSpecialtyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty loadModuleSpecialtyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ModuleSpecialty[] moduleSpecialtys = listModuleSpecialtyByQuery(session, condition, orderBy);
		if (moduleSpecialtys != null && moduleSpecialtys.length > 0)
			return moduleSpecialtys[0];
		else
			return null;
	}
	
	public static ModuleSpecialty loadModuleSpecialtyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ModuleSpecialty[] moduleSpecialtys = listModuleSpecialtyByQuery(session, condition, orderBy, lockMode);
		if (moduleSpecialtys != null && moduleSpecialtys.length > 0)
			return moduleSpecialtys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateModuleSpecialtyByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateModuleSpecialtyByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateModuleSpecialtyByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateModuleSpecialtyByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateModuleSpecialtyByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ModuleSpecialty as ModuleSpecialty");
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
	
	public static java.util.Iterator iterateModuleSpecialtyByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.resource.ModuleSpecialty as ModuleSpecialty");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ModuleSpecialty", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty createModuleSpecialty() {
		return new businesslogic.distribution.resource.ModuleSpecialty();
	}
	
	public static boolean save(businesslogic.distribution.resource.ModuleSpecialty moduleSpecialty) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().saveObject(moduleSpecialty);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(businesslogic.distribution.resource.ModuleSpecialty moduleSpecialty) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().deleteObject(moduleSpecialty);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(businesslogic.distribution.resource.ModuleSpecialty moduleSpecialty) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().refresh(moduleSpecialty);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(businesslogic.distribution.resource.ModuleSpecialty moduleSpecialty) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().evict(moduleSpecialty);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static ModuleSpecialty loadModuleSpecialtyByCriteria(ModuleSpecialtyCriteria moduleSpecialtyCriteria) {
		ModuleSpecialty[] moduleSpecialtys = listModuleSpecialtyByCriteria(moduleSpecialtyCriteria);
		if(moduleSpecialtys == null || moduleSpecialtys.length == 0) {
			return null;
		}
		return moduleSpecialtys[0];
	}
	
	public static ModuleSpecialty[] listModuleSpecialtyByCriteria(ModuleSpecialtyCriteria moduleSpecialtyCriteria) {
		return moduleSpecialtyCriteria.listModuleSpecialty();
	}
}
