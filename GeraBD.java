/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alan.oliveira.bd;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alan Oliveira
 */
public class GeraBD {

    public static void main(String[] args) {

        Random radom = new Random();
        Generate g = new Generate();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projeto_BackPU");
        EntityManager em = emf.createEntityManager();

        for (int i = 1; i <= 3000; i++) {

            tb_customer_account tb = new tb_customer_account();

            tb.setNm_customer("Cliente " + i);
            tb.setCpf_cnpj(g.geraAleatorio(999999999, 111111111));
            tb.setIs_active(true);
            tb.setVl_total(g.geraAleatorio(2000, 0));

            em.getTransaction().begin();
            em.persist(tb);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }

}
