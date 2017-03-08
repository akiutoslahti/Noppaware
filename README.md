# Noppaware

Noppaware on turvallinen salalausegeneraattori, joka hyödyntää Kai Puolamäen GNU GPL -lisenssin alla julkaisemaa sanalistaa (http://users.ics.aalto.fi/kaip/noppaware/).
Noppaware käyttää Javan SecureRandom luokkaa sanojen valinnassa sanalistasta (https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html).

Javan SecureRandom luokka on kryptografisesti vahva satunnaislukugeneraattori, joka Linux järjestelmässä käyttää /dev/urandom tuottamaa satunnaista bittivirtaa.

# Käyttö

Käyttääksesi Noppawarea kloonaa github repositorio seuraavalla komennolla:

```git clone git://github.com/akiutoslahti/Noppaware.git```

Tulostaaksesi sovelluksen 'apua' tiedot käytä komentoa:

```java Noppaware apua```

Apua toiminnon sisältö seuraavaksi:
```
Noppaware 1.0, Noppaware -sanalistaan perustuva salalausegeneraattori
Käyttö:
    java Noppaware [sl_pituus] [sl_maara]

Argumentit:
    sl_pituus,	salalauseen mitta sanoina
    sl_maara,	generoitavien salalauseiden määrä

Oletus (ei argumentteja):
    sl_pituus: 6
    sl_maara: 10
