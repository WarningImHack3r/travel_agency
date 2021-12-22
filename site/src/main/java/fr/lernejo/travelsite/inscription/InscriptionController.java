package fr.lernejo.travelsite.inscription;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public record InscriptionController(InscriptionRepository repository) {
    private static ModelMapper modelMapper;

    @Contract(" -> new")
    @Bean
    private @NotNull ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @PostMapping("/api/inscription")
    public void postInscription(@Valid @RequestBody Inscription inscription) {
        repository.save(modelMapper.map(inscription, InscriptionEntity.class));
    }
}
