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
package businesslogic.utility;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class DateDAO {
	public static Date loadDateByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadDateByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date getDateByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getDateByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date loadDateByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadDateByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date getDateByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return getDateByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date loadDateByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Date) session.load(businesslogic.utility.Date.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date getDateByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Date) session.get(businesslogic.utility.Date.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date loadDateByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Date) session.load(businesslogic.utility.Date.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date getDateByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Date) session.get(businesslogic.utility.Date.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDate(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryDate(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDate(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return queryDate(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date[] listDateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listDateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date[] listDateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return listDateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDate(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.utility.Date as Date");
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
	
	public static List queryDate(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.utility.Date as Date");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Date", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date[] listDateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDate(session, condition, orderBy);
			return (Date[]) list.toArray(new Date[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date[] listDateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDate(session, condition, orderBy, lockMode);
			return (Date[]) list.toArray(new Date[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date loadDateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadDateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date loadDateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return loadDateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date loadDateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Date[] dates = listDateByQuery(session, condition, orderBy);
		if (dates != null && dates.length > 0)
			return dates[0];
		else
			return null;
	}
	
	public static Date loadDateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Date[] dates = listDateByQuery(session, condition, orderBy, lockMode);
		if (dates != null && dates.length > 0)
			return dates[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDateByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateDateByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDateByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = businesslogic.distribution.resource.OODPersistentManager.instance().getSession();
			return iterateDateByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDateByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.utility.Date as Date");
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
	
	public static java.util.Iterator iterateDateByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From businesslogic.utility.Date as Date");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Date", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date createDate() {
		return new businesslogic.utility.Date();
	}
	
	public static boolean save(businesslogic.utility.Date date) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().saveObject(date);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(businesslogic.utility.Date date) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().deleteObject(date);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(businesslogic.utility.Date date) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().refresh(date);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(businesslogic.utility.Date date) throws PersistentException {
		try {
			businesslogic.distribution.resource.OODPersistentManager.instance().getSession().evict(date);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Date loadDateByCriteria(DateCriteria dateCriteria) {
		Date[] dates = listDateByCriteria(dateCriteria);
		if(dates == null || dates.length == 0) {
			return null;
		}
		return dates[0];
	}
	
	public static Date[] listDateByCriteria(DateCriteria dateCriteria) {
		return dateCriteria.listDate();
	}
}
