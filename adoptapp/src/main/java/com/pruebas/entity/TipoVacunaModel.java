 /** 
 * @author Alejandro Perez CC 8.029.742
 * @author Julian David Giraldo Murillo CC 1.007.240.094
 * @author Andres Escobar Vasquez CC 1.038.096.962
 * @author Jorge Andres Restrepo Cataño CC 98.648.720
 **/
 
package com.pruebas.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "tipo_vacuna")
@Data
public class TipoVacunaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacuna;

    @Column(nullable = false, length = 155)
    private String nombre_tipo_vacuna;
  
}