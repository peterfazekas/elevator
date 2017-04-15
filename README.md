<h1>Elevator - Lift</h1>
<h2>Informatika érettségi emelt szintű feladat: 2009. május</h2>
<p>A Madárház Kft. toronyházak építésével foglalkozik. Jelenleg a Csúcs Rt. 100 szintes szerkezetkész épületén kezdték meg a belső szerelési műveleteket. Az egyes szerelőcsapatok naponta többször változtatják helyüket. Ha az új munkaterület egy másik emeleten van, akkor – a biztonsági előírások miatt – lifttel kell menniük. A házban egyetlen lift működik, amelynek igénybevételét az egyes csapatok a célszint megadásával jelezhetik. A lift az igényeket a jelzés sorrendjében szolgálja ki, és egyszerre csak egy csapatot szállít. A csapatok mozgását a 9 és 14 óra közötti intervallumban követjük nyomon. Ez az intervallum a munkaidőnek csak egy része, tehát a csapatok már dolgoznak valamelyik szinten, de 9 órakor teljesítetlen kérés nincs és a lift szabad.</p>
<p>A lifthasználati igényeket az <b><em>igeny.txt</em></b> állomány tartalmazza. Első sorában a szintek száma (legfeljebb 100), a második sorban a csapatok száma (legfeljebb 50), a harmadik sorban pedig az igények száma (legfeljebb 100) olvasható. A negyedik sortól kezdve soronként egy-egy igény szerepel a jelzés sorrendjében. Egy igény hat számból áll: az első három szám az időt adja meg (óra, perc, másodpercszám sorrendben), a negyedik a csapat sorszáma, az ötödik az induló-, a hatodik a célszint sorszáma. Az egyes számokat pontosan egy szóköz választja el egymástól.</p>
<p>Például: <em>igeny.txt</em></p>
<pre>
100
10
55
9 7 11 7 6 22
9 10 30 8 18 2
9 11 0 5 12 20
…
</pre>
<p>A 4. sor megmutatja, hogy 9 óra 7 perc 11 másodperckor a 7. csapat igényelt liftet, hogy a 6. szintről a 22. szintre eljusson.</p>
<p>Készítsen programot, amely az alábbi kérdésekre válaszol! A program forráskódját lift néven mentse! Ügyeljen arra, hogy programjának minden helyes tartalmú bemeneti állomány esetén működnie kell!</p>
<p>Minden részfeladat megoldása előtt írja a képernyőre a feladat sorszámát! Ha a felhasználótól kér be adatot, jelenítse meg a képernyőn, hogy milyen értéket vár (például a 2. feladat esetén: "<code>2. feladat Kérem a lift indulási helyét!</code>")! A képernyőn megjelenített üzenetek esetén az ékezetmentes kiírás is elfogadott.</p>
<ol>
<li>Olvassa be az <b><em>igeny.txt</em></b> állományban talált adatokat, s azok felhasználásával oldja meg a következő feladatokat! Ha az állományt nem tudja beolvasni, az első 8 igényhez tartozó adatokat jegyezze be a programba és dolgozzon azzal!
<li>Tudjuk, hogy a megfigyelés kezdetén a lift éppen áll. Kérje be a felhasználótól, hogy melyik szinten áll a lift, és a további részfeladatok megoldásánál ezt vegye figyelembe! Ha a beolvasást nem tudja elvégezni, használja az <b><em>igény.txt</em></b> fájlban az első igény induló szintjét!
<li>Határozza meg, hogy melyik szinten áll majd a lift az utolsó kérés teljesítését követően! Írja képernyőre a választ a következőhöz hasonló formában: "<code>A lift a 33. szinten áll az utolsó igény teljesítése után.</code>" !</li>
<li>Írja a képernyőre, hogy a megfigyelés kezdete és az utolsó igény teljesítése között melyik volt a legalacsonyabb és melyik a legmagasabb sorszámú szint, amelyet a lift érintett!
<li>Határozza meg, hogy hányszor kellett a liftnek felfelé indulnia utassal és hányszor utas nélkül! Az eredményt jelenítse meg a képernyőn!
<li>Határozza meg, hogy mely szerelőcsapatok nem vették igénybe a liftet a vizsgált intervallumban! A szerelőcsapatok sorszámát egymástól egy-egy szóközzel elválasztva írja a képernyőre!
<li>Előfordul, hogy egyik vagy másik szerelőcsapat áthágja a szabályokat, és egyik szintről gyalog megy a másikra. (Ezt onnan tudhatjuk, hogy más emeleten igényli a liftet, mint ahova korábban érkezett.) Generáljon véletlenszerűen egy létező csapatsorszámot! (Ha nem jár sikerrel, dolgozzon a 3. csapattal!) Határozza meg, hogy a vizsgált időszak igényei alapján lehet-e egyértelműen bizonyítani, hogy ez a csapat vétett a szabályok ellen! Ha igen, akkor adja meg, hogy melyik két szint közötti utat tették meg gyalog, ellenkező esetben írja ki a <code>Nem bizonyítható szabálytalanság</code> szöveget!
<li>A munkák elvégzésének adminisztrálásához minden csapatnak egy blokkoló kártyát kell használnia. A kártyára a liftben elhelyezett blokkolóóra rögzíti az emeletet, az időpontot. Ennek a készüléknek a segítségével kell megadni a munka kódszámát és az adott munkafolyamat sikerességét. A munka kódja 1 és 99 közötti egész szám lehet. A sikerességet a „befejezett” és a „befejezetlen” szavakkal lehet jelezni. Egy műszaki hiba folytán az előző feladatban vizsgált csapat kártyájára az általunk nyomon követett időszakban nem került bejegyzés. Ezért a csapatfőnöknek a műszak végén pótolnia kell a hiányzó adatokat. Az <b><em>igeny.txt</em></b> állomány adatait felhasználva írja a képernyőre időrendben, hogy a vizsgált időszakban milyen kérdéseket tett fel az óra, és kérje be az adott válaszokat a felhasználótól! A pótlólag feljegyzett adatokat írja a <b><em>blokkol. txt</em></b> állományba! A <b><em>blokkol.txt</em></b> állomány tartalmát az alábbi sorok mintájára alakítsa ki:
<pre>
Befejezés ideje: 9:23:11
Sikeresség: befejezett
-----
Indulási emelet: 9
Célemelet: 11
Feladatkód: 23
Befejezés ideje: 10:43:22
Sikeresség: befejezetlen
-----
Indulási emelet: 11
Célemelet: 6
Feladatkód: 6
…
</pre>
</li>
</ol>
<hr>
<h3>Források:</h3>
<li><a href="https://www.oktatas.hu/pub_bin/dload/kozoktatas/erettsegi/feladatok2009tavasz/e_info_09maj_fl.pdf">Feladatlap</a>
<li><a href="https://www.oktatas.hu/pub_bin/dload/kozoktatas/erettsegi/feladatok2009tavasz/e_infofor_09maj_fl.zip">Forrásállományok</a>


