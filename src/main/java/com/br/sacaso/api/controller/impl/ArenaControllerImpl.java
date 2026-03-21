package com.br.sacaso.api.controller.impl;

import com.br.sacaso.api.controller.ArenaController;
import com.br.sacaso.api.dto.arena.ArenaRequest;
import com.br.sacaso.api.dto.arena.ArenaResponse;
import com.br.sacaso.domain.entity.Arena;
import com.br.sacaso.domain.repository.ArenaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ArenaControllerImpl implements ArenaController {

    private final ArenaRepository arenaRepository;

    @Override
    public ResponseEntity<List<ArenaResponse>> listar() {
        List<ArenaResponse> arenas = arenaRepository.findAll().stream()
                .map(a -> new ArenaResponse(a.getId(), a.getNome(), a.getLocal()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(arenas);
    }

    @Override
    public ResponseEntity<ArenaResponse> buscarPorId(Long id) {
        return arenaRepository.findById(id)
                .map(a -> ResponseEntity.ok(new ArenaResponse(a.getId(), a.getNome(), a.getLocal())))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<ArenaResponse> criar(ArenaRequest request) {
        Arena arena = new Arena();
        arena.setNome(request.nome());
        arena.setLocal(request.local());
        Arena saved = arenaRepository.save(arena);
        return ResponseEntity
                .created(URI.create("/api/arenas/" + saved.getId()))
                .body(new ArenaResponse(saved.getId(), saved.getNome(), saved.getLocal()));
    }

    @Override
    public ResponseEntity<ArenaResponse> atualizar(Long id, ArenaRequest request) {
        return arenaRepository.findById(id).map(arena -> {
            arena.setNome(request.nome());
            arena.setLocal(request.local());
            Arena saved = arenaRepository.save(arena);
            return ResponseEntity.ok(new ArenaResponse(saved.getId(), saved.getNome(), saved.getLocal()));
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> excluir(Long id) {
        if (!arenaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        arenaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
