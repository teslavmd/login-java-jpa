package persistencia;

import java.util.List;
import logica.Rol;
import logica.Usuario;


public class ControladoraPersistencia {
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    
    
    public void createUsuario(Usuario usuario) {
        usuarioJpa.create(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioJpa.findUsuarioEntities();
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    public Rol encontrarRol(String rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
