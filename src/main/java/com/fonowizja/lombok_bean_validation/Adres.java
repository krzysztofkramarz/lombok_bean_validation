package com.fonowizja.lombok_bean_validation;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.*;
import java.util.List;

/**
 * Dodaj potrzebne adnotacje
 * @author krzysztof.kramarz
 */
@Builder
@Getter
class Adres {

    private @NotNull @Min(0) Long id;
    private @NotBlank String województwo;
    private @NotBlank String gmina;
    private @NotBlank String miasto;
    private @NotBlank String ulica;
    private @NotNull @Min(1) Integer dom;
    private @Pattern(regexp = "\\w") String dodatkowyNumer;
    private @Min(1) Integer mieszkanie;
    private @Pattern(regexp = "\\d{2}-\\d{3}") String kodPocztowy;
    private @Pattern(regexp = "\\+(48)\\d{9}") String telefonKomorkowy;
    private @Email String kontaktEmail;
    private @Size(min = 1, max = 12) @NotEmpty List<Osoba> zameldowanie;
    private @AssertFalse Boolean pustostan;
}
