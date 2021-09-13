
package com.curso.excepcion;

public class GestionProductoException 
    extends RuntimeException {

    
   private String idProducto;
   private String claveMensaje;

    public GestionProductoException(String idProducto) {
        this.idProducto = idProducto;
        this.claveMensaje = "";
    }

    public GestionProductoException(String idProducto, String claveMensaje) {
        this.idProducto = idProducto;
        this.claveMensaje = claveMensaje;
    }
    
    
    

    public String getIdProducto() {
        return idProducto;
    }

    public String getClaveMensaje() {
        return claveMensaje;
    }
    
    
   
   
}
