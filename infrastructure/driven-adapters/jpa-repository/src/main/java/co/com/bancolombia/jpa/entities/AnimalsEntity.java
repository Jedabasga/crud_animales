package co.com.bancolombia.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Animales")
public class AnimalsEntity {
    @Id
    private String id;
    @Column(name="especie", nullable=false, length=100)
    private String especie;
    @Column(name="numpatas", nullable=false, length=1)
    private long numpatas;
    @Column(name="genero", nullable=false, length=1)
    private String genero;
    @Column(name="habitad", nullable=false, length=100)
    private String habitad;
    @Column(name="domestico", nullable=false, length=5)
    private boolean domestico;
}
