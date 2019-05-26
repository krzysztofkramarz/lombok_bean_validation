package com.fonowizja.lombok_bean_validation;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author krzysztof.kramarz
 */
@AllArgsConstructor
@ToString(callSuper = true, includeFieldNames = false)
@EqualsAndHashCode(callSuper = true)
class RowerLeśny extends Rower
{
   private String kamuflaż;
}
