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
                .filter(song -> song.getId().equals(id))
                .findFirst();
    }

    public President create(PresidentDto songDto) {
        President newSong = new President(currentId++, songDto);
        presidents.add(newSong);
        return newSong;
    }

    public President update(President song, PresidentDto songDto){
        song.setName(songDto.getName());
        song.setParty(songDto.getParty());
        song.setBorn(songDto.getBorn());
        return song;
    }

    public void delete(President song) {
        presidents.remove(song);
    }

}
