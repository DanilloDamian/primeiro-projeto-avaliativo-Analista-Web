package projetoavaliativo.com.br.LabBeach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoavaliativo.com.br.LabBeach.entity.Bairro;
import projetoavaliativo.com.br.LabBeach.repository.BairroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    public Bairro salvar(Bairro bairro) throws Exception{

        if(bairro.getNome() == null || bairro.getNome().isEmpty()){
            throw new Exception("Nome do bairro é obrigatório!");
        }
        if(this.bairroRepository.existsById(bairro.getId())){
            throw new Exception("Já existe bairro com este ID");
        }
        if(this.bairroRepository.existsByNome(bairro.getNome())){
            throw new Exception("Já existe bairro com este nome");
        }
        return bairroRepository.save(bairro);
    }

    public List<Bairro> listar(){
        return this.bairroRepository.findAll();
    }
    public void deletar(Long id) throws Exception{

        Optional<Bairro> bairroFound = this.bairroRepository.findById(id);

        if(!this.bairroRepository.existsById(id)){
            throw new Exception("Não existe bairro com este ID");
        }if(bairroFound != null){
            this.bairroRepository.deleteById(id);
        }
        //IMPLEMENTAR "Não permitir deletar um bairro caso tenha uma praia cadastrada"

    }
}
