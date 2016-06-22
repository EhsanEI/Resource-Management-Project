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
package businesslogic.distribution;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class AllocationDAO {
	public static Allocation loadAllocationByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadAllocationByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation getAllocationByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getAllocationByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation loadAllocationByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadAllocationByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation getAllocationByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getAllocationByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation loadAllocationByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Allocation) session.load(businesslogic.distribution.Allocation.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation getAllocationByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Allocation) session.get(businesslogic.distribution.Allocation.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation loadAllocationByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Allocation) session.load(businesslogic.distribution.Allocation.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation getAllocationByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Allocation) session.get(businesslogic.distribution.Allocation.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAllocation(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryAllocation(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAllocation(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryAllocation(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation[] listAllocationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listAllocationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation[] listAllocationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listAllocationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAllocation(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.Allocation as Allocation");
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
	
	public static List queryAllocation(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.Allocation as Allocation");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Allocation", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation[] listAllocationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAllocation(session, condition, orderBy);
			return (Allocation[]) list.toArray(new Allocation[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation[] listAllocationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAllocation(session, condition, orderBy, lockMode);
			return (Allocation[]) list.toArray(new Allocation[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation loadAllocationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadAllocationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation loadAllocationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadAllocationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation loadAllocationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Allocation[] Allocations = listAllocationByQuery(session, condition, orderBy);
		if (Allocations != null && Allocations.length > 0)
			return Allocations[0];
		else
			return null;
	}
	
	public static Allocation loadAllocationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Allocation[] Allocations = listAllocationByQuery(session, condition, orderBy, lockMode);
		if (Allocations != null && Allocations.length > 0)
			return Allocations[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAllocationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateAllocationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAllocationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateAllocationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAllocationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.Allocation as Allocation");
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
	
	public static java.util.Iterator iterateAllocationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.distribution.Allocation as Allocation");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Allocation", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation createAllocation() {
		return new businesslogic.distribution.Allocation();
	}
	
	public static boolean save(businesslogic.distribution.Allocation Allocation) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().saveObject(Allocation);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(businesslogic.distribution.Allocation Allocation) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().deleteObject(Allocation);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(businesslogic.distribution.Allocation Allocation) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().refresh(Allocation);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(businesslogic.distribution.Allocation Allocation) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().evict(Allocation);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Allocation loadAllocationByCriteria(AllocationCriteria AllocationCriteria) {
		Allocation[] Allocations = listAllocationByCriteria(AllocationCriteria);
		if(Allocations == null || Allocations.length == 0) {
			return null;
		}
		return Allocations[0];
	}
	
	public static Allocation[] listAllocationByCriteria(AllocationCriteria AllocationCriteria) {
		return AllocationCriteria.listAllocation();
	}
}
