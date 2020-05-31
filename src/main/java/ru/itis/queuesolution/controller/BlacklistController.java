package ru.itis.queuesolution.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.queuesolution.entity.dto.BlacklistPersonDto;

@RestController
public class BlacklistController {
    private BlacklistService service;

    public BlacklistController(BlacklistService service) {
        this.service = service;
    }

    @PostMapping("/blacklist")
    @ResponseBody
    public ResponseEntity addBlacklistPerson(BlacklistPersonDto dto) {
        service.addBlacklistPerson(dto);
        return ResponseEntity.ok().build();
    }
}
