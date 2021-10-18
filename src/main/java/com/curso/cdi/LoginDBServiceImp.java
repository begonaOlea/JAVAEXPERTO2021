package com.curso.cdi;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@LoginMejoradoQualifier
//@Dependent
public class LoginDBServiceImp implements LoginService{

    public LoginDBServiceImp() {
        System.out.println(".... instanciando LoginDBServiceImp");
    }

    @Override
    public boolean existe(String nombreUsuario) {
        
        return true;
   }
    
}
