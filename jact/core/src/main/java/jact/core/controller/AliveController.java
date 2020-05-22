package jact.core.controller;

import jact.core.model.AliveMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;

@RestController(value = "/alive")
public class AliveController {

    @GetMapping("/get")
    public AliveMessage get() {
        AliveMessage ret = new AliveMessage();
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        Long processId = Long.parseLong(processName.split("@")[0]);
        Long uptime = ManagementFactory.getRuntimeMXBean().getUptime();
        ret.setUptime(uptime);
        ret.setProcessId(processId);
        return ret;
    }
}
