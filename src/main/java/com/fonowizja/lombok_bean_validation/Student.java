package com.fonowizja.lombok_bean_validation;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * W tej klasie dodaj do pól
 * odpowiednie adnotacje z pakietu javax.validation.constraints
 *
 * @author krzysztof.kramarz
 */
@Getter
@Setter
class Student
{
   private String imie;
   private Integer wiek;
   private List<String> przedmioty;
   private String email;
   private Boolean activeStudent;
   private String pesel;

   public Student(String imie, Integer wiek, List<String> przedmioty, String email, Boolean activeStudent, String pesel)
   {
      this.imie = imie;
      this.wiek = wiek;
      this.przedmioty = przedmioty;
      this.email = email;
      this.activeStudent = activeStudent;
      this.pesel = pesel;
   }
}
