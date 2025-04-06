 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.service;

import com.pruebas.model.DatosPersonalesModel;
import com.pruebas.repository.DatosPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatosPersonalesService {

    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<DatosPersonalesModel> obtenerTodos() {
        return datosPersonalesRepository.findAll();
    }

    public Optional<DatosPersonalesModel> obtenerPorId(int id) {
        return datosPersonalesRepository.findById(id);
    }
    public Optional<DatosPersonalesModel> obtenerPorEmail(String email) {
        return datosPersonalesRepository.findByEmail(email);
    }


    public Optional<DatosPersonalesModel> autenticarUsuario(String email, String password) {
        Optional<DatosPersonalesModel> usuarioEncontrado = datosPersonalesRepository.findByEmail(email);


        if (usuarioEncontrado.isPresent() && passwordEncoder.matches(password, usuarioEncontrado.get().getPassword())) {
            return usuarioEncontrado; // 🔹 Si la contraseña es correcta, retorna el usuario.
        }
        return Optional.empty(); // 🔹 Si la contraseña es incorrecta, retorna vacío.
    }

    public Optional<DatosPersonalesModel> obtenerPorDni(long dni) {
        return datosPersonalesRepository.findByDni(dni);
    }


    public DatosPersonalesModel guardar(DatosPersonalesModel usuario) {
        // 🔹 Cambio: Cifrar la contraseña antes de guardarla en la BD.
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return datosPersonalesRepository.save(usuario);
    }

    public boolean eliminar(int id) {
        if (datosPersonalesRepository.existsById(id)) {
            datosPersonalesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean eliminarPorDni(Long dni) {
        Optional<DatosPersonalesModel> registro = datosPersonalesRepository.findByDni(dni);
        if (registro.isPresent()) {
            datosPersonalesRepository.delete(registro.get());
            return true;
        }
        return false;
    }
}