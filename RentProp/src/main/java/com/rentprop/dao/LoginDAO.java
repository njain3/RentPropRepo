package com.rentprop.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rentprop.dto.LoginDTO;
import com.rentprop.entity.User;

public class LoginDAO {
	@PersistenceContext(unitName = "rentprop")
	EntityManager entityManager;

	public LoginDTO findByUserNameAndPassword(LoginDTO loginDto) {
		LoginDTO loginDtoFound = null;

		List<User> list_of_user = new ArrayList<User>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("from User where username='" + loginDto.getUsername() + "' and password='"
					+ loginDto.getPassword() + "'");
			list_of_user = q.list();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (null != list_of_user && list_of_user.size() > 0) {
			for (User user : list_of_user) {
				try {
					loginDtoFound = new LoginDTO();
					BeanUtils.copyProperties(loginDtoFound, user);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return loginDtoFound;
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

			Query q = session.createQuery("delete loginDto where user_name='" + loginDto.getUsername() + "'");
			q.executeUpdate();
			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updatelogin(LoginDTO loginDto) {
		Session session = null;
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			User updatedUser = new User();
			BeanUtils.copyProperties(updatedUser, loginDto);
			session.update(updatedUser);
			// Query q = session.createQuery("update User set username = '" +
			// loginDto.getUserName() + "', password='"
			// + loginDto.getPassword() + "' where login_id='" +
			// loginDto.getLogin_id() + "'");
			// int result = q.executeUpdate();

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

	public int add_login(LoginDTO loginDTO) {
		User user = new User();
		try {
			BeanUtils.copyProperties(user, loginDTO);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int login_id = -1;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			session.save(user);
			session.flush();
			transaction.commit();
			session.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return login_id;

	}

	public List<LoginDTO> forgetPassword(LoginDTO loginDto) {
		List<LoginDTO> loginDtoList = null;
		List<User> userList = null;
		try {
			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			session = sessionfactory.openSession();
			Query q = session.createQuery("from User where emailId = '" + loginDto.getEmailId() + "'");
			userList = q.list();
			if (null != userList && userList.size() > 0) {
				loginDtoList = new ArrayList<LoginDTO>();
				for (User user : userList) {
					LoginDTO loginDtoTemp = new LoginDTO();
					BeanUtils.copyProperties(loginDtoTemp, user);
					loginDtoList.add(loginDtoTemp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginDtoList;
	}

	public void updatePassword(LoginDTO logginDto) {
		Session session = null;
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("update User set password = '" + logginDto.getPassword()
					+ "' where username='" + logginDto.getUsername() + "'");
			q.executeUpdate();
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
}
