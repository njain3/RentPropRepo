package com.rentprop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rentprop.dto.LoginDTO;
import com.rentprop.dto.ResidentDTO;
import com.rentprop.entity.Resident;
import com.rentprop.entity.User;

/**
 * 
 * @author nidhi
 *
 */
public class LoginDAO {
    @PersistenceContext (unitName="rentprop")
    EntityManager entityManager;
	public int add_login(LoginDTO loginDto) {
		// TODO Auto-generated method stub
		int login_id = -1;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			session.save(loginDto);
			login_id = loginDto.getLogin_id();
			transaction.commit();
			session.flush();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return login_id;

	}

	public void updatelogin(LoginDTO loginDto) {
		Session session = null;
		try {
			
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("update loginDto set user_name = '" + loginDto.getUser_name()
					+ "', password='" + loginDto.getPassword() + "' where login_id='" + loginDto.getLogin_id() + "'");
			int result = q.executeUpdate();

			session.flush();
			session.clear();
			transaction.commit();
			sessionFactory.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}

	public List<LoginDTO> authentication(LoginDTO loginDto) {
		List<LoginDTO> loginDTOs = null;
		
		List<User> list_of_user = new ArrayList<User>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("from User where username='" + loginDto.getUser_name()
					+ "' and password='" + loginDto.getPassword() + "'");
			list_of_user = q.list();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (null != list_of_user) {
			loginDTOs = new ArrayList<LoginDTO>();
			for (User user : list_of_user) {
				loginDTOs.add(new LoginDTO(user.getUserId(), user.getUsername(), user.getPassword(), user.getUsertype()));
			}
		}
		return loginDTOs;
	}

	@SuppressWarnings("deprecation")
	public List<ResidentDTO> fetchName(LoginDTO loginDto) {
		List<ResidentDTO> residentDTOs = null;
		
		List<Resident> residentList = new ArrayList<Resident>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			@SuppressWarnings("rawtypes")
			Query q = session.createQuery("from Resident where user_id='" + loginDto.getLogin_id() + "'");
			residentList = q.list();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (null != residentList && residentList.size() > 0) {
			residentDTOs = new ArrayList<ResidentDTO>();
			for (Resident resident : residentList) {
				residentDTOs.add(new ResidentDTO(resident.getResidentId(), resident.getFirstName(), resident.getUserType()));
			}
		}
		return residentDTOs;
	}

	/*
	 * public List forgetPassword(addResidentVO addResidentVO) { List ls=null;
	 * try{ Session session = null; SessionFactory sessionfactory = new
	 * Configuration().configure().buildSessionFactory(); session =
	 * sessionfactory.openSession(); Query q =
	 * session.createQuery("from addResidentVO where email_id='"+addResidentVO.
	 * getEmail_id()+"'"); ls = q.list(); }catch(Exception e) {
	 * e.printStackTrace(); } return ls; } public void
	 * updatePassword(addResidentVO addResidentVO) { Session session = null; try
	 * {
	 * 
	 * SessionFactory sessionFactory=new
	 * Configuration().configure().buildSessionFactory();
	 * session=sessionFactory.openSession(); Transaction
	 * transaction=session.beginTransaction();
	 * 
	 * Query
	 * q=session.createQuery("update loginDto set password = '"+addResidentVO.
	 * getPassword()+"' where user_name='"+addResidentVO.getUser_id()+"'");
	 * q.executeUpdate(); session.flush(); session.clear();
	 * transaction.commit(); sessionFactory.close(); } catch(Exception ex) {
	 * ex.printStackTrace(); } finally { session.close(); }
	 * 
	 * 
	 * }
	 */
	public void delete(LoginDTO loginDto) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("delete loginDto where user_name='" + loginDto.getUser_name() + "'");
			q.executeUpdate();
			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
