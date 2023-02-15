package projetoavaliativo.com.br.LabBeach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoavaliativo.com.br.LabBeach.entity.Bairro;
import projetoavaliativo.com.br.LabBeach.repository.BairroRepository;
import projetoavaliativo.com.br.LabBeach.repository.PraiaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    @Autowired
    private PraiaRepository praiaRepository;


    public Bairro salvar(Bairro bairro) throws Exception{

        if(bairro.getNome() == null || bairro.getNome().isEmpty()){
            throw new Exception("Nome do bairro é obrigatório!");
        }
        if(this.bairroRepository.existsByNomeEqualsIgnoreCase(bairro.getNome())){
            throw new Exception("Já existe bairro com este nome");
        }
        return bairroRepository.save(bairro);
    };

    public List<Bairro> listar(){

        return this.bairroRepository.findAll();
    };

    public Bairro findById(Long id) throws Exception{

        Optional<Bairro> bairroFound = this.bairroRepository.findById(id);

        if(!bairroFound.isPresent()){
            throw new Exception("Bairro não encontrado");
        }
        return bairroFound.get();
    };

    public void deletar(Long id) throws Exception{

        Optional<Bairro> bairroFound = this.bairroRepository.findById(id);

        if(!this.bairroRepository.existsById(id)){
            throw new Exception("Não existe bairro com este ID");
        }if(this.praiaRepository.existsByBairro_Id(id)){
            throw new Exception("Não pode deletar bairro que contenha praia cadastrada");
        }if(bairroFound != null){
            this.bairroRepository.deleteById(id);
        };
    };

};
