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

    private String nome;

    private String acessibilidade;

    private String status;
    
};
