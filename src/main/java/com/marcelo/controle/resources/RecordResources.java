package com.marcelo.controle.resources;

import com.marcelo.controle.domain.Record;
import com.marcelo.controle.dto.RecordDTO;
import com.marcelo.controle.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/records")
public class RecordResources {


    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Record obj = recordService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody RecordDTO objDto) {
        Record obj = recordService.fromDTO(objDto);
        obj = recordService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> Update(@Valid @RequestBody RecordDTO objDto, @PathVariable Integer id) {
        Record obj = recordService.fromDTO(objDto);
        obj.setId(id);
        obj = recordService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        recordService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RecordDTO>> findAll() {
        List<Record> list = recordService.findAll();
        List<RecordDTO> listDto = list.stream().map(obj -> new RecordDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }

}
