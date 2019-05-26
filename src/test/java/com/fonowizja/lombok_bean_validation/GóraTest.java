package com.fonowizja.lombok_bean_validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author krzysztof.kramarz
 */
public class GóraTest
{
   private Góra góra;
   private Szczyt szczyt;
   private List<Integer> listaWejscWczasieBurzy;

   @BeforeClass
   public void setGóraAndSzczyt()
   {
      listaWejscWczasieBurzy = new ArrayList<>();
      listaWejscWczasieBurzy.add(1932);
      listaWejscWczasieBurzy.add(1967);
      listaWejscWczasieBurzy.add(2005);
      szczyt = Szczyt.builder().nazwa("Tarnica").listaWejscWczasieBurzy(listaWejscWczasieBurzy).build().toBuilder().nazwa("Rysy").build();

      góra = new Góra(2503, szczyt, listaWejscWczasieBurzy);
   }

   @Test
   public void testGetterImmutabilityOfValue()
   {
      String expected = "Rysy";
      góra.getSzczyt().setNazwa("Święty Krzyż");
      String result = góra.getSzczyt().getNazwa();

      assertThat(result).isEqualTo(expected);
   }

   @Test
   public void testConstructorImmutabilityOfValue()
   {
      String expected = "Rysy";
      szczyt.setNazwa("Śnieżnica");
      String result = góra.getSzczyt().getNazwa();

      assertThat(result).isEqualTo(expected);
   }

   @Test
   public void testCollectionGetterImmutabilityOfValue()
   {
      List<Integer> expected = Arrays.asList(1932, 1967, 2005);
      List<Integer> faked = Arrays.asList(1002, 2511);
      listaWejscWczasieBurzy.clear();
      listaWejscWczasieBurzy.add(1002);
      listaWejscWczasieBurzy.add(2511);

      assertThat(szczyt.getListaWejscWczasieBurzy()).isEqualTo(expected);
      assertThat(szczyt.getListaWejscWczasieBurzy()).isNotEqualTo(faked);
   }

}