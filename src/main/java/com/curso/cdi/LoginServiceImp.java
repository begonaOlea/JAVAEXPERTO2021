package com.curso.cdi;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

@Named
@Default 
//@RequestScoped
@Dependent
public class LoginServiceImp implements LoginService {

    public LoginServiceImp() {
        System.out.println(".... instanciando LoginSErviImp");
    }
    
    

    @Override
    public boolean existe(String nombreUsuario) {
        
        if( nombreUsuario == null || nombreUsuario.length() == 0 ||
               !  nombreUsuario.substring(0, 1).equalsIgnoreCase("M")){
            return false;
        }else{
            return true;
        }
    
    }
    
}
