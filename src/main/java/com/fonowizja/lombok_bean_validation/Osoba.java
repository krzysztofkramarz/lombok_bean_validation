package com.fonowizja.lombok_bean_validation;

import lombok.Builder;

/**
 * Dodaj potrzebne adnotacje
 *
 * @author krzysztof.kramarz
 */
@Builder
class Osoba {
    private String imie;
    private String nazwisko;
    private String pesel;

}
