/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class UtilMensagensBean 
{

   /**
     * Creates a new instance of UtilMensagensBean
     */
    public UtilMensagensBean() 
    {
    }
    
    
    public static void adicionarMensagemDeSucesso(String str)
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, str, str);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }
    
    public static void adicionarMensagemDeErro(String str)
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, str, str);
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }
    
}