package pl.wsb.restexample.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.restexample.models.President;
import pl.wsb.restexample.models.PresidentDto;
import pl.wsb.restexample.services.PresidentService;

import java.util.List;

@RestController
@RequestMapping("presidents")
@AllArgsConstructor
public class PresidentController {

    private final PresidentService presidentService;

    @GetMapping // metoda pobierania wszystkich prezydentów
    List<President> getAll() {
        return presidentService.getAll();
    }

    @GetMapping("{id}") // metoda pobierania jednego prezydenta
    ResponseEntity<President> get(@PathVariable Long id) {
        return ResponseEntity.ok(presidentService.get(id));
    }

    @PostMapping // metoda tworzenia prezydenta
    ResponseEntity<President> create(@RequestBody PresidentDto presidentDto) {
        President president = presidentService.create(presidentDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(president);
    }

    @PutMapping("{id}") // metoda edytowania prezydenta
    ResponseEntity<President> update(@PathVariable Long id, @RequestBody PresidentDto presidentDto) {
        return ResponseEntity.ok(presidentService.update(id, presidentDto));
    }

    @DeleteMapping("{id}") // metoda usuwania prezydenta
    ResponseEntity<Void> delete(@PathVariable Long id) {
        presidentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
