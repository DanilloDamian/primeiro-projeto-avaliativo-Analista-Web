package projetoavaliativo.com.br.LabBeach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetoavaliativo.com.br.LabBeach.entity.Praia;
import projetoavaliativo.com.br.LabBeach.service.PraiaService;

import java.util.List;

@RestController
@RequestMapping("/praias")
public class PraiaController {

    @Autowired
    private PraiaService praiaService;


    @PostMapping
    public Praia salvar(@RequestBody Praia praia) throws Exception{

        return this.praiaService.salvar(praia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Praia> editar(@PathVariable Long id, @RequestBody Praia praia) throws Exception{

        return ResponseEntity.ok(this.praiaService.editar(id,praia));
    }

    @GetMapping
    public ResponseEntity<List<Praia>> listar(){

        return ResponseEntity.ok(this.praiaService.listar());
    }

    @GetMapping("/status")
    public ResponseEntity<List<Praia>> praiasStatus() throws Exception {

        return ResponseEntity.ok(this.praiaService.findByStatus());
    }

    @GetMapping("/acessibilidade")
    public ResponseEntity<List<Praia>> praiasAcessiveis() throws Exception {

        return ResponseEntity.ok(this.praiaService.findByAcessibilidade());
    }

    @GetMapping("/{pop}")
    public ResponseEntity<List<Praia>> praiasPop(@PathVariable Integer pop) throws Exception {

        return ResponseEntity.ok(this.praiaService.findByPop(pop));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws Exception{

        this.praiaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
