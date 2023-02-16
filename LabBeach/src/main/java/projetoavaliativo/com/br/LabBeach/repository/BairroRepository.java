package projetoavaliativo.com.br.LabBeach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetoavaliativo.com.br.LabBeach.entity.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

    Boolean existsByNomeEqualsIgnoreCase(String nome);

}
