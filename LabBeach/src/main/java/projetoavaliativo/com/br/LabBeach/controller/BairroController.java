package projetoavaliativo.com.br.LabBeach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoavaliativo.com.br.LabBeach.entity.Bairro;
import projetoavaliativo.com.br.LabBeach.service.BairroService;

import java.util.List;

@RestController
@RequestMapping("/bairros")
public class BairroController {

    @Autowired
    private BairroService bairroService;


    @PostMapping
    public Bairro salvar(@RequestBody Bairro bairro) throws Exception{

        return this.bairroService.salvar(bairro);
    };

    @GetMapping
    public ResponseEntity<List<Bairro>> listar(){

        return ResponseEntity.ok(this.bairroService.listar());
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) throws Exception{

        this.bairroService.deletar(id);
        return ResponseEntity.ok().build();
    };

};
