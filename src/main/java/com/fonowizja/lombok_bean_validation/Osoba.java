package com.fonowizja.lombok_bean_validation;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Dodaj potrzebne adnotacje
 * @author krzysztof.kramarz
 */
@Builder
class Osoba {
    private @NotBlank String imie;
    private @NotBlank String nazwisko;
    private @Pattern(regexp = "\\d{11}") String pesel;

}
