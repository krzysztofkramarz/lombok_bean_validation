package com.fonowizja.lombok_bean_validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.google.common.collect.ImmutableList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Nie modyfikuj tej klasy, z wyjątkiem testStudent3()
 * @author krzysztof.kramarz
 */
public class StudentTest
{
   private Validator validator;
   private Service service;
   private Student student1;
   private Student student2;

   @BeforeClass
   public void setStudent1()
   {
      List<String> przedmioty1 = ImmutableList.of();
      student1 = new Student(null, 17, null, "janek.tlen.pl", false, "5254112");
   }

   @BeforeClass
   public void setStudent2()
   {
      List<String> przedmioty = ImmutableList.of();
      student2 = new Student("  ", 68, przedmioty, "janek.tlen.pl", false, "5254112");
   }

   @BeforeClass
   public void setValidatorAndService()
   {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();
      service = new Service();
   }

   @Test
   public void testStudent1()
   {
      int serviceResponse = 0;

      Set<String> expected = new HashSet<>();
      expected.add("must match \"[0-9]{11}\"");
      expected.add("must be greater than or equal to 18");
      expected.add("must be a well-formed email address");
      expected.add("must be true");
      expected.add("must not be blank");
      expected.add("must not be null");

      Set<String> result = new HashSet<>();
      Set<ConstraintViolation<Student>> violations = validator.validate(student1);
      for (ConstraintViolation<Student> violation : violations)
      {
         result.add(violation.getMessage());
      }
      if (violations.isEmpty())
      {
         serviceResponse = service.acceptMessageFromExternalServis(student1);
      }
      assertThat(serviceResponse).isEqualTo(0);
      assertThat(expected).isEqualTo(result);
   }

   @Test
   public void testStudent2()
   {
      int serviceResponse = 0;

      Set<String> expected = new HashSet<>();
      expected.add("must match \"[0-9]{11}\"");
      expected.add("must be less than or equal to 65");
      expected.add("must be a well-formed email address");
      expected.add("must be true");
      expected.add("must not be blank");

      Set<String> result = new HashSet<>();
      Set<ConstraintViolation<Student>> violations = validator.validate(student2);
      for (ConstraintViolation<Student> violation : violations)
      {
         result.add(violation.getMessage());
      }
      System.out.println(violations.size());
      if (violations.isEmpty())
      {
         serviceResponse = service.acceptMessageFromExternalServis(student2);
      }

      assertThat(serviceResponse).isEqualTo(0);
      assertThat(expected).isEqualTo(result);
   }


   @Test
   /**
    * Jeśli masz ochotę przekazać własciwe dane zgodnie z adnotacjami, które wymyśliłeś w porzednich zadaniach
    * możesz wpisać własciwe wartości do konstruktora studenta
    * @author krzysztof.kramarz
    */
   public void testStudent3()
   {
      List<String> przedmioty = ImmutableList.of("Filozofia", "Kompilatory");
      Student student3 =  new Student("s", 40, przedmioty, "janek@tlen.pl", true, "14785236987");

       int   serviceResponse = service.acceptMessageFromExternalServis(student3);

      assertThat(serviceResponse).isEqualTo(0);
   }

}