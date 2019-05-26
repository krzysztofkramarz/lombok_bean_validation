package com.fonowizja.lombok_bean_validation;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

/**
 * @author krzysztof.kramarz
 */
@Data
@Builder(toBuilder = true)
class Szczyt
{
   private String nazwa;
   @Singular("wejscieWczasieBurzy")
   private List<Integer> listaWejscWczasieBurzy;
}
