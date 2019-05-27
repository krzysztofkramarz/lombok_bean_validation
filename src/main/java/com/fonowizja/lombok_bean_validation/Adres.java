package com.fonowizja.lombok_bean_validation;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * Dodaj potrzebne adnotacje
 *
 * @author krzysztof.kramarz
 */
@Builder
@Getter
class Adres {

    private Long id;
    private String województwo;
    private String gmina;
    private String miasto;
    private String ulica;
    private Integer dom;
    private String dodatkowyNumer;
    private Integer mieszkanie;
    private String kodPocztowy;
    private String telefonKomorkowy;
    private String kontaktEmail;
    private List<Osoba> zameldowanie;
    private Boolean pustostan;
}
