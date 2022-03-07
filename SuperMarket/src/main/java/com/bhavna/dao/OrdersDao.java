package com.bhavna.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhavna.model.Items;
import com.bhavna.model.Orders;

@Repository
public class OrdersDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Orders> getOrders() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Orders> cq = cb.createQuery(Orders.class);
		Root<Orders> root = cq.from(Orders.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	public void saveOrders(Orders sOrder) {
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		currentSession.save(sOrder);
		currentSession.getTransaction().commit();
		currentSession.close();
	}

	public Orders getOrderById(Integer oId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Orders orders = currentSession.get(Orders.class, oId);
		return orders;
	}
	
	public void updateOrderById(Integer oId, Orders orders) {
		Session currentSession = sessionFactory.openSession();
		currentSession.beginTransaction();
		currentSession.update(orders);
		currentSession.getTransaction().commit();
		currentSession.close();
	}

}
