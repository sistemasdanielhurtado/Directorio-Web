/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Contactos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Leno
 */
@Stateless
public class ContactosFacade extends AbstractFacade<Contactos> implements ContactosFacadeLocal {

    @PersistenceContext(unitName = "DirectorioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactosFacade() {
        super(Contactos.class);
    }
    
}
