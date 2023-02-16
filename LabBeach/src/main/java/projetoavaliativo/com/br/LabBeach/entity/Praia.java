package projetoavaliativo.com.br.LabBeach.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Praia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="bairro_id", nullable=false)
    private Bairro bairro;


    @Column(name = "nome", length = 150,nullable=false)
    private String nome;

    @Column(name = "acessibilidade", length = 10,nullable=false)
    private String acessibilidade;

    @Column(name = "status", length = 9,nullable=false)
    private String status;
    
}
