package com.rentprop.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rentprop.dto.ApartmentDTO;
import com.rentprop.dto.LoginDTO;
import com.rentprop.dto.PaymentDTO;
import com.rentprop.dto.ResidentDTO;
import com.rentprop.entity.Apartment;
import com.rentprop.entity.Payment;
import com.rentprop.entity.Resident;
import com.rentprop.entity.User;

public class ResidentDAO {
	public int addResident(ResidentDTO residentDTO) {
		int resident_id = -1;
		try {
			User user = new User();
			Resident resident = new Resident();
			Apartment apartment = new Apartment();
			BeanUtils.copyProperties(user, residentDTO.getLoginDto());
			BeanUtils.copyProperties(apartment, residentDTO.getApartmentDTO());
			BeanUtils.copyProperties(resident, residentDTO);
			resident.setUser(user);
			resident.setApartment(apartment);

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(resident);
			resident_id = resident.getResidentId();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resident_id;
	}

	public static List fetchid(ResidentDTO ResidentDTO) {
		List<LoginDTO> list_of_user = new ArrayList<LoginDTO>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("from Resident where resident_id='" + ResidentDTO.getResident_id() + "'");
			list_of_user = q.list();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list_of_user;
	}

	public List<ResidentDTO> search_all_residents() {
		List<ResidentDTO> list_of_all_residents = new ArrayList<ResidentDTO>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session
					.createQuery("from Resident r, User u where user_type='resident' AND u.username = r.username");

			list_of_all_residents = q.list();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list_of_all_residents;

	}

	public void update_resident(ResidentDTO residentDTO) {
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Resident resident = new Resident();
			BeanUtils.copyProperties(resident, residentDTO);
			session.update(resident);
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

	public void update_rental_status(ResidentDTO residentDTO) {
		Session session = null;
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("update Apartment set rental_status='rented' where apartment_id='"
					+ residentDTO.getApartmentDTO().getApartmentId() + "'");
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

	public ApartmentDTO findAptById(ApartmentDTO apartmentDTO) {
		ApartmentDTO apartmentDtoFoundInDb = new ApartmentDTO();
		List<ApartmentDTO> list_of_user = new ArrayList<ApartmentDTO>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("from Apartment where apartment_id='" + apartmentDTO.getApartmentId() + "'");
			list_of_user = q.list();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (null != list_of_user && list_of_user.size() > 0) {
			try {
				BeanUtils.copyProperties(apartmentDtoFoundInDb, list_of_user.get(0));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		return apartmentDtoFoundInDb;
	}

	public List authentication_email(ResidentDTO residentDTO) {
		List<ResidentDTO> list_of_user = new ArrayList<ResidentDTO>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("from User where email_id='" + residentDTO.getLoginDto().getEmailId() + "'");
			list_of_user = q.list();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list_of_user;
	}

	public static ResidentDTO findResidentIdByUserName(String userName) {
		ResidentDTO residentDtoFound = null;
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			Query q = session.createQuery("from Resident where username='" + userName + "'");
			List<Resident> residentList = q.list();
			if (residentList != null && residentList.size() == 1) {
				residentDtoFound = new ResidentDTO();
				BeanUtils.copyProperties(residentDtoFound, residentList.get(0));
			}
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return residentDtoFound;
	}

	public int addPayment(PaymentDTO paymentDto) {
		int paymentId = -1;
		try {
			Payment payment = new Payment();

			payment.setDate(paymentDto.getDate());
			payment.setStatus(paymentDto.getStatus());

			Apartment apartment = new Apartment();
			apartment.setApartmentId(paymentDto.getApartmentDTO().getApartmentId());
			payment.setApartment(apartment);

			Resident resident = new Resident();
			resident.setResidentId(paymentDto.getResidentDTO().getResident_id());
			payment.setResident(resident);

			payment.setPaymentDate(paymentDto.getPayment_date());

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(payment);
			paymentId = payment.getPaymentId();
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return paymentId;
	}

	public static List<ResidentDTO> findAllResidentTypeUser() {
		List<ResidentDTO> residentDtoList = null;
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();

			Query q = session.createQuery("from User where usertype = 'resident'");
			List<User> userList = q.list();
			if (null != userList && userList.size() > 0) {
				residentDtoList = new ArrayList<ResidentDTO>();
				for (User user : userList) {
					LoginDTO loginDto = new LoginDTO();
					BeanUtils.copyProperties(loginDto, user);

					Query qr = session.createQuery("from User where username = '" + user.getUsername() + "'");
					List<Resident> residentList = qr.list();
					if (null != residentList && residentList.size() > 0) {
						ResidentDTO residentDto = new ResidentDTO();
						BeanUtils.copyProperties(residentDto, residentList.get(0));
						residentDto.setLoginDto(loginDto);
						residentDtoList.add(residentDto);
					}
				}
			}
			session.clear();
			sessionFactory.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return residentDtoList;
	}
}
