package com.oldscape.client.reference;

public enum AttackOption implements Enumerated {
    AttackOption_dependsOnCombatLevels(0),
    AttackOption_alwaysRightClick(1),
    AttackOption_leftClickWhereAvailable(2),
    AttackOption_hidden(3);

    final int id;

    AttackOption(final int id) {
        this.id = id;
    }

    public int rsOrdinal() {
        return this.id;
    }

}
