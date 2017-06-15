package com.jpro.philosophibackend.dao.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.jpro.philosophibackend.dao.SupplierDAO;
import com.jpro.philosophibackend.domain.Supplier;

@EnableTransactionManagement
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	private static final Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;		
	}

	@Transactional
	public List<Supplier> getAllSupplier() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	@Transactional
	public boolean saveSupplier(Supplier supplier) {
		log.debug("Start of saveSupplier");
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
		log.debug("End of saveSupplier");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of saveSupplier");
			return false;
		}
	}

	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		log.debug("Start of updateSupplier");
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		log.debug("End of updateSupplier");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of updateSupplier");
			return false;
		}
	}

	@Transactional
	public boolean deleteSupplier(Supplier supplier) {
		log.debug("Start of deleteSupplier");
		try
		{
		sessionFactory.getCurrentSession().delete(supplier);
		log.debug("End of deleteSupplier");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.debug("End of deleteSupplier");
			return false;
		}	
	}

	@Transactional
	public boolean deleteSupplier(String supplierId) {
		log.debug("Start of deleteSupplier");
		try {
			sessionFactory.getCurrentSession().delete(getSupplierById(supplierId));
			log.debug("End of deleteSupplier");
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			log.debug("End of deleteSupplier");
			return false;
		}
	}

	@Transactional
	public Supplier getSupplierById(String supplierId) {
		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where supplierId ='"+ supplierId +"'" ).uniqueResult();
	}

	@Transactional
	public Supplier getSupplierByName(String supplierName) {
		return (Supplier) sessionFactory.getCurrentSession().createQuery("from Supplier where supplierName ='"+ supplierName +"'" ).list().get(0);
	}

}
