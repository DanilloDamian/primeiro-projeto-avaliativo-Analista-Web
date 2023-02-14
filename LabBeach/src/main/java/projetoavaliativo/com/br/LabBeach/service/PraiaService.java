package projetoavaliativo.com.br.LabBeach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoavaliativo.com.br.LabBeach.entity.Bairro;
import projetoavaliativo.com.br.LabBeach.entity.Praia;
import projetoavaliativo.com.br.LabBeach.repository.PraiaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PraiaService {

    @Autowired
    private PraiaRepository praiaRepository;

    public Praia salvar(Praia praia) throws Exception{
        if(praia.getNome() == null || praia.getNome().isEmpty()){
            throw new Exception("Nome da praia é obrigatório!");
        }if(praia.getBairro() == null){
            throw new Exception("Bairro da praia é obrigatório!");
        }if(praia.getAcessibilidade() == null || praia.getAcessibilidade().isEmpty()){
            throw new Exception("Acessibilidade da praia é obrigatório!");
        }if(praia.getStatus() == null || praia.getStatus().isEmpty()){
            throw new Exception("Status da praia é obrigatório!");
        }
        if(this.praiaRepository.existsById(praia.getId())){
            throw new Exception("Já existe bairro com este ID");
        }
        if(this.praiaRepository.existsByNome(praia.getNome())){
            throw new Exception("Já existe praia com este nome");
        }
        return praiaRepository.save(praia);
    }

    public Praia editar(Long id, Praia praia) throws Exception{
        Praia praiaFound= findById(id);
        praiaFound.setNome(praia.getNome());
        praiaFound.setBairro(praia.getBairro());
        praiaFound.setAcessibilidade(praia.getAcessibilidade());
        praiaFound.setStatus(praia.getStatus());
        return this.praiaRepository.save(praiaFound);
    }

    public Praia findById(Long id) throws Exception{
        Optional<Praia> praiaFound = this.praiaRepository.findById(id);
        if(!praiaFound.isPresent() || praiaFound == null){
            throw new Exception("Não existe praia com este ID!");
        }
        return praiaFound.get();
    }

    public List<Praia> listar(){
        return this.praiaRepository.findAll();
    }
    public void deleteById(Long id) throws Exception{
        Optional<Praia> praiaFound = this.praiaRepository.findById(id);
       if(praiaFound != null){
           this.praiaRepository.deleteById(id);
       }
    }
}
