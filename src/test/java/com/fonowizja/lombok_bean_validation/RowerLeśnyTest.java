package com.fonowizja.lombok_bean_validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tej klasy nie modyfikuj
 *
 * @author krzysztof.kramarz
 */
public class RowerLeśnyTest
{

   RowerLeśny rowerLeśny;

   @BeforeClass
   public void setRowerLeśny()
   {
      rowerLeśny = new RowerLeśny("moro");
      rowerLeśny.setKierownica("leśna");
      rowerLeśny.setSiodełko("ze sprężyną");
      rowerLeśny.setPrzerzutka(null);
   }

   @Test
   public void testToString()
   {
      String expected = "RowerLeśny(super=Rower(kierownica=leśna, siodełko=ze sprężyną), moro)";
      String s = rowerLeśny.toString();
      assertThat(rowerLeśny.toString()).isEqualTo(expected);
   }

   @Test
   public void testHashCode()
   {
      int expected = 106810173;
      int i = rowerLeśny.hashCode();
      assertThat(i).isEqualTo(expected);
   }
}