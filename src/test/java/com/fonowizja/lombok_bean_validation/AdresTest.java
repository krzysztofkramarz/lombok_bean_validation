package com.fonowizja.lombok_bean_validation;

import com.google.common.collect.ImmutableList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Wyobraź sobie serwis, który zwraca dane o adresie i mieszkańcach
 * Dostawca usług podaje przykładowe poprawne dane. W naszym przypadku są to dane w polach
 * private Adres adresPoprawny;
 * private Adres adres1;
 * To są wzorcowe dane.
 * <p>
 * Ale serwis zwraca dane nie zawsze poprawne. Szalony tester napisał testy dla tych przypadków,
 * zakodował to w sobie tylko znany sposób i zwolnił się z firmy. Czeka na telefon z propozycją podwyżki.
 * Oznacz klasy Adres i Osoba adnotacjami  * z pakietu javax.validation.constraints.*,
 * aby poniższe testy przechodziły.
 * W niektórych miejscach adnotacje moga mieć kilka poprawnych wartości ograniczających, to jest w porzadku.
 * W ostateczności zadzwonisz do osoby odpowiedzialnej za webserwis w firmie dostarczającej dane,
 * jak tylko wróci z urlopu i dostaniesz oficjalną dokumentację webserwisu.
 * <p>
 * Tej klasy testowej nie zmieniaj.
 *
 * @author krzysztof.kramarz
 */
public class AdresTest {
    private Validator validator;
    private Adres adresPoprawny;
    private Adres adres1;
    private Adres adres2;
    private Adres adres3;
    private Adres adres4;
    private Adres adres5;
    private Osoba osoba1;
    private Osoba osoba2;
    private Osoba osoba3;
    private List<Osoba> osoby1;
    private List<Osoba> osoby2;
    private List<Osoba> osoby3;

    @BeforeClass
    public void setData() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        osoba1 = Osoba.builder()
                .imie("Tadzio")
                .nazwisko("null")
                .pesel("54120189745")
                .build();

        osoba2 = Osoba.builder()
                .imie(null)
                .nazwisko(" ")
                .pesel("92042145214")
                .build();

        osoba3 = Osoba.builder()
                .imie(" ")
                .nazwisko("")
                .pesel("680522811")
                .build();

        osoby1 = ImmutableList.of(osoba1, osoba2, osoba3);
        osoby2 = ImmutableList.of();
        osoby3 = ImmutableList.of(osoba1, osoba2, osoba3, osoba1, osoba2, osoba3,
                osoba1, osoba2, osoba3, osoba1, osoba2, osoba3, osoba1);

        adresPoprawny = Adres.builder()
                .id(34L)
                .województwo("pomorskie")
                .gmina("Koczała")
                .miasto("Miękina")
                .ulica("Leśna")
                .dom(4)
                .dodatkowyNumer("c")
                .mieszkanie(3)
                .kodPocztowy("87-322")
                .telefonKomorkowy("+48287451246")
                .kontaktEmail("studenciaki@imprezki.pl")
                .zameldowanie(osoby1)
                .pustostan(false)
                .build();


        adres1 = Adres.builder()
                .id(null)
                .województwo(" ")
                .gmina(" ")
                .miasto(" ")
                .ulica(" ")
                .dom(null)
                .dodatkowyNumer("ac")
                .mieszkanie(null)
                .kodPocztowy("87 -322")
                .telefonKomorkowy("+480287451246")
                .kontaktEmail("studenciaki(at)imprezki.pl")
                .zameldowanie(osoby1)
                .pustostan(true)
                .build();

        adres2 = Adres.builder()
                .id(-23L)
                .województwo(null)
                .gmina(null)
                .miasto(null)
                .ulica(null)
                .dom(-3)
                .dodatkowyNumer("")
                .mieszkanie(-2)
                .kodPocztowy("87322")
                .telefonKomorkowy("48287451246")
                .kontaktEmail("studenciaki(at)imprezki.pl")
                .zameldowanie(osoby2)
                .pustostan(true)
                .build();


        adres3 = Adres.builder()
                .id(-23L)
                .województwo(null)
                .gmina(null)
                .miasto(null)
                .ulica(null)
                .dom(-3)
                .dodatkowyNumer(" ")
                .mieszkanie(-2)
                .kodPocztowy("87322")
                .telefonKomorkowy("48287451246")
                .kontaktEmail("studenciaki(at)imprezki.pl")
                .zameldowanie(osoby3)
                .pustostan(true)
                .build();

        adres4 = Adres.builder()
                .id(-23L)
                .województwo(null)
                .gmina(null)
                .miasto(null)
                .ulica(null)
                .dom(-3)
                .dodatkowyNumer(" ")
                .mieszkanie(-2)
                .kodPocztowy("87322")
                .telefonKomorkowy("48287451246")
                .kontaktEmail("studenciaki(at)imprezki.pl")
                .zameldowanie(null)
                .pustostan(false)
                .build();

    }


    @Test
    public void testPoprawnyAdresIOsoba() {


        List<String> expectedAdres = new LinkedList<>();

        List<String> resultAdres = new LinkedList<>();
        Set<ConstraintViolation<Adres>> violations = validator.validate(adresPoprawny);
        for (ConstraintViolation<Adres> violation : violations) {
            resultAdres.add(violation.getMessage());
        }

        assertThat(expectedAdres).isEqualTo(resultAdres);
        assertThat(expectedAdres.size()).isEqualTo(resultAdres.size());

        // ######################   OSOBA ########################

        List<String> expectedOsoba = new LinkedList<>();

        List<String> resultOsoba = new LinkedList<>();
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBtYXRjaCAiXGR7MTF9Ig=="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        Iterator<Osoba> iteratorOsoby = adresPoprawny.getZameldowanie().iterator();
        while (iteratorOsoby.hasNext()) {
            Osoba osoba = iteratorOsoby.next();
            Set<ConstraintViolation<Osoba>> violationsOsoby = validator.validate(osoba);
            for (ConstraintViolation<Osoba> violation : violationsOsoby) {
                resultOsoba.add(violation.getMessage());
            }
        }

        assertThat(expectedOsoba).containsAll(resultOsoba);
        assertThat(expectedOsoba.size()).isEqualTo(resultOsoba.size());
    }


    @Test
    public void testAdres1() {


        List<String> expectedAdres = new LinkedList<>();

        expectedAdres.add(decode("bXVzdCBub3QgYmUgbnVsbA=="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgbnVsbA=="));
        expectedAdres.add(decode("bXVzdCBiZSBmYWxzZQ=="));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXGR7Mn0tXGR7M30i"));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXHci"));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXCsoNDgpXGR7OX0i"));
        expectedAdres.add(decode("bXVzdCBiZSBhIHdlbGwtZm9ybWVkIGVtYWlsIGFkZHJlc3M="));

        List<String> resultAdres = new LinkedList<>();
        Set<ConstraintViolation<Adres>> violations = validator.validate(adres1);
        for (ConstraintViolation<Adres> violation : violations) {
            resultAdres.add(violation.getMessage());
        }

        assertThat(expectedAdres).containsAll(resultAdres);
        assertThat(expectedAdres.size()).isEqualTo(resultAdres.size());

        // ######################   OSOBA ########################
        List<String> expectedOsoba = new LinkedList<>();
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBtYXRjaCAiXGR7MTF9Ig=="));

        List<String> resultOsoba = new LinkedList<>();
        Iterator<Osoba> iteratorOsoby = adres1.getZameldowanie().iterator();
        while (iteratorOsoby.hasNext()) {
            Osoba osoba = iteratorOsoby.next();
            Set<ConstraintViolation<Osoba>> violationsOsoby = validator.validate(osoba);
            for (ConstraintViolation<Osoba> violation : violationsOsoby) {
                resultOsoba.add(violation.getMessage());
            }
        }

        assertThat(expectedOsoba).containsAll(resultOsoba);
        assertThat(expectedOsoba.size()).isEqualTo(resultOsoba.size());
    }


    @Test
    public void testAdres2() {


        List<String> expectedAdres = new LinkedList<>();

        expectedAdres.add(decode("bXVzdCBiZSBmYWxzZQ=="));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXGR7Mn0tXGR7M30i"));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXHci"));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgZW1wdHk="));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXCsoNDgpXGR7OX0i"));
        expectedAdres.add(decode("bXVzdCBiZSBhIHdlbGwtZm9ybWVkIGVtYWlsIGFkZHJlc3M="));
        expectedAdres.add(decode("bXVzdCBiZSBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gMQ=="));
        expectedAdres.add(decode("bXVzdCBiZSBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gMQ=="));
        expectedAdres.add(decode("bXVzdCBiZSBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gMA=="));
        expectedAdres.add(decode("c2l6ZSBtdXN0IGJlIGJldHdlZW4gMSBhbmQgMTI="));

        List<String> resultAdres = new LinkedList<>();
        Set<ConstraintViolation<Adres>> violations = validator.validate(adres2);
        for (ConstraintViolation<Adres> violation : violations) {
            resultAdres.add(violation.getMessage());
        }
        assertThat(expectedAdres).containsAll(resultAdres);
        assertThat(expectedAdres.size()).isEqualTo(resultAdres.size());

        // ######################   OSOBA ########################
        List<String> expectedOsoba = new LinkedList<>();

        List<String> resultOsoba = new LinkedList<>();

        Iterator<Osoba> iteratorOsoby = adres2.getZameldowanie().iterator();
        while (iteratorOsoby.hasNext()) {
            Osoba osoba = iteratorOsoby.next();
            Set<ConstraintViolation<Osoba>> violationsOsoby = validator.validate(osoba);
            for (ConstraintViolation<Osoba> violation : violationsOsoby) {
                resultOsoba.add(violation.getMessage());
            }
        }

        assertThat(expectedOsoba).containsAll(resultOsoba);
        assertThat(expectedOsoba.size()).isEqualTo(resultOsoba.size());
    }


    @Test
    public void testAdres3() {


        List<String> expectedAdres = new LinkedList<>();

        expectedAdres.add(decode("bXVzdCBiZSBmYWxzZQ=="));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXGR7Mn0tXGR7M30i"));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXHci"));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXCsoNDgpXGR7OX0i"));
        expectedAdres.add(decode("bXVzdCBiZSBhIHdlbGwtZm9ybWVkIGVtYWlsIGFkZHJlc3M="));
        expectedAdres.add(decode("bXVzdCBiZSBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gMQ=="));
        expectedAdres.add(decode("bXVzdCBiZSBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gMQ=="));
        expectedAdres.add(decode("bXVzdCBiZSBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gMA=="));
        expectedAdres.add(decode("c2l6ZSBtdXN0IGJlIGJldHdlZW4gMSBhbmQgMTI="));

        List<String> resultAdres = new LinkedList<>();
        Set<ConstraintViolation<Adres>> violations = validator.validate(adres3);
        for (ConstraintViolation<Adres> violation : violations) {
            resultAdres.add(violation.getMessage());
        }

        assertThat(expectedAdres).containsAll(resultAdres);
        assertThat(expectedAdres.size()).isEqualTo(resultAdres.size());
        // ######################   OSOBA ########################
        List<String> expectedOsoba = new LinkedList<>();

        List<String> resultOsoba = new LinkedList<>();
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedOsoba.add(decode("bXVzdCBtYXRjaCAiXGR7MTF9Ig=="));
        expectedOsoba.add(decode("bXVzdCBtYXRjaCAiXGR7MTF9Ig=="));
        expectedOsoba.add(decode("bXVzdCBtYXRjaCAiXGR7MTF9Ig=="));
        expectedOsoba.add(decode("bXVzdCBtYXRjaCAiXGR7MTF9Ig=="));
        Iterator<Osoba> iteratorOsoby = adres3.getZameldowanie().iterator();
        while (iteratorOsoby.hasNext()) {
            Osoba osoba = iteratorOsoby.next();
            Set<ConstraintViolation<Osoba>> violationsOsoby = validator.validate(osoba);
            for (ConstraintViolation<Osoba> violation : violationsOsoby) {
                resultOsoba.add(violation.getMessage());
            }
        }

        assertThat(expectedOsoba).containsAll(resultOsoba);
        assertThat(expectedOsoba.size()).isEqualTo(resultOsoba.size());
    }


    @Test
    public void testAdres4() {


        List<String> expectedAdres = new LinkedList<>();

        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXGR7Mn0tXGR7M30i"));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXHci"));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgYmxhbms="));
        expectedAdres.add(decode("bXVzdCBub3QgYmUgZW1wdHk="));
        expectedAdres.add(decode("bXVzdCBtYXRjaCAiXCsoNDgpXGR7OX0i"));
        expectedAdres.add(decode("bXVzdCBiZSBhIHdlbGwtZm9ybWVkIGVtYWlsIGFkZHJlc3M="));
        expectedAdres.add(decode("bXVzdCBiZSBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gMQ=="));
        expectedAdres.add(decode("bXVzdCBiZSBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gMA=="));
        expectedAdres.add(decode("bXVzdCBiZSBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gMA=="));

        List<String> resultAdres = new LinkedList<>();
        Set<ConstraintViolation<Adres>> violations = validator.validate(adres4);
        for (ConstraintViolation<Adres> violation : violations) {
            resultAdres.add(violation.getMessage());
        }

        assertThat(expectedAdres).containsAll(resultAdres);
        assertThat(expectedAdres.size()).isEqualTo(resultAdres.size());

    }


    static String decode(String message) {
        return new String(Base64.getDecoder().decode(message.getBytes(StandardCharsets.UTF_8)));
    }

}