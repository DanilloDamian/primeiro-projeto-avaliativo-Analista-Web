package projetoavaliativo.com.br.LabBeach.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 150,nullable=false)
    private String nome;

    @Column(name = "descricao", length = 200)
    private String descricao;

    @Column(name = "populacao")
    private Integer populacao;

    public Bairro(Long id) {
        this.id = id;
    };

}
