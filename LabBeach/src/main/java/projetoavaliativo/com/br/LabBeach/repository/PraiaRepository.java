package projetoavaliativo.com.br.LabBeach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projetoavaliativo.com.br.LabBeach.entity.Praia;

import java.util.List;

@Repository
public interface PraiaRepository extends JpaRepository<Praia,Long> {

    Boolean existsByNome(String nome);

    Boolean existsByBairro_Id(Long id);

    List<Praia> findAllByStatusEqualsIgnoreCase(String status);

    List<Praia> findPraiaByAcessibilidadeEqualsIgnoreCase(String acessibilidade);

    @Query("SELECT praia FROM Praia praia WHERE praia.bairro.populacao <= :pop")
    List<Praia> findByPop(Integer pop);

}
