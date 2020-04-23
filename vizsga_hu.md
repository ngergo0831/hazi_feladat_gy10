# 1. feladat

Készíts egy `bar.AgeGroup` nevű felsorolási típust. Értékei:

- `ADULT`
- `MINOR`
- `UNSPECIFIED`

Készítsd el a `bar.Person` osztályt, amely a bár egy vendégét reprezentálja. A következő adattagokkal rendelkezik:

- `name`, sztringek tömbje
- `age`, final pozitív egész
- `ageGroup`, melynek típusa `bar.AgeGroup`

Minden adattag rendelkezik getterrel és szetterrel, kivéve `age`-et, amelynek nincs szettere.
Az osztálynak egy konstruktora van, amely értékül kapja az összes adattag értékét, és beállítja őket.
A konstruktor a következő megszorításokat ellenőrzi:

- Ha `age` egy negatív egész, akkor dob egy `IllegalArgumentException`-t.
- A `name` adattag nem lehet lehet `null`, és nem tartalmazhat üres sztringet.
  - Szóközökből álló sztringet üresnek tekintünk.
  - Tipp: nézd meg a `String.trim()` metódust.

Készítsd el a következő szokásos metódusokat:

- `Person` szöveges reprezentációja: `<name> (<age>, <ageGroup>)`.
  - Például: `Kate Ellen (19, UNSPECIFIED)` vagy `Zsolt Farago (43, ADULT)`.
- Két személyt akkor tekintünk egyenlőnek, ha minden adattagjuk egyenlő.

# 2. feladat

Készítsd el a `bar.util.AgeGroupException` ellenőrzött kivételt.
A konstruktora egy szöveget vár és a szülőosztály konstruktorának adja át.

Készítsd el a `bar.Beverage` osztályt. A következő mezőkkel és metódusokkal rendelkezik:

- `name`, egy sztring
- `price`, pozitív egész
- `legalAge`, pozitív egész
- Minden attribútum számára készítsd el a getterét és a setterét.
- Írj egy konstruktort, amely minden tagváltozó értékét megkapja és beállítja azokat.
  - A `Person` osztály `name` és `age` attribútumainak megszorításai itt is érvényesek a megfelelő adattagok esetén.
- A `getLegalAge` változó értéke határozza meg, hogy melyik korosztály (`AgeGroup`) fogyaszthatja az italt.
- A `Beverage` szöveges reprezentációja ilyen: `<name> (<price>, <legalAge>)`.
  - Például: `2012 Villanyi Cuvee (35900, 18)` or `Strawberry Lemonade (1200, 6)`.

Hozd létre a `bar.Guest` osztályt, ami kiterjeszti `Person`-t.

- Rendelkezik egy `Beverage` típusú `beverage` változóval, amelynek van gettere és settere is. Kezdeti értéke egy `none` nevű ital,
  amely nem számít érvényes italnak.
- Van még egy `paidAmount` nevű egész adattagja, amely szintén rendelkezik getterrel és setterrel.
- Adj az osztályhoz egy statikus final Beverage adattagot, amely a `none` italt tartalmazza. Az összes vendég, amely a `none` italra hivatkozik, erre a példányra hivatkozzon.
- Készítsd el a `increasePaidAmount(int)` függvényt, amely megnöveli `paidAmount` értékét a paraméterrel.

Hozd létra a `bar.Bartender` osztályt. Származzon le a `Person`-ből.

- Egy bartender csak felnőtt lehet, ezért ha valaki nem az `ADULT` értéket adja át `AgeGroup`-ként, akkor dobjon `AgeGroupException`-t.
  - A kivétel szövege legyen: `Only adult bartenders are allowed.`

Egészítsd ki a `Person` osztályt a `giveBeverage` metódussal, amelynek két paramétere van: egy `Guest` és egy `Beverage` típusú.

- A `Person` osztályban dobjon egy `UnsupportedOperationException`-t. Ez a Java nyelv egy beépített kivétele.
- `Guest`-ben implementáljuk a függvényt. Ha a vendégnek van egy érvényes itala (nem `none`), akkor ingyen odaadja a paraméterben átadott vendégnek. Az italt adó vendég `beverage` adattagja ezután mutasson a `none` italra. A paraméterben átadott `Guest` `beverage` adattagja ezután mutasson az új italra, és a régitől váljon meg.
- A `Bartender` ellenőrzi, hogy kiszolgálhatja-e a vendéget az itallal. Ha nem, dobjon egy `AgeGroupException`-t. Ha igen, beállítja a vendég italát az újra és meghívja a vendég `increasePaidAmount` metódusát a megfelelő paraméterrel.

# 3. feladat

A `Person` osztályban készíts egy osztályszintű `beverageFileTransformer` metódust, amely két fájlnevet kap paraméterül. A metódus dobhat `IOException`-t, ha valamilyen probléma lenne valamelyik fájllal, pl. nem olvasható.

Az első paraméterként kapott bemeneti fájl minden sorában egy-egy ital adatai szerepelnek: `<name>,<price>,<legalAge>`, például `2012 Villanyi Cuvee,35900,18`.

A metódus olvassa be a fájl tartalmát, és írja ki a második paraméterként kapott fájlba az italok szöveges reprezentációját.

- Az italok ár szerint növekvő sorrendben kerüljenek a fájlba.
- A kimeneti fájlban ne szerepeljenek egymással egyenlő italok.

# 4. feladat

Készítsd el a `bar.DelayedBeverageSeller` interfészt. Az interfésznek két metódusa van:

- `orderBeverage(Guest, Beverage)`
- `beverageReady(Guest, Beverage)`

Hozd létre a `bar.DelayedBartender` osztályt, `Bartender` egy leszármazottját.

- Az osztály implementálja a `DelayedBeverageSeller` interfészt.
- Az osztálynak van egy `readyBeverages` adattagja. Ez kezdetben üres, nem tartalmaz italt.
- Rendelkezik még egy `pendingOrders` mezővel is. Kezdetben ez is üres, italrendelés nélkül.
- `orderBeverage` hívásakor a bartender megnézi, hogy a `readyBeverages` tartalmaz-e ilyen italt (megegyezik-e a paraméterként átadott ital neve valamelyik italéval a `readyBeverages` listában).
  - Ha igen, akkor az italt felszolgálja a vendégnek, meghívva annak `giveBeverage` metódusát.
  - Különben a rendelést (az italt) a `pendingOrders` listába teszi.
- `beverageReady` hívása esetén a bartender megnézi, hogy létezik-e ilyen ital a `pendingOrders` listában.
  - Ha létezik, a rendelést felszolgálja, és az italt kiveszi a `pendingOrders`-ből.
  - Különben adja az italt a `readyBeverages` listához.
