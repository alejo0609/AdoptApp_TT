 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.service;

import com.pruebas.model.UsuarioModel;
import com.pruebas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // 🔹 Agregamos BCrypt para cifrar y comparar contraseñas.

    public List<UsuarioModel> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> obtenerPorId(int id) {
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioModel> obtenerPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public UsuarioModel guardar(UsuarioModel usuario) {
        // 🔹 Cambio: Cifrar la contraseña antes de guardarla en la BD.
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> autenticarUsuario(String email, String password) {
        Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(email);

        if (usuario.isPresent() && passwordEncoder.matches(password, usuario.get().getPassword())) {
            return usuario; // 🔹 Si la contraseña es correcta, retorna el usuario.
        }
        return Optional.empty(); // 🔹 Si la contraseña es incorrecta, retorna vacío.
    }

    public boolean eliminar(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}