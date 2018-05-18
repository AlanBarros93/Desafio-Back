/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alan.oliveira.main;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import alan.oliveira.bd.tb_customer_account;
import alan.oliveira.dao.tb_customer_account_dao;

/**
 *
 * @author Alan Oliveira
 */
public class Consultas {

    public static void main(String[] args) {

        float soma = 0;
        int cont = 0;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projeto_BackPU");
        EntityManager em = emf.createEntityManager();

        tb_customer_account_dao tbdao = new tb_customer_account_dao(em);

        List<tb_customer_account> l = tbdao.consultaMedia();

        for (tb_customer_account tbo : l) {
            
            System.out.println("ID: " + tbo.getId_customer() + "  ---> Nome: "
                    + tbo.getNm_customer() + "  --->  Valor: " + tbo.getVl_total());

            soma = soma + tbo.getVl_total();
            cont++;
        }

        System.out.println("Média --> " + soma / cont);

        em.close();
        emf.close();
    }

}
