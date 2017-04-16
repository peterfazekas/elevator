package hu.elevator.service;

import hu.elevator.model.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public class Elevator {

    private static final String NEW_LINE = "\r\n";
    private static final String NO_FOUL_MESSAGE = "%d. csapat esetében nem bizonyítható szabálytalanság%n";
    private static final String FOUL_MESSAGE = "A(z) %d. csapat vétett a szabályok ellen: gyalog közlekedtek a %d - %d szintek között.%n";
    private static final String EMPTY_MESSAGE = "";

    private final List<Request> requests;
    private final List<Request> selectedGroupRequests;
    private final int numberOfGroups;
    private final Random random;
    private final int groupId;
    private int initLevel;

    public Elevator(final List<Request> requests, final int numberOfGroups) {
        this.requests = requests;
        this.numberOfGroups = numberOfGroups;
        random = new Random();
        groupId = generateRandomNumber(numberOfGroups);
        selectedGroupRequests = getGroupById(groupId);
    }

    private int generateRandomNumber(int max) {
        return random.nextInt(max) + 1;
    }

    private List<Request> getGroupById(final int groupId) {
        return requests.stream().filter(i -> i.getGroupId() == groupId).collect(Collectors.toList());
    }

    /**
     * 2. feladat: Kérje be a felhasználótól, hogy melyik szinten áll a lift, és a
     * további részfeladatok megoldásánál ezt vegye figyelembe!
     *
     * @param initLevel - melyik szinten áll a lift
     */
    public void setInitLevel(final int initLevel) {
        this.initLevel = initLevel;
    }

    /**
     * 3. feladat: Határozza meg, hogy melyik szinten áll majd a lift az utolsó kérés teljesítését követően!
     *
     * @return - melyik szinten áll a lift
     */
    public int getFinalLevel() {
        int last = requests.size() - 1;
        return requests.get(last).getTo();
    }

    /**
     * 4. feladat: Írja a képernyőre, hogy a megfigyelés kezdete és az utolsó igény teljesítése között
     * melyik volt a legalacsonyabb és melyik a legmagasabb sorszámú szint, amelyet a lift érintett!
     *
     * @return - legmagasabb sorszámú szint
     */
    public int getMaxLevel() {
        return createLevelSet().stream()
                .mapToInt(i -> i)
                .max()
                .getAsInt();
    }

    /**
     * 4. feladat: Írja a képernyőre, hogy a megfigyelés kezdete és az utolsó igény teljesítése között
     * melyik volt a legalacsonyabb és melyik a legmagasabb sorszámú szint, amelyet a lift érintett!
     *
     * @return - legalacsonyabb sorszámú szint
     */
    public int getMinLevel() {
        return createLevelSet().stream()
                .mapToInt(i -> i)
                .min()
                .getAsInt();
    }

    private Set<Integer> createLevelSet() {
        Set<Integer> levelList = requests.stream()
                .map(Request::getFrom)
                .collect(Collectors.toSet());
        requests.stream()
                .map(Request::getTo)
                .forEach(levelList::add);
        levelList.add(initLevel);
        return levelList;
    }

    /**
     * 5. feladat: Határozza meg, hogy hányszor kellett a liftnek felfelé indulnia utassal és hányszor
     * utas nélkül! Az eredményt jelenítse meg a képernyőn!
     *
     * @return - felfelé utak száma utasokkal
     */
    public long getUpWithGroups() {
        return requests.stream()
                .filter(i -> i.getFrom() < i.getTo())
                .count();
    }

    /**
     * 5. feladat: Határozza meg, hogy hányszor kellett a liftnek felfelé indulnia utassal és hányszor
     * utas nélkül! Az eredményt jelenítse meg a képernyőn!
     *
     * @return - felfelé utak száma utasok nélkül
     */
    public long getUpWithoutGroups() {
        long count = initLevel < requests.get(0).getFrom() ? 1 : 0;
        for (int i = 1; i < requests.size(); i++) {
            if (requests.get(i - 1).getTo() < requests.get(i).getFrom()) {
                count++;
            }
        }
        return count;
    }

    /**
     * 6. feladat: Határozza meg, hogy mely szerelőcsapatok nem vették igénybe a liftet a vizsgált
     * intervallumban! A szerelőcsapatok sorszámát egymástól egy-egy szóközzel elválasztva írja a képernyőre!
     *
     * @return - szöveg - a szerelőcsapatok számával
     */
    public String getGroupDidNotUsedTheElevator() {
        StringBuilder sb = new StringBuilder();
        createGroupDidNotUsedTheElevator()
                .stream()
                .map(i -> i + " ")
                .forEach(sb::append);
        return sb.toString();
    }

    private List<Integer> createGroupDidNotUsedTheElevator() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= numberOfGroups; i++) {
            numbers.add(i);
        }
        numbers.removeAll(requests.stream()
                .map(Request::getGroupId)
                .collect(Collectors.toSet()));
        return numbers;
    }

    /**
     * 7. feladat: Előfordul, hogy egyik vagy másik szerelőcsapat áthágja a szabályokat, és egyik
     * szintről gyalog megy a másikra. (Ezt onnan tudhatjuk, hogy más emeleten igényli a liftet,
     * mint ahova korábban érkezett.) Generáljon véletlenszerűen egy létező csapatsorszámot!
     * (Ha nem jár sikerrel, dolgozzon a 3. csapattal!) Határozza meg, hogy a vizsgált időszak igényei
     * alapján lehet-e egyértelműen bizonyítani, hogy ez a csapat vétett a szabályok ellen!
     * Ha igen, akkor adja meg, hogy melyik két szint közötti utat tették meg gyalog, ellenkező
     * esetben írja ki a "Nem bizonyítható szabálytalanság" szöveget!
     *
     * @return - szöveg - a megfelelő válasz
     */
    public String getGroupFouls() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < selectedGroupRequests.size(); i++) {
            sb.append(checkGroupRule(i));
        }
        return sb.length() == 0 ? String.format(NO_FOUL_MESSAGE, groupId) : sb.toString();
    }

    private String checkGroupRule(final int i) {
        int from = selectedGroupRequests.get(i - 1).getTo();
        int to = selectedGroupRequests.get(i).getFrom();
        return from != to ? String.format(FOUL_MESSAGE, groupId, from, to) : EMPTY_MESSAGE;
    }

    /**
     * 8. feladat: A munkák elvégzésének adminisztrálásához minden csapatnak egy blokkoló kártyát kell
     * használnia. A kártyára a liftben elhelyezett blokkolóóra rögzíti az emeletet, az időpontot.
     * Ennek a készüléknek a segítségével kell megadni a munka kódszámát és az adott munkafolyamat
     * sikerességét. A munka kódja 1 és 99 közötti egész szám lehet. A sikerességet a „befejezett”
     * és a „befejezetlen” szavakkal lehet jelezni.
     * Egy műszaki hiba folytán az előző feladatban vizsgált csapat kártyájára az általunk nyomon
     * követett időszakban nem került bejegyzés. Ezért a csapatfőnöknek a műszak végén pótolnia kell
     * a hiányzó adatokat. Az igeny.txt állomány adatait felhasználva írja a képernyőre időrendben,
     * hogy a vizsgált időszakban milyen kérdéseket tett fel az óra, és kérje be az adott válaszokat a
     * felhasználótól! A pótlólag feljegyzett adatokat írja a blokkol.txt állományba!
     */

    public List<String> blockingCard() {
        return selectedGroupRequests.stream()
                .map(this::printItemToCard)
                .collect(Collectors.toList());
    }

    private String printItemToCard(Request request) {
        return "Indulási emelet: " + request.getFrom() + NEW_LINE + "Célemelet: " + request.getTo() + NEW_LINE
                + "Feladatkód: " + generateRandomNumber(99) + NEW_LINE + "Befejezés ideje: " + request.getTime()
                + NEW_LINE + "Sikeresség: " + (generateRandomNumber(2) == 1 ? "befejezetlen" : "befejezett")
                + NEW_LINE + "-----";
    }


}
