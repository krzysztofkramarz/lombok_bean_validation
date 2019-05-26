package com.fonowizja.lombok_bean_validation;

import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

/**
 * W tej klasie dodaj odpowiednie adnotacje
 * z pakietu javax.validation.constraints
 * @author krzysztof.kramarz
 */
@Getter
@Setter
class Student
{
   private @NotBlank String imie;
   private @NotNull @Max(65) @Min(18) Integer wiek;
   private @NotNull List<@NotBlank String> przedmioty;
   private @Email String email;
   private @AssertTrue Boolean activeStudent;
   private @Pattern(regexp = "[0-9]{11}") String pesel;

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
