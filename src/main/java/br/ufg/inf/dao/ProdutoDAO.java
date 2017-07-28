/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.dao;

import java.util.List;

import br.ufg.inf.dto.Produto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Paulo de Oliveira
 */
public class ProdutoDAO {

    private SessionFactory sessionFactory = null;
    
    public ProdutoDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Produto getProduto(String codigo) {
        Produto produto = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            produto = (Produto) session.createQuery("from Produto p where p.codigo = :codigo").
                    setString("codigo", codigo).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produto;
    }

    public List<Produto> getProdutos() {
        List<Produto> produtos = null;
        Session session = null;
        try {            
            session = sessionFactory.openSession();
            session.beginTransaction();
// **** Exemplo de Uso com Criteria             
//            Criteria crit = session.createCriteria(Produto.class);
//            crit.add(Restrictions.like("nome","ar%"));
//            produtos = crit.list();
// **** Fim do exemplo de Criteria            
            produtos = session.createQuery("from Produto").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produtos;
    }

    public void addProduto(Produto produto){
        Session session = null;
        Transaction tx = null;
        Integer employeeID = null;
        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(produto);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            assert session != null;
            session.close();
        }
    }

    public void delProduto(Integer produtoID){
        Session session = null;
        Transaction tx = null;
        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Produto produto =
                    (Produto) session.get(Produto.class, produtoID);
            session.delete(produto);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            assert session != null;
            session.close();
        }
    }

    public void updateProduto(Produto novoProduto){
        Session session = null;
        Transaction tx = null;
        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Produto produto = (Produto) session.get(Produto.class, novoProduto.getProdutoId());

            produto.setNome(novoProduto.getNome());
            produto.setPreco(novoProduto.getPreco());
            produto.setCodigo(novoProduto.getCodigo());

            session.update(produto);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            assert session != null;
            session.close();
        }
    }

}
