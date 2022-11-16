package pl.wsb.restexample.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.restexample.exceptions.ResourceNotFoundException;
import pl.wsb.restexample.models.President;
import pl.wsb.restexample.models.PresidentDto;
import pl.wsb.restexample.repositories.PresidentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PresidentService {

    private final PresidentRepository presidentRepository;

    public List<President> getAll() {
        return presidentRepository.getAll();
    }

    public President get(Long id) {
        return presidentRepository
                .get(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public President create(PresidentDto presidentDto) {
        return presidentRepository.create(presidentDto);
    }

    public President update(Long id, PresidentDto presidentDto){
        President president = get(id);
        return  presidentRepository.update(president, presidentDto);
    }

    public void delete(Long id) {
        President president = get(id);
        presidentRepository.delete(president);
    }
}
