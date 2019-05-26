package com.fonowizja.lombok_bean_validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tej klasy nie modyfikuj
 *
 * @author krzysztof.kramarz
 */
public class PrzerzutkaTest
{

   Przerzutka przerzutka;

   @BeforeClass
   public void setPrzerzutak()
   {
      przerzutka = new Przerzutka("romet", 23);
   }

   @Test
   public void testOf()
   {
      Method[] methods = przerzutka.getClass().getDeclaredMethods();

      List<Method> staticMethod = Stream.of(methods)
            .filter(it -> it.getName().startsWith("of"))
            .collect(Collectors.toList());

      assertThat(staticMethod.size()).isEqualTo(1);
   }
}