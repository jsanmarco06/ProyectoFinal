package org.jsanmarco.springframework.boot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import java.util.Date;

@Entity
@Table(name="productos")
public class Producto {
    @Getter
    @Setter
    @Id
    @Column(name="idproductos")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Integer id;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private Double precio;
    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @CreatedDate
    @Column(name = "fechaalta")
    private Date fechaAlta;

    @Override
    public String toString() {
        return  "id =" + id +
                " | nombre ='" + nombre + '\'' +
                " | precio =" + precio +
                " | fechaAlta =" + fechaAlta +
                '}';
    }
}

