package com.fonowizja.lombok_bean_validation;

/**
 * Użyj jak najmniej adnotacji Lomboka, aby przeszły testy. Niech adnotacje nie będa nadmiarowe (np. gdy potrzebujesz @Getters, nie używaj @Data)
 * Dla logowania użyj log4j2 (plik konfiguracyjny jest załączony
 * Zastanów się nad uzyskaniem niezmienności klasy (immutable class) w kontekście Lomboka.
 * Może trzeba samodzielnie napisac jakiś kawałek kodu?
 *
 * @author krzysztof.kramarz
 */
class Góra
{
   private Integer wysokosc;
   private Szczyt szczyt;

   // spróbuj poniższą linijke wstawić w jakis kawalek kodu.
   //to zachowanie nie jest testowane, ale będziesz miał satysfakcję, widzac, jak dzięki lombokowi logujesz informacje
   //log.info("Jestem robot młody, nie boje się wody, bo gdzie woda, to ja hyc, nie boje sie nic, a nic");

}
