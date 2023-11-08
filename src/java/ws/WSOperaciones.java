/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.HashMap;
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
    private HashMap<String, String> map;
    
    @WebMethod(operationName = "Login")
    public Boolean Login(@WebParam(name = "usuario") String usuario, @WebParam(name = "contrasena") String contrasena) {
        if(usuario.equals("Evelyn") && contrasena.equals("Evelyn")){
            return true;
        }else{
            return false;
        }
    }

    
    @WebMethod(operationName = "ProcesarPago")
    public int ProcesarPago(@WebParam(name = "total") int total, @WebParam(name = "pago") int pago) {
        if(pago>=total){
            //retornar vuelto
            return pago-total;
        }else{
            return -1;
        }
    }
    
  
    @WebMethod(operationName = "consultaPalabra")
    public String consultaPalabra(@WebParam(name = "name") String palabra) {
        String defi= map.get(palabra);
        if (defi !=null) {
            return "La definicion es :"+defi;
        }else  {
            return "Palabra no encontrada";
        }
    }
        private void CargarDiccionario() {
        map = new HashMap<>();
        map.put("gato", "Un animal doméstico felino.");
        map.put("perro", "Un animal doméstico canino.");
        map.put("pájaro", "Un animal alado.");
    }


    
}
