package com.fonowizja.lombok_bean_validation;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.log4j.Log4j2;

/**
 * @author krzysztof.kramarz
 */
@AllArgsConstructor
@Value
@Log4j2
@Builder
class Góra
{
   private Integer wysokosc;
   private Szczyt szczyt;

   Góra(Integer wysokosc, Szczyt szczyt, List<Integer> listaWejscWczasieBurzy)
   {
      log.info("Klasa została stworzona");
      this.wysokosc = wysokosc;

      this.szczyt = new Szczyt(szczyt.getNazwa(), listaWejscWczasieBurzy);
   }

   public Szczyt getSzczyt()
   {
      return new Szczyt(szczyt.getNazwa(), szczyt.getListaWejscWczasieBurzy());

   }
}
