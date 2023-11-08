/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author USUARIO
 */
@WebService(serviceName = "WSOperaciones")
public class WSOperaciones {

    /**
     * Web service operation
     */
    
    ArrayList<Usuario> listUsuarios = new ArrayList<>();
    Usuario usuarios;

    @WebMethod(operationName = "Ingresar")
    public String Ingresar(@WebParam(name = "usuario") String user, @WebParam(name = "contrasenia") String password) {

        String mensaje = null;

        for (int i = 0; i < listUsuarios.size(); i++) {
            if (listUsuarios.get(i).getUsuario().equals(user)) {
                if (listUsuarios.get(i).getUsuario().equals(user) && listUsuarios.get(i).getPassword().equals(password)) {
                    mensaje = "Inicio sesión exitoso";
                } else {
                    mensaje = "Contraseña no coincide con su registro ";
                }
            } else {
                mensaje = "Este usuario no se encuentra";
            }

        }
        return mensaje;

    }

    @WebMethod(operationName = "Registrar")
    public String Registrar(@WebParam(name = "usuario") String user, @WebParam(name = "contrasenia") String password, @WebParam(name = "contrasenia2") String password2, @WebParam(name = "Saldo") Integer saldo) {
        String mensaje = ":(";
        Boolean est = false;
        if (password.equals(password2)) {

            for (int i = 0; i < listUsuarios.size(); i++) {

                if (listUsuarios.get(i).getUsuario().equals(user)) {
                    mensaje = "Este usuario ya se encuentra registrado" + user;
                    est = true;
                }
            }

            if (!est) {
                usuarios = new Usuario();
                usuarios.setUsuario(user);
                usuarios.setPassword(password);
                usuarios.setSaldo(saldo);
                listUsuarios.add(usuarios);
                mensaje = "Usuario registrado exitosamente" + user;
            }
        } else {
            System.out.println("Contraseña incorrecta");
        }

        return mensaje;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Depositar")
    public String Depositar(@WebParam(name = "cantidad") Integer cantidad, @WebParam(name = "usuario") String user) {
        int canti = 0;
        String mensaje = null;

        for (int i = 0; i < listUsuarios.size(); i++) {
            if (listUsuarios.get(i).getUsuario().equals(user)) {
                Usuario usuarios = new Usuario();
                canti = listUsuarios.get(i).getSaldo() + cantidad;
                listUsuarios.get(i).setSaldo(canti);
                mensaje = "Depósito realizado exitosamente...Su saldo actual es: " + canti;
            }

        }
        return mensaje;
    }

    @WebMethod(operationName = "Retirar")
    public String Retirar(@WebParam(name = "cantidad") Integer cantidad, @WebParam(name = "usuario") String user) {
        int canti2 = 0;
        String mensaje = null;

        for (int i = 0; i < listUsuarios.size(); i++) {
            if (listUsuarios.get(i).getUsuario().equals(user)) {
                if (listUsuarios.get(i).getSaldo() > cantidad) {
                    canti2 = listUsuarios.get(i).getSaldo() - cantidad;
                    listUsuarios.get(i).setSaldo(canti2);
                    mensaje = "Retiro realizado con éxito...Su saldo actual es: " + canti2;
                }
            }

        }
        return mensaje;
    }
    
    @WebMethod(operationName = "Saldo")
    public int Saldo(@WebParam(name = "usuario") String user) {
        int saldo=0;
        
        for (int i = 0; i < listUsuarios.size(); i++) {
            if (listUsuarios.get(i).getUsuario().equals(user)) {
                saldo=listUsuarios.get(i).getSaldo();
            }
        }
        return saldo;
        
    }

}
