package Models;

public enum Race {
    AMAZON("Amazon"),
    BLACK_ORCS("Black Orcs"),
    BRETONNIANS("Bretonnians"),
    CHAOS_CHOSEN("Chaos Chosen"),
    CHAOS_RENEGADE("Chaos Renegade"),
    DARK_ELVES("Dark Elves"),
    DWARVES("Dwarves"),
    ELVEN_UNION("Elven Union"),
    GNOMES("Gnomes"),
    GOBLINS("Goblins"),
    HALFLINGS("Halflings"),
    HIGH_ELVES("High Elves"),
    HUMANS("Humans"),
    IMPERIAL_NOBILITY("Imperial Nobility"),
    KHORNE("Khorne"),
    LIZARDMEN("Lizardmen"),
    NECROMANTIC_HORROR("Necromantic Horror"),
    NORSE("Norse"),
    NURGLE("Nurgle"),
    OGRES("Ogres"),
    OLD_WORLD_ALLIANCE("Old World Alliance"),
    ORCS("Orcs"),
    SHAMBLING_UNDEAD("Shambling Undead"),
    SKAVENS("Skaven"),
    SLANN_KISLEV("Slann/Kislev"),
    SNOTLINGS("Snotlings"),
    TOMB_KINGS("Tomb Kings"),
    UNDERWORLD_DENIZEN("Underworld Denizen"),
    VAMPIRES("Vampires"),
    WOOD_ELVES("Wood Elves");

    private final String displayName;

    Race(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}