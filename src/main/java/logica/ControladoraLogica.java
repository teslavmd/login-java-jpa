package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    ControladoraPersistencia controladoraPersis = null;

    public ControladoraLogica() {
        controladoraPersis = new ControladoraPersistencia();
    }
    
    
    
    public void crearUsuario(String nombre, String password, String rol){
        
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setPassword(password);
        Rol rolBD = this.encontrarRol(rol);
        if(rolBD != null){
            usuario.setUnRol(rolBD); 
        }
        
        
        controladoraPersis.createUsuario(usuario);
    }

    public List<Usuario> traerUsuarios() {
        return controladoraPersis.findAll();
    }

    public Usuario validar(String nombre, String password) {
        
        Usuario usuarioLog = null;
        List<Usuario> listUsuarios = traerUsuarios();
        
        for(Usuario usuario : listUsuarios){
            if(usuario.getNombre().equals(nombre) && usuario.getPassword().equals(password)){
                //mensaje = "Bienvenido eres el usuario que esta registrado en la base de datos";
                System.out.println("admin aca");
                usuarioLog = usuario;
                return usuarioLog;
            }  
        }
        return usuarioLog;
    }

    public String validarRol(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Rol> traerRoles() {
        return controladoraPersis.traerRoles();
    }

    private Rol encontrarRol(String rol) {
        List<Rol> listRol = this.traerRoles();
        for(Rol rolsito: listRol){
            if(rolsito.getNombreRol().equals(rol)){
                return rolsito;
            }
        }
        return null;
    }

    public Usuario encontrarUsuario(int idUser) {
        return controladoraPersis.encontrarUsuario(idUser);
    }

    public void editarUsuario(int id, String nombre, String password, String rol) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setPassword(password);
        Rol rolEncontrado = this.encontrarRol(rol);
        usuario.setUnRol(rolEncontrado);
        
        controladoraPersis.editarUsuario(usuario);
    }

    public void borrarUsuario(int idUser) {
        controladoraPersis.borrarUsuario(idUser);
    }
    
}
