package jact.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AliveMessage {

    private Long uptime;
    private Long processId;

}
