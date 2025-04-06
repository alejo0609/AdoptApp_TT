 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreoAgradecimiento(String destinatario, String nombreAnimal) {
        try {
            SimpleMailMessage mensaje = new SimpleMailMessage();
            mensaje.setTo(destinatario);
            mensaje.setSubject("Gracias por postularte a la adopción 🐶");
            mensaje.setText("¡Gracias por postularte para adoptar a " + nombreAnimal + "!\n\n" +
                    "Nos pondremos en contacto contigo pronto para informarte sobre los próximos pasos.");

            mailSender.send(mensaje);
            System.out.println("Correo de agradecimiento enviado a " + destinatario);
        } catch (Exception e) {
            System.err.println("❌ No se pudo enviar el correo a " + destinatario + ": " + e.getMessage());
            // Aquí puedes también usar un logger si lo prefieres
        }
    }

    public void enviarCorreoATienda(String correoTienda, String nombreAnimal, String nombreAdoptante) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(correoTienda);
        mensaje.setSubject("Nueva solicitud de adopción");
        mensaje.setText("Hola,\n\nSe ha recibido una solicitud de adopción para el animal: " + nombreAnimal +
            " por parte de: " + nombreAdoptante + ".\n\nPor favor revisa la plataforma para más detalles.");
        mailSender.send(mensaje);
    }
}
