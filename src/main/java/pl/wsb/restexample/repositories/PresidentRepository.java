package pl.wsb.restexample.repositories;

import org.springframework.stereotype.Repository;
import pl.wsb.restexample.models.President;
import pl.wsb.restexample.models.PresidentDto;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class PresidentRepository {

    static Long currentId = 5L;

    private final List<President> presidents = new LinkedList<>(Arrays.asList(
            new President(1L,"George W. Bush", "republikanin", 1946),
            new President(2L,"Barack Obama", "demokrata", 1961),
            new President(3L, "Donald Trump", "republikanin", 1946),
            new President(4L,"Joe Biden", "demokrata", 1942)
    ));

    public List<President> getAll() {
        return presidents;
    }

    public Optional<President> get(Long id) {
        return presidents.stream()
                .filter(president -> president.getId().equals(id))
                .findFirst();
    }

    public President create(PresidentDto presidentDto) {
        President newPresident = new President(currentId++, presidentDto);
        presidents.add(newPresident);
        return newPresident;
    }

    public President update(President president, PresidentDto presidentDto){
        president.setName(presidentDto.getName());
        president.setParty(presidentDto.getParty());
        president.setBorn(presidentDto.getBorn());
        return president;
    }

    public void delete(President president) {
        presidents.remove(president);
    }

}
