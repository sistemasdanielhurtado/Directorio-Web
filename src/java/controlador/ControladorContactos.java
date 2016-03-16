/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidad.Contactos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import servicio.ContactosFacadeLocal;

/**
 *
 * @author Leno
 */
@ManagedBean(name = "controladorContactos")
@ViewScoped
public class ControladorContactos implements Serializable{

    @EJB
    private ContactosFacadeLocal contactosFacade;

    /**
     * Creates a new instance of ControladorContactos
     */
    private Contactos contacto;
    private List<Contactos> contactos;
    
    @PostConstruct
    public void init() {
        contactos = contactosFacade.findAll();
    }

    public Contactos getContacto() {
        return contacto;
    }

    public void setContacto(Contactos contacto) {
        this.contacto = contacto;
    }

    public List<Contactos> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contactos> contactos) {
        this.contactos = contactos;
    }
    
    public void borrar(Contactos c){
        contactosFacade.remove(contacto);
        contactos = contactosFacade.findAll();
    }
    
    public void ver(Contactos c){
        contacto = c;
    }
    
    public void guardar(){
        contactosFacade.create(contacto);
        contactos = contactosFacade.findAll();
    }
    
    public void editar(){
        contactosFacade.edit(contacto);
        contactos = contactosFacade.findAll();
    }
    
    public void nuevo(){
        contacto = new Contactos();
    }
    
}
