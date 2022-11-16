package pl.wsb.restexample.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // adnotacje Lombokowe
@Setter
@NoArgsConstructor
@AllArgsConstructor // wygenerowany konstruktor ze wszystkimi zmiennymi kodu
public class President {

    private Long id;
    private String name;
    private String party;
    private Integer born;

    public President(Long id, PresidentDto presidentDto) {
        this.id = id;
        this.name = presidentDto.getName();
        this.party = presidentDto.getParty();
        this.born = presidentDto.getBorn();
    }
}
