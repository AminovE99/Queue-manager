package ru.itis.queuesolution.config;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.queuesolution.controller.TableController;
import ru.itis.queuesolution.entity.Ticket;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TableRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Ticket>> {
    @Override
    public EntityModel<Ticket> process(EntityModel<Ticket> model) {
        Ticket ticket = model.getContent();
        if (ticket != null) {
            model.add(linkTo(methodOn(TableController.class).book(ticket.getId())).withRel("ticket"));
        }
        return model;
    }
}
