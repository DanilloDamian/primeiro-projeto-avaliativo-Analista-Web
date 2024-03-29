package projetoavaliativo.com.br.LabBeach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoavaliativo.com.br.LabBeach.entity.Praia;
import projetoavaliativo.com.br.LabBeach.repository.PraiaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PraiaService {

    @Autowired
    private PraiaRepository praiaRepository;

    @Autowired
    private BairroService bairroService;


    public Praia salvar(Praia praia) throws Exception{

        if(praia.getNome() == null || praia.getNome().isEmpty()){
            throw new Exception("Nome da praia é obrigatório!");
        }if(praia.getBairro() == null){
            throw new Exception("Bairro da praia é obrigatório!");
        }if(praia.getAcessibilidade() == null || praia.getAcessibilidade().isEmpty()){
            throw new Exception("Acessibilidade da praia é obrigatório!");
        }if(praia.getStatus() == null || praia.getStatus().isEmpty()){
            throw new Exception("Status da praia é obrigatório!");
        }if(this.praiaRepository.existsByNome(praia.getNome())){
            throw new Exception("Já existe praia com este nome");
        }

        praia.setBairro(bairroService.findById(praia.getBairro().getId()));

        return praiaRepository.save(praia);
    }

    public Praia editar(Long id, Praia praia) throws Exception{

        Praia praiaFound= findById(id);
        praiaFound.setNome(praia.getNome());
        praiaFound.setBairro(bairroService.findById(praia.getBairro().getId()));
        praiaFound.setAcessibilidade(praia.getAcessibilidade());
        praiaFound.setStatus(praia.getStatus());

        salvar(praiaFound);

        return praiaFound;
    }

    public Praia findById(Long id) throws Exception{

        Optional<Praia> praiaFound = this.praiaRepository.findById(id);

        if(!praiaFound.isPresent() || praiaFound == null){
            throw new Exception("Não existe praia com este ID!");
        }
        return praiaFound.get();
    }

    public List<Praia> findByStatus()throws Exception{

        return this.praiaRepository.findAllByStatusEqualsIgnoreCase("propria");
    }

    public List<Praia> findByAcessibilidade() throws Exception{

        return this.praiaRepository.findPraiaByAcessibilidadeEqualsIgnoreCase("Possui");
    }

    public List<Praia> findByPop(Integer pop)throws Exception{

        return this.praiaRepository.findByPop(pop);
    }


    public List<Praia> listar(){

        return this.praiaRepository.findAll();
    }

    public void deleteById(Long id) throws Exception{

        Optional<Praia> praiaFound = this.praiaRepository.findById(id);

        if(!this.praiaRepository.existsById(id)){
            throw new Exception("Não existe praia com este ID");
        }if(praiaFound != null){
           this.praiaRepository.deleteById(id);
        }
    }

}
