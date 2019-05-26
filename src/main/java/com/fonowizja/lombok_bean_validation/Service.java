package com.fonowizja.lombok_bean_validation;

/**
 * Tutaj nic nize zmieniaj
 * Atrapa serwisu konsumującego jakies dane
 * @author krzysztof.kramarz
 */
class Service
{

   int acceptMessageFromExternalServis(Student student)
   {
      StringBuilder stringBuilder = new StringBuilder(student.getImie());

      if (student.getWiek() < 18 || student.getWiek() > 65)
      {
         throw new IllegalArgumentException();
      }

      String przedmiot = student.getPrzedmioty().get(0);
      przedmiot.contains("Grafika");


      if(student.getActiveStudent()!=true || !student.getEmail().contains("@")){
         throw new IllegalStateException();
      }

      if(student.getPesel().length()<11)
      {
        return -1;
      }

      return 0;
   }
}
