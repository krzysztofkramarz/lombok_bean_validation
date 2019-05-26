package com.fonowizja.lombok_bean_validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tej klasy nie modyfikuj
 *
 * @author krzysztof.kramarz
 */
public class RowerTest
{
   Rower rower;

   @BeforeClass
   public void setRower()
   {
      rower = new Rower("górska", "bmx", null);
   }

   @Test
   public void testGetters()
   {
      Method[] methods = rower.getClass().getDeclaredMethods();

      List<Method> getters = Stream.of(methods)
            .filter(it -> it.getName().startsWith("get"))
            .collect(Collectors.toList());

      assertThat(getters.size()).isEqualTo(3);
   }

   @Test
   public void testSetters()
   {
      Method[] methods = rower.getClass().getDeclaredMethods();

      List<Method> setters = Stream.of(methods)
            .filter(it -> it.getName().startsWith("set"))
            .filter(it -> it.getModifiers() == 1)
            .collect(Collectors.toList());

      assertThat(setters.size()).isEqualTo(3);
   }

   @Test
   public void testModifiers()
   {
      Method[] methods = rower.getClass().getDeclaredMethods();

      Pattern pattern = Pattern.compile("get.*|set.*");
      int sum = Stream.of(methods)
            .filter(it -> pattern.matcher(it.getName()).matches()
            )
            .map(Method::getModifiers)
            .mapToInt(Integer::intValue)
            .sum();

      assertThat(sum).isEqualTo(9);
   }

   @Test
   public void testConstructorNoArgs()
   {
      Constructor<?>[] constructors = rower.getClass().getConstructors();

      List<Constructor<?>> noArgConstructor = Stream.of(constructors)
            .filter(it -> it.getParameters().length == 0)
            .collect(Collectors.toList());
      assertThat(noArgConstructor.size()).isEqualTo(1);
   }
}