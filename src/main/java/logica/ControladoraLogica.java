package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    ControladoraPersistencia controladoraPersis = new ControladoraPersistencia();
    
    public void crearUsuario(Usuario usuario){
        controladoraPersis.createUsuario(usuario);
    }

    public List<Usuario> traerUsuarios() {
        return controladoraPersis.findAll();
    }

    public String validar(String nombre, String password) {
        
        String mensaje = "";
        List<Usuario> listUsuarios = traerUsuarios();
        
        for(Usuario usuario : listUsuarios){
            if(usuario.getNombre().equals(nombre) && usuario.getPassword().equals(password)){
                mensaje = "Bienvenido eres el usuario que esta registrado en la base de datos";
            }else{
                mensaje = "Datos incorrectos, por favor ingrese nuevamente los datos :D";
            }
        }
        return mensaje;
    }
    
}
