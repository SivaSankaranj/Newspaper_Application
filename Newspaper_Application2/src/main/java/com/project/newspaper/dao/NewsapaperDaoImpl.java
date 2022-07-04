package com.project.newspaper.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.newspaper.dto.NewspaperDto;
import com.project.newspaper.entity.Newspaper;

@Component
public class NewsapaperDaoImpl implements NewspaperDao {
	@Autowired
	private SessionFactory sessionFactory;

	public NewsapaperDaoImpl() {
		System.out.println("object is created:" + this.getClass().getName());
	}

	@Override
	public boolean saveNewspaperEntity(Newspaper newspaper) {
		System.out.println("Invoked save Newspaper Entity method()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(newspaper);
			session.getTransaction().commit();
			System.out.println("Newspaper details has been saved successfully");
			return true;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());

		} finally {
			if (session != null) {
				System.out.println("session is cloed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return false;
	}

	@Override
	public List<Newspaper> getNewspaperEntity(String newspaperName) {
		System.out.println("Invoked get Newspaper Entity method() by Newspaper name");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query quey = session.getNamedQuery("Newspaper.getNewspaperObject");
			quey.setParameter("name", newspaperName);
			List<Newspaper> newspaperEntity = quey.list();
			System.out.println("Found NewspaperEntity By name:" +newspaperEntity);
			if (newspaperEntity != null) {
				return newspaperEntity;
			} else {
				System.out.println("newspaper name is not found......,,,,");
				return null;
			}
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				System.out.println("session is clodsed....,,,,");
				session.close();
			} else {
				System.out.println("session is not closed");
			}

		}

		return null;
	}

	@Override
	public Newspaper getNewspaperEntityByLanguage(String Language) {
		System.out.println("Invoked Newspaper language DAO()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createNamedQuery("Newspaper.getLanguageObject");
			query.setParameter("name", Language);
			Newspaper newspaper = (Newspaper) query.uniqueResult();
			if (newspaper != null) {
				return newspaper;
			} else {
				System.out.println("Newspaper language is not found");
			}
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				System.out.println("session is clodsed....,,,,");
				session.close();
			} else {
				System.out.println("session is not closed");
			}

		} 

		return null;
	}

	@Override
	public List<Newspaper> getAllNewspaperEntity() {
		System.out.println("NewsapaperDaoImpl.getAllNewspaperEntity()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query<Newspaper> query=session.getNamedQuery("Newspaper.getAllEntity");
			List<Newspaper> list=query.list();
			if(list!=null &&! list.isEmpty()) {
				return list;
			}else {
				System.out.println("list is empty,,,,,, add some data");
			}
				
			}catch (HibernateException e) {
				System.out.println(e.getMessage());
			}finally {
				if(session!=null) {
					System.out.println("session is closed,,,,,,,,");
					session.close();
				}else {
					System.out.println("session is not closed,,,,,,,");
				}
			}
		return null;
	}

	@Override
	public boolean deleteNewspaperEntity(String newspaperName) {
		System.out.println("NewsapaperDaoImpl.deleteNewspaperEntity()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("deleteNewspaperEntity");
			query.setParameter("name", newspaperName);
			Newspaper newspaper = (Newspaper) query.uniqueResult();
			System.out.println("object is deleted:"+newspaper);
			session.beginTransaction();
			session.delete(newspaper);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				System.out.println("session is clodsed....,,,,");
				session.close();
			} else {
				System.out.println("session is not closed");
			}

		} 

		return false;
	}

	@Override
	public boolean updateNewspaperEntity(NewspaperDto dto) {
	 System.out.println("NewsapaperDaoImpl.updateNewspaperEntityById()");
		Session session=null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("updateNewspaperEntity");
			query.setParameter("Name",dto.getNewspaperName());
			query.setParameter("PRICE",dto.getPrice());
			query.setParameter("LANGUAGE",dto.getLanguage());
			query.setParameter("NOOFPAGES",dto.getNoofPages());
			query.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Data Updated successfully....,,,:");
			return true;
			} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}finally {
			if (session != null) {
				System.out.println("session is clodsed....,,,,");
				session.close();
			} else {
				System.out.println("session is not closed");
			}
		}
		return false;
	}
} 
		

