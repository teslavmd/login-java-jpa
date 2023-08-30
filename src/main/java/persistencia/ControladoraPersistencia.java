package persistencia;

import java.util.List;
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
    
}
