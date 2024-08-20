package com.example.ListaTarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ListaTarefas.model.Tarefas;
import com.example.ListaTarefas.repository.TarefaRepository;

@RestController
@RequestMapping
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefas>listarTarefas(){
        return tarefaRepository.findAll();
    }

    @PostMapping
    public Tarefas adicionarTarefa(@RequestBody Tarefas tarefas){
        return tarefaRepository.save(tarefas);
    }
    @PutMapping("/{id}")
    public Tarefas atualizarTarefa(@PathVariable Long id,@RequestBody Tarefas tarefasatualizadas){
        Tarefas tarefas = tarefaRepository.findById(id).orElseThrow();
        tarefas.setDescricao(tarefasatualizadas.getDescricao());
        tarefas.setConcluida(tarefasatualizadas.isConcluida());
        return tarefaRepository.save(tarefas);
    }
    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        tarefaRepository.deleteById(id);
    }


}

