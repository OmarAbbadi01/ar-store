package com.abbadi.arstore.common.generic.service;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.generic.model.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
public abstract class GenericController<Id extends Serializable, Dto extends GenericDto<Id>, Req extends GenericRequest<Id>,
        Res extends GenericResponse<Id>> {

    private final GenericService<Id, Dto> service;

    private final GenericControllerMapper<Id, Dto, Req, Res> mapper;

    @GetMapping("/{id}")
    public ResponseEntity<Res> findById(@PathVariable("id") final Id id) {
        Dto dto = service.findById(id);
        return ResponseEntity.ok(mapper.toResponse(dto));
    }

    @GetMapping
    public ResponseEntity<List<Res>> findAll() {
        List<Res> responses = service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<URI> create(@RequestBody final Req request) {
        Dto dto = service.create(mapper.toDto(request));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Res> update(@RequestBody final Req request, @PathVariable("id") final Id id) {
        if (request == null || !request.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        service.update(mapper.toDto(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Res> delete(@PathVariable("id") final Id id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
