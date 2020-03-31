package com.qintess.estudo.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qintess.estudo.hibernate.config.HibernateConfig;
import com.qintess.estudo.livraria.Autor;

public class AutorDao {
	
	public void salva(Autor autor) {
		
		Transaction transacao = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			
			transacao = session.beginTransaction();
			
			session.save(autor);
			
			transacao.commit();
			
		} catch (Exception e) {
			
			if(transacao != null) {
				transacao.rollback();
				
			}
		}
		
	}
	
	public List<Autor> buscaTodos(){
		
		try (Session session = HibernateConfig.getSessionFactory().openSession()){
			
			return session.createQuery("from Autor", Autor.class).list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
