package br.com.bionexo.ubs.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.bionexo.ubs.modelo.Ubs;
import br.com.bionexo.ubs.util.Desempenho;
import br.com.bionexo.ubs.util.JPAUtil;

/**
 *	Importa para o banco os registros de UBS em CSV apos a inicialização do tomcat
 * @author fvitorino
 */
@WebListener
public class InsereUBS implements ServletContextListener{
	private static final Logger log = LoggerFactory.getLogger(InsereUBS.class);

	public void iniciaImportacao() {

		EntityManager em = new JPAUtil().getEntityManager();
		try {
			log.info("Iniciando importação de UBS's");
			ClassLoader classLoader = new InsereUBS().getClass().getClassLoader();
			File f = new File(classLoader.getResource("META-INF/ubs.csv").getFile());
			BufferedReader b = new BufferedReader(new FileReader(f));

			String readLine = "";
			boolean firstLine = true;

			em.getTransaction().begin();
			while ((readLine = b.readLine()) != null) {
				Ubs ubs = new Ubs();
				if (firstLine) {
					firstLine = false;
					continue;
				}
				carregaAtributos(readLine, ubs);
				log.info("Inserindo UBS id: {} Nome: {}", ubs.getId(), ubs.getName() );
				em.persist(ubs);
			}
			em.getTransaction().commit();
			b.close();
			log.info("Fim do processo de importação de UBS's");

		} catch (IOException e) {
			log.error("Erro ao inserir UBS's ", e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	private void carregaAtributos(String readLine, Ubs ubs) {
		String[] atributo = readLine.split(",");
		ubs.setLat(Float.valueOf(atributo[0]));
		ubs.setLng(Float.valueOf(atributo[1]));
		ubs.setCity(atributo[2]);
		ubs.setId(Integer.valueOf(atributo[3]));
		ubs.setName(atributo[4]);
		ubs.setAddress(atributo[5] + " - " + atributo[6] + " - " + atributo[7]);
		ubs.setPhone(atributo[8]);
		ubs.setSize(Desempenho.buscaPorString(atributo[9]));
		ubs.setAdptSeniors(Desempenho.buscaPorString(atributo[10]));
		ubs.setMedicalEquipaments(Desempenho.buscaPorString(atributo[11]));
		ubs.setMedicine(Desempenho.buscaPorString(atributo[12]));
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		this.iniciaImportacao();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
