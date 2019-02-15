package br.com.bionexo.ubs.bd;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.bionexo.ubs.util.JPAUtil;

public class TestaConexao {

    private static final Logger log = LoggerFactory.getLogger(TestaConexao.class);
    private static EntityManager em ;

    @Before
    public void setUpClass() {
    	em = new JPAUtil().getEntityManager();
    	cleanup();
    }
	@Test
	public void deveConectarComOBanco() throws SQLException {
        if (em!=null) {

            em.getTransaction().begin();
            em.flush();
            em.getTransaction().commit();
            em.close();

            log.debug("tearDown() complete, em={}", em);
        }
	}
	

    public void cleanup() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("delete from UBS");
        int rows = query.executeUpdate();
        em.getTransaction().commit();
        log.info("Removido {} rows", rows);
    }
    
    @After
    public void destruir() throws Exception {

        if (em!=null) {
            em.getTransaction().begin();
            em.flush();

            em.getTransaction().commit();

            em.close();

            log.debug("Destruicao completa, em={}", em);

            em=null;

        }

     }
}
