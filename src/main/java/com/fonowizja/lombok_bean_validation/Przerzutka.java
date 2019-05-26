package com.fonowizja.lombok_bean_validation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author krzysztof.kramarz
 */
@NoArgsConstructor(staticName = "of")
@AllArgsConstructor
class Przerzutka
{
   private String producent;
   private Integer biegi;
}
