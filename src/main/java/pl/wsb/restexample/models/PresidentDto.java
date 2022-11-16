package pl.wsb.restexample.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// DTO Data Transfer Object
public class PresidentDto {

    private String name;
    private String party;
    private Integer born;
}
