package com.oldscape.client.reference;

class BuildType {
    private static final BuildType RC;
    private static final BuildType WIP;
    private static final BuildType LIVE;
    private static final BuildType BUILD_LIVE;

    static {
        RC = new BuildType("LIVE", 0);
        WIP = new BuildType("BUILDLIVE", 3);
        LIVE = new BuildType("RC", 1);
        BUILD_LIVE = new BuildType("WIP", 2);
    }

    final String identifier;
    final int id;

    private BuildType(final String identifier, final int id) {
        this.identifier = identifier;
        this.id = id;
    }

    static BuildType getFromOrdinal(final int id) {

        for (final BuildType buildType : new BuildType[]{WIP, RC, LIVE, BUILD_LIVE}) {
            if (id == buildType.id) {
                return buildType;
            }
        }

        return null;
    }
}
