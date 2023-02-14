package projetoavaliativo.com.br.LabBeach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoavaliativo.com.br.LabBeach.entity.Praia;

@Repository
public interface PraiaRepository extends JpaRepository<Praia,Long> {

    Boolean existsByNome(String nome);
    Boolean existsByBairro_Id(Long id);
}
