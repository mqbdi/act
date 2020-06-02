package jact.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PingMessage {

    private Long uptime;
    private Long processId;

}
