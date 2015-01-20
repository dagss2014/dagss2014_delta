/*
 Proyecto Java EE, DAGSS-2014
 */

package es.uvigo.esei.dagss.dominio.daos;

import es.uvigo.esei.dagss.dominio.entidades.Cita;
import es.uvigo.esei.dagss.dominio.entidades.Paciente;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;


@Stateless
@LocalBean
public class CitaDAO  extends GenericoDAO<Cita>{  
    
public List<Cita> buscarCitas(int id) {
        Query q = em.createQuery("SELECT c FROM Cita AS c"
                + "  WHERE c.medico.dni = :dni");
        q.setParameter("dni", id);
        
        return q.getResultList();
    }

public Cita getCita(int codigo) {
    Query q = em.createQuery("SELECT c FROM Cita AS c WHERE c.id = :codigo");
        q.setParameter("codigo", codigo);
        
        return filtrarResultadoUnico(q);
}

    public List<Cita> buscarCitasPorDni(String dni) {
        Query q = em.createQuery("SELECT c FROM Cita AS c"
                + "  WHERE c.medico.dni = :dni");
        q.setParameter("dni", dni);
        
        return q.getResultList();
    }
}
