package com.fonowizja.lombok_bean_validation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author krzysztof.kramarz
 */
@Data
@NoArgsConstructor
@ToString(of = { "kierownica", "siodełko" })
class Rower
{
   @Getter(AccessLevel.PROTECTED)
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
