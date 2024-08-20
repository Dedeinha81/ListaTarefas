package com.example.ListaTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ListaTarefas.model.Tarefas;

public interface TarefaRepository extends JpaRepository<Tarefas,Long> {




}
