package pages.faq_section;

public enum FaqSectionDescription {

    SUMMARY                             ("Summary", 10),
    UTILITY                             ("Utility", 7),
    SUPERNOVA_TRAITS                    ("Supernova Traits", 8),
    SMART_CONTRACT                      ("Smart contract", 1),
    WHY_DYNAMIC_NFT_AND_HOW_IT_WORKS    ("Why dynamic NFT and how it works?", 1),
    NEBULA_DAO                          ("Nebula DAO", 1),
    GOVERNANCE_SLOW_START               ("Governance ‘Slow Start’", 1),
    TEAM                                ("Team", 5),
    ROAD_MAP_2021                       ("Road map 2021", 5),
    REWARDS                             ("Rewards", 4),
    FAQ_TEXT                            ("faq", 0);


    public final String dropdownMenuName;
    public final int textQuantity;

    FaqSectionDescription(String dropdownMenuName, int textQuantity) {
        this.dropdownMenuName = dropdownMenuName;
        this.textQuantity = textQuantity;
    }

    public static String getDropdownMenuName(int index) {
        return FaqSectionDescription.values()[index].dropdownMenuName.toUpperCase();
    }

    public static int getTextQuantity(int index) {
        return FaqSectionDescription.values()[index].textQuantity;
    }
}
