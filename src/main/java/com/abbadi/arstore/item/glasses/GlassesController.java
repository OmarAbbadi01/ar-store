package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.glasses.model.GlassesRequest;
import com.abbadi.arstore.item.glasses.model.GlassesResponse;
import com.abbadi.arstore.item.glasses.model.RateRequest;
import com.abbadi.arstore.item.photo.PhotoControllerMapper;
import com.abbadi.arstore.item.photo.model.PhotoDto;
import com.abbadi.arstore.item.photo.model.PhotosUploadRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.PHOTOS_NUMBER_MUST_BE_BETWEEN_ZERO_AND_FOUR;
import static com.abbadi.arstore.item.glasses.GlassesControllerMapper.toDto;
import static com.abbadi.arstore.item.glasses.GlassesControllerMapper.toResponse;

@RestController
@RequestMapping("/api/glasses")
@RequiredArgsConstructor
public class GlassesController {

    private final GlassesService service;

    @GetMapping("/{id}")
    public ResponseEntity<GlassesResponse> findById(@PathVariable("id") final Long id) {
        GlassesDto dto = service.findById(id);
        return ResponseEntity.ok(toResponse(dto));
    }

    @GetMapping
    public ResponseEntity<List<GlassesResponse>> findAll() {
        List<GlassesResponse> responses = service.findAll()
                .stream()
                .map(GlassesControllerMapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    @Validated(value = OnCreate.class)
    @Secured("STORE")
    public ResponseEntity<URI> create(@RequestBody @Valid final GlassesRequest request) {
        GlassesDto dto = service.create(toDto(request));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "/{id}/photos", consumes = {"multipart/form-data"})
//    @io.swagger.v3.oas.annotations.parameters.RequestBody(
//            required = true,
//            content = @Content(mediaType = "multipart/form-data", schema = @Schema(type = "string", format = "binary"))
//    )
    public ResponseEntity<List<String>> uploadPhotos(@ModelAttribute PhotosUploadRequest request, @PathVariable Long id) {
        List<PhotoDto> dtos = PhotoControllerMapper.toDto(request, id);
        dtos = service.uploadPhotos(dtos);
        List<String> urls = dtos.stream()
                .map(PhotoDto::getUrl)
                .toList();
        return ResponseEntity.ok(urls);
    }

    @PutMapping("/{id}")
    @Validated(value = OnUpdate.class)
    @Secured("STORE")
    public ResponseEntity<GlassesResponse> update(@RequestBody @Valid final GlassesRequest request,
                                                  @PathVariable("id") final Long id) {
        if (!request.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        service.update(toDto(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Secured({"STORE", "ADMIN"})
    public ResponseEntity<GlassesResponse> delete(@PathVariable("id") final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rate")
    @Secured("CUSTOMER")
    public ResponseEntity<?> rate(@RequestBody @Valid RateRequest request) {
        service.rate(request.getItemId(), request.getRating());
        return ResponseEntity.ok().build();
    }
}
