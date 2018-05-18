/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alan.oliveira.dao;

import java.util.List;
import javax.persistence.EntityManager;
import alan.oliveira.bd.tb_customer_account;

/**
 *
 * @author Alan Oliveira
 */
public class tb_customer_account_dao extends AbstractDao<tb_customer_account, Integer>{
    
    public tb_customer_account_dao(EntityManager em) {
        super(em);
    }
    
    public List<tb_customer_account> consultaMedia (){
        return em.createQuery(
                "select t "
                + "from tb_customer_account t "
                + "where vl_total > 560 and "
                + "id_customer between 1500 and 2700 order by t.vl_total desc"
        ).getResultList();
    }

}
