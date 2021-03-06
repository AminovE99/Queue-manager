package ru.itis.queuesolution.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.queuesolution.entity.Table;

@RepositoryRestController
public class TableController {
    private final TableService tableService;
    private final EmailService emailService;

    public TableController(TableService tableService, @Qualifier("bookEmailServiceImpl") EmailService emailService) {
        this.tableService = tableService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/ticket/{ticket-id}/book", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> book(@PathVariable("table-id") Long tableId) {
        Table book = tableService.book(tableId);
        if (book != null) {
            emailService.sendEmail(book.getRestaurant().getEmail(), tableId.toString());
            return ResponseEntity.ok(new EntityModel<>(book));
        }
        return ResponseEntity.notFound().build();
    }
}
