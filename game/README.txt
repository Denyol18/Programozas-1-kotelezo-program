----- BEÜZEMELÉSI ÚTMUTATÓ -----

A program futtatásához kelleni fog a az IntelliJ IDEA fejlesztői környezet.

Ha ez nincs meg, akkor az alábbi linket bemásolva egy böngészőbe tudod elérni és letölteni azt.

https://www.jetbrains.com/idea/download/

Meglehet próbálni konzollal vagy terminállal fordítani és úgy futtatni, de erősen ajánlom, hogy IDEA-ban futtasd.

Ha megvolt a telepíés, akkor nyisd meg az IDEA-t, majd jobb felül az "OPEN" gombra kattintva válaszd ki a játék mappáját, majd
kattints az "OK" gombra.


Külön dolgokat nem kell letölteni, a Maven minden szükséges libraryt importál, de ha ez mégse történne meg, akkor itt egy videó a
JavaFX beüzemeléséhez (a scenebuilder nem fog kelleni):

https://www.youtube.com/watch?v=m2AFU3Tjeg4&list=PLGlj9VbLRrjA_i8dGwGWhNu17CXbFRUYD&index=3

JavaFX-et innen lehet letölteni: https://gluonhq.com/products/javafx/

Ezután keresd meg a program belépési pontját, a pontos elérési út a következő:

src -> main -> java -> com.kotprog.game -> Launcher


Ha a program azt irja, hogy "Project JDK is not defined", akkor az "Add JDK"-ra kell kattintani, ami letölti a jdk-t, lehetőleg a 17-eset
válaszd.

Ha ezután is probléma van, akkor a jobbszélen lévő Maven ikonra kell kattintani. Ezen belül game -> plugins -> clean és a fogaskerék 
ikonnal ellátott clean:clean-re kell duplán kattintani.
Ezt követően még mindig a Maven fülben a compiler-re kattintva eléred a compiler:compile-t, erre is duplán kell kattintani.

Eztán a 18. sor mellett bal oldalt lévő
kis zöld háromszögre kattintva az utána megjelenő "Run 'Launcher.main()'"-re kattintva lehet elinditani a programot.

Másik megoldás a menüsorban lévő "Run" fület lenyitni (ablak legfelső részénél) a "Run Launcher"-re kattintani.


----- INFÓK A JÁTÉKHOZ -----

A menük között nem lehet visszalépni, csakis előre fele. Ez azt jelenti, hogy a nehézségi szint választás után azt nem lehet megváltoztatni, illetve
nem érdemes a hős tulajdonságaira és a varázslatokra elkölteni a rendelkezésre álló aranyat, mert utána az egységekre kell költeni.
A csatából sem lehet visszalépni sehogyse az egység vásárláshoz.

Tulajdonságpontot a legfelső vásárlás gombbal lehet, minden vásárlás után nő a következő tulajdonságpont ára 10%-al.
A megvett tulajdonság pontot a növelés gombokkal lehet felhasználni, mindegyik gomb a mellette lévő tulajdonságot fogja növelni.

Egy db varázslatot csak egyszer lehet megvásárolni. Egy adott varázslat megvétele után a hozzá rendelt vásárlás gomb letiltódik, nem lehet utána arra kattintani.

A varázslatok leírásai: 

villámcsapás: Egy kiválasztott ellenséges egységre (varázserő * 30) sebzés okozása
tűzlabda: Egy kiválasztott mező körüli 3x3-as területen lévő összes (saját, illetve ellenséges) egységre (varázserő * 20) sebzés okozása
feltámasztás: Egy kiválasztott saját egység feltámasztása. Maximális gyógyítás mértéke: (varázserő * 50) (de az eredeti egységszámnál több nem lehet).

Csak akkor lehet csatába menni, ha legalább 1 db egységet vásároltál. Csakis pozitív egész számokat használj vásárlás során, különben a program szól, hogy nem így cselekedtél,
majd fut tovább.

Csata előtt az egységet/egységeket le kell helyezni a mezőre, cssakis a bal szélső kettő oszlopba lehet lepakolni őket. Az egységre rákattintva bal egér gombbal, majd nyomva tartva
azt kell oda húzni őket. Ha a megfelelő oszlopok felé érsz, az adott terület kizöldül és ha elengeded az egérgombot, akkor le tudod rakni arra a mezőre az egységet.

Ezután nem tudod megváltoztatni a pozicióját. Az összes egységet le kell helyezni, különben a tovább gombra nem lehet kattintani.

Tovább gombra kattintva megjelennek az ellenfél egységei és a hős tulajdonságai, varázslatai. Csak ekkor láthatóak ezek az adatok.

Csata elkezdése gomb elkezdi a csatát.

Ha egy piros egység van soron, akkor nem tudsz semmit se csinálni, a következő egység nevű gombra kell kattintani.

Hőst használni csakis a saját egységed lépése előtt lehet csak, ha előbb lépsz az egységeddel, akkor utána nem használhatod a hősöd, meg kell várni mikor fog sorra kerülni a másik egységed.

Hőst használni egy körben csak egyszer lehet.

Akció gombok után (Támadás, varázslás) azokra az egységekre kell kattintani, amiknek szövege "kifehérült". Hős vagy egység támadása esetén az ellenfél valamelyik egységére kell kattintani,
a hős támadó jellegű varázslatai után is, ellenben a hős gyógyító varázslata esetén a saját egységeink közül valamelyikre kell kattintani. A várakozás akció nem csinál semmit.

A varázslás gombra kattintva megjelennek a megvett varázslataink, zárójelben pedig a manna költségük. Ha nem vettünk varázslatokat, akkor nem jelenik meg a varázslás gomb.

Megsemmisült egységet nem lehet megtámadni.

A játék 5 kör után véget ér, az a csapat nyer, aki megsemmisítette az ellenfél összes egységét. Ha ez hamarabb bekövetkezik, akkor várakozás gombot nyomd meg mindig, addig amíg eléred
a játék végét.









