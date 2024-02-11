/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managerBeans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author julio
 */
@ManagedBean
@SessionScoped
public class UtilBean 
{

     /**
     * Creates a new instance of UtilBean
     */
    private boolean concordar;

    public UtilBean()
    {
    }

    public boolean isConcordar() 
    {
        return concordar;
    }

    public void setConcordar(boolean concordar) {
        this.concordar = concordar;
    }
    
    public String proximaPagina()
    {
        System.out.println("Concordar : " + this.concordar);
        if(this.concordar)
            return "login";
        else return "login";                                                
    }
    
    
}