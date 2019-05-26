package com.fonowizja.lombok_bean_validation;

/**
 * Użyj jak najmniej adnotacji Lomboka, aby przeszły testy. Niech adnotacje nie będa nadmiarowe (np. gdy potrzebujesz @Getters, nie używaj @Data)
 *
 * @author krzysztof.kramarz
 *//

class Rower
{
   public String kierownica;
   private String siodełko;
   private Przerzutka przerzutka;

   public Rower(String kierownica, String siodełko, Przerzutka przerzutka)
   {
      this.kierownica = kierownica;
      this.siodełko = siodełko;
      this.przerzutka = przerzutka;
   }
}
